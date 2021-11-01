#Author: Andrew Eisenhour
#Date: 11/14/19
#Sales Data Program, calculates projected sales

#Initialize to avoid errors
salesFile = None
newSalesFile = None
try: #Open the try block
    salesFile = open("sales.txt", "r") #Open the sales
    newSalesFile = open("projections.txt", "w") #The output file

    #Initialize variables
    companyName = ""
    sales = 0
    line = salesFile.readline()
    #While there is another line
    while line!="":
        #Create an array of the items on the line
        fields = line.split(" ")
        #The name of the company
        companyName = fields[0]
        #The current sales
        sales = float(fields[1])
        #Calculate the sales
        newSales = sales + sales*0.15
        #Write to the file
        newSalesFile.write(str(companyName) + " " + str(sales) + " %.2f" %newSales + "\n")
        line = salesFile.readline()
except IOError: #Catch if file does not exist
    print("File not found")
except ValueError: #Catch if there is a mistmatch of value
    print("Value does not match")
except Exception as exceptObject: #Catch general exceptions
    print("General Error:", str(exceptObject))
finally:
    if salesFile!=None:
        salesFile.close()
        newSalesFile.close()
