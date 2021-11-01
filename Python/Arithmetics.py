#Author: Andrew Eisenhour
#Date: 9/3/19
#Determines a variety of arithmetic operations

#Input
num1=int(input("What is your first number? "))
num2=int(input("What is your second number? "))

#Calculations
sums = num1 + num2
diff = num1-num2
product = num1*num2
average = sums/2
distance = abs(diff)
maximum = max(num2, num1)
minimum = min(num2, num1)

#Output
print("Your numbers were", num1, "and", num2)
print("The difference is:", diff)
print("The product is:", product)
print("The average is:", average)
print("The distance is:", distance)
print("The maximum is:", maximum)
print("The minimum is:", minimum)

