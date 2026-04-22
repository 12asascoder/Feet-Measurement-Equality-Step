import java.util.Scanner;

public class QuantityMeasurementApp {

    static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Take input from user
            System.out.print("Enter first value in feet: ");
            double value1 = scanner.nextDouble();

            System.out.print("Enter second value in feet: ");
            double value2 = scanner.nextDouble();

            // Create objects
            Feet f1 = new Feet(value1);
            Feet f2 = new Feet(value2);

            // Compare
            boolean result = f1.equals(f2);

            // Output
            System.out.println("Result: Equal (" + result + ")");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numeric values only.");
        } finally {
            scanner.close();
        }
    }
}