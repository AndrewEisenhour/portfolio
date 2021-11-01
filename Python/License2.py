#Author: Andrew Eisenhour
#Date: 9/17/19
#Improved driver's license

#Prompt the user for an input
applicantAge = int(input("Enter your age: "))
state = input("Enter the name of your state: ")
nearDMV = input("Enter your nearest DMV Office: ")

#Determine if the applicant qualifies for a Driving License
#If 15 they qualify for permit
if applicantAge==15:
    print("Welcome! You qualify for a", state, "Instruction Permit.")
    print("Please visit the", nearDMV, "for your Written Test.")
#If 16 or older they qualify for a license
elif applicantAge >= 16:
    print("You qualify for a ", state , "Driving License Test.")
    print("Please visit the", nearDMV, "for your Written Test.")
#Else wait until they are 15
else:
    print("Sorry, you don't qualify for a", state,"Driving License Test.")
    print("Please come back after", 15-applicantAge, "years for an Instruction Permit.")
