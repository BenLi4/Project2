import java.util.Scanner;
public class LinearEquationLogic {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private String answer = "y";
    private Scanner scan;
    private LinearEquation x;




    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }




    public void start() {
        logic();




    }




    private void logic() {
        System.out.println("Welcome to the Linear equation calculator!");
        while (!answer.equals("n")) {
            System.out.print("Enter coordinate 1: ");
            String coordinate1 = scan.nextLine();
            System.out.print("Enter coordinate 2: ");
            String coordinate2 = scan.nextLine();
            int a = coordinate1.indexOf(",");
            int b = coordinate2.indexOf(",");
            int c = coordinate1.indexOf(")");
            int d = coordinate2.indexOf(")");
            if (coordinate1.substring(1, 2).equals("-")) {
                x1 = Integer.parseInt(coordinate1.substring(1, a));
                if (coordinate1.substring(a + 2, a + 3).equals("-")) {
                    y1 = Integer.parseInt(coordinate1.substring(5, c));
                } else {
                    y1 = Integer.parseInt(coordinate1.substring(5, c));
                }
            } else if (coordinate1.substring(a + 2, a + 3).equals("-")) {
                x1 = Integer.parseInt(coordinate1.substring(1, a));
                y1 = Integer.parseInt(coordinate1.substring(a + 2, c));
            } else {
                x1 = Integer.parseInt(coordinate1.substring(1, a));
                y1 = Integer.parseInt(coordinate1.substring(a + 2, c));
            }
            if (coordinate2.substring(1, 2).equals("-")) {
                x2 = Integer.parseInt(coordinate2.substring(1, b));
                if (coordinate2.substring(b + 2, b + 3).equals("-")) {
                    y2 = Integer.parseInt(coordinate2.substring(b + 2, d));
                } else {
                    y2 = Integer.parseInt(coordinate2.substring(b + 2, d));
                }
            } else if (coordinate2.substring(b + 2, b + 3).equals("-")) {
                x2 = Integer.parseInt(coordinate2.substring(1, b));
                y2 = Integer.parseInt(coordinate2.substring(b + 2, d));
            } else {
                x2 = Integer.parseInt(coordinate2.substring(1, b));
                y2 = Integer.parseInt(coordinate2.substring(b + 2, d));
            }
            x = new LinearEquation(x1, y1, x2, y2);
            System.out.println();
            if (x1 == x2) {
                System.out.println("These points are on a vertical line: " + x.equation());
            } else {
                System.out.println(x.lineInfo() + "\n  \n");
                System.out.print("\nEnter a value for x: ");
                double p = scan.nextDouble();
                String xx = scan.nextLine();
                System.out.println("\n\nThe point on the line is " + x.coordinateForX(p));
            }
            System.out.print("\nWould you like to enter another pair of coordinates? (y/n): ");
            answer = scan.nextLine();
        }
        System.out.println("Thanks for using the slope calculator, cya!");
    }
}


