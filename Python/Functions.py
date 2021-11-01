#Author: Andrew Eisenhour
#Date: 9/3/19
#Simple functions

#Declaration and initialization of variables
squareSide = 0
perimeter = 0
area = 0

#Prompt the user for input
squareSide = int(input("Enter the length of the side: "))

#Calculate the perimeter
perimeter = 2*(squareSide + squareSide)

#Calculate the area
area = squareSide**2

#Display the output
print("\nLength of Square's Side:",squareSide)
print("Perimeter of Square:", perimeter)
print("Area of Square:", area)
