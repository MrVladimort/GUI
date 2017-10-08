/**
 *
 *  @author Hravchenko Vladyslav S15567
 *
 */

package zadanie1;

public class Calc {

    private double result;
    private String calculated;

    public double calculate(String str){
        String parts[] = str.split(" ");
        double result = Double.parseDouble(parts[0]);
        for (int i = 1; i < parts.length-1; i++){
            switch (parts[i]){
                case "/" : result = divide(result, Double.parseDouble(parts[i+1])); break;
                case "*" : result = multiply(result, Double.parseDouble(parts[i+1])); break;
                case "+" : result = add(result, Double.parseDouble(parts[i+1])); break;
                case "-" : result = substract(result, Double.parseDouble(parts[i+1])); break;
            }
        }
        return result;
    }

    public void startGui(){ new Gui(); }

    public double add(double arg1, double arg2){
            result = arg1 + arg2;
            calculated = arg1 + " + " + arg2 + " = " + result;
            return result;
    }

    public double divide(double arg1, double arg2){
        result = arg1 / arg2;
        if (!Double.isInfinite(result)) {
            calculated = arg1 + " / " + arg2 + " = " + result;
        } else {
            calculated = arg1 + " / " + arg2 + " =  ERR";
            result = Double.NaN;
        }
        return result;
    }

    public double multiply(double arg1, double arg2) {
        result = arg1 * arg2;
        calculated = arg1 + " * " + arg2 + " = " + result;
        return result;
    }

    public double substract(double arg1, double arg2) {
        result = arg1 - arg2;
        calculated = arg1 + " - " + arg2 + " = " + result;
        return result;
    }

    @Override
    public String toString() {
        return calculated;
    }
}