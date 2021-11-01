#Author: Andrew Eisenhour
#Date: 11/7/19
#A program for the purpose of reading and writing to files

#Create an object pointing to the continents file for reading
contFile = open("continents.txt", "r")
newContFile = open("newgrowth.txt", "w")

#Display the contents of the file in the program
continentName = ""
population = 0
line = contFile.readline() #Read the first line of the file

while line != "": #Check for end of file
    fields = line.split(" ")    #Make array of the names
    continentName = fields[0] #Extract name
    population = int(fields[1]) #Extract the population
    print(continentName, population) #Display name and population

    newPopulation = population + (population*0.1)
    print("Population in 5 Yrs:", newPopulation)

    #Write the new record in the newgrowth.txt file
    print("Writing to new file....\n")
    newContFile.write(continentName + " " + str(newPopulation)+"\n")
    #newPopulation converted to text prior to writing
    line = contFile.readline()

print("End of writing to new file. Confirmation required!")
#Close the files
contFile.close()
newContFile.close()
