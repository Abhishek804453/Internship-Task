import java.util.Scanner;

public class Calculator {

    // addition
    public static double add(double a, double b) {
        return a + b;
    }

    // subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        System.out.println("Simple Calculator");

        while (run) {
            System.out.print("First number: ");
            double n1 = sc.nextDouble();

            System.out.print("Operator (+,-,*,/): ");
            char operator = sc.next().charAt(0);

            System.out.print("Second number: ");
            double n2 = sc.nextDouble();

            double ans = 0;

            switch (operator) {
                case '+':
                    ans = add(n1, n2);
                    break;
                case '-':
                    ans = subtract(n1, n2);
                    break;
                case '*':
                    ans = multiply(n1, n2);
                    break;
                case '/':
                    ans = divide(n1, n2);
                    break;
                default:
                    System.out.println("Wrong operator!");
                    continue;
            }

            System.out.println("Result = " + ans);

            System.out.print("Do you want to continue? (yes/no): ");
            String c = sc.next();
            if (c.equalsIgnoreCase("no")) {
                run = false;
                System.out.println("Exiting...");
            }
        }
    }
}
