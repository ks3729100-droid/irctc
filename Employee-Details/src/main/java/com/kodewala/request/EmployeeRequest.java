package com.kodewala.request;

public class EmployeeRequest {
	
	 private String employeeName;
	 private String department;
	 private String designation;
	 private double salary;
	 private String email;
	 
	 public String getEmployeeName() {
		 return employeeName;
	 }
	 public void setEmployeeName(String employeeName) {
		 this.employeeName = employeeName;
	 }
	 public String getDepartment() {
		 return department;
	 }
	 public void setDepartment(String department) {
		 this.department = department;
	 }
	 public String getDesignation() {
		 return designation;
	 }
	 public void setDesignation(String designation) {
		 this.designation = designation;
	 }
	 public double getSalary() {
		 return salary;
	 }
	 public void setSalary(double salary) {
		 this.salary = salary;
	 }
	 public String getEmail() {
		 return email;
	 }
	 public void setEmail(String email) {
		 this.email = email;
	 }
	
}
