package CS234_Project;

import java.util.ArrayList;

/**
 * This class handles the creation, reading, updating and deleting of objects of the class Cars.
 */
class Cars {

    private static final ArrayList<Cars> carsList = new ArrayList<>();

    private String Make;
    private String Model;

    //Constructor
    public Cars(String make, String model){
        this.Make = make;
        this.Model = model;
    }

    //Getters and setters
    public static ArrayList<Cars> getCarsList(){return carsList;}

    public String getMake(){return this.Make;}

    public void setMake(String make){this.Make = make;}

    public String getModel(){return this.Model;}

    public void setModel(String model){this.Model = model;}

    //Overrides the standard toString method
    public String toString(){return "Make: " + this.getMake() +" | Model: "+ this.getModel();}

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
            System.out.println("5. Search cars");
            System.out.println("6. Go back");
            System.out.println("7. Quit");

            int input = Main.intInputValidation();

            switch(input) {
                case 1: carType.addCarOptions(); break;

                case 2: listCars(); break;

                case 3: updateCar(); break;

                case 4: removeCar(); break;

                case 5: searchCars(); break;

                case 6: Main.menu(); break;

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
     * Creates new object of class car then adds it to carsList.
     * @param make The cars make
     * @param model The cars model
     */
    public static void addCar(String make,String model){
        Cars newCar = new Cars(make,model);
        getCarsList().add(newCar);
        System.out.println("Vehicle added successfully");
    }

    /**
     * Lists all cars
     */
    public static void listCars(){
        int carIndex = 0;
        for (Cars car : carsList){
            System.out.println(carIndex + " " + car);
            carIndex++;
        }
    }

    /**
     * Gets the index of a car in cars list then updates a given element
     */
    public static void updateCar(){
        listCars();
        System.out.println("Write the number of the car you would like to update:");
        int carSelection = Main.arrayInRangeCheck(getCarsList());

        Cars car = getCarsList().get(carSelection);

        System.out.println("What would you like to update about this car:");
        System.out.println("1. The make");
        System.out.println("2. The model");
        System.out.println("3. The type");
        System.out.println("4. Cancel");
        int selection = Main.intInputValidation();

        switch (selection){
            case 1:
                System.out.println("What is the new make of this vehicle:");
                String newMake = Main.stringInputValidation();

                car.setMake(newMake);
                System.out.println("Make updated successfully");
                break;

            case 2:
                System.out.println("What is the new model of this vehicle:");
                String newModel = Main.stringInputValidation();

                car.setModel(newModel);
                System.out.println("Model updated successfully");
                break;

            case 3:
                System.out.println("What is the cars new type");
                String newType = Main.stringInputValidation();

                String make = car.getMake();
                String model = car.getModel();

                Cars newCar = new carType(make,model,newType);
                getCarsList().remove(car);
                getCarsList().add(carSelection,newCar);
                System.out.println("Type updated successfully");           
                break;

            case 4:
                carsMenu();
                break;

            case 5: default:
                System.out.println("Invalid input");
                break;
        }
    }

    /**
     * Takes a cars make and model then removes it from carsList.
     */
    public static void removeCar(){
        listCars();
        System.out.println("Write the number of the car you would like to remove:");
        int carSelection = Main.arrayInRangeCheck(getCarsList());

        getCarsList().remove(carSelection);
        System.out.println("Vehicle removed successfully");
    }

    public static void searchCars(){
        System.out.println("Write the make or model of the car you are searching for:");
        String search = Main.stringInputValidation();

        for(int i = 0; i < getCarsList().size();){
            if(getCarsList().get(i).getMake().equalsIgnoreCase(search) || getCarsList().get(i).getModel().equalsIgnoreCase(search)){
                Cars car = getCarsList().get(i);
                System.out.println(car);
            }
            i++;
        }
    }

}

class carType extends Cars{

    private String Type;

    public carType(String make, String model, String type){
        super(make,model);
        this.Type = type;
    }

    public void setType(String type){this.Type = type;}

    public String getType(){return this.Type;}

    //Overrides the standard toString method
    public String toString(){
        return "Maker: " + this.getMake() + " | Model: " + this.getModel() + " | Type: " + this.getType();
    }

    public static void addCarOptions(){
        System.out.println("Write the cars make:");
        String Make = Main.stringInputValidation();

        System.out.println("Write the cars model:");
        String model = Main.stringInputValidation();

        System.out.println("What is the cars type:");
        String type = Main.stringInputValidation();

        Cars carWithType = new carType(Make,model,type);
        getCarsList().add(carWithType);
    }

    public static void addCar(String make, String model, String type){
        Cars newCar = new carType(make,model,type);
        getCarsList().add(newCar);
        System.out.println("Vehicle added successfully");
    }


}