#Author: Andrew Eisenhour
#Date: 8/29/19
#Determines time in minutes and seconds

#Constants
SECONDS_PER_MINUTE = 60

#Obtain seconds
seconds = int(input("Enter the number of seconds: "))

#Convert
outMinutes = seconds//SECONDS_PER_MINUTE
outSeconds = seconds-(outMinutes*SECONDS_PER_MINUTE)

#Output
print("Value Entered: ", seconds, "\n")
print(outMinutes, " minutes and ", outSeconds, " seconds")
