package com.medicover.hms.generic.fileutility;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random=new Random();
		int ranDomNumber = random.nextInt(5000);
		return ranDomNumber;
	}
	
	public String getRequiredDateYYYYMMDD(int days) {   //if u pass + int data so it will give you after and if - then previous
 //if u want required date maybe either befor- or after+, then pass the argument
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
}
