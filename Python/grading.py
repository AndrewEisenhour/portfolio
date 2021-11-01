#Author: Andrew Eisenhour
#Date: 9/24/19
#Grading program

#Receive the input grade
grade = int(input("What is your score on the test? "))

#Check which tier the grade falls in
#Not valid
if (grade>100 or grade<0):
    print("Invalid Grade: Enter 0-100")
#A
elif grade>89 and grade<101:
    print("You got an A!")
    if grade>=95:
        print("You will receive a COBACS PEN and be considered for a Lab Instructor position")
#B
elif grade>=80 and grade <=89:
    print("You got a B.")
    if grade>=85:
        print("You will be considered for a Work-study Position")
#C
elif grade>=70 and grade<=79:
    print("You got a C.")
#D
elif grade>=60 and grade<=69:
    print("You got a D.")
#F
else:
    print("You got an F. Better luck next time!")
