#Authors: Andrew Eisenhour and Jake Stepp
#Date: 9/5/19
#Calculates the area, circumference, volume, and surface area for a given radius

import math

#Input
radius = int(input("Input the radius you would like to calculate for: "))

#Calculations
area=math.pi*radius*radius
circum=2*radius*math.pi
surfaceArea=4*area
volume=(4/3)*radius*area

#Return
print("For a circle with radius " + str(radius) + ":")
print("\tThe area is", round(area, 2))
print("\tThe circumference is", round(circum, 2))
print("For a sphere with radius " + str(radius) + ":")
print("\tThe volume is", round(volume, 2))
print("\tThe surface area is", round(surfaceArea, 2))
