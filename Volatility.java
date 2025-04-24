import java.util.*;

public class Volatility{
	protected double varianceAdjustment = 0;
	protected double meanAdjustment = 0;
	protected int timeSinceRecession = 1;
	protected int oldHeadline;
	protected int currentHeadline;

	public double getVarianceAdjustment(){
		return varianceAdjustment;
	}//end getVarianceAdjustment
	
	public double getMeanAdjustment(){
		return meanAdjustment;
	}//end getMeanAdjustment
	
	public void adjustHeadline(){
		Random rand = new Random();
		double randomNum = rand.nextDouble();
		if(oldHeadline == 1){
			if(randomNum < 4/timeSinceRecession){
				currentHeadline = 5;
			}else{
				currentHeadline = 6;
				timeSinceRecession = 0;
			}//end if
		}else if(oldHeadline == 2){
			if(randomNum > .75){
				currentHeadline = 7;
			}else{
				currentHeadline = 8;
			}//end if
		}else if(oldHeadline == 4){
			if(randomNum < .75){
				currentHeadline = 9;
			}else{
				currentHeadline = 10;
			}//end if
		}else{
			if(randomNum < .5){
				currentHeadline = 0;
			}else if(randomNum < .625){
				currentHeadline = 1;
			}else if(randomNum < .75){
				currentHeadline = 2;
			}else if(randomNum < .875){
				currentHeadline = 3;
			}else{
				currentHeadline = 4;
			}//end if
		}//end if
		timeSinceRecession += 1;
		oldHeadline = currentHeadline;
	}//end adjustHeadline

	public int getHeadline(){
		return currentHeadline;
	}//end getHeadline
	
	public void applyHeadline(){
		if(currentHeadline == 0){
			meanAdjustment = 0;
			varianceAdjustment = 0;
		}else if(currentHeadline == 1 || currentHeadline == 2 || currentHeadline == 4){
			meanAdjustment = 0;
			varianceAdjustment = .2;
		}else if(currentHeadline == 3 || currentHeadline == 5 || currentHeadline == 7 || currentHeadline == 10){
			meanAdjustment = .1;
			varianceAdjustment = -.3;
		}else{
			meanAdjustment = -.4;
			varianceAdjustment = -.3;
		}//end if
	}//end applyHeadline
}// end Volatility
