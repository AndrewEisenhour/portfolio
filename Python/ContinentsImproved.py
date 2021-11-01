#Author: Andrew Eisenhour
#Date: 11/14/19
#Improvement on the continents program

contFile = None
newContfile = None

try: #Beginning of try block
    #Create an object pointing to the continents file for reading
    contFile = open("continents.txt", "r")
    newContfile = open("newgrowth.txt", "w")

    #Display the contents of the file in the program
    continentName = ""
    population = 0
    line = contFile.readline() #Read the first line of the file

    while line!="":
        fields = line.split(" ") #Split the record
        continentName = fields[0] #Assign continentName
        population = int(fields[1]) #Assign the population
        print(continentName, " ", population) #Print the name we are working with
        newPopulation = population + population*0.1 #Calculate the new population
        print("Population in 5 Yrs:", newPopulation) #Print the future population to console
        print("Writing to new file...\n") #Write to the file
        newContfile.write(continentName+" "+str(population)+" " +str(newPopulation)+"\n")#Convert to text

        line = contFile.readline()
#Handles when file can't be found
except IOError:
    print("File not found. Please confirm the file is located in your program directory")
#Handles value type mistmatches
except ValueError:
    print("File contents are not valid. Please check the format of your data set")
#Handles where data set is incomplete or too large
except RuntimeError as error:
    print("Runtime Error:", str(error))
#General excetions
except Exception as exceptObject:
    print("General Error:", str(exceptObject))

finally:
    print("End of writing to new file. Confirmation requried!")
    #Close the files
    if (contFile!=None):
        contFile.close()
    newContfile.close()
