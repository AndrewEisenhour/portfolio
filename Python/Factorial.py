#Author: Andrew Eisenhour
#Date: 10/29/19
#A program to demonstrate the use of recursive functions

#main function
def main():
    #prompt the user for a number
    num = int(input("Enter a number: "))

    #call the recursion function to calculate the factorial
    num_factorial = factorial(num)

    #print results
    print("Factorial of " + str(num) + " = " + str(num_factorial))

#recursive factorial function
def factorial(myNum):
    if myNum==1:
        #Exit condition
        return 1
    else:
        #Until myNum is one, we do this
        return myNum * factorial(myNum-1)

#call the main function
main()
