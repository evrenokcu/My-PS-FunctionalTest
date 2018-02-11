import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    private static final double[] salesValues = new double[]{40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95};

    public static void main(String[] args) {

        Function<String, Integer> wordCount = s -> s.split(" ").length;
        BiFunction<Integer, Integer, Integer> multiply = (v1, v2) -> v1 * v2;


        System.out.println(wordCount.apply("asdf fd asf fds as"));

        System.out.println(multiply.apply(3, 5));


        final FunctionOverTime salesFunction = FunctionOverTime.montyByMonth(salesValues);
        final FunctionOverTime fixedCostsFuction = FunctionOverTime.constant(15);
        final FunctionOverTime estimatedCostFunction = FunctionOverTime.line(5, 0.1);


        final FunctionOverTime profitFunction = FunctionOverTime.functionOf3.combine3(salesFunction, fixedCostsFuction, estimatedCostFunction, (s, f, e) -> s - f - e);

        final Sales sales = new Sales(FunctionOverTime.montyByMonth(salesValues));
        final FixedCosts fixedCosts=new FixedCosts(FunctionOverTime.constant(15));
        final IncrementalCost incrementalCostClass=new IncrementalCost(estimatedCostFunction);
        final Profit profitClass= new Profit(sales,incrementalCostClass,fixedCosts);




        for (int x = 1; x <= 12; x++) {

            System.out.print(salesFunction.valueAt(x));
            System.out.print(" :");
            System.out.println(profitClass.valueAt(x));
        }


        //final FunctionOverTime profitFunction;


    }

    class xxx{
        private final int macBook =1;

    }
}
