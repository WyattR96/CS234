package CS234_Project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){menu();}

    public static void menu(){

        Scanner x = new Scanner(System.in);

        while(true){
            System.out.println("\nWhat would you like to access:");
            System.out.println("1. Employees");
            System.out.println("2. Cars");
            System.out.println("3. Clients");
            System.out.println("4. Services");
            System.out.println("5. Appointments");
            System.out.println("6. Quit");

            //Input Validation
            int input;
            while(!x.hasNextInt()){
                System.out.println("invalid input, type a number between 1 and 6");
                x.next();
            }

            input = x.nextInt();

            switch(input) {
                case 1: //TODO: ;
                    break;
                case 2: //TODO: ;
                    break;
                case 3: //TODO: ;
                    break;
                case 4: //TODO: ;
                    break;
                case 5: //TODO ;
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
}
