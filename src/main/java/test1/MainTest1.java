package test1;

import PSOcore.MultiswarmPSO;

public class MainTest1 {
    public static void main(String[] args){
        CustomFunction cf = new CustomFunction();
        //(int numSwarms, int particlesPerSwarm, FitnessFunctionInterface fitnessFunction)
        MultiswarmPSO mPSO = new MultiswarmPSO(20,5000,cf);
        for (int i = 0; i < 10000; i++) {
            mPSO.mainLoop();
        }

    }
}
