/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Moosa Raza
 */

abstract class Employee{
    protected String firstName;
    protected String lastName;
    protected String socialSecurityNumber;
    public abstract void earning();
    
    // Three para constructor for setting firstname, lastname and ssn
    public Employee(String firstName, String lastName, String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }
    @Override
    public String toString(){
        return firstName + " " + lastName + "\nSocial Security Number: " + socialSecurityNumber;
    }
}

class SalariedEmployee extends Employee{
    double weeklySalary;
    double earned;
    // Three para constructor for setting firstname, lastname and ssn
    SalariedEmployee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }
    @Override
    public void earning(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your weekly salary: ");
        weeklySalary = sc.nextDouble();
        earned = weeklySalary;
    }
    @Override
    public String toString(){
        return "Salaried Employee: " + super.toString() + "\nWeekly Salary: $" + weeklySalary + "\nEarned: $" + earned;
    }
}

class HourlyEmployee extends Employee{
    double hourlyWage;
    double workingHours;
    double earned;
    // Three para constructor for setting firstname, lastname and ssn
    HourlyEmployee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }
    @Override
    public void earning(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your hourly wage: ");
        hourlyWage = sc.nextDouble();
        System.out.print("Enter your working hours: ");
        workingHours = sc.nextDouble();
        if(workingHours <= 40){
            earned = hourlyWage * workingHours;
        }
        else{
            earned = (40 * hourlyWage) + ((workingHours - 40) * hourlyWage * 1.5);
        }
    }
    @Override
    public String toString(){
        return "Hourly Employee: " + super.toString() + "\nHourly Wage: $" + hourlyWage + " " + "Hours Worked: " + workingHours + "\nEarned: $" + earned;
    }
}

class CommissionEmployee extends Employee{
    double commissionRate;
    double earned;
    double grossSales;
    CommissionEmployee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }
    @Override
    public void earning(){
        Scanner sc = new Scanner(System.in);
        commissionRate = 0.06;
        System.out.print("Enter your gross sales: ");
        grossSales = sc.nextDouble();
        earned = grossSales * commissionRate;
    }
    @Override
    public String toString(){
        return "Commission Employee: " + super.toString() + "\nGross Sales: $" + grossSales + " " + "Commission Rate: " + commissionRate + "\nEarned: $" + earned;
    }
}

class BasePlusCommissionEmployee extends CommissionEmployee{
    double commissionRate;
    double grossSales;
    double baseSalary;
    double newBaseSalary, percent;
    double earned;
        
    BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }
    @Override
    public void earning(){
        Scanner sc = new Scanner(System.in);
        commissionRate = 0.04;
        System.out.print("Enter your base salary: ");
        baseSalary = sc.nextDouble();
        percent = (baseSalary * 10) / 100;
        newBaseSalary = baseSalary + percent;
        System.out.print("Enter your gross sales: ");
        grossSales = sc.nextDouble();
        earned = (commissionRate * grossSales) + newBaseSalary;
    }
    @Override
    public String toString(){
        return "Base-Salaried Commission Employee: " + firstName + " " + lastName + "\nSocial Security Number: " + socialSecurityNumber
                + "\nGross Sales: $" + grossSales + " " + "Commission Rate: " + commissionRate + " " +
                "Base Salary: $" + baseSalary + "\nNew base salary with 10% increase is: $" + newBaseSalary + "\nEarned: $" + earned;
    }
}

public class PayrollSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        
        String a = "", b = "", c = "", d = "";
        
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> employee = new ArrayList<>();
        
        for(int i = 0; i < 4; i++){
            System.out.print("Enter your first name: ");
            String firstName = sc.next();
            System.out.print("Enter your last name: ");
            String lastName = sc.next();
            System.out.print("Enter your Social Security Number: ");
            String ssn = sc.next();
            if(i == 0){
                employee.add("Salaried Employee");
                SalariedEmployee obj1 = new SalariedEmployee(firstName, lastName, ssn);
                obj1.earning();
                a = obj1.toString();
                System.out.println("");
            }
            else if(i == 1){
                employee.add("Hourly Employee");
                HourlyEmployee obj2 = new HourlyEmployee(firstName, lastName, ssn);
                obj2.earning();
                b = obj2.toString();
                System.out.println("");
            }
            else if(i == 2){
                employee.add("Commission Employee");
                CommissionEmployee obj3 = new CommissionEmployee(firstName, lastName, ssn);
                obj3.earning();
                c = obj3.toString();
                System.out.println("");
            }
            else{
                employee.add("Base Plus Commission Employee");
                BasePlusCommissionEmployee obj4 = new BasePlusCommissionEmployee(firstName, lastName, ssn); 
                obj4.earning();
                d = obj4.toString();
                System.out.println("");
            }
        }
        
        System.out.println(a);
        System.out.println("");
        System.out.println(b);
        System.out.println("");
        System.out.println(c);
        System.out.println("");
        System.out.println(d);
        System.out.println("");
        
        for(int i = 0; i < 4; i++){
            System.out.println("Employee " + i + " is a " + employee.get(i));
        }
    }
}
