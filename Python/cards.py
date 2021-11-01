#Author: Andrew Eisenhour
#Date: 10/1/19
#Card shorthand problem

#Input
card = input("Enter the card notation: ")
#Make output string
cardName = ""

#Check for suit
if (card.endswith("D")):
    cardName += "of Diamonds"
elif (card.endswith("H")):
    cardName += "of Hearts"
elif (card.endswith("S")):
    cardName += "of Spades"
elif (card.endswith("C")):
    cardName += "of Clubs"
#Work through your digits    
if (card[0:1].isdigit()):
    if (card.startswith("2")):
        cardName = "Two " + cardName
    elif (card.startswith("3")):
        cardName = "Three " + cardName
    elif (card.startswith("4")):
        cardName = "Four " + cardName
    elif (card.startswith("5")):
        cardName = "Five " + cardName
    elif (card.startswith("6")):
        cardName = "Six " + cardName
    elif (card.startswith("7")):
        cardName = "Seven " + cardName
    elif (card.startswith("8")):
        cardName = "Eight " + cardName
    elif (card.startswith("9")):
        cardName = "Nine " + cardName
    elif (card.startswith("10")):
        cardName = "Ten " + cardName
#Check for face cards
elif (card.startswith("A")):
    cardName = "Ace " + cardName
elif (card.startswith("J")):
    cardName = "Jack " + cardName
elif (card.startswith("Q")):
    cardName = "Queen " + cardName
elif (card.startswith("K")):
    cardName = "King " + cardName

#Output
if not cardName:
    print("That was an invalid card")
else :
    print ("You got the", cardName)
