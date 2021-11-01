#Author: Andrew Eisenhour
#Date: 10/15/19
#Average Exam Grades for multiple students

#Max and min
high = 0;
low = 100;

#Obtain the number of exam grades per student
numExams = int(input("How many exam grades does each student have? "))

#Initialize moreGrades to a non-sentinel value
moreGrades = "Y"

#Compute average exam grades until the user wants to stop
while moreGrades == "Y":

    #Compute the average grade for one student
    print("Enter the exam grades.")
    total = 0
    for i in range(1, numExams+1):
        score = int(input("Exam %d: " % i))
        #Change high and low appropriately
        high = max(high, score)
        low = min(low, score)
        total = total+score

    #Calculate average for this student
    average = total/numExams
    print("The average is %.2f" %average)

    #Prompt as to whether the user wants to enter grades for another student
    moreGrades = input("Enter exam grades for another student (Y/N)? ")
    moreGrades = moreGrades.upper()

#Print the highest and lowest
print("The highest score was: ", high)
print("The lowest score was: ", low)
