package test1;

import PSOcore.BasicPSO;
import PSOcore.MultiSwarmPSO;

public class MainTest {
    public static void main(String[] args){

        int nFunction = 0;

        switch(nFunction) {
            case 0:
                FunctionToMaximize ftMax = new FunctionToMaximize();
                MultiSwarmPSO mPSO = new MultiSwarmPSO(20,500,ftMax);
                mPSO.startSearchingOptimal(100);
                printBestPosition(mPSO.getBestPosition(),mPSO.getBestFitness());
                break;
            case 1:
                FunctionToMinimize ftMin = new FunctionToMinimize();
                MultiSwarmPSO mPSO2 = new MultiSwarmPSO(20,500,ftMin);
                mPSO2.startSearchingOptimal(100);
                printBestPosition(mPSO2.getBestPosition(),mPSO2.getBestFitness());
                break;
            case 2:
                FunctionToMaximizeUnderConstraint ftMaxUC = new FunctionToMaximizeUnderConstraint();
                MultiSwarmPSO mPSO3 = new MultiSwarmPSO(20,500,ftMaxUC);
                mPSO3.startSearchingOptimal(100);
                printBestPosition(mPSO3.getBestPosition(),mPSO3.getBestFitness());
                break;
            case 3:
                FunctionToMaximize ftMaxUCb = new FunctionToMaximize();
                BasicPSO bPSO = new BasicPSO(5000,ftMaxUCb);
                bPSO.startSearchingOptimal(100);
                printBestPosition(bPSO.getBestPosition(),bPSO.getBestFitness());
                break;
            default:
                System.out.println("Not valid");
        }

    }

    public static void printBestPosition(double[] position, double optimal){

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println("-----------------------------------------");
        System.out.println();
        for (int i = 0; i < position.length; i++) {
            System.out.println("PARAMETER " + i + " : "+ position[i]);
        }
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println("OPTIMAL : "+ optimal);
    }
}
