#Author: Andrew Eisenhour
#Date: 9/19/19
#Tax Calculator Improved

#Constants for rates and limits
RATE1 = 0.10
RATE2 = 0.12
RATE3 = 0.22
RATE4 = 0.24
RATE5 = 0.32
RATE6 = 0.35
RATE7 = 0.37

RATE1_SINGLE_LIMIT = 9700.0
RATE2_SINGLE_LIMIT = 39475.0
RATE3_SINGLE_LIMIT = 84200.0
RATE4_SINGLE_LIMIT = 160725.0
RATE5_SINGLE_LIMIT = 204100
RATE6_SINGLE_LIMIT = 510300.0

RATE1_MARRIED_LIMIT = RATE1_SINGLE_LIMIT*2
RATE2_MARRIED_LIMIT = RATE2_SINGLE_LIMIT*2
RATE3_MARRIED_LIMIT = RATE3_SINGLE_LIMIT*2
RATE4_MARRIED_LIMIT = RATE4_SINGLE_LIMIT*2
RATE5_MARRIED_LIMIT = RATE5_SINGLE_LIMIT*2
RATE6_MARRIED_LIMIT = 612350
#Read income and marital status
income=float(input("Please enter your income: "))
maritalStatus = input("Please enter s for single, m for married: ")

#Compute taxes due
tax1 = 0.0
tax2 = 0.0
tax3 = 0.0
tax4 = 0.0
tax5 = 0.0
tax6 = 0.0
tax7 = 0.0

if maritalStatus == "s":
    if income <= RATE1_SINGLE_LIMIT:
        tax1 = RATE1 * income
    elif income <= RATE2_SINGLE_LIMIT:
        tax1 = RATE1 * RATE1_SINGLE_LIMIT
        tax2 = RATE2 * (income-RATE1_SINGLE_LIMIT)
    elif income <= RATE3_SINGLE_LIMIT:
        tax1 = RATE1 * RATE1_SINGLE_LIMIT
        tax2 = RATE2 * (RATE2_SINGLE_LIMIT-RATE1_SINGLE_LIMIT)
        tax3 = RATE3 * (income-RATE2_SINGLE_LIMIT)
    elif income <= RATE4_SINGLE_LIMIT:
        tax1 = RATE1 * RATE1_SINGLE_LIMIT
        tax2 = RATE2 * (RATE2_SINGLE_LIMIT-RATE1_SINGLE_LIMIT)
        tax3 = RATE3 * (RATE3_SINGLE_LIMIT-RATE2_SINGLE_LIMIT)
        tax4 = RATE4 * (income-RATE3_SINGLE_LIMIT)
    elif income <= RATE5_SINGLE_LIMIT:
        tax1 = RATE1 * RATE1_SINGLE_LIMIT
        tax2 = RATE2 * (RATE2_SINGLE_LIMIT-RATE1_SINGLE_LIMIT)
        tax3 = RATE3 * (RATE3_SINGLE_LIMIT-RATE2_SINGLE_LIMIT)
        tax4 = RATE4 * (RATE4_SINGLE_LIMIT-RATE3_SINGLE_LIMIT)
        tax5 = RATE5 * (income-RATE4_SINGLE_LIMIT)
    elif income <= RATE6_SINGLE_LIMIT:
        tax1 = RATE1 * RATE1_SINGLE_LIMIT
        tax2 = RATE2 * (RATE2_SINGLE_LIMIT-RATE1_SINGLE_LIMIT)
        tax3 = RATE3 * (RATE3_SINGLE_LIMIT-RATE2_SINGLE_LIMIT)
        tax4 = RATE4 * (RATE4_SINGLE_LIMIT-RATE3_SINGLE_LIMIT)
        tax5 = RATE5 * (RATE5_SINGLE_LIMIT-RATE4_SINGLE_LIMIT)
        tax6 = RATE6 * (income-RATE5_SINGLE_LIMIT)
    else:
        tax1 = RATE1 * RATE1_SINGLE_LIMIT
        tax2 = RATE2 * (RATE2_SINGLE_LIMIT-RATE1_SINGLE_LIMIT)
        tax3 = RATE3 * (RATE3_SINGLE_LIMIT-RATE2_SINGLE_LIMIT)
        tax4 = RATE4 * (RATE4_SINGLE_LIMIT-RATE3_SINGLE_LIMIT)
        tax5 = RATE5 * (RATE5_SINGLE_LIMIT-RATE4_SINGLE_LIMIT)
        tax6 = RATE6 * (RATE6_SINGLE_LIMIT-RATE5_SINGLE_LIMIT)
        tax7 = RATE7 * (income-RATE6_SINGLE_LIMIT)
else:
    if income <= RATE1_MARRIED_LIMIT:
        tax1 = RATE1 * income
    elif income <= RATE2_MARRIED_LIMIT:
        tax1 = RATE1 * RATE1_MARRIED_LIMIT
        tax2 = RATE2 * (income-RATE1_MARRIED_LIMIT)
    elif income <= RATE3_MARRIED_LIMIT:
        tax1 = RATE1 * RATE1_MARRIED_LIMIT
        tax2 = RATE2 * (RATE2_MARRIED_LIMIT-RATE1_MARRIED_LIMIT)
        tax3 = RATE3 * (income-RATE2_MARRIED_LIMIT)
    elif income <= RATE4_MARRIED_LIMIT:
        tax1 = RATE1 * RATE1_MARRIED_LIMIT
        tax2 = RATE2 * (RATE2_MARRIED_LIMIT-RATE1_MARRIED_LIMIT)
        tax3 = RATE3 * (RATE3_MARRIED_LIMIT-RATE2_MARRIED_LIMIT)
        tax4 = RATE4 * (income-RATE3_MARRIED_LIMIT)
    elif income <= RATE5_MARRIED_LIMIT:
        tax1 = RATE1 * RATE1_MARRIED_LIMIT
        tax2 = RATE2 * (RATE2_MARRIED_LIMIT-RATE1_MARRIED_LIMIT)
        tax3 = RATE3 * (RATE3_MARRIED_LIMIT-RATE2_MARRIED_LIMIT)
        tax4 = RATE4 * (RATE4_MARRIED_LIMIT-RATE3_MARRIED_LIMIT)
        tax5 = RATE5 * (income-RATE4_MARRIED_LIMIT)
    elif income <= RATE6_MARRIED_LIMIT:
        tax1 = RATE1 * RATE1_MARRIED_LIMIT
        tax2 = RATE2 * (RATE2_MARRIED_LIMIT-RATE1_MARRIED_LIMIT)
        tax3 = RATE3 * (RATE3_MARRIED_LIMIT-RATE2_MARRIED_LIMIT)
        tax4 = RATE4 * (RATE4_MARRIED_LIMIT-RATE3_MARRIED_LIMIT)
        tax5 = RATE5 * (RATE5_MARRIED_LIMIT-RATE4_MARRIED_LIMIT)
        tax6 = RATE6 * (income-RATE5_MARRIED_LIMIT)
    else:
        tax1 = RATE1 * RATE1_MARRIED_LIMIT
        tax2 = RATE2 * (RATE2_MARRIED_LIMIT-RATE1_MARRIED_LIMIT)
        tax3 = RATE3 * (RATE3_MARRIED_LIMIT-RATE2_MARRIED_LIMIT)
        tax4 = RATE4 * (RATE4_MARRIED_LIMIT-RATE3_MARRIED_LIMIT)
        tax5 = RATE5 * (RATE5_MARRIED_LIMIT-RATE4_MARRIED_LIMIT)
        tax6 = RATE6 * (RATE6_MARRIED_LIMIT-RATE5_MARRIED_LIMIT)
        tax7 = RATE7 * (income-RATE6_MARRIED_LIMIT)

totalTax = tax1 + tax2 + tax3 + tax4 + tax5 + tax6 + tax7


#Print the results
print("The tax is %.2f" %totalTax)
