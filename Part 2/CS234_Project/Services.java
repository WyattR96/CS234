package CS234_Project;

import java.util.*;

public class Services {

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
        //TODO
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
    }

    /**
     * This method lists all services
     */
    public static void listServices(){for(Services service: servicesList) System.out.println(service);}


    public static void updateService(){
        //TODO
    }


    public static void removeService(){
        //TODO
    }
}