

public class Main {


    public static void main(String[] args) {
        double[] arr = Generator1.generator(10_000, 2);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if(i%5==0){
                System.out.println();
            }
        }
        Generator1.gistograma(arr,50);
        Generator1.midValue(arr);
    }
}
