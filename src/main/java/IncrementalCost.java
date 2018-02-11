class IncrementalCost implements QuantityOfInterest {
    FunctionOverTime valueFunction;

    public IncrementalCost(FunctionOverTime valueFunction) {
        this.valueFunction = valueFunction;
    }

    @Override
    public String getName() {
        return "Incremental Costs";
    }

    @Override
    public double valueAt(int time) {
        return valueFunction.valueAt(time);
    }
}
