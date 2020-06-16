package test1;

import PSOcore.MultiswarmPSO;

public class MainTest1 {
    public static void main(String[] args){
        CustomFunction cf = new CustomFunction();
        //(int numSwarms, int particlesPerSwarm, FitnessFunctionInterface fitnessFunction)
        MultiswarmPSO mPSO = new MultiswarmPSO(20,5000,cf);
        mPSO.startSearchingOptimal(100);

    }
}
