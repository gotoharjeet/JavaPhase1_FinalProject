package com.company.lockers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.company.singleton.ScannerObject;

class Employee
{
	private int eId;
	private String ename;
	private float esal;
	
	Employee(int eid,String ename,float esal )
	{
		this.eId=eid;
		this.ename=ename;
		this.esal=esal;
	}
	
	public int getEid()
	{
		return eId;
	}
	
	public String getEname()
	{
		return ename;
	}
	
	public float getEsal()
	{
		return esal;
	}
	
	public String toString()
	{
		return "Employee Id : "+eId+"\n"
				+"Employee Name : "+ename+"\n"
				+"Employee Salary : "+esal+"\n";
				
	}
}


public class LockedMe {
	public static Scanner obj;
	static
	{
		obj=ScannerObject.getScannerObj();
	}
	public static void display_menu()
	{
		System.out.println("\t**************************************************");
		System.out.println("\t\tProject Name: LockedMe");
		System.out.println("\t\tDeveloper Name : Harjeet Singh Kainth");
		System.out.println("\t**************************************************");
		System.out.println("\t\t1. Display File Names");
		System.out.println("\t\t2. Create File.");
		System.out.println("\t\t3. Delete File.");
		System.out.println("\t\t4. Search File.");
		System.out.println("\t\t5. Exit option");
		
		System.out.println("\t**************************************************");
	}
	
	public static void getFileNames()
	{
	   	File[] file_names=new File("E:\\springframework\\core\\eclipse"
	   			+ "\\Session1\\JavaPhase1_FinalProject\\"
	   			+ "CompanyLockersProject\\src\\com\\company\\lockers\\"
	   			+ "dataFiles").listFiles();
	   	System.out.println("\t\tList of Files");
   		System.out.println("\t\t*************");
	   	for(File fname:file_names)
	   	{	
	   		System.out.println("\t\t"+fname.getName());
	   	}
	   	obj.nextLine();
	   	System.out.flush();
	}
	public static void createFile()
	{
		
		int option=1;
		int eid=0;
		String ename="";
		float esal=0;
		Employee eobj;
		
		
		do {
			System.out.println("\t\t**************************");
			System.out.println("\t\tEnter Employee Id : "+(eid=obj.nextInt()));
			
			System.out.println("\t\tEnter Employee Name : "+(ename=obj.next()));
			System.out.println("\t\tEnter Employee Salary : "+(esal=obj.nextFloat()));						
			eobj=new Employee(eid,ename,esal);
		
		System.out.println(eobj.toString());
			try {
			      // Creates a FileWriter
				FileWriter fw=new FileWriter("E:\\springframework\\core\\eclipse\\Session1\\JavaPhase1_FinalProject\\CompanyLockersProject\\src\\com\\company\\lockers\\dataFiles\\EmployeeDetails.txt",true);

			      // Writes the string to the file
				
				fw.write(eobj.toString());

			      // Closes the writer
				fw.close();
			    }

			    catch (Exception e) {
			      e.printStackTrace();
			    }	
		} while (++option<=4);
	}
	
	
	public static void deleteFile()
	{
		
	}
	public static void searchFile()
	{
		
	}
	public static void main(String[] args) throws Exception{
		
		int menu_option=5;
		
		do
		{
			display_menu();	
			menu_option=obj.nextInt();
			switch(menu_option)
			{
			case 1: getFileNames();break;
			case 2: createFile();break;
			case 3: break;
			case 4: break;
			default: break;
			}
		}while(menu_option <5);
	}

}
