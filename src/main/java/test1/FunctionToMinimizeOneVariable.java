package test1;

import PSOcore.FitnessFunctionInterface;
/**
 * @author Lorenzo Matteucci
 */
public class FunctionToMinimizeOneVariable implements FitnessFunctionInterface {

    double bound = 1000;

    @Override
    public double fitnessFunctionDefinition(double ... particlePosition) {
        double x = particlePosition[0];
        double y= Math.pow(x,4)-x;
        return y;
    }

    @Override
    public boolean evaluationCriteria(double ... args) {

        double param1 = args[0];
        double param2 = args[1];
        return param1 <= param2 ? true : false;

    }

    @Override
    public double initializeBestFit() {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public int inputDimensionality() {
        return 1;
    }

    @Override
    public double minBound() {
        return -bound;
    }

    @Override
    public double maxBound() {
        return bound;
    }
}
