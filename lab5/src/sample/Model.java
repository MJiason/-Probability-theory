package sample;


import java.util.Random;

public class Model {
    private int nodNum;
    private float firstNodIntensity;
    private float secondNodIntensity;
    private static final int COUNT_OPERATIONS = 1000;
    private double firstImagNodeTime;
    private double secondImagNodeTime;
    private double thirdImagNodeTime;
    private double fourthImagNodeTime;


    public Model(int nodNum, float firstNodIntensity, float secondNodIntensity) {
        this.nodNum = nodNum;
        this.firstNodIntensity = firstNodIntensity * 4;
        this.secondNodIntensity = secondNodIntensity * 4;
        countProbability(COUNT_OPERATIONS);
    }
    private double countTime(float intensity){
        double currentTime = 0;
        Random random = new Random();
            currentTime = -(1/intensity)*Math.log(random.nextDouble());
        return currentTime;
    }

    private void countProbability(int countOperations){
        double totalTime = 0;
        for (int i = 0; i < countOperations ; i++) {
            if (nodNum == 1){
                firstImagNodeTime += countTime(firstNodIntensity);
                secondImagNodeTime += countTime(firstNodIntensity);
                nodNum = 2;
            }
            else {thirdImagNodeTime += countTime(secondNodIntensity);
                fourthImagNodeTime += countTime(secondNodIntensity);
            nodNum = 1;}
        }
        totalTime = firstImagNodeTime + secondImagNodeTime + thirdImagNodeTime + fourthImagNodeTime;
        firstImagNodeTime = firstImagNodeTime / totalTime;
        secondImagNodeTime = secondImagNodeTime / totalTime;
        thirdImagNodeTime = thirdImagNodeTime / totalTime;
        fourthImagNodeTime = fourthImagNodeTime / totalTime;
    }

    public double getFirstImagNodeTime() {
        return  firstImagNodeTime;
    }

    public double getSecondImagNodeTime() {
        return secondImagNodeTime;
    }

    public double getThirdImagNodeTime() {
        return thirdImagNodeTime;
    }

    public double getFourthImagNodeTime() {
        return fourthImagNodeTime;
    }
}
