#Author: Andrew Eisenhour
#Date: 11/5/19
#A program to demonstrate the use of tables in Python

#Declare the list of countries
countries = ["USA", "Russia", "Jamaica", "GB", "Ethiopia", "Kenya", "Germany", "Aus", "Total:"]

#Declare the list of medal categories
medals = ["Gold", "Silver", "Bronze", "Total"]

#Declare an empty etable to store the medals
medals_table = []

#Initialize the table of medals with zeros in each position
for i in range(len(countries)):
    row = [0]*len(medals)
    medals_table.append(row)

#prompt the user to enter th emedals as provided in medal counts
for i in range(len(countries)-1):
        print("Medals for ", countries[i])
        counter = 0 #Total medals per country
        for j in range(len(medals)):
            if j==3:
                medals_table[i][j]=counter
            else:
                print("Enter the number of ", medals[j], end=": ")
                count = int(input()) #Store medals per category
                counter += count #Increment the total medals per country
                medals_table[i][j]=count #Store medals in the table
        print() 

#Display the medal table
print("\n\tMEDALS Table ")
print("-"*30)
print("\t",end="") #Print a tab

#Print the medal categories
for i in range(len(medals)):
    print(medals[i], end="\t")
print()

#Get the total medals from each category
for i in range(len(medals)):
    for j in range(len(countries)-1):
        medals_table[len(countries)-1][i]+=medals_table[j][i]
        
#Print the medal count for each country
for i in range(len(countries)):
    print(countries[i], end="\t")
    for j in range(len(medals)):
        print(medals_table[i][j],end="\t")
    print()
