#Author: Andrew Eisenhour
#Date: 9/10/19
#Gas Cost: Calculates the cost for driving a vehicle 100 miles and how far it can get in one tank of gas

#Constants
MILES = 100

#Input
#Number of gallons
gallons = int(input("How many gallons of gas are in the tank? "))

#Fuel efficiency
mpg = float(input("What is the fuel efficiency of the vehicle in miles per gallon? "))

#Price of gas
gasPrice = float(input("What is the price of gas per gallon? "))

#Calculations

#Total cost for 100 miles
totalCost = MILES / mpg * gasPrice

#Distance that can be traveled
distance = mpg * gallons

#Return output
print("The total cost to drive 100 miles is: %.2f" %totalCost)
print("The distance you can travel on this amount of gas is: %.2f" %distance)

                 
