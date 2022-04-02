package CS234_Project;

import java.util.*;

public class Employees {

    //TODO: make employeeList be of type hashmap, and instead of salary make an employee ID system
    private static Collection<Employees> employeeList = new ArrayList<>();

    private String EmployeeName;
    private double EmployeeSalary;

    //Constructor
    public Employees(String name, double salary){
        this.EmployeeName = name;
        this.EmployeeSalary = salary;
    }

    //Getters, setters and toString
    public void setEmployeeName(String name){this.EmployeeName = name;}

    public void setEmployeeSalary(double salary){this.EmployeeSalary = salary;}

    public String getEmployeeName(){return this.EmployeeName;}

    public double getEmployeeSalary(){return this.EmployeeSalary;}

    public static ArrayList<Employees> getEmployeeList(){return (ArrayList<Employees>) employeeList;}

    public String toString(){return "Name: " + this.getEmployeeName() + " | Salary: " + this.getEmployeeSalary();}


    /**
     * This method gets a name and salary then creates a new employee object, saving it employeeList.
     */
    public static void addEmployeeOptions(){
        System.out.println("Write the employees name:");
        String name = Main.stringInputValidation();

        System.out.println("Write the employees salary:");
        double salary = Main.doubleInputValidation();

        addEmployee(name,salary);
    }

    /**
     * Creates a new object of type employee and adds it to employeeList.
     * @param name employees name
     * @param salary employees salary
     */
    public static void addEmployee(String name,double salary){
        Employees newEmployee = new Employees(name,salary);
        employeeList.add(newEmployee);
    }

    /**
     * This method takes employeeList and prints its contents.
     */
    public static void listEmployees(){for (Employees employee :employeeList) System.out.println(employee);}

    /**
     * This method asks for an employees name to update then calls the update employee method to save the changes.
     */
    public static void updateEmployeeOptions(){
        //TODO
    }


    /**
     * This method asks for an employee name then removes it from employeeList.
     */
    public static void removeEmployee(){
        //TODO
    }
}