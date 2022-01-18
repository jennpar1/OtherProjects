# Jennifer Parnell
# Homework 2 Part 1
import os.path
def Word_Count(textfile):
    if os.path.isfile(textfile):
        with open(textfile, "r") as text_file:
            lines = text_file.readlines()
            word_count = 0
            char_count = 0
            for x in range(len(lines)):
                for word in lines[x].split():
                    if word in lines[x].split():
                        word_count += 1
                    else:
                        word_count = -1
                for char in lines[x]:
                    if char in lines[x]:
                        char_count += 1
                    else:
                        char_count = -1
            output = len(lines), word_count, char_count
            return output
        text_file.close()
    else: 
        print "File cannot be found"                  

textfile = raw_input("Enter file name to count lines, words, and characters: ")
print Word_Count(textfile)          