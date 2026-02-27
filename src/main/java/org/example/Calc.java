package org.example;

public class Calc {
//    public <T extends Number> double add(T a , T b){
//        return a.doubleValue() +b.doubleValue();
//    }

//    public double add(Object a,Object b){
//        double num1=parseIoDouble(a);
//        double num2=parseIoDouble(b);
//        return num1+num2;
//    }
//    private double parseIoDouble(Object value){
//        if(value instanceof Number){
//            return ((Number) value).doubleValue();
//        }
//        if(value instanceof String){
//            try{
//                return Double.parseDouble((String) value);
//            }
//            catch(NumberFormatException e){
//                throw new IllegalArgumentException("Enter numbers only");
//            }
//        }
//        throw new IllegalArgumentException("enter numbers");
//    }
//public double add(Object a, Object b) {
//
//    double num1;
//    double num2;
//
//    // Parse first value
//    if (a instanceof Number) {
//        num1 = ((Number) a).doubleValue();
//    }
//    else if (a instanceof String) {
//        try {
//            num1 = Double.parseDouble((String) a);
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("Enter numbers only");
//        }
//    }
//    else {
//        throw new IllegalArgumentException("Enter numbers only");
//    }
//
//    // Parse second value
//    if (b instanceof Number) {
//        num2 = ((Number) b).doubleValue();
//    }
//    else if (b instanceof String) {
//        try {
//            num2 = Double.parseDouble((String) b);
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("Enter numbers only");
//        }
//    }
//    else {
//        throw new IllegalArgumentException("Enter numbers only");
//    }
//
//    return num1 + num2;
//}

    public double add(Object a, Object b) {
        return parseToDouble(a) + parseToDouble(b);
    }

    private double parseToDouble(Object value) {

        if (value == null) {
            throw new NullPointerException("Input value cannot be null");
        }

        if (value instanceof Number) {
            double result = ((Number) value).doubleValue();

            if (Double.isNaN(result) || Double.isInfinite(result)) {
                throw new ArithmeticException("Invalid numeric value (NaN or Infinite)");
            }

            return result;
        }

        if (value instanceof String) {
            String str = ((String) value).trim();

            if (str.isEmpty()) {
                throw new IllegalArgumentException("Empty string is not a valid number");
            }

            try {
                double result = Double.parseDouble(str);

                if (Double.isNaN(result) || Double.isInfinite(result)) {
                    throw new ArithmeticException("Invalid numeric value (NaN or Infinite)");
                }

                return result;

            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid numeric format: " + str);
            }
        }

        throw new IllegalArgumentException(
                "Unsupported type: " + value.getClass().getName()
        );
    }
}
