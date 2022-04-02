package CS234_Project;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        nameInputValidation("asdf");
        nameInputValidation("1234");
    }

    public static Boolean nameInputValidation(String name){

        char ch = 0;
        for(int i = 0; i < name.length();i++){
            ch = name.charAt(i);
        }

        if((ch >= '0' && ch <='9')){
            System.out.println("Invalid input");
            return false;
        }
        return true;
    }
}
