#Author: Andrew Eisenhour
#Date: 9/3/19
#Powers, displays square, cube, and 4th power

#Receive number
num = int(input("Enter the number you would like to see the powers of: "))

#Calculate each power
square = num*num
cube = num*square
fourth = square**2

#Output
print("The square, cube, fourth power of", num, "are " + str(square) + ", " + str(cube) + ", and", fourth)
