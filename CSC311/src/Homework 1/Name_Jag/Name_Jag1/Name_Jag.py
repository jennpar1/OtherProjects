my_list = []
x = 587290
y = 1985
total = (x**y)

# print len(str(total))
# 


for digit in (str(total)):
    my_list.append(int(digit))
    
c = 0   
# print my_list
# 
# count_total = my_list.count(1) + my_list.count(3) 
# print count_total 

for i in range(len(my_list)):
    if my_list[i] in [1,3]:
        c+=1
print c    
