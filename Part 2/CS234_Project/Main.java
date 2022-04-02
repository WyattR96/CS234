package CS234_Project;


import java.util.Scanner;

public class Main {

    /**
     * This method creates dummy data then calls the main menu method.
     */
    public static void main(String[] args){

        Employees.addEmployee("Wyatt Robinson",60000);
        Employees.addEmployee("John Smith",65000);
        Employees.addEmployee("John Doe",55555);
        Employees employee = Employees.getEmployeeList().get(2);
        Employees employee2 = Employees.getEmployeeList().get(1);
        Employees employee3 = Employees.getEmployeeList().get(0);

        Cars.addCar("Ford","Ranger");
        Cars.addCar("Toyota","Hilux");
        Cars.addCar("Chevrolet","Silverado");

        Cars car = Cars.getCarsList().get(1);
        Cars car2 = Cars.getCarsList().get(2);
        Cars car3 = Cars.getCarsList().get(0);

        Clients.addClient("Jane Doe", car);
        Clients.addClient("asdf asdfson", car2);
        Clients.addClient("Josh Smithson", car3);
        Clients client = Clients.getClientsList().get(1);
        Clients client2 = Clients.getClientsList().get(0);
        Clients client3 = Clients.getClientsList().get(2);

        Appointments.addAppointment(client, employee, "02/22/2022");
        Appointments.addAppointment(client2, employee2, "08/21/2022");
        Appointments.addAppointment(client3, employee3, "08/22/2022");

        Services.addService(employee,client,"Engine blew up lol", 6000);
        Services.addService(employee2,client2,"I drove it for 5000 miles without oil", 50000);
        Services.addService(employee3,client3,"I spilled baked beans all over the dash", 500);

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
            System.out.println("6. Quit");

            int input = intInputValidation();

            switch(input) {
                case 1: employeeMenu();
                    break;
                case 2: carsMenu();
                    break;
                case 3: clientsMenu();
                    break;
                case 4: servicesMenu();
                    break;
                case 5: appointmentsMenu();
                    break;
                case 6: System.exit(0);
                    break;
                case 7: default: System.out.println(
                        "You typed "+ input + "\ninvalid input");
                    break;
            }
            System.out.println("----------------");
        }
    }

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
            System.out.println("5. Go back");
            System.out.println("6. Quit");

            int input = intInputValidation();

            switch(input) {
                case 1: Employees.addEmployeeOptions();
                    break;
                case 2: Employees.listEmployees();
                    break;
                case 3: Employees.updateEmployeeOptions();
                    break;
                case 4: Employees.removeEmployee();
                    break;
                case 5: menu();
                    break;
                case 6: System.exit(0);
                    break;
                case 7: default: System.out.println(
                        "You typed "+ input + "\ninvalid input");
                    break;
            }
            System.out.println("----------------");
        }
    }

    /**
     * This method builds a menu to access everything having to do with the Cars class.
     */
    public static void carsMenu(){

        while(true){
            System.out.println("\nWhat would you like to do:");
            System.out.println("1. Add car");
            System.out.println("2. List cars");
            System.out.println("3. Update car");
            System.out.println("4. Remove car");
            System.out.println("5. Go back");
            System.out.println("6. Quit");

            int input = intInputValidation();

            switch(input) {
                case 1: Cars.addCarOptions();
                    break;
                case 2: Cars.listCars();
                    break;
                case 3: Cars.updateCar();
                    break;
                case 4: Cars.removeCar();
                    break;
                case 5: menu();
                    break;
                case 6: System.exit(0);
                    break;
                case 7: default: System.out.println(
                        "You typed "+ input + "\ninvalid input");
                    break;
            }
            System.out.println("----------------");
        }
    }

    /**
     * This method builds a menu in order to access everything having to do with the Clients class.
     */
    public static void clientsMenu(){

        while(true){
            System.out.println("\nWhat would you like to do:");
            System.out.println("1. Add client");
            System.out.println("2. List clients");
            System.out.println("3. Update client");
            System.out.println("4. Remove client");
            System.out.println("5. Go back");
            System.out.println("6. Quit");

            int input = intInputValidation();

            switch(input) {
                case 1: Clients.addClientOptions();
                    break;
                case 2: Clients.listClients();
                    break;
                case 3: Clients.updateClient();
                    break;
                case 4: Clients.removeClient();
                    break;
                case 5: menu();
                    break;
                case 6: System.exit(0);
                    break;
                case 7: default: System.out.println(
                        "You typed "+ input + "\ninvalid input");
                    break;
            }
            System.out.println("----------------");
        }
    }

    /**
     * This method builds a menu to access every method dealing with the Services class.
     */
    public static void servicesMenu(){

        while(true){
            System.out.println("\nWhat would you like to do:");
            System.out.println("1. Create service");
            System.out.println("2. Service report");
            System.out.println("3. Update service");
            System.out.println("4. Remove service");
            System.out.println("5. Go back");
            System.out.println("6. Quit");

            int input = intInputValidation();

            switch(input) {
                case 1: Services.addServicesOptions();
                    break;
                case 2: Services.listServices();
                    break;
                case 3: Services.updateService();
                    break;
                case 4: Services.removeService();
                    break;
                case 5: menu();
                    break;
                case 6: System.exit(0);
                    break;
                case 7: default: System.out.println(
                        "You typed "+ input + "\ninvalid input");
                    break;
            }
            System.out.println("----------------");
        }
    }

    /**
     * This method builds a menu to access everything having to do with the Appointments class.
     */
    public static void appointmentsMenu(){

        while(true){
            System.out.println("\nWhat would you like to do:");
            System.out.println("1. Create appointment");
            System.out.println("2. List appointments");
            System.out.println("3. Update appointment");
            System.out.println("4. Remove appointment");
            System.out.println("5. Go back");
            System.out.println("6. Quit");

            int input = intInputValidation();

            switch(input) {
                case 1: Appointments.addAppointmentOptions();
                    break;
                case 2: Appointments.listAppointments();
                    break;
                case 3: Appointments.updateAppointment();
                    break;
                case 4: Appointments.removeAppointment();
                    break;
                case 5: menu();
                    break;
                case 6: System.exit(0);
                    break;
                case 7: default: System.out.println(
                        "You typed "+ input + "\ninvalid input");
                    break;
            }
            System.out.println("----------------");
        }
    }

    /**
     * This method is used to make sure the user inputs a string. Used mainly for names.
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
}