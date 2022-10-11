package genericUtility;

import java.util.Random;

public class JavaUtility {
	public static int generateRanNum() {
		Random r =new Random();
		int ranNum = r.nextInt(1000);
		return ranNum;
	}
}
