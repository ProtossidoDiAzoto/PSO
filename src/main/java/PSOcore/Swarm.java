package PSOcore;

import static PSOcore.Constants.MAX_BOUND_SWARM;
import static PSOcore.Constants.MIN_BOUND_SWARM;

public class Swarm {
    private Particle[] particles;
    private double[] bestPosition;
    private double bestFitness = Double.NEGATIVE_INFINITY;

    private double defaultMinPos = 100.0;
    private double getDefaultMaxPos = 100.0;

    public Swarm(int numParticles, int dimensionality, double minPos, double maxPos) {

        particles = new Particle[numParticles];

        for (int i = 0; i < numParticles; i++) {

            double[] position = new double[dimensionality];
            double[] velocity = new double[dimensionality];

            for (int j = 0; j < dimensionality; ++i) {
                position[i] = Common.getRandomNumberDouble(minPos,maxPos);
                velocity[i] = Common.getRandomNumberDouble(minPos,maxPos);
            }
            particles[i] = new Particle(position, velocity);
        }
    }

    public Swarm(int numParticles, int dimensionality) {

        particles = new Particle[numParticles];

        for (int i = 0; i < numParticles; i++) {

            double[] position = new double[dimensionality];
            double[] velocity = new double[dimensionality];

            for (int j = 0; j < dimensionality; j++) {
                position[j] = Common.getRandomNumberDouble(MIN_BOUND_SWARM,MAX_BOUND_SWARM);
                velocity[j] = Common.getRandomNumberDouble(MIN_BOUND_SWARM,MAX_BOUND_SWARM);
            }
            particles[i] = new Particle(position, velocity);
        }
    }

    // methods omitted


    public Particle[] getParticles() {
        return particles;
    }

    public void setParticles(Particle[] particles) {
        this.particles = particles;
    }

    public double[] getBestPosition() {
        return bestPosition;
    }

    public void setBestPosition(double[] bestPosition) {
        this.bestPosition = bestPosition;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public void setBestFitness(double bestFitness) {
        this.bestFitness = bestFitness;
    }
}
