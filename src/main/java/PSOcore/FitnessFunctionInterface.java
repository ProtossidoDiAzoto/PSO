package PSOcore;

public interface FitnessFunctionInterface {

    /**
     * With this method we define the actual function to be maximized or minimized,
     * any additional constraints will have to be implemented here
     * @param particlePosition a set of double defining a particle's position in a swarm and the input of the function
     * @return the result of the function to optimize
     */
    double fitnessFunctionDefinition(double ... particlePosition);

    /**
     * Here we define how to evaluate the position of a particle,
     * for example if we wanted to maximize a function we will return
     * true if the first parameter is greater than the second
     * @param args parameters to evaluate
     * @return the outcome of the evaluation
     */
    boolean evaluationCriteria(double ... args );

    /**
     * Method that define how to initialize the best fit: it's IMPORTANT to
     * chose wisely the value, for example if we want to maximize
     * a good value to start could be negative infinite
     * (everything will result bigger than negative infinite)
     * @return the initial value for the best fit
     */
    double initializeBestFit();

    /**
     * Method that define the dimensionality of the the function's input
     * @return the dimensionality of the input
     */
    int inputDimensionality();

    /**
     * method that allows to define the lower limit for the random generation of the particles
     * @return lower limit for the particle
     */
    double minBound();

    /**
     * method that allows to define the upper limit for the random generation of the particles
     * @return upper limit for the particle
     */
    double maxBound();

}
