package test1;

import PSOcore.FitnessFunctionInterface;

public class FunctionToMaximizeUnderConstraint implements FitnessFunctionInterface {

    double bound = 100;

    @Override
    public double fitnessFunctionDefinition(double ... particlePosition) {
        double x = particlePosition[0];
        double y = particlePosition[1];
        double z = 3 * Math.pow(1-x,2) * Math.exp( -Math.pow(x,2) - Math.pow(y+1,2) ) - 10 * (x/5 - Math.pow(x,3) - Math.pow(y,5) ) * Math.exp(-Math.pow(x,2)-Math.pow(y,2)) - 1/3 * Math.exp(-1*Math.pow(x+1,2)-Math.pow(y,2));

        // Constraint

        if(z>8){
            z = -1;
        }
        
        return z;
    }

    @Override
    public boolean evaluationCriteria(double ... args) {


        double param1 = args[0];
        double param2 = args[1];
        return param1 >= param2 ? true : false;

    }


    @Override
    public double initializeBestFit() {
        return Double.NEGATIVE_INFINITY;
    }

    @Override
    public int inputDimensionality() {
        return 2;
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
