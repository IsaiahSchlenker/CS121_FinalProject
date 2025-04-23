Investor.class: Investor.java StockData.class Volatility.class
	javac Investor.java

StockData.class: StockData.java Volatility.class
	javac StockData.java

Volatility.class: Volatility.java
	javac Volatility.java

run: Investor.class StockData.class Volatility.class
	java Investor

clean:
	rm -f *.class
