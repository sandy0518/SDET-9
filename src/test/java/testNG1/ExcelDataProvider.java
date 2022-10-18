package testNG1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.ExcelFileUtility;

public class ExcelDataProvider {
	
	@Test(dataProvider = "getDataFromExcel")
	public void getCre(String un, String pwd) {
		System.out.println(un +" --> "+ pwd);
	}

	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable {
		ExcelFileUtility eFU= new ExcelFileUtility();
		int rCount = eFU.getLastRowCount("Sheet2");
		System.out.println(rCount);
		Object[][] arr = new Object[rCount+1][2];
		
		
		
		for(int i=0;i<=rCount;i++) {
			arr[i][0]=eFU.readDataFromExcelFile("sheet2", i, 0);
			arr[i][1]=eFU.readDataFromExcelFile("sheet2", i, 1);
		}
		
		return arr;
	}
}
