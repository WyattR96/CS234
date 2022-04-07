package CS234_Project;

import java.util.*;

/**
 * This class handles the creation, reading, updating and deleting of objects of class Appointments.
 */
class Appointments {

    private static final ArrayList<Appointments> appointmentsList = new ArrayList<>();

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

    //Overrides the standard toString method
    public String toString(){
        return this.getClient() + " Has an appointment with \n" + this.getEmployee() +" on " + this.getDate() + "\n";
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

            int input = Main.intInputValidation();

            switch(input) {
                case 1: Appointments.addAppointmentOptions();
                    break;
                case 2: Appointments.listAppointments();
                    break;
                case 3: Appointments.updateAppointment();
                    break;
                case 4: Appointments.removeAppointment();
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
     * This method gets the client with the appointment, the employee assigned to the appointment and the date of the
     * appointment, it then calls on addAppointment.
     */
    public static void addAppointmentOptions(){

        System.out.println("Which client needs to make an appointment:");
        Clients.listClients();
        int selection = Main.intInputValidation();
        Clients client = Clients.getClientsList().get(selection);


        System.out.println("Which employee is assigned to this appointment:");
        Employees.listEmployees();
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
        System.out.println("Appointment added successfully");
    }

    /**
     * This method lists all appointments
     */
    public static void listAppointments(){
        int appointmentIndex = 0;
        for(Appointments appointment: getAppointmentsList()){
            System.out.println(appointmentIndex + " " + appointment);
            appointmentIndex++;
        }
    }

    /**
     * Lists all appointments then gets the users input for the index of the appointment to be updated. It then asks
     * the user what needs to be updated and changes elements in appointmentsList as needed
     */
    public static void updateAppointment(){

        System.out.println("Which appointment would you like to update:");
        listAppointments();
        int selectedAppointment = Main.intInputValidation();
        int appointmentIndex = Main.arrayInRangeCheck(getAppointmentsList(),selectedAppointment);

        Appointments appointment = getAppointmentsList().get(appointmentIndex);

        System.out.println("What would you like to update about the appointment:");
        System.out.println("1. Assigned employee");
        System.out.println("2. The client");
        System.out.println("3. The date");
        System.out.println("4. Cancel");
        int appointmentEdit = Main.intInputValidation();

        switch(appointmentEdit){

            case 1:
                System.out.println("Which employee will now be assigned to this appointment:");
                Employees.listEmployees();
                int employeeSelection = Main.intInputValidation();
                int employeeIndex = Main.arrayInRangeCheck(Employees.getEmployeeList(),employeeSelection);

                Employees newEmployee = Employees.getEmployeeList().get(employeeIndex);
                appointment.setEmployee(newEmployee);
                System.out.println("Assigned employee updated successfully");
                break;

            case 2:
                System.out.println("Who is the new client:");
                Clients.listClients();
                int clientSelection = Main.intInputValidation();
                int clientIndex = Main.arrayInRangeCheck(Clients.getClientsList(),clientSelection);

                Clients newClient = Clients.getClientsList().get(clientIndex);
                appointment.setClient(newClient);
                System.out.println("Client updated successfully");
                break;

            case 3:
                System.out.println("What is the new date of the appointment:");
                String newTime = Main.stringInputValidation();

                appointment.setDate(newTime);
                System.out.println("Appointment date updated successfully");
                break;
            case 4:
                appointmentsMenu();
                break;

            case 5: default:
                System.out.println("Invalid input, input must be between 1 and 3");
                break;
        }

    }

    /**
     * Gets the index of an appointment then removes it
     */
    public static void removeAppointment(){

        System.out.println("Which appointment would you like to remove:");
        listAppointments();
        int selectedAppointment = Main.intInputValidation();
        int AppointmentIndex = Main.arrayInRangeCheck(getAppointmentsList(),selectedAppointment);

        getAppointmentsList().remove(AppointmentIndex);
        System.out.println("Appointment removed successfully");
    }
}