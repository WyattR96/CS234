package CS234_Project;

import java.util.*;

public class Clients {

    private static ArrayList<Clients> clientsList = new ArrayList<>();

    private String Name;
    private Cars Car;

    //Constructor
    public Clients(String name, Cars car){
        this.Name = name;
        this.Car = car;
    }

    //Getters and setters
    public static ArrayList<Clients> getClientsList(){return clientsList;}

    public void setClientName(String name){ this.Name = name; }

    public String getClientName(){ return this.Name; }

    public void setClientCar(Cars car){ this.Car = car; }

    public Cars getClientCar(){ return this.Car; }

    public String toString(){
        return "Client name: "+ this.getClientName() + " | Client vehicle: " + this.getClientCar();
    }


    /**
     * gets a clients name and which car they have and sends it to addClient.
     */
    public static void addClientOptions(){
        System.out.println("Enter the clients name:");
        String name = Main.stringInputValidation();

        System.out.println("What car does the client have:");

        int i = 0;
        for (Object car :Cars.getCarsList()) {
            System.out.println(i + " " + car);
            i++;
        }
        int selection = Main.intInputValidation();

        Cars car = Cars.getCarsList().get(selection);

        addClient(name, car);
    }

    /**
     * creates a new object of class client then adds that to clientsList.
     * @param name The clients name
     * @param car The clients car
     */
    public static void addClient(String name,Cars car){
        Clients newClient = new Clients(name,car);
        getClientsList().add(newClient);
    }


    /**
     * Takes a clients name then removes them from clientsList.
     */
    public static void removeClient(){
        //TODO
    }

    public static void listClients(){for (Clients client :clientsList) System.out.println(client);}

    public static void updateClient(){
        //TODO
    }
}