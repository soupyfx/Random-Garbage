import java.util.Objects;
import java.util.Scanner;

public class Main {
    static boolean checkIfNumber(String value) {
        try {
            int check = Integer.parseInt(value);
        } catch (NumberFormatException i) {
            return false;
        }
        return true;
    }

    static boolean checkIfOperator(String value) {
        String[] allowedOperators= {"+","-","*","/"};
        for (String i: allowedOperators) {
            if (Objects.equals(value,i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // new scanner

        int output = 0,numOne = 0, numTwo = 0;
        String operator = "";

        String[] numbersInCalculation = {}, splitCalculation;

        System.out.print("Enter calculation to calculate: ");
        String calculation = scanner.nextLine();

        splitCalculation = calculation.split("");

        for (String i: splitCalculation){
            if (Objects.equals(i, "+")){
                numbersInCalculation = calculation.split("\\+",2);
                operator = "+";
            } else if (Objects.equals(i, "-")) {
                numbersInCalculation = calculation.split("-",2);
                operator = "-";
            } else if (Objects.equals(i, "*")) {
                numbersInCalculation = calculation.split("\\*",2);
                operator = "*";
            } else if (Objects.equals(i, "/")) {
                numbersInCalculation = calculation.split("/",2);
                operator = "/";
            } else {
                if (!checkIfOperator(i)&&(!checkIfNumber(i))) {
                    System.out.println("Inputted value is invalid: Found not allowed character!");
                    System.out.println("Exiting Program.");
                    return;
                }
            }
        }

        if (Objects.equals(numbersInCalculation[0], "") || Objects.equals(numbersInCalculation[1], "")) {
            System.out.println("Inputted value is invalid: Either program cant detect number or number was not provided!");
            System.out.println("Exiting Program.");
            return;
        }

        if (!checkIfNumber(numbersInCalculation[0]) || !checkIfNumber(numbersInCalculation[1])) {
            System.out.println("Inputted value is invalid: Found multi-calculation this software doest support more than 1 operator!");
            System.out.println("Exiting Program.");
            return;
        }

        output = Integer.parseInt(numbersInCalculation[0]) + Integer.parseInt(numbersInCalculation[1]);
        System.out.println(numbersInCalculation[0]+operator+numbersInCalculation[1]+"="+output);

    }
}
