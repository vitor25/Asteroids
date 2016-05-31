/**
 * Created by Vitor on 19/05/2016.
 */

import java.util.Set;

public class Nave {
    private Ponto centro;
    private double vx;
    private double vy;
    private double angulo;
    public static final Cor cor = new Cor("branco");

    public Nave(double x, double y, double vx, double vy){
        centro = new Ponto(x,y);
        this.vx = vx;
        this.vy = vy;
        this.angulo = 0.0;
    }

    public void desenhar(Tela t){
        Ponto[] vertices = new Ponto[3];
        vertices[0] = new Ponto(10,0);
        vertices[1] = new Ponto(-8,-9);
        vertices[2] = new Ponto(-8,9);

        for(Ponto p: vertices){
            p.rotacionar(angulo);
        }

        t.triangulo(vertices[0].getX()+centro.getX(),
                    vertices[0].getY()+centro.getY(),
                    vertices[1].getX()+centro.getX(),
                    vertices[1].getY()+centro.getY(),
                    vertices[2].getX()+centro.getX(),
                    vertices[2].getY()+centro.getY(),
                    cor
        );

        t.triangulo(centro.getX(),centro.getY(),
                    vertices[1].getX()+centro.getX(),
                    vertices[1].getY()+centro.getY(),
                    vertices[2].getX()+centro.getX(),
                    vertices[2].getY()+centro.getY(),
                    new Cor(0,0,0)
        );
    }

    public void acelera(Set<String> t){
        if(t.contains("up") || t.contains("acima")) {
            vx += Math.cos(angulo)*100;
            vy += Math.sin(angulo)*100;
        }
        if(t.contains("down") || t.contains("abaixo")){
            vx += -Math.cos(angulo)*100;
            vy += -Math.sin(angulo)*100;
        }
    }

    public void mover(int altTela, int largTela, double dt){


        centro.setX(centro.getX() + vx*dt);
        centro.setY(centro.getY() + vx*dt);

        if(centro.getY() > altTela+5){
            centro.setY(-5);
        }
        if(centro.getY() < -5){
            centro.setY(altTela+5);
        }
        if(centro.getX() > largTela+5){
            centro.setX(-5);
        }
        if(centro.getX() < -5){
            centro.setX(largTela+5);
        }
    }

    public void giraNave(Set<String> t, double dt){
        if(t.contains("left") || t.contains("esquerda")){
            angulo -= Math.PI*dt;
        }if(t.contains("right") || t.contains("direita")){
            angulo += Math.PI*dt;
        }
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
}
