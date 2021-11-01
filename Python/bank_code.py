#Author: Andrew Eisenhour
#Date: 12/5/19
#A program to demonstrate the use of classes in python

from account import account

#Enter the details of the account holder
name = input("Enter the name: ")
yob = int(input("Enter the Year of Birth: "))
address = input("Enter the Address:")

#Create a Account object and set its properties
account1 = account(name, yob, address)

#Carry out some transactions
print("\n")
print('-'*20)
print("Account Transactions")
print('-'*20)

depositAmount = float(input("Enter the amount you wish to deposit: "))
#Update the deposit for the current Account object
account1.deposit(depositAmount)

withdrawalAmount = float(input("\nEnter the amount you wish to withdraw: "))
#Update the withdrawal for the current Account object
account1.withdraw(withdrawalAmount)

#Display the Account statement
account1.holdersInfo()
print(account1.getAccountNumber())
print('-'*10)
print("Account Balance: $" + str(account1.getBalance()))

#Enter the details of the second account holder
name2 = input("Enter the name of the second account holder: ")
yob2 = int(input("Enter the Year of Birth: "))
address2 = input("Enter the Address:")

#Create a Account object and set its properties
account2 = account(name2, yob2, address2)

depositAmount = float(input("Enter the amount you wish to deposit: "))
#Update the deposit for the current Account object
account2.deposit(depositAmount)

withdrawalAmount = float(input("\nEnter the amount you wish to withdraw: "))
#Update the withdrawal for the current Account object
account2.withdraw(withdrawalAmount)

#Display the Account statement
account2.holdersInfo()
print(account1.getAccountNumber())
print('-'*10)
print("Account Balance: $" + str(account2.getBalance()))
