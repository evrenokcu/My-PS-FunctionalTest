class Sales implements QuantityOfInterest {
    FunctionOverTime valueFunction;

    public Sales(FunctionOverTime valueFunction) {
        this.valueFunction = valueFunction;
    }

    @Override
    public String getName() {
        return "Sales";
    }

    @Override
    public double valueAt(int time) {
        return valueFunction.valueAt(time);
    }
}
