package sample;

import java.util.Random;

public class Model {
    private int n;
    private double[] valueArrX;
    private double[] valueArrY;
    private Random random = new Random();

    public Model(int n) {
        this.n = n;
        generate();
    }

    private void generate(){
        valueArrX = new double[n];
        valueArrY = new double[n];
        for (int i = 0; i < this.n; i++) {
            valueArrX[i] = random.nextDouble() + 1;
            valueArrY[i] = random.nextDouble() + 1;
        }
    }
    
    double countMathExp(double[] arr){
        double counter = 0;
        for (int i = 0; i < arr.length; i++) {
            counter += arr[i];
        }
        return counter/arr.length;
    }
    
    double countCov(double[] arrX,double[] arrY , double mathExpX, double mathExpY){
        double counter = 0;
        for (int i = 0; i < arrX.length; i++) {
            counter += (arrX[i]-mathExpX)*(arrY[i] - mathExpY);
        }
        return counter/arrX.length;
    }

    public double[] getValueArrX() {
        return valueArrX;
    }

    public double[] getValueArrY() {
        return valueArrY;
    }
}


