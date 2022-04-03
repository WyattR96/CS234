package CS234_Project;

import java.util.*;

public class Services {

    /**
     * TODO, make this class print out a service report, adding up all the money made from a service
     */

    private static Collection<Services> servicesList = new ArrayList<>();

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
    public static ArrayList<Services> getServicesList(){return (ArrayList<Services>) servicesList;}

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
        return this.getEmployee() + " is servicing " + this.getClient() +
                "\nProblem: " + this.getCarService() +
                "\nCost: " + this.getServiceCost() +
                "\n" ;
    }


    /**
     * This method gets the users input for an employee a client a service and the service cost, then calls to
     * addService().
     */
    public static void addServicesOptions(){

        System.out.println("Which employee will be performing the service:");
        Employees.listEmployees();
        int employeeSelection = Main.intInputValidation();
        int employeeIndex = Main.arrayInRangeCheck(Employees.getEmployeeList(),employeeSelection);

        Employees employee = Employees.getEmployeeList().get(employeeIndex);

        System.out.println("Which client will be recieving the service:");
        Clients.listClients();
        int clientSelection = Main.intInputValidation();
        int clientIndex = Main.arrayInRangeCheck(Clients.getClientsList(),clientSelection);

        Clients client = Clients.getClientsList().get(clientIndex);

        System.out.println("What does the client say is wrong with their vehicle:");
        String service = Main.stringInputValidation();

        System.out.println("What is the estimated cost of this service:");
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
            System.out.println(serviceIndex + " " + service);
            serviceIndex++;
        }
    }

    /**
     * This method lists services, asking which one to update, it then asks what needs to be updated in the service.
     * it then gets the users input on what to update and changes elements of the service as needed.
     */
    public static void updateService(){

        System.out.println("Which service would you like to update:");
        listServices();
        int serviceSelection = Main.intInputValidation();
        int serviceIndex = Main.arrayInRangeCheck(getServicesList(),serviceSelection);

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
                int employeeSelection = Main.intInputValidation();
                int employeeIndex = Main.arrayInRangeCheck(Employees.getEmployeeList(),employeeSelection);

                Employees employee = Employees.getEmployeeList().get(employeeIndex);

                service.setEmployee(employee);
                System.out.println("Assigned employee updated successfully");
                break;

            case 2:
                System.out.println("Which client is now assigned to this service:");
                Clients.listClients();
                int clientSelection = Main.intInputValidation();
                int clientIndex = Main.arrayInRangeCheck(Clients.getClientsList(),clientSelection);

                Clients client = Clients.getClientsList().get(clientIndex);

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

            case 5:
                Main.servicesMenu();
                break;

            case 6:
                default: System.out.println("Invalid input, type a number between 1 and 4");
                break;
        }
    }

    /**
     * This method gets the index of a service and removes it from servicesList
     */
    public static void removeService(){

        System.out.println("Which service would you like to remove:");
        listServices();
        int serviceSelection = Main.intInputValidation();
        int serviceIndex = Main.arrayInRangeCheck(getServicesList(),serviceSelection);

        getServicesList().remove(serviceIndex);
        System.out.println("Service removed successfully");
    }
}