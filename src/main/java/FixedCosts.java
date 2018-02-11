public class FixedCosts implements QuantityOfInterest {
    @Override
    public String getName() {
        return "FixedCosts";
    }


    @Override
    public double valueAt(int time) {
        return valueFunction.valueAt(time);
    }

    FunctionOverTime valueFunction;

    public FixedCosts(FunctionOverTime valueFunction) {
        this.valueFunction = valueFunction;
    }

}
