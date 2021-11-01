#Author: Andrew Eisenhour
#Date: 10/3/19
#French country names

#Input
country = input("Please enter a country: ")

#Declare the article
article = ""

#Run our test cases
if country=="Etats-Unis" or country=="Pays-Bas":
    article = "les"
elif country=="Belize" or country=="Cambodge" or country=="Mexique" or country=="Mozambique" or country=="Zaire" or country=="Zimbabwe":
    article = "le"
elif country.startswith("A") or country.startswith("E") or country.startswith("I") or country.startswith("O") or country.startswith("U"):
    country = "l'" + country
elif country.endswith("e"):
    article = "la"
else:
    article = "le"

#Output
print("The French name of the country is " + article + " " + country)
