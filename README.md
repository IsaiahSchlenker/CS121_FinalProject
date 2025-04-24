# Investor

import packages

create variables for balance, stock holding, and balance history

## main
create instance of investor
call investor menu

## menu
print menu
get user choice
interpret choice

## buySellMenu
print buying and selling menu
get user choice
interpret choice

## buyStock
print NVDA current price and stock holding
get user input for quantity they are buying
if they have enough
    take away the correct amount from balance
    add stock to stock holding

## sellStock
print NVDA current price and stock holding
get user input for quantity they are selling
if they have enough stock
    add money to their balance
    subract quantity from stock holding

## nextYear
save current price
adjust headline and price
multiply rate of return to stock holding and save in balance history
calculate and print rate of return
show balance

## viewBalance
print current balance

## viewGraph
use parameters to assemble chart website url
convert url to proper url format by encoding
add base to the url
open website

## readNews
get headline from stock data
create array with all headlines
print headline selected

# StockData

import packages

create variables for mean, variance, current price, current year, years, and price history

## getReturn
caculate mu with mean and adjustment
calculate sigma as the square root of variance plus the adjustment
get a value from a standard normal distribution
return e^(average + z * standard deviation)

## adjustPrice
multiply price by return rate
add current year to years
go to next year
add current price to price history

## getCurrentPrice
return current price

## getHeadline
return headline from volatility

## newHeadline
adjust and apply headline from volatility

## getYears
return array list years

## getPriceHistory
return array list price history

# Volatility

import packages

create variables for variance adjustment, mean adjustment, time since recession, old headline, and current headline

## getVarianceAdjustment
return variance adjustment

## getMeanAdjustment
return mean adjustment

## adjustHeadline
generate random number 0-1
use this for probability of each headline
adjust probability for recession based on time since recession
check if the old headline is any values that have a required follow up response
if select headline 0-4
add 1 to time since recession
update old headline

## getHeadline
return current headline

## applyHeadline
update mean adjustment and variance adjustment based on which headline is selected
