class Profit implements QuantityOfInterest {

    @Override
    public String getName() {
        return "Profit";
    }

    Sales sales;
    IncrementalCost incrementalCost;
    FixedCosts fixedCosts;

    public Profit(Sales sales, IncrementalCost incrementalCost, FixedCosts fixedCosts) {
        this.sales = sales;
        this.incrementalCost = incrementalCost;
        this.fixedCosts = fixedCosts;
    }

    @Override
    public double valueAt(int time) {
        return this.sales.valueAt(time) - incrementalCost.valueAt(time) - incrementalCost.valueAt(time);
    }
}
