#Author: Andrew Eisenhour
#Date: 11/12/19
#Items program

#Prompt user for input output files
inputFileName = input("Input file: ")
outputFileName = input("Output file: ")

#Open the input and output files
inputFile = open(inputFileName, "r")
outputFile = open(outputFileName, "w")

#Read the input and write the output
total = 0.0

for line in inputFile:
    #Make sure there is a colon in the input line, otherwise skip the line
    if ":" in line:
        #Split record at the colon
        parts = line.split(":")

        #Extract the two data fields
        item = parts[0]
        price = float(parts[1])

        #Increment the total
        total = total + price

        #Write the output
        outputFile.write("%-20s%10.2f\n" % (item, price))

#Write the total price
outputFile.write("%-20s%10.2f\n" % ("Total:", total))

#Close the files
inputFile.close()
outputFile.close()
