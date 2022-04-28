package CS234_Project;

import java.util.ArrayList;

/**
 * This class handles the creation, reading, updating and deleting of employee objects. It also has a method for
 * creating a report that shows the cost of all the employees.
 */
class Employees {

    private static final ArrayList<Employees> employeeList = new ArrayList<>();

    private String EmployeeName;
    private double EmployeeSalary;

    //Constructor
    public Employees(String name, double salary){
        this.EmployeeName = name;
        this.EmployeeSalary = salary;
    }

    //Getters, setters and toString
    public static ArrayList<Employees> getEmployeeList(){return employeeList;}

    public void setEmployeeName(String name){this.EmployeeName = name;}

    public void setEmployeeSalary(double salary){this.EmployeeSalary = salary;}

    public String getEmployeeName(){return this.EmployeeName;}

    public double getEmployeeSalary(){return this.EmployeeSalary;}


    //Overrides the standard toString method
    public String toString(){return this.getEmployeeName();}

    /**
     * This method builds the menu to access all methods having to do with the Employees class.
     */
    public static void employeeMenu(){

        while(true){
            System.out.println("\nWhat would you like to do:");
            System.out.println("1. Add employee");
            System.out.println("2. List employees");
            System.out.println("3. Update employee");
            System.out.println("4. Remove employee");
            System.out.println("5. Search employees");
            System.out.println("6. Go back");
            System.out.println("7. Quit");

            int input = Main.intInputValidation();

            switch(input) {
                case 1: addEmployeeOptions();
                    break;
                case 2: listEmployees();
                    break;
                case 3: updateEmployee();
                    break;
                case 4: removeEmployee();
                    break;
                case 5: searchEmployee();
                    break;
                case 6: Main.menu();
                    break;
                case 7: System.exit(0);
                    break;
                case 8: default: System.out.println(
                        "You typed "+ input + "\ninvalid input");
                    break;
            }
            System.out.println("----------------");
        }
    }

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
            System.out.println(
                    employeeIndex + " Name:" + employee.getEmployeeName() + "| Salary: $" + employee.getEmployeeSalary()
            );
            employeeIndex++;
        }
    }

    /**
     * This method asks for an employees name to update then calls the update employee method to save the changes.
     */
    public static void updateEmployee(){
        listEmployees();
        System.out.println("Type the number of the employee you would like to update:");
        int employeeSelection = Main.arrayInRangeCheck(getEmployeeList());
        Employees employee = getEmployeeList().get(employeeSelection);

        System.out.println("What would you like to update about this employee:");
        System.out.println("1. Their name");
        System.out.println("2. Their salary");
        System.out.println("3. Cancel");
        int selection = Main.intInputValidation();

        switch(selection){
            case 1:
                System.out.println("Write the employees updated name");
                String newName = Main.stringInputValidation();

                employee.setEmployeeName(newName);
                System.out.println("Employee updated successfully");
                break;

            case 2:
                System.out.println("Write the employees new salary");
                double newSalary = Main.doubleInputValidation();

                employee.setEmployeeSalary(newSalary);
                System.out.println("Employee updated successfully");
                break;

            case 3:
                employeeMenu();
                break;

            case 4:
                default:
                System.out.println("invalid input");
                break;
        }
    }

    /**
     * This method asks for an employee name then removes it from employeeList.
     */
    public static void removeEmployee(){
        listEmployees();
        System.out.println("Write the number of the employee you would like removed:");
        int employeeSelection = Main.arrayInRangeCheck(getEmployeeList());

        getEmployeeList().remove(employeeSelection);
        System.out.println("Employee removed successfully");
    }

    /**
     * Creates a report of the cost of all the employees combined
     */
    public static double employeeCostReport(){
        double sum = 0;

        for(Employees employee: getEmployeeList()){
            System.out.println(employee.getEmployeeName() + "| Salary: $" + employee.getEmployeeSalary());
            sum += employee.getEmployeeSalary();
        }

        System.out.print("Total employee salaries paid: $");
        System.out.printf("%.2f", sum);
        System.out.println("\n");
        return sum;
    }

    /**
     * This method is used to search for an employee. It asks the user to input the name and searches employeeList for
     * any occurrences of that name.
     */
    public static void searchEmployee(){
        System.out.println("Write the name of the employee you are searching for:");
        String search = Main.stringInputValidation();

        for(int i = 0; i < getEmployeeList().size();){

            if(getEmployeeList().get(i).getEmployeeName().equalsIgnoreCase(search)){
                Employees employee = getEmployeeList().get(i);
                System.out.println(
                        "Name: " + employee.getEmployeeName() + " | Salary: " + employee.getEmployeeSalary()
                );
                break;
            }else{
                i++;
            }
        }
    }
}