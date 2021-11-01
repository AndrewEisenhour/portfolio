#Author: Andrew Eisenhour
#Date: 9/10/19
#Hybrid Car Problem

#Constants
NUM_YEARS = 5
#Input
#Cost of vehicle
car_cost = float(input("Enter the cost of the car: "))

#Mies per year
miles_per_year = float(input("How many miles will you drive each year? "))

#Price of gas
gas_price = float(input("Enter the price of gas per gallon: "))

#Efficiency
efficiency = float(input("Enter the fuel efficiency in mpg: "))

#Resale value
resale = float(input("How much can you sell the car for after 5 years? "))

#Compute
total_cost = car_cost - resale + NUM_YEARS * miles_per_year / efficiency * gas_price

#Output
print("The total cost of ownership is %.2f" %total_cost)
