#Author: Andrew Eisenhour
#Date: 10/8/19
#Averages

#Declare required variables
total=0
average=0
num=1

#A While loop to add numbers 1-10
while num<11:
    total = total + num
    num = num + 1

average=total/num

print("Sum of 1-10", total)
print("Average: ", average)
