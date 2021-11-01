#Author: Andrew Eisenhour
#Date: 10/8/19
#Point of Sale

#Declare initial amount and item number
amountLoaded = float(input("Enter amount loaded in the card: "))
num = 1

#While we have a positive balance
while amountLoaded>0:
    #Receive price
    print("\nEnter item", num, "price: ")
    price = float(input())
    #Decrement the price
    amountLoaded = amountLoaded-price
    #Increase the item number
    num = num+1
    
    #Decide if you are out of money or do not have enough
    if amountLoaded<0:
        print("You don't have enough money!")
    elif amountLoaded==0:
        print("Amount exhausted!")
    else:
        #Print the balance
        print("Available balance: $" + str(amountLoaded))
        
                  
                     
