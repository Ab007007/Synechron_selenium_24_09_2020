package com.synechron.actitime.basic.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

	
	
	 @DataProvider
	  public Object[][] customer_data()
	  {
	    return new Object[][] {
//	      new Object[] { "Syn-Customer_25_09_10", "Syn-Customer_25_09_10_Desc" },
//	      new Object[] { "Syn-Customer_25_09_5", "Syn-Customer_25_09_5_Desc" },
//	      new Object[] { "Syn-Customer_25_09_6", "Syn-Customer_25_09_6_Desc" },
	      new Object[] { "Syn-Customer_25_09_7", "Syn-Customer_25_09_7_Desc" },
	      new Object[] { "Syn-Customer_25_09_8", "Syn-Customer_25_09_8_Desc" },
	      new Object[] { "Syn-Customer_25_09_9", "Syn-Customer_25_09_9_Desc" },
	    };
	  }
	 
	 
	 @DataProvider
	  public Object[][] project_data()
	  {
	    return new Object[][] {
	      new Object[] { "Syn-Customer_25_09_10", "Project-1" , "Project-1_Desc" },
	      new Object[] { "Syn-Customer_25_09_10", "Project-2" , "Project-2_Desc" },
	      new Object[] { "Syn-Customer_25_09_10", "Project-3" , "Project-3_Desc" },
	      new Object[] { "Syn-Customer_25_09_10", "Project-4" , "Project-4_Desc" },
	     
	    };
	  }
}
