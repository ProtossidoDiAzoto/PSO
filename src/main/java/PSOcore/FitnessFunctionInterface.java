package PSOcore;

public interface FitnessFunctionInterface {

    double getFitness(double ... particlePosition);

    boolean evaluationCriteria(double ... args );

}
