# Author: Andrew Eisenhour
# Date: 8/29/19
# The use of variables and Arithmetic operations in python

#Define the constants
PENNIES_PER_DOLLAR = 100
PENNIES_PER_QUARTER = 25

#Obtain the Bill Value from the user
billValue = int(input("Enter the bill value(1, 2, 3, etc): "))

#Obtain the Item price in pennies
itemInput = input("Enter the item price in pennies: ")
itemPrice = int(itemInput)

#Compute the change due
changeDue = PENNIES_PER_DOLLAR * billValue - itemPrice
dollarCoins = changeDue // PENNIES_PER_DOLLAR
changeDue = changeDue % PENNIES_PER_DOLLAR
quarters = changeDue//PENNIES_PER_QUARTER

#Print change due
print("The Change Due: ")
print("Dollar coins: %6d" %dollarCoins)
print("Quarters: %6d" %quarters)
