package Teoria.AnaliseAlgoritmo;

import java.util.Random;

public class String2 {
    public static void main(String[] args) {
        int n = 320000;
        comString(n);
        comStringBuilder(n);
    }

    public static void comString(int n) {
        StopWatch watch = new StopWatch();

        Random rd = new Random();
        String s = "";
        for (int i = 0; i < n; i++)
            s += rd.nextBoolean() ? "0" : "1";

        System.out.println(watch.elapsedTime());
    }

    public static void comStringBuilder(int n) {
        StopWatch watch = new StopWatch();
        Random rd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(rd.nextBoolean() ? "0" : "1");
        String s = sb.toString();

        System.out.println(watch.elapsedTime());

    }
}
