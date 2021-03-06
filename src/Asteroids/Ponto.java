package Asteroids;

/**
 * Created by Vitor on 19/05/2016.
 */

public class Ponto {
    private double x;
    private double y;

    public Ponto(double x, double y){
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void rotacionar(double dir) {
        double tempX = x*Math.cos(dir) - y*Math.sin(dir);
        double tempY = y*Math.cos(dir) + x*Math.sin(dir);
        x = tempX;
        y = tempY;
    }
}
