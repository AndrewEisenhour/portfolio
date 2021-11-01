#Author: Andrew Eisenhour
#Date: 10/29
#A program to demonstrate the use of Functions in Python

#define a global variable
balance = 5000

#main function definition
def main():
    print("Current Account Balance: " + str(balance))
    #prompt the user to enter amount they wish to deposit
    toDeposit = int(input("Enter the deposit amount: "))
    #call the deposit function in order to add the amount to the current balance
    deposit(toDeposit)
    #prompt the user to enter amount they wish to withdraw
    toDeposit= int(input("\nEnter the deposit withdraw: "))
    #call the deposit function in order to add the amount to current balance
    withdraw(toDeposit)

#withdraw function
def withdraw(amount):
    #Access the global variable balance
    global balance
    if balance >= amount:
        balance = balance - amount
        print("Withdrawal Success! Balance: $" + str(balance))
    else:
        print("Withdrawal Failed: Insufficient Funds! Balance: $" + str(balance))

#deposit function
def deposit(amount):
    #Access the global variable balance
    global balance
    #increase the balance by amount
    balance = balance + amount
    print("Deposit Success! Balance: $" + str(balance))

main()
    
