package PSOcore;

public class MultiswarmPSO {

    private Swarm[] swarms;
    private double[] bestPosition;
    private double bestFitness = Double.NEGATIVE_INFINITY;
    private FitnessFunctionInterface fitnessFunction;

    //Default  PSOcore.Swarm(int numParticles, int dimensionality, double minPos, double maxPos)

    int defaultDim = 2;


    public MultiswarmPSO(int numSwarms, int particlesPerSwarm, FitnessFunctionInterface fitnessFunction) {
        this.fitnessFunction = fitnessFunction;
        this.swarms = new Swarm[numSwarms];
        for (int i = 0; i < numSwarms; i++) {
            swarms[i] = new Swarm(particlesPerSwarm,defaultDim);
        }
        System.out.println("fin qui tutto bene");
    }

    public void mainLoop() {


        for (Swarm swarm : swarms) {
            for (Particle particle : swarm.getParticles()) {
                double[] particleOldPosition = particle.getPosition().clone();
                particle.setFitness(fitnessFunction.getFitness(particleOldPosition));
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
        }

        System.out.println(bestPosition[0]+"  "+bestPosition[1]);
        System.out.println(fitnessFunction.getFitness(bestPosition[0],bestPosition[1]));
    }



    /*
      public void mainLoop() {
        for (Swarm swarm : swarms) {
            for (Particle particle : swarm.getParticles()) {
                double[] particleOldPosition = particle.getPosition().clone();
                particle.setFitness(fitnessFunction.getFitness(particleOldPosition));
                if (particle.getFitness() > particle.getBestFitness()) {
                    particle.setBestFitness(particle.getFitness());
                    particle.setBestPosition(particleOldPosition);
                    if (particle.getFitness() > swarm.getBestFitness()) {
                        swarm.setBestFitness(particle.getFitness());
                        swarm.setBestPosition(particleOldPosition);
                        if (swarm.getBestFitness() > bestFitness) {
                            bestFitness = swarm.getBestFitness();
                            bestPosition = swarm.getBestPosition().clone();
                        }
                    }
                }

                double[] position = particle.getPosition();
                double[] speed = particle.getSpeed();
                position[0] += speed[0];
                position[1] += speed[1];
                speed[0] = getNewParticleSpeedForIndex(particle, swarm, 0);
                speed[1] = getNewParticleSpeedForIndex(particle, swarm, 1);
            }
        }
    }
    */


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
     * @param particle
     * @param swarm
     * @param index
     * @return
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

}
