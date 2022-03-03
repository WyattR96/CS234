package CS234_Project;

import java.util.Scanner;

public class Appointments {
    public static void menu() {
        Scanner x = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat would you like to do:");
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("5. Go back");
            System.out.println("6. Quit");

            //Input Validation
            int input;
            while (!x.hasNextInt()) {
                System.out.println("invalid input, type a number between 1 and 6");
                x.next();
            }

            input = x.nextInt();

            switch(input) {
                case 1: Employees.menu();
                    break;
                case 2: //TODO: ;
                    break;
                case 3: //TODO: ;
                    break;
                case 4: //TODO: ;
                    break;
                case 5: //TODO: ;
                    break;
                case 6: System.exit(0);
                    break;
                case 7: default: System.out.println(
                        "You typed "+ input + "\ninvalid input \nType a number between 1 and 5");
                    break;
            }
            System.out.println("----------------");
        }

    }
}
