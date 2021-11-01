#Author: Andrew Eisenhour
#Date: 10/22/19
#Wheel Spin program

from random import randint

#Declare points
points = 0
for i in range(3): #Spin three times
    #Random wheel value
    number = randint(1,16)
    #Check points received
    if number%4==0:
        points+=5

#Print the score
print("You got", points, "points!")
        
