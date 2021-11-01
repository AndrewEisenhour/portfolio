#Author: Andrew Eisenhour
#Date: 9/17/19
#Using if statements

#Prompt the user for an input
applicantAge = int(input("Enter your age: "))
state = input("Enter the name of your state: ")

#Determine if the applicant qualifies for a Driving License
if applicantAge > 16:
    print("You qualify for a ", state , "Driving License")
else:
    print("you don't qualify for a", state, "Driving License test")
