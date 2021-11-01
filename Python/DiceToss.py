#Author: Andrew Eisenhour
#Date: 10/22/19
#Random number practice with dice

from random import randint

for i in range(10): #Toss 10 times
#Generate two random numbers between 1 and 6
    dice1 = randint(1,6)
    dice2 = randint(1,6)

    #print the two values
    print(dice1, dice2)
