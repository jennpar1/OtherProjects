// Name: Alex Dudenhoeffer
// JagNumber: J00589451
// Class: CSC 120
// Assignment: Program 04

package earnings;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.event.*;

public class WeeklyReportGUI extends JPanel {

	// GUI elements
	JButton viewButton, clearButton, sortButton, writeButton, readButton;
	static JButton loadButton, quitButton;
	JLabel employeesLabel, infoLabel;
	JList employeesList;
	JPanel listPanel, buttonPanel, infoPanel;
	JScrollPane listScroller, textScroller;
	JTextArea infoTextArea;
	
	private static Employee[] employees;
	
	public WeeklyReportGUI() {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		
		// Employees Label
		employeesLabel = new JLabel("Employees:");
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(10, 10, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 5;
		add(employeesLabel, gbc);
		
		// Employees List
		employeesList = new JList<String>();
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 10, 5, 10);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 5;
		employeesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listScroller = new JScrollPane(employeesList);
		add(listScroller, gbc);
			
		// View Button
		viewButton = new JButton("View");
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 10, 5, 2);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		add(viewButton, gbc);

		// Clear Button
		clearButton = new JButton("Clear");
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 2, 0, 2);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		add(clearButton, gbc);
				
		// Sort Button
		sortButton = new JButton("Sort List");
		sortButton.setEnabled(false);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 2, 0, 2);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		add(sortButton, gbc);
		
		// Write Button
		writeButton = new JButton("Write To File");
		writeButton.setEnabled(false);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 2, 0, 2);
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		add(writeButton, gbc);
		
		// Read Button
		readButton = new JButton("Read From File");
		readButton.setEnabled(false);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 2, 0, 10);
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		add(readButton, gbc);

		// Load Button
		loadButton = new JButton("Load Data");
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 10, 0, 2);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		add(loadButton, gbc);

		// Quit Button
		quitButton = new JButton("Quit");
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 2, 0, 10);
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 1;
		add(quitButton, gbc);
		
		// Info Label
		infoLabel = new JLabel("Employee Information:");
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(5, 10, 0, 0);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1;
		gbc.weighty = 0;
		gbc.gridwidth = 5;
		add(infoLabel, gbc);
		
		// Info Text Area
		infoTextArea = new JTextArea();
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 5;
		textScroller = new JScrollPane(infoTextArea);
		add(textScroller, gbc);
		
		// View button event handler
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (employeesList.isSelectionEmpty()) {
					return;
				}
				else {
					infoTextArea.setText(((Employee) employeesList.getSelectedValue()).getEarnings());	
				}
			}		
		});
		
		// Clear button event handler
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				employeesList.clearSelection();
				infoTextArea.setText(null);
			}		
		});
		
		// Sort button event handler
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (employeesList.getModel().getSize() == -1) {
					return;
				}
				else {
					employeesList.clearSelection();
					infoTextArea.setText(null);
					sort(employees);
					employeesList.setListData(employees);
				}
			}		
		});
		
		// Write button event handler
		writeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				writeToBinary(employees);
				employeesList.clearSelection();
				infoTextArea.setText(null);
				writeButton.setEnabled(false);
				readButton.setEnabled(true);
			}		
		});
		
		// Read button event handler
		readButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				readFromBinary();
				employeesList.setListData(employees);
				readButton.setEnabled(false);
				writeButton.setEnabled(true);
			}		
		});
		
		// Load button event handler
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				readFileAndCreateArray();
				loadButton.setEnabled(false);
				employeesList.setListData(employees);
				sortButton.setEnabled(true);
				writeButton.setEnabled(true);
			}		
		});
		
		// Quit button event handler
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}		
		});

	} // End WeeklyReportGUI() constructor
	
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Employee Weekly Report");

        // Create and set up the content pane.
        JComponent newContentPane = new WeeklyReportGUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        frame.pack();
        
        // Display the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		loadButton.grabFocus();
        frame.setVisible(true);
    } // End createAndShowGUI() method
	
	public static void readFileAndCreateArray() {
		
		String fileName = "employees";
	
		try {
			File inputFile = new File("employees");
			Scanner input = new Scanner(inputFile);
			Scanner inputLineCounter = new Scanner(inputFile);
			
			// Count lines 
			int lineCount = 0;
			while (inputLineCounter.hasNextLine()){
				lineCount++;
				inputLineCounter.nextLine();
			} // End while loop
			
			employees = new Employee[lineCount];
			
			// Store data into employee array
			Name name;
			String id;
			double rate, sales, wage, hoursWorked, salary;
			Employee employee = null;
			for (int i = 0; i < lineCount; i++) {
				String line = input.nextLine();
				String[] splitEmployee = line.split(" ");
				
				name = new Name(splitEmployee[2], splitEmployee[3], splitEmployee[1], splitEmployee[4]);
				id = splitEmployee[5];
				
				switch (splitEmployee[0]) {
					case "C":
						rate = Double.parseDouble(splitEmployee[6]);
						sales = Double.parseDouble(splitEmployee[7]);
						employee = new CommissionBasedEmployee(name, id, rate, sales);
						break;
					case "H":
						wage = Double.parseDouble(splitEmployee[6]);
						hoursWorked = Double.parseDouble(splitEmployee[7]);
						employee = new HourlyEmployee(name, id, wage, hoursWorked);
						break;
					case "S":
						salary = Double.parseDouble(splitEmployee[6]);
						employee = new SalariedEmployee(name, id, salary);
						break;
				} // End switch statement
				
				// Store employee object into array
				employees[i] = employee;
				
			} // End for loop
			
			// Close Scanner objects
			input.close();
			inputLineCounter.close();
			
		} // End try block
		
		catch (Exception e) {
			System.out.println(e + "\nCould not read the file: " + fileName);
		} // End catch block
		
	} // End readFileAndCreateArray() method

	public static void sort(Employee[] x) {
		if (x ==  null || x.length == 0) {
			System.out.println("Empty list.");
			return;
		} // End if statement
		quickSort(0, x.length - 1);
	} // End sortArray() method
	
	private static void quickSort(int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;
        Employee pivot = employees[lowerIndex + (higherIndex - lowerIndex) / 2];
        
        while (i <= j) {
            while (employees[i].compareTo(pivot) < 0) {
                i++;
            }
            while (employees[j].compareTo(pivot) > 0) {
                j--;
            }
            
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
            
        } // End while loop
        
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
        
   	} // End quickSort() method
	
	private static void swap(int i, int j) {
		Employee temp = employees[i];
		employees[i] = employees[j];
		employees[j] = temp;
	} // End swap() method
	
	private static void writeToBinary(Employee[] x) {
		ObjectOutputStream outputStream = null;
		
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream("employees.dat"));
			outputStream.writeObject(x);
		} // End try block
		
		catch (Exception e) {
			System.out.println("Could not write to 'employees.dat'");
		} // End catch block
		
		finally {
			try {
				outputStream.close();
			}
			catch (Exception e) { 
				e.printStackTrace();
			}
		} // End finally block
		
	} // End writeToBinary() method
	
	private static void readFromBinary() {
		ObjectInputStream inputStream = null;
		
		try {
			inputStream = new ObjectInputStream(new FileInputStream("employees.dat"));
			employees = (Employee[]) (inputStream.readObject());
		} // End try block
		
		catch (Exception e) {
			System.out.println("Could not read 'employees.dat'");
		} // End catch block
		
		finally {
			try {
				inputStream.close();
			}
			catch (Exception e) { 
				e.printStackTrace();
			}
		} // End finally block
		
	} // End readFromBinary() method
	
	public static void main(String[] args) {
		readFileAndCreateArray();
		createAndShowGUI();
	} // End main() method
	
} // End WeeklyReport class