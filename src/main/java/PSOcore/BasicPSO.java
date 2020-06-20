package PSOcore;

/**
 *
 *   @author Lorenzo Matteucci
 *
 *
 *   particle swarm optimization (PSO) is a computational method that optimizes a problem by iteratively
 *   trying to improve a candidate solution with regard to a given measure of quality. It solves a problem
 *   by having a population of candidate solutions, here dubbed particles, and moving these particles around
 *   in the search-space according to simple mathematical formulae over the particle's position and velocity.
 *   Each particle's movement is influenced by its local best known position, but is also guided toward the best
 *   known positions in the search-space, which are updated as better positions are found by other particles.
 *   This is expected to move the swarm toward the best solutions.
 */
public class BasicPSO {

    private Swarm swarm;
    private double[] bestPosition;
    private double bestFitness;
    private FitnessFunctionInterface fitnessFunction;

    int dim;

    public BasicPSO(int particlesNumber, FitnessFunctionInterface fitnessFunction) {

        this.fitnessFunction = fitnessFunction;
        this.bestFitness = fitnessFunction.initializeBestFit();
        dim = fitnessFunction.inputDimensionality();

        Constants.MIN_BOUND_SWARM = fitnessFunction.minBound();
        Constants.MAX_BOUND_SWARM = fitnessFunction.maxBound();

        Common.INIT_BEST_FITNESS = fitnessFunction.initializeBestFit();

        swarm = new Swarm(particlesNumber, dim);

    }

    public void startSearchingOptimal(int epoch) {
        for (int i = 0; i < epoch; i++) {
            this.mainLoop();
        }
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public double[] getBestPosition() {
        return bestPosition;
    }

    public void mainLoop() {

            for (Particle particle : swarm.getParticles()) {
                double[] particleOldPosition = particle.getPosition().clone();
                particle.setFitness(fitnessFunction.fitnessFunctionDefinition(particleOldPosition));
                boolean isNewBestFitness = fitnessFunction.evaluationCriteria(particle.getFitness(),particle.getBestFitness());
                if (isNewBestFitness) {
                    particle.setBestFitness(particle.getFitness());
                    particle.setBestPosition(particleOldPosition);
                    boolean isNewBestFitnessInTheSwarm = fitnessFunction.evaluationCriteria(particle.getFitness(),swarm.getBestFitness());
                    if (isNewBestFitnessInTheSwarm) {
                        swarm.setBestFitness(particle.getFitness());
                        swarm.setBestPosition(particleOldPosition);
                        boolean isNewBestFitnessBetweenSwarms = fitnessFunction.evaluationCriteria(swarm.getBestFitness(),bestFitness);
                        if (isNewBestFitnessBetweenSwarms) {
                            bestFitness = swarm.getBestFitness();
                            bestPosition = swarm.getBestPosition().clone();
                        }
                    }
                }

                double[] position = particle.getPosition();
                double[] speed = particle.getSpeed();

                for (int i = 0; i < position.length-1 ; i++) {
                    position[i] += speed[i];
                }

                for (int i = 0; i < speed.length-1; i++) {
                    speed[i] = getNewParticleSpeedForIndex(particle, swarm, i);
                }

            }
        printCurrentBestPosition();
    }



    /**
     *
     * It's essential for the particle to change its speed since
     * that's how it manages to explore different possible solutions.
     *
     * The speed of the particle will need to make the particle move towards
     * the best position found by itself, by its swarm and by all the swarms,
     * assigning a certain weight to each of these. We'll call these weights,
     * cognitive weight, social weight and global weight, respectively.
     *
     * To add some variation, we'll multiply each of these weights with a
     * random number between 0 and 1. We'll also add an inertia factor to
     * the formula which incentivizes the particle not to slow down too much:
     *
     * @param particle particle taken in analysis
     * @param swarm swarm to which the particle belongs
     * @param index an index
     * @return the speed
     */

    private double getNewParticleSpeedForIndex(Particle particle, Swarm swarm, int index) {

        return  ((Constants.INERTIA_FACTOR * particle.getSpeed()[index])
                + (Common.getRandomPercentageOf(Constants.COGNITIVE_WEIGHT)
                * (particle.getBestPosition()[index] - particle.getPosition()[index]))
                + (Common.getRandomPercentageOf(Constants.SOCIAL_WEIGHT)
                * (swarm.getBestPosition()[index] - particle.getPosition()[index]))
                + (Common.getRandomPercentageOf(Constants.GLOBAL_WEIGHT)
                * (bestPosition[index] - particle.getPosition()[index])));
    }

    private void printCurrentBestPosition(){

        System.out.println("============================================");
        System.out.println("");
        String parameterLine = "";

        for (int i = 0; i < dim; i++) {
            String param = "Parameter " + i + " = "+bestPosition[i];
            parameterLine = parameterLine + param;
        }

        System.out.println(parameterLine);
        System.out.println("");

        String result = "Result = " + fitnessFunction.fitnessFunctionDefinition(bestPosition[0],bestPosition[1]);
        System.out.println(result);
        System.out.println("");
    }

}
