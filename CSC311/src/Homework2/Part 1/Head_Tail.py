# Jennifer Parnell
# Homework 2 Part 1
import os.path
def Head_Tail(textfile, flag):
    if os.path.isfile(textfile):
        with open(textfile, "r") as text_file:
            lines = text_file.readlines()
            if flag < (len(lines)/2):    
                first_lines = lines[0:flag]
                last_lines = lines[-flag:]
                Head_Tail = first_lines + last_lines
            else:
                Head_Tail = lines
        return len(Head_Tail)
        text_file.close()
    else:
        print "File cannot be found"
        
file_name = raw_input('Enter file name: ')
flag_num = int((raw_input('Enter number of lines (Default 10): ')) or 10)

Head_Tail(file_name, flag_num)  
