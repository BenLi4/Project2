public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public double distance () {
        double a = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        return roundedToHundredth(a);
    }
    public double slope() {
        double a = x2 - x1;
        double b = y2 - y1;
        return roundedToHundredth(b / a);
    }
    public double yIntercept() {
        double a = slope();
        double b = x1 * a;
        return roundedToHundredth(y1 - b);
    }
    public String equation() {
        int a = x2 - x1;
        int b = y2 - y1;
        if (x2 == x1) {
            return "x = " + x1;
        }
        int c = b / a;
        double d = yIntercept();
        String x = "" + d;
        if (x.substring(0, 1).equals("-")) {
            d = Math.abs(d);
        }
        if (y1 == y2) {
            return "y = " + roundedToHundredth(y1);
        }
        if (a != Math.abs(a) && b != Math.abs(b)) {
            a = Math.abs(a);
            b = Math.abs(b);
        }
        if (a != Math.abs(a)) {
            a = Math.abs(a);
            b *= -1;
        }
        if (d % 1 == 0.0) {
            int e = (int) yIntercept();
            if (b % a != 0) {
                return "y = " + b + "/" + a + "x + " + e;
            } else if (c == 1) {
                return "y = x + " + e;
            } else if (c == -1) {
                return "y = -x +" + e;
            }else {
                return "y = " + c + "x + " + e;
            }
        }
        if (b % a != 0) {
            return "y = " + b + "/" + a + "x + " + d;
        } else if (c == 1) {
            return "y = " + "x + " + d;
        } else {
            return "y = " + c + "x + " + d;
        }
    }
    public String coordinateForX(double x) {
        return "(" + x + ", " + (slope() * x + yIntercept()) + ")";
    }
    public String lineInfo() {
        return "The two points are: (" + x1 + ", " + y1 + ")" + " and " + "(" + x2 + ", " + y2 + ")" + "\nThe equation of the line between these points is: " + equation() + "\nThe y-intercept of this line is: " + yIntercept() + "\nThe slope of this line is: " + slope() + "\nThe distance between these points is " + distance();
    }
    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }
}
