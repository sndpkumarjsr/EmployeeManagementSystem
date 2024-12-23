package com.employee.jdbc;

public class Employee {

	final int eid;
	String ename;
	double esalary;
	String designation;
	int edeptno;
	static int randnum=101;
	public Employee(String ename, double esalary, String designation, int edeptno) {
		this.eid=randnum++;
		this.ename = ename;
		this.esalary = esalary;
		this.designation = designation;
		this.edeptno = edeptno;
	}
	
	
	
}
