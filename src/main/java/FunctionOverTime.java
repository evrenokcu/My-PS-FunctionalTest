@FunctionalInterface
interface FunctionOverTime {
    double valueAt(int time);

    static FunctionOverTime montyByMonth(final double[] values) {
        return time -> values[time - 1];
    }

    static FunctionOverTime constant(final double value) {
        return polynomial(new double[]{value});
    }

    static FunctionOverTime line(final double intercept, final double slope) {
        return polynomial(new double[]{intercept, slope});
    }

    static FunctionOverTime polynomial(final double[] coefficients) {
        return time -> {
            double val = 0;
            for (int x = 0; x < coefficients.length; x++) {
                val += Math.pow(time, x) * coefficients[x];
            }
            return val;
        };
    }


    @FunctionalInterface
    interface functionOf3 {
        double apply(double a, double b, double c);

        static FunctionOverTime combine3(final FunctionOverTime first, final FunctionOverTime second, final FunctionOverTime third, final functionOf3 f) {
            return time -> f.apply(first.valueAt(time), second.valueAt(time), third.valueAt(time));
        }
    }
}
