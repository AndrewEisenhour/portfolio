#Author: Andrew Eisenhour
#Date: 10/17/19
#Power Tables

#Declare variables
MAX_COLUMN = 4
MAX_ROW = 10

#Print the header table
for n in range(1, MAX_COLUMN+1):
    print("%10d" % n, end="")

print()
for n in range(1, MAX_COLUMN+1):
    print("%10s" % "x", end="")

print("\n", "   ", "-"*35)

#Print the table body
for x in range(1, MAX_ROW + 1):
    #Print the xth row in the table
    for n in range(1, MAX_COLUMN+1):
        print("%10.0f" % x**n, end="") #Print columns populate

    print()
