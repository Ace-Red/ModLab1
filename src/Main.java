import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;


public class Main {
    static int n = 10_000;

    public static void main(String[] args) {
        generator(18);
    }

    public static double[] createExpDist(double[] x, double lambda) {
        double[] fx = new double[n];
        for (int i = 0; i < n; i++) {
            fx[i] = 1 - Math.pow(Math.E, -lambda * x[i]);
        }
        return fx;
    }

    public static void generator(double lambda) {
        // генеруємо випадкові числа
        double[] x = new double[n];
        Random random = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = -Math.log(random.nextDouble()) / lambda;
        }
        // рахуємо середнє значення
        double midValue = 0;
        for (double v : x) {
            midValue += v;
        }
        midValue = (midValue / n);
        System.out.println("Середнє значення: " + midValue);
        // рахуємо середнє дисперсію
        double variance = 0;
        for (double v : x) {
            variance += (Math.pow((v - midValue), 2));
        }
        variance = variance / n;
        System.out.println("Дисперсія: " + variance);
        // рахуємо функцію розподілу
        double[] fx = createExpDist(x, lambda);

//        try (PrintWriter writer = new PrintWriter(new File("result2.csv"))) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < n; i++) {
//
//                sb.append((fx[i]+"").replace(".",","));
//                sb.append(";");
//                sb.append( (x[i]+"").replace(".",","));
//                sb.append("\n");
//
//            }
//            writer.write(sb.toString());
//            writer.close();
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//
//        }


    }
}
