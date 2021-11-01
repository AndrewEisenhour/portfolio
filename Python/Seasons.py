#Author: Andrew Eisenhour
#Date: 10/3
#Seasons Program, P3.20

#Receive input
month = int(input("Enter the number of a month: "))
day = int(input("Enter a day: "))

#Initialize season
season = "none"

#Test for months
if month<=3:
    season = "Winter"
elif month<=6:
    season = "Spring"
elif month<=9:
    season = "Summer"
else:
    season = "Fall"
if month%3==0 and day>=21:
    if season=="Winter":
        season = "Spring"
    elif season == "Spring":
        season = "Summer"
    elif season == "Summer":
        season = "Fall"
    else:
        season = "Winter"

#Output
print("The season is", season)
