package PSOcore;

/**
 *  https://www.baeldung.com/java-multi-swarm-algorithm
 */
public class BasicPSO {

    private int dimensionality;
    private int iteration;




    /*
    public void mainLoop() {
        for (PSOcore.Swarm swarm : swarms) {
            for (PSOcore.Particle particle : swarm.getParticles()) {
                long[] particleOldPosition = particle.getPosition().clone();
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

                long[] position = particle.getPosition();
                long[] speed = particle.getSpeed();
                position[0] += speed[0];
                position[1] += speed[1];
                speed[0] = getNewParticleSpeedForIndex(particle, swarm, 0);
                speed[1] = getNewParticleSpeedForIndex(particle, swarm, 1);
            }
        }
    }

     */


    /*
    private int getNewParticleSpeedForIndex(
            PSOcore.Particle particle, PSOcore.Swarm swarm, int index) {

        return (int) ((PSOcore.Constants.INERTIA_FACTOR * particle.getSpeed()[index])
                + (randomizePercentage(PSOcore.Constants.COGNITIVE_WEIGHT)
                * (particle.getBestPosition()[index] - particle.getPosition()[index]))
                + (randomizePercentage(PSOcore.Constants.SOCIAL_WEIGHT)
                * (swarm.getBestPosition()[index] - particle.getPosition()[index]))
                + (randomizePercentage(PSOcore.Constants.GLOBAL_WEIGHT)
                * (bestPosition[index] - particle.getPosition()[index])));
    }
    */
}
