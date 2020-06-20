package test1;

import PSOcore.BasicPSO;
import PSOcore.MultiSwarmPSO;
/**
 * @author Lorenzo Matteucci
 */
public class MainTest {
    public static void main(String[] args){

        /*
        Set nFunction as:

            0 --> Maximize a function with global maximum using mPSO

            1 --> Minimize a function with global minimum using mPSO

            2 --> Maximize a function with global maximum but with
                  constraint using mPSO

            3 --> Maximize a function with global maximum using basicPSO

            4 --> Minimize a function with global minimum and one variable
                  using mPSO

            5 --> Minimize a function with three variable and several Constraint
                  details in class "FunctionToMinimizeThreeVariablesAndConstraint"

         */

        int nFunction = 2;

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
                bPSO.startSearchingOptimal(1000);
                printBestPosition(bPSO.getBestPosition(),bPSO.getBestFitness());
                break;
            case 4:
                FunctionToMinimizeOneVariable ftMin1Var= new FunctionToMinimizeOneVariable();
                MultiSwarmPSO mPSO1v = new MultiSwarmPSO(2,50,ftMin1Var);
                mPSO1v.startSearchingOptimal(1000);
                printBestPosition(mPSO1v.getBestPosition(),mPSO1v.getBestFitness());
                break;
            case 5:
                FunctionToMinimizeThreeVariablesAndConstraint ftMin3Var= new FunctionToMinimizeThreeVariablesAndConstraint();
                MultiSwarmPSO mPSO3v = new MultiSwarmPSO(200,10000,ftMin3Var);
                mPSO3v.startSearchingOptimal(100);
                printBestPositionRounded(mPSO3v.getBestPosition(),mPSO3v.getBestFitness());
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

    public static void printBestPositionRounded(double[] position, double optimal){

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println("-----------------------------------------");
        System.out.println();
        for (int i = 0; i < position.length; i++) {
            System.out.println("PARAMETER " + i + " : "+ Math.round(position[i]));
        }
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();
        System.out.println("OPTIMAL : "+ Math.round(optimal));
    }
}
