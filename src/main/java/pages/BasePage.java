package pages;

import java.util.Random;


public class BasePage {
	
	public int generateRandomNum(int i) {
		Random radom = new Random();
		int generatedNum = radom.nextInt(999);
		return generatedNum;
		
	}

}
