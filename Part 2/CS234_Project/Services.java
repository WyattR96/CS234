package CS234_Project;

import java.util.ArrayList;

/**
 * This class handles the creation, reading, updating and deleting of objects of class Services. It also creates a
 * report of all the money gained from the services.
 */
class Services {

    private static final ArrayList<Services> servicesList = new ArrayList<>();

    private Employees AssignedEmployee;
    private Clients Client;
    private String Service;
    private double ServiceCost;

    //Constructor
    public Services(Employees employee, Clients client, String service, double cost){
        this.AssignedEmployee = employee;
        this.Client = client;
        this.Service = service;
        this.ServiceCost = cost;
    }

    //Getters and setters
    public static ArrayList<Services> getServicesList(){return servicesList;}

    public void setEmployee(Employees employee){ this.AssignedEmployee = employee; }

    public Employees getEmployee(){ return this.AssignedEmployee; }

    public void setClient(Clients client){ this.Client = client; }

    public Clients getClient(){ return this.Client; }

    public void setCarService(String service){ this.Service = service; }

    public String getCarService(){ return this.Service; }

    public void setServiceCost(double cost){ this.ServiceCost = cost; }

    public double getServiceCost(){ return this.ServiceCost; }

    //Overrides the standard toString method
    public String toString(){
        return "Assigned employee: " + this.getEmployee() + "\n" + this.getClient() +
                "\nProblem: " + this.getCarService() +
                "\nCost: $" + this.getServiceCost() +
                "\n" ;
    }

    /**
     * This method builds a menu to access every method dealing with the Services class.
     */
    public static void servicesMenu(){

        while(true){
            System.out.println("\nWhat would you like to do:");
            System.out.println("1. Create service");
            System.out.println("2. List services");
            System.out.println("3. Update service");
            System.out.println("4. Remove service");
            System.out.println("5. Go back");
            System.out.println("6. Quit");

            int input = Main.intInputValidation();

            switch(input) {
                case 1: Services.addServicesOptions();
                    break;
                case 2: Services.listServices();
                    break;
                case 3: Services.updateService();
                    break;
                case 4: Services.removeService();
                    break;
                case 5: Main.menu();
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
     * This method gets the users input for an employee a client a service and the service cost, then calls to
     * addService().
     */
    public static void addServicesOptions(){
        System.out.println("Which employee will be performing the service:");
        Employees.listEmployees();
        int employeeIndex = Main.arrayInRangeCheck(Employees.getEmployeeList());

        Employees employee = Employees.getEmployeeList().get(employeeIndex);

        System.out.println("Which client will be receiving the service:");
        Clients.listClients();
        int clientIndex = Main.arrayInRangeCheck(Clients.getClientsList());

        Clients client = Clients.getClientsList().get(clientIndex);

        System.out.println("What does the client say is wrong with their vehicle:");
        String service = Main.stringInputValidation();

        System.out.print("What is the estimated cost of this service:\n$");
        double cost = Main.doubleInputValidation();

        addService(employee,client,service,cost);
    }

    /**
     * This method takes an employee a client a service and a service cost to create a new object of type service, it
     * then adds that service to servicesList
     * @param employee The employee performing the service
     * @param client The client whose car is being serviced
     * @param service The service being performed
     * @param serviceCost The cost of the service
     */
    public static void addService(Employees employee, Clients client,String service, double serviceCost){
        Services newService = new Services(employee,client,service,serviceCost);
        getServicesList().add(newService);
        System.out.println("Service added successfully");
    }

    /**
     * This method lists all services
     */
    public static void listServices(){
        int serviceIndex = 0;
        for(Services service: servicesList){
            System.out.println("Service number: " + serviceIndex + "\n" + service);
            serviceIndex++;
        }
    }

    /**
     * This method lists services, asking which one to update, it then asks what needs to be updated in the service.
     * it then gets the users input on what to update and changes elements of the service as needed.
     */
    public static void updateService(){
        listServices();
        System.out.println("Type the service number you would like to update:");
        int serviceIndex = Main.arrayInRangeCheck(getServicesList());
        Services service = getServicesList().get(serviceIndex);


        System.out.println("What would you like to update about this service:");
        System.out.println("1. Assigned employee");
        System.out.println("2. The client");
        System.out.println("3. The service being performed");
        System.out.println("4. The service cost");
        System.out.println("5. Cancel");
        int selection = Main.intInputValidation();

        switch(selection){

            case 1:
                System.out.println("Which employee is now assigned to this service:");
                Employees.listEmployees();
                int employeeSelection = Main.arrayInRangeCheck(Employees.getEmployeeList());

                Employees employee = Employees.getEmployeeList().get(employeeSelection);

                service.setEmployee(employee);
                System.out.println("Assigned employee updated successfully");
                break;

            case 2:
                System.out.println("Which client is now assigned to this service:");
                Clients.listClients();
                int clientSelection = Main.arrayInRangeCheck(Clients.getClientsList());

                Clients client = Clients.getClientsList().get(clientSelection);

                service.setClient(client);
                System.out.println("Assigned client updated successfully");
                break;


            case 3:
                System.out.println("What is the new service being performed:");
                String newService = Main.stringInputValidation();

                service.setCarService(newService);
                System.out.println("Service updated successfully");
                break;

            case 4:
                System.out.println("What is the new cost of this service:");
                double newCost = Main.doubleInputValidation();

                service.setServiceCost(newCost);
                System.out.println("Service cost updated successfully");
                break;

            case 5: servicesMenu(); break;

            case 6: default: System.out.println("Invalid input, type a number between 1 and 4"); break;
        }
    }

    /**
     * This method gets the index of a service and removes it from servicesList
     */
    public static void removeService(){
        listServices();
        System.out.println("Write the number of the service you would like to remove:");
        int serviceSelection = Main.arrayInRangeCheck(getServicesList());

        getServicesList().remove(serviceSelection);
        System.out.println("Service removed successfully");
    }

    /**
     * This method prints out a service report.
     */
    public static double serviceReport(){
        double sum = 0;
        for(Services service: getServicesList()){
            System.out.println(service.getClient());
            System.out.println("Client says: " + service.getCarService());
            System.out.println("Cost of this service: $" + service.getServiceCost() + "\n");
            sum += service.getServiceCost();
        }

        System.out.print("Total made from all services : $");
        System.out.printf("%.2f", sum);
        System.out.println();
        return sum;
    }
}