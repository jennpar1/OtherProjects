from math import factorial
from _ast import Compare
def Count_Doubles(input):

    count = 0
    
    while input > 0:
        num = input%10  #takes one number
        input//=10      #drops a number
        if num > 0:
            num2 = input%10
            compare_num = cmp(num, num2)
            if compare_num == 0:
                count += 1 
    
    return count
    
print "Count Doubles for number '1234567890' returns "; print (Count_Doubles(1234567890)) 
print "Count Doubles for number '111222333444' returns "; print (Count_Doubles(111222333444))
print "Count Doubles for number 'factorial(400)' returns "; print (Count_Doubles(factorial(400)))
 