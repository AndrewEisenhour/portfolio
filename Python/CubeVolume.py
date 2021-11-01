#Author: Andrew Eisenhour
#Date: 10/24/19
#Demonstration of the sue of functions

#main function definition
def main():
    #prompt the user to enter the length of the sides of a cube
    side = int(input("Enter the length of sides of the cube: "))
    #call the cubeVolume function to calculate the volume
    result = cubeVolume(side)
    #display the result
    print("Cube Volume =", result)

#function definition
def cubeVolume(sideLength):
    volume = sideLength**3
    return volume
main() #Call main function to start program execution
