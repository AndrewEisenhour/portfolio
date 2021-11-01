#Author: Andrew Eisenhour
#Date: 9/5/19
#P2.21 finding Easter Sunday

#Receive the year
y = int(input("What year would you like to find Easter Sunday for? "))

#Calculations from textbook
a = y%19
c = y%100
b = y//100
d = b//4
e = b%4
g = (8*b+13)//25
h = (19*a+b-d-g+15)%30
j = c//4
k = c%4
m = (a+11*h)//319
r = (2*e+2*j-k-h+m+32)%7
n = (h-m+r+90)//25
p = (h-m+r+n+19)%32

#Output with the format mm/dd/yyyy
print("Easter falls on " + str(n) + "/" + str(p) + "/" + str(y))
