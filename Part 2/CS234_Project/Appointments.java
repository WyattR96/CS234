package CS234_Project;

import java.util.*;

public class Appointments {

    private static ArrayList<Appointments> appointmentsList = new ArrayList<>();

    private Clients Client;
    private Employees Employee;
    private String Date;

    //Constructor
    public Appointments(Clients client, Employees employee, String date){

        this.Client = client;
        this.Employee = employee;
        this.Date = date;

    }

    //Getters and setters
    public static ArrayList<Appointments> getAppointmentsList(){return appointmentsList;}

    public void setClient(Clients client){ this.Client = client; }

    public Clients getClient(){ return this.Client; }

    public void setEmployee(Employees employee){ this.Employee = employee; }

    public Employees getEmployee(){ return this.Employee; }

    public void setDate(String date){ this.Date = date; }

    public String getDate(){ return this.Date; }

    public String toString(){
        return this.getClient() + " Has an appointment with \n" + this.getEmployee() +" on " + this.getDate() + "\n";
    }

    /**
     * This method gets the client with the appointment, the employee assigned to the appointment and the date of the
     * appointment, it then calls on addAppointment.
     */
    public static void addAppointmentOptions(){

        System.out.println("Which client needs to make an appointment:");
        for(Object client: Clients.getClientsList()){
            int i = 0;
            System.out.println(i + " " + client);
            i++;
        }
        int selection = Main.intInputValidation();

        Clients client = Clients.getClientsList().get(selection);


        System.out.println("Which employee is assigned to this appointment:");
        for(Object employee: Employees.getEmployeeList()){
            int i = 0;
            System.out.println(i + " " + employee);
            i++;
        }
        int employeeSelection = Main.intInputValidation();

        Employees employee = Employees.getEmployeeList().get(employeeSelection);

        //TODO: find a better way to input times and dates, a string probably isn't the best method.
        System.out.println("Type the date of the appointment:");
        String date = Main.stringInputValidation();

        addAppointment(client, employee, date);
    }

    /**
     * This method creates a new object of class employee then adds it to appointmentsList.
     * @param client The client with the appointment
     * @param employee The employee assigned to the appointment
     * @param date The date of the appointment
     */
    public static void addAppointment(Clients client,Employees employee, String date){
        Appointments newAppointment = new Appointments(client,employee,date);
        getAppointmentsList().add(newAppointment);
    }

    /**
     * This method lists all appointments
     */
    public static void listAppointments(){
        for(Object appointment: getAppointmentsList()) System.out.println(appointment);
    }

    public static void updateAppointment(){

    }

    public static void removeAppointment(){

    }
}