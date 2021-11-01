#Author: Andrew Eisenhour
#Date: 9/10/19
#P2.35, computes change that the consumer should receive

#Constants
DOLLAR = 100
QUARTER = 25
DIME = 10
NICKEL = 5
#Amount due
due = float(input("How much is due? "))

#Amont given
given = float(input("How much was given? "))

#Convert to pennies
penniesDue = int(due * 100)
penniesGiven = int(given * 100)

#Calculate change
change = penniesGiven-penniesDue
dollars = change//DOLLAR
change -= dollars*DOLLAR
quarters = change//QUARTER
change -= quarters*QUARTER
dimes = change//DIME
change -= dimes*DIME
nickels = change//NICKEL
change -= nickels*NICKEL
pennies = change

#If they didn't give enough money return a request for more
if (given<due):
    print("That's not enough money!")
else:
    print("The customer is owed:")
    print(dollars, "dollars")
    print(quarters, "quarters")
    print(dimes, "dimes")
    print(nickels, "nickels")
    print(pennies, "pennies")
    print("Have a great day!")
    
