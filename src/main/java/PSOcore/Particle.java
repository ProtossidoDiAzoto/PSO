package PSOcore;
/**
 * @author Lorenzo Matteucci
 */
public class Particle {


    private double[] position;
    private double[] speed;
    private double fitness;
    private double[] bestPosition;
    private double bestFitness = Common.INIT_BEST_FITNESS;

    public Particle(double[] position, double[] speed, double fitness, double[] bestPosition, double bestFitness) {
        this.position = position;
        this.speed = speed;
        this.fitness = fitness;
        this.bestPosition = bestPosition;
        this.bestFitness = bestFitness;
    }

    public Particle(double[] position, double[] speed) {
        this.position = position;
        this.speed = speed;
    }

    public double[] getPosition() {
        return position;
    }

    public double[] getSpeed() {
        return speed;
    }

    public double getFitness() {
        return fitness;
    }

    public double[] getBestPosition() {
        return bestPosition;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public void setSpeed(double[] speed) {
        this.speed = speed;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void setBestPosition(double[] bestPosition) {
        this.bestPosition = bestPosition;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }
}
