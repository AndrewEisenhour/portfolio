costOne=int(input("What is the cost of the first car? "))
mpgOne=int(input("What is the mpg of the first car? "))
costTwo=int(input("What is the cost of the second car? "))
mpgTwo=int(input("What is the mpg of the second car? "))
miles=int(input("How many miles per year do you plan to drive this car? "))
years=int(input("How many years do you wish to drive this car? "))
cpg=int(input("What is the cost of gas per gallon? ")
totalOne=costOne+(mpgOne/miles)*years*cpg
totalTwo=costTwo+(mpgTwo/miles)*years*cpg
if (totalOne>totalTwo):
    print("Car two is cheapter at $")
if (totalTwo>totalOne):
    print("Car one is cheaper")
