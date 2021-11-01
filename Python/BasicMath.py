#Author: Andrew Eisenhour
#Date: 10/24/19
#Basic Math program, does different functions

#Main function
def main():
    #Input
    a = int(input("Enter your first integer: "))
    b = int(input("Enter your second integer: "))
    #Print out the product, quotient, and difference
    print("The product is:", product(a, b))
    print("The quotient is:", quotient(a, b))
    print("The difference is:", difference(a, b))
#Product function
def product(a, b):
    return a*b
#Quotient function
def quotient(a, b):
    return a/b
#Difference function
def difference(a, b):
    return a-b
main() #call the main function
