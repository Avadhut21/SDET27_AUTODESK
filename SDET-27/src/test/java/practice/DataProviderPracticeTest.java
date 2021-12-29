package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {
	@Test(dataProvider = "getData")
		
	public void readDataProviderPracticeTest(String Name,int qty) 
	{
		System.out.println("Mobile name----->"+Name+"Mobile Qty---->"+qty);
	}
	@DataProvider
	public Object [][] getData()
	{
		Object[][] Objarr = new Object[3][2];
		
		Objarr[0][0] ="Iphone";
		Objarr[0][1] =10;
		
		Objarr[1][0] ="vivo";
		Objarr[1][1] =20;
		
		Objarr[2][0] ="samsumg";
		Objarr[2][1] =13;
		
		return Objarr;
		
	}
		
	}


