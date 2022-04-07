package CS234_Project;

import java.util.List;
import java.util.Scanner;

/**
 * This class is the entry point for the program, it handles creating dummy data and then calls the main menu. It also
 * has methods for input validation as well as for anything else that wasn't large enough to justify its own class.
 */
class Main {

    /**
     * This method creates dummy data then calls the main menu method.
     */
    public static void main(String[] args){
        
        Employees.addEmployee("Wyatt Robinson",60000);
        Employees.addEmployee("John Smith",65000);
        Employees.addEmployee("John Doe",55555);
        Employees.addEmployee("Jane smith",88888.88);
        Employees.addEmployee("Mechanic McMechanicson", 4.25);
        Employees.addEmployee("SomeName Nameson",44444);

        Employees employee = Employees.getEmployeeList().get(0);
        Employees employee2 = Employees.getEmployeeList().get(1);
        Employees employee3 = Employees.getEmployeeList().get(2);
        Employees employee4 = Employees.getEmployeeList().get(3);
        Employees employee5 = Employees.getEmployeeList().get(4);
        Employees employee6 = Employees.getEmployeeList().get(5);


        Cars.addCar("Ford","Ranger");
        Cars.addCar("Toyota","Hilux");
        Cars.addCar("Chevrolet","Silverado");
        Cars.addCar("Ford","Mustang");
        Cars.addCar("Chevrolet","Camaro");
        Cars.addCar("Nissan","Armada");

        Cars car = Cars.getCarsList().get(0);
        Cars car2 = Cars.getCarsList().get(1);
        Cars car3 = Cars.getCarsList().get(2);
        Cars car4 = Cars.getCarsList().get(3);
        Cars car5 = Cars.getCarsList().get(4);
        Cars car6 = Cars.getCarsList().get(5);


        Clients.addClient("Jane Doe", car);
        Clients.addClient("asdf asdfson", car2);
        Clients.addClient("Josh Smithson", car3);
        Clients.addClient("xX_CarWrecker47_Xx", car4);
        Clients.addClient("dummy mcdatason",car5);
        Clients.addClient("Persons Name",car6);

        Clients client = Clients.getClientsList().get(0);
        Clients client2 = Clients.getClientsList().get(1);
        Clients client3 = Clients.getClientsList().get(2);
        Clients client4 = Clients.getClientsList().get(3);
        Clients client5 = Clients.getClientsList().get(4);
        Clients client6 = Clients.getClientsList().get(5);


        Appointments.addAppointment(client, employee, "02/22/2022");
        Appointments.addAppointment(client2, employee2, "08/21/2022");
        Appointments.addAppointment(client3, employee3, "08/22/2022");
        Appointments.addAppointment(client4,employee4,"4/30/2022");
        Appointments.addAppointment(client5,employee5,"4/18/2222");
        Appointments.addAppointment(client6,employee6,"4/31/2024");

        Services.addService(employee,client,"Engine blew up lol", 6000);
        Services.addService(employee2,client2,"I drove it for 5000 miles without oil", 50000);
        Services.addService(employee3,client3,"I spilled baked beans all over the dash", 500);
        Services.addService(employee4,client4,"I wrecked my car for the third time this week",100000);
        Services.addService(employee5,client5,"I put a bowling ball in the trunk and now it sounds like theres a bowling ball in the trunk, please tell me why it sounds like that.",5.00);
        Services.addService(employee6,client6,"My car is currently on fire",30000);

        System.out.println("\n***Dummy data added***\n");

        menu();
    }

    /**
     * This method builds the main menu to access the rest of the program.
     */
    public static void menu(){

        while(true){
            System.out.println("\nWhat would you like to access:");
            System.out.println("1. Employees");
            System.out.println("2. Cars");
            System.out.println("3. Clients");
            System.out.println("4. Services");
            System.out.println("5. Appointments");
            System.out.println("6. Reports");
            System.out.println("7. Quit");

            int input = intInputValidation();

            switch(input) {
                case 1: Employees.employeeMenu();
                    break;
                case 2: Cars.carsMenu();
                    break;
                case 3: Clients.clientsMenu();
                    break;
                case 4: Services.servicesMenu();
                    break;
                case 5: Appointments.appointmentsMenu();
                    break;
                case 6: Reports();
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
     * This method gets the total amount made from the services and subtracts the amount needed to keep all employees
     * giving the user the total profits of the garage.
     * @return total profit
     */
    public static void Reports(){

        while(true) {
            System.out.println("What report would you like to print:");
            System.out.println("1. Employee cost report");
            System.out.println("2. Services income report");
            System.out.println("3. Total profit report");
            System.out.println("4. Go back");
            int input = intInputValidation();

            switch (input) {
                case 1:
                    Employees.employeeCostReport();
                    break;

                case 2:
                    Services.serviceReport();
                    System.out.println("\n");
                    break;

                case 3:
                    double employeeCost = Employees.employeeCostReport();
                    double servicesIncome = Services.serviceReport();
                    double total = servicesIncome-employeeCost;
                    String totalString = String.format("%.2f",total);

                    if(servicesIncome-employeeCost >= 0){
                        System.out.println("\nTotal profits: $" + totalString + "\n");
                    }else{
                        System.out.println("\nTotal loss: $" + totalString + "\n");
                    }

                    break;

                case 4: menu(); break;

                case 5: default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    /*
    All methods below this are used for input validation, mainly used to reduce the amount of code that all does similar
    operations in the main objects.
     */

    /**
     * This method is used to make sure the user inputs a string.
     * @return the string
     */
    public static String stringInputValidation() {
        
        Scanner x = new Scanner(System.in);

        while (!x.hasNextLine()) {
            System.out.println("invalid input");
            x.next();
        }

        return x.nextLine();
    }

    /**
     * This method makes sure the user inputs an int.
     * @return the int
     */
    public static int intInputValidation(){

        Scanner x = new Scanner(System.in);

        while(!x.hasNextInt()){
            System.out.println("invalid input, input must be an integer");
            x.next();
        }

        return x.nextInt();
    }

    /**
     * This is used to make sure the user inputs a double
     * @return the double
     */
    public static double doubleInputValidation(){

        Scanner x = new Scanner(System.in);

        while(!x.hasNextDouble()){
            System.out.println("invalid input, input must be a number");
            x.next();
        }

        return x.nextDouble();
    }

    /**
     * This is used to check if an integer is in the range of an arraylist. if the arrayList has no entries it falls
     * back to the main menu.
     * @param arr the desired array
     * @param num the number to be checked
     * @return the number if it is smaller than the arraylists size
     */
    public static int arrayInRangeCheck(List<?> arr){

        Scanner x = new Scanner(System.in);

        while(!x.hasNextInt()){
            System.out.println("invalid input, input must be an integer");
            x.next();
        }
        int num = x.nextInt();

        if(arr.size() <= 0){
            //HALT_AND_CATCH_FIRE
            System.out.println("\n***LIST HAS NO ENTRIES***");
            System.out.println("FALLING BACK TO MAIN MENU");
            menu();
        }

        while(num >= arr.size() || num < 0) {

            System.out.println("Input must be a non-negative number " + (arr.size()-1) + " or less");
            while (!x.hasNextInt()) {
                System.out.println("invalid input");
                x.next();
            }
            num = x.nextInt();
        }
            return num;
        }
    }