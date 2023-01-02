package testNG2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideTest {
	@Test(dataProvider = "getData")
	public void bookingTickets(String src, String dest) {
		System.out.println(src+ " ---> " +dest);
	}

	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] arr = new Object[3][2];
		
		arr[0][0]="hyd";
		arr[0][1]="bng";
		
		arr[1][0]="hyd";
		arr[1][1]="bom";
		
		arr[2][0]="hyd";
		arr[2][1]="mas";
		
		return arr;
	}
}
