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

    //Overrides the standard toString method
    public String toString(){return "Name: " + this.getEmployeeName() + " | Salary: $" + this.getEmployeeSalary();}


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
        getEmployeeList().add(newEmployee);
        System.out.println("employee added successfully");
    }

    /**
     * This method takes employeeList and prints its contents.
     */
    public static void listEmployees(){
        int employeeIndex = 0;
        for (Employees employee :employeeList){
            System.out.println(employeeIndex + " " + employee);
            employeeIndex++;
        }
    }

    /**
     * This method asks for an employees name to update then calls the update employee method to save the changes.
     */
    public static void updateEmployee(){

        System.out.println("Which employee would you like to update:");
        listEmployees();
        int employeeSelection = Main.intInputValidation();
        int employeeIndex = Main.arrayInRangeCheck(getEmployeeList(),employeeSelection);

        Employees employee = getEmployeeList().get(employeeIndex);

        System.out.println("Write the employees new salary");
        double newSalary = Main.doubleInputValidation();

        employee.setEmployeeSalary(newSalary);
        System.out.println("Employee updated successfully");
    }



    /**
     * This method asks for an employee name then removes it from employeeList.
     */
    public static void removeEmployee(){

        System.out.println("Which employee would you like to remove:");
        listEmployees();
        int employeeSelection = Main.intInputValidation();

        int employeeIndex = Main.arrayInRangeCheck(getEmployeeList(),employeeSelection);

        getEmployeeList().remove(employeeIndex);
        System.out.println("Employee removed successfully");
    }
}