#Author: Andrew Eisenhour
#Date: 12/5/19
#A program to demonstrate the use of classes in python

#Define a class
class account:

    #A class variable to assign and keep track of account numbers
    lastAssignedNumber = 1000

    #The method to initialize the attributes of the class
    def __init__(self, name, yob, address):
        self.name = name
        self.yob = yob
        self.address = address
        #Set initial balance to be 0 for all new accounts
        self.balance = 0
        #Set the account number to be the last assigned number plus one
        self.accountNo = account.lastAssignedNumber + 1
        account.lastAssignedNumber += 1

    #A method to effect deposit transactions
    def deposit(self, amount):
        print(amount, "has been deposited into the account")
        #update the balance
        self.balance = self.balance + amount

    #A method to effect withdrawal transactions
    def withdraw(self, amount):
        if (amount>self.balance):
            #Check to see if that amount can be withdrawn
            print("Insufficient balance! You only have", self.balance, "in your account")
        else:
            print(amount, " has been withdrawn from the account")
            #update the balance
            self.balance = self.balance - amount

    #A method to return the current account balance
    def getBalance(self):
        return self.balance

    #A method to return the account number
    def getAccountNumber(self):
        return self.accountNo

    #A method to return the account holder's information
    def holdersInfo(self):
        print("\nAccount Holder's Bio Data")
        print("Name: " + self.name)
        print("Age: " + str(2019-int(self.yob)))
        print("Address: " + self.address)
