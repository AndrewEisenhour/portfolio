#Author: Andrew Eisenhour
#Date: 10/30/19
#Programming Assignment #3, a unit conversion program

#Main function definition
def main():
    #Constants
    stars = "****************************"

    #Format the header of the problem
    print(stars)
    print("Unit Conversion Program")
    print(stars)

    #Print the options
    print("Available Options")
    print("1. Gallons to Liters")
    print("2. Miles to Kilometers")
    print("3. Fahrenheit to Centigrade")
    print(stars)

    #User input
    option = int(input("Enter your option: "))

    #Display the chosen option
    #If gallons to liters is chosen
    if (option==1):
        print("Selected: Gallons to Liters")
        #Save units for later output
        unit1 = "Gallons"
        unit2 = "Liters"
        #Receive the amount
        num = int(input("Enter the amount in gallons: "))
        #Call the conversion function to get the converted number
        convertedNum = galToLit(num)
    #If miles to kilometers is chosen    
    elif (option==2):
        print("Selected: Miles to Kilometers")
        #Save the units for later output
        unit1 = "Miles"
        unit2 = "Kilometers"
        #Receive the amount
        num = int(input("Enter the distance in miles: "))
        #Call the conversion function to get the converted number
        convertedNum = milesToKilo(num)
    #If Fahrenheit to Celsius is chosen    
    elif (option==3):
        print("Selected: Fahrenheit to Centigrade")
        #Save the units for later output
        unit1 = "Fahrenheit"
        unit2 = "Centigrade"
        #Receive the amount
        num = int(input("Enter the degrees in Fahrenheit: "))
        #Call the conversion function to get the converted number
        convertedNum = fahToCen(num)
    #Output at the end: a blank line, a line of stars, the conversion,
        #a blank line, and finally a Welcome to America!
    print()
    print(stars)
    #Format number to prevent long decimals
    print(num, unit1, "equals to %.0f" % convertedNum, unit2)
    print()
    print("Welcome to America!")

#Gallons to liters function
def galToLit(gallons):
    return gallons*3.785

#Miles to kilometers function
def milesToKilo(miles):
    return miles*1.6

#Fahrenheit to centigrade function
def fahToCen(fahrenheit):
    return (fahrenheit-32)*5/9

#Call the main function
main()
