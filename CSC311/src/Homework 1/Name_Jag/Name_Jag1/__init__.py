jag_num = 2
birth_year = 10
total = (jag_num**birth_year)

num = 0
count = 0

print total

while total >0:
    num = total%10
    total//=10
    if num in [1,3]:
        count += 1

print count
print num 
print total 