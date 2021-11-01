#Author: Andrew Eisenhour
#Date: 11/19/19
#Spell check program

#Import the split function
from re import split

def main():
    #Read the word list and document
    correctlySpelledWords = readWords("words")
    documentWords = readWords("alice30.txt")

    #Print all words that are in the document but not the word list
    misspellings = documentWords.difference(correctlySpelledWords)
    for word in sorted(misspellings):
        print(word)

#Reads all words from a file
def readWords(filename):
    wordSet = set()
    inputFile = open(filename, "r")
    for line in inputFile:
        line = line.strip()
        parts = split("[^a-zA-Z]+", line)
        for word in parts:
            if len(word)>0:
                wordSet.add(word.lower())
    inputFile.close()
    return wordSet
#Run the main method
main()
