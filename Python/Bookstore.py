#Author: Andrew Eisenhour
#Date: 9/10/19
#P2.32, a program computing price of an order to a bookstore

#Receives the number of books and the total price of said books
number_of_books = int(input("How many books were bought? "))
total_price = float(input("What was the total price? "))

#Total with tax
total_price = total_price * 1.075

#Shipping charge
total_price += 2

#Print the total price
print("The total price is: %.2f" %total_price)
