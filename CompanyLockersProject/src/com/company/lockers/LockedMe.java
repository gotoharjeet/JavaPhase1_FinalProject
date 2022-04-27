package com.company.lockers;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
	public static String fname;
	public static File[] file_names=new File("E:\\springframework\\core\\eclipse"
   			+ "\\Session1\\JavaPhase1_FinalProject\\"
   			+ "CompanyLockersProject\\src\\com\\company\\lockers\\"
   			+ "dataFiles").listFiles();
	public static ArrayList<String> list_filenames=new ArrayList<String>();
	static
	{
		obj=ScannerObject.getScannerObj();
	}
	public static void display_msg(String message)
	{
		System.out.println(message);
	}
	
	public static void display_menu()
	{
		//System.out.println("press<Enter> to display Main Menu");
		obj.nextLine();
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
	
	public static void getFileNames() throws InterruptedException
	{
			
	   	System.out.println("\t\tList of Files");
   		System.out.println("\t\t*************");
	   	for(File fname:file_names)
	   	{	
	   		System.out.println("\t\t"+fname.getName());
	   	}
	   	System.out.println("press<Enter>back to Main Menu");
	    obj.nextLine();
	}
	public static void createFile()
	{
		int option=1;
		int eid=0;
		String ename="";
		float esal=0;
		Employee eobj;
		int nrec=0;
		obj.nextLine();
		System.out.println("Enter How many records you want to enter ");
		nrec=obj.nextInt();
		do {
			try
			{
			System.out.println("**************************");
			System.out.println("Enter Employee Id : \n");
			eid=obj.nextInt();
			System.out.println("Enter Employee Name : ");
			ename=obj.next();
			System.out.println("Enter Employee Salary : ");
			esal=obj.nextInt();	
			System.out.println("**************************");	
			}
			catch(InputMismatchException e)
			{
				System.out.println("employee id must be number,Employee Name must be single word, and Employee Salary must be number only");
			}
						eobj=new Employee(eid,ename,esal);
			try {
			      // Creates a FileWriter
				FileWriter fw=new FileWriter("E:\\springframework\\core\\eclipse\\Session1\\JavaPhase1_FinalProject\\CompanyLockersProject\\src\\com\\company\\lockers\\dataFiles\\EmployeeDetails.txt",true);

			      // Writes the string to the file
				
				fw.write(eobj.toString());

			      // Closes the writerEmployee - Copy
				fw.close();
				
			    }

			    catch (Exception e) {
			      e.printStackTrace();
			      
			    }	
		} while (++option<=nrec);
		System.out.println("press<Enter>back to Main Menu");
		obj.nextLine();
	}
	
	
	public static void deleteFile()
	{
		
		//display_msg("**********************************");
		System.out.println("**********************************");
		System.out.println("Enter the File Name to be deleted : ");
		//display_msg("Enter the File Name to be deleted : ");
		System.out.println("**********************************");
		//display_msg("**********************************");
		fname=obj.next();
		System.out.println(fname);
		try
		{
			File file = new File("E:\\springframework\\core\\eclipse\\Session1\\JavaPhase1_FinalProject\\CompanyLockersProject\\src\\com\\company\\lockers\\dataFiles\\"+fname);
		
			if(file.exists())
			{
				file.delete();
				System.out.println("File deleted successfully");
			}
			else
			{
				System.out.println("File does not exist");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("press<Enter>back to Main Menu");
		obj.nextLine();
	}
	public static void searchFile()
	{
		boolean flag=false;
		//obj.nextLine();
		System.out.println("**********************************");
		System.out.println("Enter the File Name to be searched : ");
		System.out.println("**********************************");
		fname=obj.next();
		System.out.println(fname);
		
		for(File fn:file_names)
		{
			list_filenames.add(fn.getName());
		}
		
		if(list_filenames.contains(fname))
		{
			System.out.println("File is available");
			System.out.println("press<Enter>back to Main Menu");
			obj.nextLine();
		}
		else
		{
			System.out.println("File does not exist");
			System.out.println("press<Enter>back to Main Menu");
			obj.nextLine();
		}
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
			case 3: deleteFile();break;
			case 4: searchFile();break;
			case 5: System.exit(0);
			default: break;
			}
		}while(menu_option <5);
	}
}

