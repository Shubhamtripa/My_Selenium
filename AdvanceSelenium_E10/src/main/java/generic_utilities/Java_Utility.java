package generic_utilities;

import java.util.Random;

public class Java_Utility {
	/**
	 * This method is use to avoid Duplicate
	 * @retrun
	 * @author Shubham
	 */
public int	getRandomNum() {
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	return ranNum;
}

}
