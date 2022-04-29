package CS234_Project;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class handles the creation, reading, updating and deleting of objects of class Clients.
 */
class Clients implements Serializable {

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

    public static void setClientsList(ArrayList<Clients> arr){clientsList = arr;}

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
            System.out.println("5. Search clients");
            System.out.println("6. Go back");
            System.out.println("7. Quit");

            int input = Main.intInputValidation();

            switch(input) {
                case 1: addClientOptions();
                    break;
                case 2: listClients();
                    break;
                case 3: updateClient();
                    break;
                case 4: removeClient();
                    break;
                case 5: searchClients();
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
     * gets a clients name and which car they have and sends it to addClient.
     */
    public static void addClientOptions(){
        System.out.println("Enter the clients name:");
        String name = Main.stringInputValidation();

        System.out.println("What car does the client have:");
        Cars.listCars();
        int carIndex = Main.arrayInRangeCheck(Cars.getCarsList());

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
        listClients();
        System.out.println("Write the client number you would like to update:");
        int clientSelection = Main.arrayInRangeCheck(getClientsList());

        Clients client = getClientsList().get(clientSelection);

        System.out.println("What would you like to update about this client:");
        System.out.println("1. Their name");
        System.out.println("2. Their vehicle");
        System.out.println("3. Cancel");
        int selection = Main.intInputValidation();

        switch(selection){
            case 1:
                System.out.println("What is the clients new name:");
                String newName = Main.stringInputValidation();

                client.setClientName(newName);
                System.out.println("Client updated successfully");
                break;

            case 2:
                System.out.println("What is the clients new vehicle");
                Cars.listCars();
                int carSelection = Main.arrayInRangeCheck(Cars.getCarsList());

                Cars car = Cars.getCarsList().get(carSelection);

                client.setClientCar(car);
                System.out.println("Client updated successfully");
                break;

            case 3: clientsMenu(); break;

            case 4: default: System.out.println("Invalid input"); break;

        }

    }

    /**
     * Takes a clients index then removes them from clientsList.
     */
    public static void removeClient(){
        listClients();
        System.out.println("Write the number of the client you would like to remove:");
        int clientSelection = Main.arrayInRangeCheck(getClientsList());

        Clients client = getClientsList().get(clientSelection);
        getClientsList().remove(client);
        System.out.println("Client removed successfully");
    }

    /**
     * This method is used to search for a client. It asks the user for their name as an input and if there is an
     * occurrence of that name in clientsList it will print out all info about that particular client.
     */
    public static void searchClients(){
        System.out.println("Write the clients name you would like to search for:");
        String search = Main.stringInputValidation();

        for(int i = 0; i < getClientsList().size();){

            if(getClientsList().get(i).getClientName().equalsIgnoreCase(search)){
                Clients client = getClientsList().get(i);
                System.out.println(client);
                break;
            }else{
                i++;
            }
        }
    }
}