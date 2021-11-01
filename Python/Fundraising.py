#Author: Andrew Eisenhour
#Date: 10/8/19
#The use of while loops in Python

#Declare variables
amountRaised = 0
year = 0

#Prompt the user to enter the amount they intend to raise
targetAmount = float(input("Enter the target amount: "))

#Create a while loop to prompt the user for deposit per year
while amountRaised<targetAmount:
    year = year+1                                #Increment the years
    print("\nEnter amount raised in year ", year)#print prompt showing year
    amount = float(input())                      #Store amount in variable
    amountRaised = amountRaised + amount         #Add new amount to amount raised
    difference = targetAmount-amountRaised       #Calculate difference
    if difference>0:
        print("Great!... $", difference, "more to go! \n")

#After target is reached, display output
print("\nCongratulations! Target amount raised!")
print("Target Amount:$", targetAmount)
print("Raised Amount:$", amountRaised)
print("Time Taken   :", year, "year(s)")

