#Author: Andrew Eisenhour
#Date: 11/19/19
#Counting Words

def main():
    uniqueWords = set()

    filename = input("Enter filename (default: nurseryrhyme.txt): ")
    if len(filename) == 0:
        filename = "nurseryrhyme.txt"
    inputFile = open(filename, "r")

    for line in inputFile:
        theWords = line.split()
        for word in theWords:
            cleaned = clean(word)
            if cleaned !="":
                uniqueWords.add(cleaned)

    print("The document contains", len(uniqueWords), "unique words.")

#Method to clean a string
def clean(string):
    result = ""
    for char in string:
        if char.isalpha():
            result = result + char.lower()

    return result

#Start the program
main()
