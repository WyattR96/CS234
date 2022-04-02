package CS234_Project;

import java.util.*;

public class Cars {

    private static Collection<Cars> carsList = new ArrayList<>();

    private String Make;
    private String Model;

    //Constructor
    public Cars(String make, String model){
        this.Make = make;
        this.Model = model;
    }

    //Getters and setters
    public String getMake(){return this.Make;}

    public void setMake(String make){this.Make = make;}

    public String getModel(){return this.Model;}

    public void setModel(String model){this.Model = model;}

    public String toString(){return "Make: " + this.getMake() +" | Model: "+ this.getModel();}

    public static ArrayList<Cars> getCarsList(){return (ArrayList<Cars>) carsList;}


    /**
     * gets a cars make and model then calls addCar()
     */
    public static void addCarOptions(){
        System.out.println("Write the cars make:");
        String Make = Main.stringInputValidation();

        System.out.println("Write the cars model:");
        String model = Main.stringInputValidation();

        addCar(Make,model);
    }

    /**
     * Creates new object of class car then adds it to carsList.
     * @param make The cars make
     * @param model The cars model
     */
    public static void addCar(String make,String model){
        Cars newCar = new Cars(make,model);
        getCarsList().add(newCar);
    }

    public static void listCars(){for (Cars car : carsList) System.out.println(car);}

    /**
     * Takes a cars make and model then removes it from carsList.
     */
    public static void removeCar(){
        //TODO
    }


    public static void updateCar(){
        //TODO
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

    public String toString(){
        return "Maker: " + this.getMake() + " | Model: " + this.getModel() + " | Type: " + this.getType();
    }
}