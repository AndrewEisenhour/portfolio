# Author: Andrew Eisenhour
# Date: 8/27/19
# Variables Lab #3

# Liters in a 12-ounce can
CAN_VOLUME = 0.355

# Liters in a two-liter bottle.
BOTTLE_VOLUME = 2

# Prompt the user to enter the number of cans per pack.
cansPerPack = int(input("Enter the number of cans per pack: "))
print("")

# Calculate total volume in the cans.
totalVolume = cansPerPack * CAN_VOLUME

# Display the total volume in the cans
print('A ' + str(cansPerPack) + "-pack of 12-ounce cans contains " + str(totalVolume) + " liters.")
print("")

# Calculate total volume in the cans and a 2-liter bottle
totalVolume = totalVolume + BOTTLE_VOLUME

# Display the total volume in the cans and the bottle
print("A " + str(cansPerPack) + "-pack and a two-liter bottle bontain " + str(totalVolume) + " liters.")
