package org.itstep.qa.zadachi;
import java.util.Random;
public class Mouse {
    private final int FORCE_WIND = 2;

    private int a;
    private int b;
    private int x;
    private int y;
    private String name;
    private String color;

    private int dXRun;
    private int dYRun;

    private int dXDig;
    private int dYDig;

    private int sizeField;

    public Mouse(int a, int b, String name, int sizeField) {
        this.a = a;
        this.b = b;
        this.x = a;
        this.y = b;
        this.name = name;
        this.color = "Белая";
        dXRun = 1;
        dYRun = 1;
        dXDig = 5;
        dYDig = 5;
        this.sizeField = sizeField;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void mouseToRun (){
        Random random = new Random();
        int windX = random.nextInt(FORCE_WIND);
        int windY = random.nextInt(FORCE_WIND);
        dXRun = controlMouse(x, dXRun, windX*dXRun);
        dYRun = controlMouse(y, dYRun, windY*dYRun);
        x  = x + dXRun + windX*dXRun;
        y  = y + dYRun + windY*dYRun;
    }

    public void toDigTunnelMouse(){
        dXDig = controlMouse(x, dXDig, 0);
        dYDig = controlMouse(y, dYDig, 0);
        x = x + dXDig;
        y = y + dYDig;
    }

    private int controlMouse (int current, int d, int wind){ // параметры: текущая координата и приращение,
        // нужен этот метод для того чтобы проверить не выбежила ли мышь за пределы
        Random random = new Random();
        int temp = current + d + wind;
        if (temp >= sizeField || temp < 0){
            d = -d;
        }
        return d;
    }
}

