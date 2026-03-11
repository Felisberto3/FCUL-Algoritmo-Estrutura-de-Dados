package Teoria.AnaliseAlgoritmo;

public class For {
    public static void main(String[] args) {
        StopWatch time = new StopWatch();

        int n = 1000000;
        for (int i = 0; i < n; i++) {
            System.out.print(i);
        }

        System.out.println("On time: " + time.elapsedTime());
    }
}
