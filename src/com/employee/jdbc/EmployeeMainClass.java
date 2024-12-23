package com.employee.jdbc;

import java.util.Scanner;

public class EmployeeMainClass {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		EmployeeOperation eo=new EmployeeOperation();
//		eo.createDatabase("emp_db");
//		eo.createtable("employee");
		boolean flag=false;
		int id=eo.fetchEmployeeId();;
//		System.out.println(id);
		while(true)
		{
			System.out.println("Press 1 to Add a Employee");
			System.out.println("Press 2 to Update Name of Employee");
			System.out.println("Press 3 to Update Designation of Employee");
			System.out.println("Press 4 to Update salary of Employee");
			System.out.println("Press 5 to Fetch a Detail of Particular Employee ");
			System.out.println("Press 6 to fetch a Details of Employee");
			System.out.println("Press 7 to Delete the Employee");
			System.out.println("Press 8 to Exits");
			System.out.println("\n Enter a Option");
			byte num=scn.nextByte();
			switch(num) {
			
			case 1:System.out.println("Enter a Employee Name");
					String ename=scn.next();
					System.out.println("Enter a Employee Salary");
					double esal=scn.nextDouble();
					System.out.println("Enter a Employee Designation");
					String job=scn.next();
					eo.addEmp(++id, ename, esal, job);
					break;
				
			case 2:System.out.println("Enter a id of Employee");
					int eid=scn.nextInt();
					System.out.println("Enter a Name of Employee");
					ename=scn.next();
					eo.updateEmpName(eid, ename);
					break;
				
			case 3:System.out.println("Enter a id of Employee");
					eid=scn.nextInt();
					System.out.println("Enter a Designation of Employee");
					job=scn.next();
					eo.updateEmpJob(eid, job);
					break;
			case 4:System.out.println("Enter a id of Employee");
					eid=scn.nextInt();
					System.out.println("Enter a Salary of Employee");
					esal=scn.nextInt();
					eo.updateEmpSal(eid, esal);
					break;
				
			case 5:System.out.println("Enter a id of Employee");
					eid=scn.nextInt();
					eo.fetchParticularRecord(eid);
					System.out.println();
					System.out.println("==============================");
					System.out.println();
					break;
				
			case 6:eo.fetchAllRecord();
					System.out.println("==============================");
					System.out.println();
					break;
				
			case 7:System.out.println("Enter a id of Employee");
					eid=scn.nextInt();
					eo.deleteEmp(eid);
					break;
				
			case 8:System.out.println("Exit");
					flag=true;
					break;
	
				default:System.out.println("Invalid Option");
			}
			if(flag) {
				break;
			}
		}

		

	}

}
