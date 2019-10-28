package com.company;

import java.util.Random;

public class Model {
    private double lambda;
    private int k;
    private Random random = new Random();
    public Model(String lambda, String k) {
        this.lambda = Integer.valueOf(lambda);
        this.k = Integer.valueOf(k);
    }

    private double generateValue() {
        double R;
        double sum = 0;
        for (int i = 0; i < this.k; i++) {
            sum += Math.log(random.nextDouble());
        }
        R = -1 / (this.lambda * this.k) * sum;
        return R;
    }


    double[] genArrayValues() {
        double[] arrayValues = new double[50000];
        for (int i = 0; i < arrayValues.length; i++) {
            arrayValues[i] = generateValue();
        }
        return arrayValues;
    }


    double countMathExpectation(double[] array) {
        double mathExpectation = 0;
        for (double v : array) {
            mathExpectation += v;
        }
        return mathExpectation / array.length;
    }

    double countDispersion(double[] array, double mathExpectation) {
        double dispersion = 0;
        for (double v : array) {
            dispersion += Math.pow((v - mathExpectation), 2);
        }
        return dispersion / array.length;
    }

    double Sigma(double Dispersion){
        return Math.sqrt(Dispersion);
    }

    double mathExpectation() {
        return 1 / this.lambda;
    }

    double dispersion() {
        return 1 / (this.k * Math.pow(lambda, 2));
    }

}
