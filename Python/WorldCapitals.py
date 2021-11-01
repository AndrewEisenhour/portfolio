#Author: Andrew Eisenhour
#Date: 11/7/19
#World Capitals program

capitalFile = open("worldcapitals.txt", "r")
newCapitalFile = open("capitalsgrowth.txt", "w")

#Display the contents of the file in the program
capitalName = ""
population = 0
line = capitalFile.readline() #Read the first line of the file

while line != "": #Check for end of file
    fields = line.split(" ")    #Make array of the names
    capitalName = fields[0] #Extract name
    population = int(fields[1]) #Extract the population
    print(capitalName, population) #Display name and population

    newPopulation = population + (population*0.1)
    

    #Write the new record in the newCapitals.txt file
    newCapitalFile.write(capitalName + " " + str(population) + " " + str(int(newPopulation))+"\n")
    #newPopulation converted to text prior to writing
    line = capitalFile.readline()


#Close the files
capitalFile.close()
newCapitalFile.close()
