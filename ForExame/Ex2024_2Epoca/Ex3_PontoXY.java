package ForExame.Ex2024_2Epoca;

public class Ex3_PontoXY {
    private final double x;
    private final double y;

    public Ex3_PontoXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Ex3_PontoXY add(double deltaX, double deltaY) {
        return new Ex3_PontoXY(this.x + deltaX, this.y + deltaY);
    }
}
