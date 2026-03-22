package Series04;

import java.util.Random;

public class Ex2C {
    public void mediaAleatorios(int n) {
        Acumulador acumulador = new Acumulador();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            acumulador.adicionar(rand.nextDouble());
        }

        System.out.println(acumulador);
    }

    public static void main(String[] args) {
        Ex2C ex = new Ex2C();
        ex.mediaAleatorios(100000);

    }
}
