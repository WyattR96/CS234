package CS234_Project;

import java.util.Scanner;

public class Sales {

    public static void menu(){

        Scanner x = new Scanner(System.in);

        while(true){
            System.out.println("\nWhat would you like to do:");
            System.out.println("1. Add sale");
            System.out.println("2. Print sales report");
            System.out.println("3. Add item");
            System.out.println("4. list items");
            System.out.println("5. Go back");
            System.out.println("6. Exit");

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
                case 5: Main.menu();
                    break;
                case 6: System.exit(0);
                    break;
                case 7: default: System.out.println(
                        "You typed "+ input + "\ninvalid input \n Type a number between 1 and 5");
                    break;
            }
            System.out.println("\n----------------");
        }
    }
}
