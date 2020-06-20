package PSOcore;

import java.util.Random;
/**
 * @author Lorenzo Matteucci
 */
public class Common {

    public static double INIT_BEST_FITNESS = 0;

    /**
     * Method that returns a random percentage of a number
     * @param number a number whose percentage we want
     * @return the percentage of the number passed as parameter
     */
    public static double getRandomPercentageOf(double number){
        return number * getRandomNumberDouble(0.0,1.0);
    }

    /**
     * Method that returns a random number between a range defined by the parameters passed to the method
     * @param min lower limit for random number
     * @param max upper limit for random number
     * @return A random number between two limits
     */
    public static double getRandomNumberDouble(double min, double max) {
        Random r = new Random();
        double randomValue = min + (max - min) * r.nextDouble();
        return randomValue;
    }


}
