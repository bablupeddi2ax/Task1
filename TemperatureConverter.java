package Task1;
import java.util.*;

public class TemperatureConverter {

    public static void main(String[] args) {
        // Java program for converting temperatures
        Temperature t = new Temperature();
        Converter c = new Converter();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter temperature (e.g., 32.5): ");
            double temperature;
            while (true) {
                try {
                    temperature = Double.parseDouble(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number: ");
                }
            }

            System.out.println("Enter temperature scale (F or C): ");
            String scale;
            while (true) {
                scale = sc.nextLine().trim().toLowerCase();
                if (scale.equals("f") || scale.equals("c")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'F' or 'C': ");
                }
            }

            t.setTemperature(temperature);
            t.setDegree(scale);

            Temperature r = c.convert(t);
            System.out.println("The converted temperature is " + r.getTemperature() + " " + r.getDegree().toUpperCase());

            System.out.println("Do you want to convert another temperature? (Y/N): ");
            String response = sc.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}

class Temperature {
    private double value;
    private String degree;

    public double getTemperature() {
        return value;
    }

    public String getDegree() {
        return degree;
    }

    public void setTemperature(double d) {
        this.value = d;
    }

    public void setDegree(String t) {
        this.degree = t;
    }
}

class Converter {
    public Temperature convert(Temperature t) {
        double T = t.getTemperature();
        String c = t.getDegree();
        if (c.equals("f")) {
            t.setTemperature(fahrenheitToCelsius(t.getTemperature()));
            t.setDegree("c");
        } else {
            t.setTemperature(celsiusToFahrenheit(t.getTemperature()));
            t.setDegree("f");
        }
        return t;
    }

    public double celsiusToFahrenheit(double v) {
        double f = (((9.0 / 5.0) * (v)) + 32.0);
        return f;
    }

    public double fahrenheitToCelsius(double v) {
        double c = (((v) - 32.0) * (5.0 / 9.0));
        return c;
    }
}
