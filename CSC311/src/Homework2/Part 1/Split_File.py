# Jennifer Parnell
# Partner: Blair Doyle
# Homework 2 Part 1
import os.path
def Split_File(textfile, flag):
    if os.path.isfile(textfile):
        with open(textfile, "r") as text_file:
            num = 0
            lines = text_file.readlines()
            files = ["xaa.ext", "xab.ext", "xac.ext", "xad.ext", "xae.ext", "xaf.ext"]
            begin = 0
            end = flag
            
            while end:
                split = lines[begin:end]
                if num < len(files):
                    with open(files[num], "w") as ext_file:
                        for item in split:
                            ext_file.write("{}".format(item))  
                        print files[num]
                        begin += flag
                        end += flag
                        num += 1
        text_file.close()
    else:
        print "File cannot be found"        

file_name = raw_input('Enter name of file: ')
flag_num = int((raw_input('Enter number of lines for split (Default 1000): ')) or 1000)
Split_File(file_name, flag_num)
