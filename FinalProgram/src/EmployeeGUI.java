import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

	@SuppressWarnings({"serial"})
	public class EmployeeGUI extends JFrame implements Serializable 
	{	@SuppressWarnings("rawtypes")
		static JList list;
		static Employee[] employeeArray = new Employee [100];
		static String [] namesForListBox = new String [100];
		static int lastElementInUse = 0;
		static JTextArea txaList;
		static JLabel lblMessage;
		JButton btnGetFile, btnQuit, btnSort;
		JPanel pnlNames, pnlMessage, pnlButtons, pnlOutput;
		
		JScrollPane scroller, listScroller;
		
		/************************************************************************************************/
		
		@SuppressWarnings({"unchecked", "rawtypes"})
		public EmployeeGUI()
		{
			super("Payroll Program");
			
			pnlNames = new JPanel(new FlowLayout());
			pnlButtons = new JPanel(new GridLayout(1,3));
			pnlMessage = new JPanel(new FlowLayout());
			pnlOutput = new JPanel(new FlowLayout());
			
			lblMessage = new JLabel();
			lblMessage.setFont(new Font("serif", Font.BOLD, 20));
			lblMessage.setText("Click on Get Employee File button first");
			
			btnGetFile = new JButton("Get Employee File");
			btnSort = new JButton ("Sort Employees");
			btnQuit = new JButton("Exit");
			
			list = new JList(namesForListBox);
			list.setSelectedIndex(0);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listScroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
			txaList = new JTextArea(5,25);
			txaList.setEditable(false);
			scroller = new JScrollPane(txaList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
			pnlOutput.add(scroller);
			
			pnlMessage.add(lblMessage);
			
			pnlButtons.add(btnGetFile);
			pnlButtons.add(btnSort);
			pnlButtons.add(btnQuit);
			
			pnlNames.add(listScroller);
			
			add(pnlMessage, BorderLayout.SOUTH);
			add(pnlButtons, BorderLayout.NORTH);
			add(pnlNames, BorderLayout.CENTER);
			add(pnlOutput, BorderLayout.EAST);
			
			showList();
		
		/*******************************************************************************************/
			btnGetFile.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					readFileAndCreateArray();
					btnGetFile.setEnabled(false);
					lblMessage.setText("Next you should click on the Sort button to sort the employees ");
				}
			});
			
		/*******************************************************************************************/
					
			btnQuit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					lblMessage.setText("Your data has been saved to employees.dat - click on 'X' to end");
				}
			});
			
		/*******************************************************************************************/
				
			btnSort.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					sort();
					showList();
					saveData();
					getDataFromBinaryFile();
					list.setListData(namesForListBox);
					btnSort.setEnabled(false);
				}
			});
			
		/*******************************************************************************************/
			
			list.addListSelectionListener(new ListSelectionListener(){ 
				public void valueChanged(ListSelectionEvent e){ 
					DecimalFormat currency = new DecimalFormat("$ 000.00");
					lblMessage.setText("Earnings for: " + employeeArray[list.getSelectedIndex()].getName().toString()
							+ " is " + currency.format(employeeArray[list.getSelectedIndex()].earnings()));
				}
			});
			
		/*******************************************************************************************/
				
			btnGetFile.grabFocus();
			setSize(600, 300);
			setVisible(true);
		}
		
		/*******************************************************************************************/
		
		static void readFileAndCreateArray()
		{
			String fileName = "listOfEmployees.txt";
			File infile;
			Scanner input = null;
			Scanner line = null;
			
			try
			{
				infile = new File(fileName);
				input = new Scanner(infile);
				while (input.hasNext())
				{
					String aLine = input.nextLine();
					line = new Scanner(aLine);
					String code = line.next();
					if (code.equals("H"))
					
						employeeArray[lastElementInUse] = new HourlyEmployee(line.next(), line.next(), line.next(), line.next(), line.nextDouble(), line.nextDouble());
					
					
					else if (code.equals("S"))
					
						employeeArray[lastElementInUse] = new SalariedEmployee(line.next(), line.next(), line.next(), line.next(), line.nextDouble());
						
					
					
					else if (code.equals("C"))
					
						employeeArray[lastElementInUse] = new CommissionEmployee(line.next(), line.next(), line.next(), line.next(), line.nextDouble(), line.nextDouble());
					namesForListBox[lastElementInUse] = employeeArray[lastElementInUse].getName().toString();
					txaList.setText(employeeArray[lastElementInUse].toString());
					lastElementInUse++;
				}
				showList();
			}
			catch (FileNotFoundException fnfe)
			{
				lblMessage.setText("Problem finding file: " + fileName);
			}
			catch (@SuppressWarnings("hiding") IOException ioe)
			{
				lblMessage.setText("Problem reading file: " + fileName);
			}
			finally
			{
				try
				{
					line.close();
					input.close();
				}catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		
			/*******************************************************************************************/
		
		
			public static void showList()
			{
				String output = "";
				txaList.setText(output);
				for (int i = 0; i < lastElementInUse; i++)
				{
					output += employeeArray[i] + "\n";
					namesForListBox[i] = employeeArray[i].getName().toString();
				}
				txaList.setText(output);
			}
			
			/********************************************************************************************/
		
		public static void main(String[]args)
		{
			EmployeeGUI payroll = new EmployeeGUI();
			payroll.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
			
			/*******************************************************************************************/
			
		public void sort()
		{
			if (employeeArray == null || employeeArray.length == 0)
			{
				lblMessage.setText("Empty list");
			}
			int length = (lastElementInUse);
			quickSort(0, length-1);
			lblMessage.setText("Click on an employee name in list box on the left to show earnings");
			btnSort.setEnabled(false);
		}
			
		/*******************************************************************************************/
			
		void quickSort(int lowerIndex, int higherIndex)
		{
			int i = lowerIndex;
			int j = higherIndex;
			
			Employee pivot = employeeArray[lowerIndex + (higherIndex-lowerIndex)/2];
			while (i<=j)
			{
				while (employeeArray[i].compareTo(pivot)<0)
				{
					i++;
				}
				while (employeeArray[i].compareTo(pivot)>0)
				{
					j--;
				}
				if (i<= j)
				{
					swap(i,j);
					i++;
					j--;
				}
			}
			if (lowerIndex<j)
				quickSort(lowerIndex, j);
			if (i< higherIndex)
				quickSort(i, higherIndex);
		}
		
		void swap(int i, int j)
		{
			Employee temp = employeeArray[i];
			employeeArray[i]= employeeArray[j];
			employeeArray[j]= temp;
		}
		/*******************************************************************************************/
		
		void saveData()
		{
			ObjectOutputStream outFile = null;
			
			try
			{
				outFile = new ObjectOutputStream(new FileOutputStream("employees.dat"));
				outFile.writeObject(employeeArray);
			}
			catch (IOException ioe)
			{
				lblMessage.setText("Problem reading file: employees.dat");
			}
			finally
			{
				try
				{
					outFile.close();
				}catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}
			
		/*******************************************************************************************/
				
		void getDataFromBinaryFile()
		{
			ObjectInputStream inFile = null;
			
			try
			{
				inFile = new ObjectInputStream(new FileInputStream("employees.dat"));
				employeeArray = (Employee[])(inFile.readObject());
			}
			catch (IOException ioe)
			{
				lblMessage.setText("Problem reading file: employees.dat");
			}
			catch (ClassNotFoundException cnfe)
			{
				lblMessage.setText("Class Employee not found");
			}
			finally
			{
				try
				{
					inFile.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
			
}
