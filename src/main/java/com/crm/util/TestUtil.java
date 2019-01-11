package com.crm.util;

import com.crm.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long pageLoadTimeout = 30;
	public static long implicitlyWait = 30;
	
	public void switchToFrame()//This is a common method
	{
		driver.switchTo().frame(1);
	}

}
