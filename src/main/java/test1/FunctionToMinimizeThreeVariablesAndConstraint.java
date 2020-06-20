package test1;

import PSOcore.FitnessFunctionInterface;


/**
 *
 * @author Lorenzo Matteucci
 *
 * Problem:
 * A small storage shed is to be constructed of material that cost
 *      1 dollar/squaredFoot for the roof,
 *      2 dollar/squaredFoot for the two side and the back, and
 *      5 dollar/squaredFoot for the front.
 *  The volume needs to be 756 cubicFoot, what dimensions
 *  will minimize the total cost of construction?
 *
 *
 *  Considering:
 *      z the height of the storage shed,
 *      x the width of the front of the storage shed and
 *      y the depth of the storage shed
 *
 *  Minimize:
 *      f(x,y,z) = 5xy + 2(2yz + xz) + xy
 * 	    f(x,y,z) = 7xz + 4yz + xy
 *
 * As Constraint we have
 *
 *      xyz = 756
 *      x > 0
 *      y > 0
 *      z > 0
 *
 * SOLUTION:
 *
 *      x = 12
 *      y = 21
 *      z =  3
 *
 *
 */
public class FunctionToMinimizeThreeVariablesAndConstraint implements FitnessFunctionInterface {

    double bound = 100;

    @Override
    public double fitnessFunctionDefinition(double ... particlePosition) {
        double x = particlePosition[0];
        double y = particlePosition[1];
        double z = particlePosition[2];

        double result = (7 * x * z) + (4 * y * z) + (x * y);

        if( (x < 0) || (y < 0) || (z < 0) || x*y*z < 755.5 || x*y*z > 756.5 || (result < 0)){
            return Double.MAX_VALUE;
        }
        return result;
    }

    @Override
    public boolean evaluationCriteria(double ... args) {

        double param1 = args[0];
        double param2 = args[1];
        return param1 < param2 ? true : false;

    }

    @Override
    public double initializeBestFit() {
        return Double.POSITIVE_INFINITY;
    }

    @Override
    public int inputDimensionality() {
        return 3;
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
