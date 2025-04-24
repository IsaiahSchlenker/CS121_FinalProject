import java.util.*;
import java.awt.Desktop;
import java.net.URI;

public class Investor{
	protected double balance = 1000;
	protected double stockHolding = 0;
	protected StockData sd = new StockData();
	protected ArrayList<Double> balHistory = new ArrayList<>();

	public static void main(String[] args){
		Investor inv = new Investor();
		inv.menu();
	}//end main
	
	public void menu(){
		String menuChoice;
		Scanner scnr = new Scanner(System.in);
		boolean keepGoing = true;
                while(keepGoing){
			System.out.println("0) Exit");
			System.out.println("1) Buy/sell stock");
                	System.out.println("2) Next year");
                	System.out.println("3) Read news");
                	System.out.println("4) Graph");
			System.out.println("5) View balance\n");
                	System.out.print("Please choose 0-5: ");
			menuChoice = scnr.nextLine();
                        if(menuChoice.equals("0")){
                                keepGoing = false;
                        }else if(menuChoice.equals("1")){
				buySellMenu();	
                        }else if(menuChoice.equals("2")){
				nextYear();
                        }else if(menuChoice.equals("3")){
				readNews();
			}else if(menuChoice.equals("4")){
				System.out.println("0) NVDA chart");
				System.out.println("1) Balance chart\n");
				System.out.print("Please choose 0-1: ");
				String chartChoice = scnr.nextLine();
				if(chartChoice.equals("0")){
					viewGraph(sd.getPriceHistory(), "NVDA");
				}else{
					viewGraph(balHistory, "Balance");
				}//end if
			}else if(menuChoice.equals("5")){
				viewBalance();
                        }else{
				System.out.println("You must enter 0-5");
                        }//end if
                }//end while
	}//end menu
        
	public void buySellMenu(){
		Scanner scnr = new Scanner(System.in);
		String menuChoice;
		boolean keepGoing = true;
		while(keepGoing){
			System.out.println("0) Main menu");
			System.out.println("1) Buy stock");
			System.out.println("2) Sell stock\n");
			System.out.print("Please choose 0-2: ");
			menuChoice = scnr.nextLine();
			if(menuChoice.equals("0")){
                                keepGoing = false;
                        }else if(menuChoice.equals("1")){
                                buyStock();
                        }else if(menuChoice.equals("2")){
                                sellStock();
                        }else{
				System.out.println("You must enter 0-2");
			}//end if
		}//end while
	}//end buySellMenu

	public void buyStock(){
		Scanner scnr = new Scanner(System.in);
		double quantity;
		System.out.println("NVDA current price: " + sd.getCurrentPrice());
		System.out.println("You currently own: " + stockHolding + "\n");
		System.out.print("How much to buy: ");
		quantity = scnr.nextDouble();
		if((quantity * sd.getCurrentPrice()) > balance){
			System.out.println("Insufficient funds");
		}else{
			balance -= quantity * sd.getCurrentPrice();
			stockHolding += quantity;
			System.out.println("Order filled");
		}//end if
	}//end buyStock
	
	public void sellStock(){
                Scanner scnr = new Scanner(System.in);
                double quantity;                                                            
		System.out.println("NVDA current price: " + sd.getCurrentPrice());
		System.out.println("You currently own: " + stockHolding + "\n");
                System.out.print("How much to sell: ");
                quantity = scnr.nextDouble();
                if(quantity > stockHolding){
                        System.out.println("You can not sell more stock than you own");
                }else{
                        balance += quantity * sd.getCurrentPrice();
			stockHolding -= quantity;
			System.out.println("Order filled");
                }//end if
        }//end sellStock
	
	public void nextYear(){
		double oldPrice = sd.getCurrentPrice();
		sd.newHeadline();
		sd.adjustPrice();
		balHistory.add(balance+stockHolding*sd.getCurrentPrice());
		double newPrice = sd.getCurrentPrice();
		System.out.printf("Return last year: %%%.2f%n", (100*((newPrice/oldPrice)-1)));
		viewBalance();
	}//end nextYear
	
	public void viewBalance(){
		System.out.printf("Current balance: $%.2f%n", balance+stockHolding*sd.getCurrentPrice());
	}//end viewBalance
	
	public void viewGraph(ArrayList<Double> history, String account){
		try {
        		String chartConfig = "{type:'line',data:{labels:" + sd.getYears() + ",datasets:[{label:'" + account + "',data:" + history + "}]}}";
        		String encodedConfig = java.net.URLEncoder.encode(chartConfig, java.nio.charset.StandardCharsets.UTF_8);
        		String url = "https://quickchart.io/chart?c=" + encodedConfig;
        		Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", url});
		}catch(Exception e){
			System.out.println(e);
		}//end catch
	}//end viewGraph
	
	public void readNews(){
		int headline = sd.getHeadline();
		String[] headlines = {"Nothing interesting happening in the world","Fears of recession are becoming common","New computing system discovered by NVDA competitor could make current technology obsolete","Cryptocurrency mining boom boosts demand for NVDA GPUs","NVDA faces lawsuit over alleged patent infringement","Recession has been warded off","Fed announces recession","Major flaw found in competitor's new computing system, consumers are flocking back to NVDA","Competitor's new computing system is better than expected, NVDA struggles to adapt and incorporate it", "NVDA lost lawsuit for patent infringement","NVDA won lawsuit for patent infringement"};
		System.out.println(headlines[headline]);
	}//end readNews
}//end Investor
