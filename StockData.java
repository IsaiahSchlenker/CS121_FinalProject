import java.util.*;

public class StockData{
	
	protected double mean = .2562;
	protected double variance = .4666;
	protected double currentPrice = 100;
	protected Volatility vol = new Volatility();
	protected int currentYear = 2025;
	protected ArrayList<Integer> years = new ArrayList<>();
	protected ArrayList<Double> priceHistory = new ArrayList<>();

	public double getReturn(){
		Random rand = new Random();
		double mu = mean + vol.getMeanAdjustment();
		double sigma = Math.sqrt(variance + vol.getVarianceAdjustment());
		double z = rand.nextGaussian();
		return Math.exp(mu+sigma*z);
	}//end getReturn
	
	public void adjustPrice(){
		currentPrice *= getReturn();
		years.add(currentYear);
		currentYear += 1;
		priceHistory.add(currentPrice);
	}//end adjustPrice

	public double getCurrentPrice(){
		return currentPrice;
	}//end getCurrentPrice
	
	public int getHeadline(){
		return vol.getHeadline();
	}//end getHeadline
	
	public void newHeadline(){
		vol.adjustHeadline();
		vol.applyHeadline();
	}//end newHeadline
	
	public ArrayList<Integer> getYears(){
		return years;
	}//end getYears
	
	public ArrayList<Double> getPriceHistory(){
		return priceHistory;
	}//end getPriceHistory
}//end StockData
