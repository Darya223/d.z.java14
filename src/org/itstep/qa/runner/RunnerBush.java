package org.itstep.qa.runner;
import java.util.Random;
import org.itstep.qa.zadachi.Bush;
import org.itstep.qa.zadachi.Mouse;
public class RunnerBush {
    private static final int SIZE_FIELD = 100;
    private static final int COUNT_BUSHES = 18;
    public static void main(String[] args) {
        String [] colors = {"Зеленый", "Салатовый", "Розовый", "Красный", "Пурпурный", "Черный", "Коричневый", "Желтый",
                "Синий", "Фиолетовый", "Оранжевый", "Голубой", "Малиновый", "Перламутровый", "Бежевый", "Белый", "Фуксия", "Хаки"};
        Random random = new Random();
        Bush[] arrayBushes = initBushes(colors);
        Mouse mouseOne = new Mouse(random.nextInt(SIZE_FIELD-1), random.nextInt(SIZE_FIELD-1), "Оптимистина", SIZE_FIELD);
        Mouse mouseTwo = new Mouse(random.nextInt(SIZE_FIELD-1), random.nextInt(SIZE_FIELD-1), "Пессемистина", SIZE_FIELD);
        boolean isRun =true;
        while (isRun){
            for(int i = 0; i < arrayBushes.length; i++){
                if(controlWin(mouseOne, arrayBushes[i])){
                    mouseOne.setColor(arrayBushes[i].getColor());
                }
                if(controlWin(mouseTwo, arrayBushes[i])){
                    mouseTwo.setColor(arrayBushes[i].getColor());
                }
                if(controlWin(mouseOne, arrayBushes[i]) || controlWin(mouseOne, arrayBushes[i])){
                    isRun = false;
                    break;
                }
            }
            if(isRun){
                mouseOne.mouseToRun();
                mouseTwo.mouseToRun();
            }
        }
        prinWinner(mouseOne);
        prinWinner(mouseTwo);
    }

    private static void prinWinner(Mouse mouse){
        if(!mouse.getColor().equals("Белая ")){
            System.out.println("Мышь " + mouse.getName()+ " победила!");
            System.out.println("Ее координаты " + mouse.getX() + ":" + mouse.getY());
            System.out.println("Ей присвоен цвет " + mouse.getColor());
        }
    }

    private static boolean controlWin(Mouse mouse, Bush bush){
        if (mouse.getX() == bush.getX() && mouse.getY() == bush.getY()){
            return true;
        }else {
            return false;
        }
    }

    private static Bush[] initBushes(String[] colors){
        Bush[] bushes = new Bush[COUNT_BUSHES];
        Random random = new Random();
        for(int i = 0; i < bushes.length; i++){
            bushes[i] = new Bush(random.nextInt(SIZE_FIELD-1), random.nextInt(SIZE_FIELD-1),
                    colors[random.nextInt(colors.length-1)]);
        }
        return bushes;
    }
}
