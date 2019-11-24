package sample;

public class MainTemp {
    public static void main(String[] args) {
        Model model = new Model(5000);
        double[] arrX = model.getValueArrX();
        double[] arrY = model.getValueArrY();
        double mathExpX = model.countMathExp(arrX);
        double mathExpY = model.countMathExp(arrY);
        double cov = model.countCov(arrX, arrY, mathExpX, mathExpY);

        System.out.println(mathExpX);
        System.out.println(mathExpY);
        System.out.println(cov);

    }
}
