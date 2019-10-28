package com.company;

public class Isnumeric {
    public Isnumeric() {
    }

    public boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
            if (d == 0 ){
                return false;
            }
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public boolean isDigit(String strNum) {
        try {
            double d = Integer.parseInt(strNum);
            if (d <= 0 ){
                return false;
            }
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

}

