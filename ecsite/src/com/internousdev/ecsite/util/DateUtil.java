package com.internousdev.ecsite.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate(){
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		return sim.format(date);
	}
}
