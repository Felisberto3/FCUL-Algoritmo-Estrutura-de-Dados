package Teoria.AnaliseAlgoritmo;

public class StopWatch {

    private final long start;

    /**
     * começa a cronometrar
     */
    public StopWatch() {
        start = System.currentTimeMillis();
    }

    /**
     * 
     * @return retorna O tempo (em segundo) decorrido desde que este objecto foi
     *         criado
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}