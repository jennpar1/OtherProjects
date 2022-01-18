from __future__ import division
from math import *

def my_means(a,b, flag = 'M'):
    if flag == "C":
        if a == 0 and b == 0:
            return "F"
        else:   
            return ((2*((a**2)+a*b+(b**2)))/(3*(a+b)))    
    elif flag == "L":
        if a > 0 and b > 0:
            return ((b-a)/(log(b)- log(a)))
        else:
            return "F"
    elif flag == "H":
        if a > 0 and b > 0:
            return ((a + sqrt(a*b)+b)/3)
        elif a < 0 and b < 0:
            return ((a + sqrt(a*b)+b)/3)
        else:
            return "F"
        
    elif flag == "G":
        if a > 0 and b > 0 or a < 0 and b < 0:
            return ((a*b)**(1./3))
        elif a < 0 and b < 0:
            return ((a*b)**(1./3))
        else:
            return "F"
    elif flag == "A":
        if a != 0 and b != 0:
            return (2/((1/a)+(1/b)))
        else:
            return "F"
    elif flag == "M":
        return ((a+b)/2)
    else:
        return "Error"
        

# print my_means(0,0,"C")
# print my_means(-1,3,"C")
# print my_means(1,3,"L")
# print my_means(-2,3,"L")
# print my_means(1,3,"H")
# print my_means(-2,3,"H")
# print my_means(-1,-3,"H")
# print my_means(4,3,"G")
# print my_means(-3,-2,"G")
# print my_means(-2,3,"G")
# print my_means(1,0,"A")
# print my_means(-1,-2,"A")
# print my_means(2, 2, "A")
# print my_means(2, 3, "M")
print my_means(-1, 3, "M")
