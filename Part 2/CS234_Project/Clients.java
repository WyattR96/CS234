package CS234_Project;

import java.util.*;

/**
 * This class handles the creation, reading, updating and deleting of objects of class Clients.
 */
class Clients {

    private static final ArrayList<Clients> clientsList = new ArrayList<>();

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

    //Overrides the standard toString method
    public String toString(){
        return "Client name: "+ this.getClientName() + " | Client vehicle: " + this.getClientCar();
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

            int input = Main.intInputValidation();

            switch(input) {
                case 1: Clients.addClientOptions();
                    break;
                case 2: Clients.listClients();
                    break;
                case 3: Clients.updateClient();
                    break;
                case 4: Clients.removeClient();
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
     * gets a clients name and which car they have and sends it to addClient.
     */
    public static void addClientOptions(){
        System.out.println("Enter the clients name:");
        String name = Main.stringInputValidation();

        System.out.println("What car does the client have:");
        Cars.listCars();
        int selection = Main.intInputValidation();
        int carIndex = Main.arrayInRangeCheck(Cars.getCarsList(),selection);

        Cars car = Cars.getCarsList().get(carIndex);

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
        System.out.println("Client added successfully");
    }




    /**
     * This method lists clients as well as their index in clientsList
     */
    public static void listClients(){
        int clientIndex = 0;
        for (Clients client :getClientsList()){
            System.out.println(clientIndex + " " + client);
            clientIndex++;
        }
    }

    /**
     * List all clients in clientsList, then gets an input for the index of the client, it then asks what needs to be
     * updated about a client then changes clientsList as needed
     */
    public static void updateClient(){

        System.out.println("Which client would you like to update:");
        listClients();
        int clientSelection = Main.intInputValidation();
        int clientIndex = Main.arrayInRangeCheck(getClientsList(),clientSelection);


        System.out.println("What is the clients new vehicle");
        Cars.listCars();
        int vehicleSelection = Main.intInputValidation();
        int vehicleIndex = Main.arrayInRangeCheck(Cars.getCarsList(),vehicleSelection);

        Cars car = Cars.getCarsList().get(vehicleIndex);

        getClientsList().get(clientIndex).setClientCar(car);
        System.out.println("Client updated successfully");
    }

    /**
     * Takes a clients index then removes them from clientsList.
     */
    public static void removeClient(){

        System.out.println("Which client would you like to remove:");
        listClients();
        int clientSelection = Main.intInputValidation();
        int clientIndex = Main.arrayInRangeCheck(getClientsList(),clientSelection);

        Clients client = getClientsList().get(clientIndex);
        getClientsList().remove(client);
        System.out.println("Client removed successfully");
    }
}