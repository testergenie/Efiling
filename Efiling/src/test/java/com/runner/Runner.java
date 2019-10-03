package com.runner;
import org.testng.TestNG;


import Admin_Module.*;
import GSTR1.Login;
import GSTR1.Upload;
//import Admin_Module.SP_Role_Mapping;
import Rough.Rough1;
import reconciliation.ReconciliationProduct;

public class Runner {
	public static TestNG testNG;
	public static void main(String[] args) {
	
		try {
			testNG = new TestNG();
			testNG.setTestClasses(new Class[] {ReconciliationProduct.class});
			testNG.run();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
}
}
