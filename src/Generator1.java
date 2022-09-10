import java.util.Arrays;
import java.util.OptionalDouble;


public class Generator1 {
    public static double[] generator(int count, double lambda){
        double[] array = new double[count];
        for (int i = 0; i < count; i++) {
            array[i] = -(1/lambda) * Math.log(Math.random());
        }
        return array;
    }

    public static void gistograma (double[] x,int k){
        OptionalDouble max = Arrays.stream(x).max();

        OptionalDouble min = Arrays.stream(x).min();

        double h = (max.getAsDouble() - min.getAsDouble())/k;

        System.out.println(h);
        // кількість влучень випадкової величини в цей інтервал
        int[] countNi = new int[k];
        double newH = h;
        double prevH = 0;
        for (int i = 0; i < countNi.length; i++) {
            int count = 0;
            for (double v : x) {
                if (v <= newH && v >= prevH) {
                    count += 1;
                }
            }
            countNi[i] = count;
            prevH = newH;
            newH=newH+h;
        }
        System.out.println("------------------------------");
        for (int j : countNi) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void midValue(double[] arr){
        double value = 0;
        for (double v : arr) {
            value += v;
        }
        System.out.println("------------------------------");
        System.out.println(value/arr.length);
    }

}
