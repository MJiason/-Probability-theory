package sample;

import Jama.Matrix;

public class TheoreticProb {
    private float firstNodIntensity;
    private float secondNodIntensity;
    private double[][] lhsArray;
    private double[] rhsArray;
    private Matrix lhs;
    private Matrix rhs;
    private Matrix ans;


    public TheoreticProb(float firstNodIntensity, float secondNodIntensity) {
        this.firstNodIntensity = firstNodIntensity;
        this.secondNodIntensity = secondNodIntensity;
        countProb();
    }

    private void countProb() {
        lhsArray = new double[][]{{1, 1}, {(double) -this.firstNodIntensity, (double) this.secondNodIntensity}};
        rhsArray = new double[]{1, 0};
        lhs = new Matrix(lhsArray);
        rhs = new Matrix(rhsArray, 2);
        ans = lhs.solve(rhs);
    }


    public float getTheoreticProbability1() {
        return (float) ans.get(0, 0);
    }

    public float getTheoreticProbability2() {
        return (float) ans.get(1, 0);

    }
}
