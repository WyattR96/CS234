package CS234_Project;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class handles the creation, reading, updating and deleting of objects of class Appointments.
 */
class Appointments implements Serializable {

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

    public static void setAppointmentsList(ArrayList<Appointments> arr){appointmentsList = arr;}

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
            System.out.println("5. Search appointments");
            System.out.println("6. Go back");
            System.out.println("7. Quit");

            int input = Main.intInputValidation();

            switch(input) {
                case 1: addAppointmentOptions();
                    break;
                case 2: listAppointments();
                    break;
                case 3: updateAppointment();
                    break;
                case 4: removeAppointment();
                    break;
                case 5: searchAppointments();
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
            System.out.println(
                    "Appointment number: "+ appointmentIndex + "\n" + appointment.getClient() + "\nEmployee: "
                            + appointment.getEmployee() + "\nDate: " + appointment.getDate() + "\n");
            appointmentIndex++;
        }
    }

    /**
     * Lists all appointments then gets the users input for the index of the appointment to be updated. It then asks
     * the user what needs to be updated and changes elements in appointmentsList as needed
     */
    public static void updateAppointment(){
        listAppointments();
        System.out.println("Write the number of the appointment you would like to update:");
        int appointmentIndex = Main.arrayInRangeCheck(getAppointmentsList());
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
                int employeeSelection = Main.arrayInRangeCheck(Employees.getEmployeeList());

                Employees newEmployee = Employees.getEmployeeList().get(employeeSelection);
                appointment.setEmployee(newEmployee);
                System.out.println("Assigned employee updated successfully");
                break;

            case 2:
                System.out.println("Who is the new client:");
                Clients.listClients();
                int clientSelection = Main.arrayInRangeCheck(Clients.getClientsList());

                Clients newClient = Clients.getClientsList().get(clientSelection);
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
        listAppointments();
        System.out.println("Write the number of the appointment you would like to remove");
        int appointmentSelection = Main.arrayInRangeCheck(getAppointmentsList());

        getAppointmentsList().remove(appointmentSelection);
        System.out.println("Appointment removed successfully");
    }

    /**
     * This method is used to search appointments. It takes a search input and checks if a client or employee by that
     * name exist in appointmentsList.
     */
    public static void searchAppointments(){
        System.out.println("Write the Client, Employee or date of the appointment:");
        String search = Main.stringInputValidation();

        for(int i = 0; i < getAppointmentsList().size();){

            if(getAppointmentsList().get(i).getClient().getClientName().equalsIgnoreCase(search)
                    || getAppointmentsList().get(i).getDate().equalsIgnoreCase(search)
                    || getAppointmentsList().get(i).getEmployee().getEmployeeName().equalsIgnoreCase(search))
            {

                Appointments appointment = getAppointmentsList().get(i);
                System.out.println(appointment);
            }
            i++;
        }
    }
}