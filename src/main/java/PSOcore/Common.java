package PSOcore;

import java.util.Random;

public class Common {


    public static double getRandomPercentageOf(double number){
        return number * getRandomNumberDouble(0.0,1.0);
    }

    public static double getRandomNumberDouble(double min, double max) {
        Random r = new Random();
        double randomValue = min + (max - min) * r.nextDouble();
        return randomValue;
    }

    public static int getRandomNumberInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

}
