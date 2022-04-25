package com.company.singleton;

import java.util.Scanner;

public class ScannerObject {
	
	private static Scanner obj=null;
	
	private ScannerObject()
	{
		
	}
	
	public static Scanner getScannerObj()
	{
		if (obj == null)
			obj=new Scanner(System.in);
		return obj;
	}

}
