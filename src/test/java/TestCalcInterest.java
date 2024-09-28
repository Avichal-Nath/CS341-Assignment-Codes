public class TestCalcInterest {


//program to test the test cases and compare the expected output 
//with the actual output_results) as PASSED or FAILED
//Question 1 - Task 2/3

    private static final double DELTA = 0.0001; // Precision threshold for comparison

    public static void main(String[] args) {
        double[][] testCases = {
                { 1, 99999, 5, 39999.6 },
                { 1, 100000, 5, 32500 },
                { 1, 100000, 6, 39000 },
                { 1, 499999, 10, 324999.35 },
                { 1, 500000, 11, 302500 },
                { 2, 99999, 5, 59999.4 },
                { 2, 100000, 5, 42500 },
                { 2, 499999, 9, 382499.15 },
                { 2, 500000, 11, 385000 },
                { 1, 50000, 3, 12000 },
                { 1, 75000, 8, 39000 },
                { 1, 125000, 9, 73125 },
                { 1, 350000, 11, 211750 },
                { 1, 600000, 12, 396000 },
                { 2, 80000, 4, 38400 },
                { 2, 99999, 6, 50999.47 },
                { 2, 200000, 7, 119000 },
                { 2, 450000, 10, 382500 },
                { 2, 600000, 15, 630000 },
                { 3, 100000, 5, -1 },
                { 1, -10000, 5, -1 },
                { 1, 100000, -5, -1 },
                { 1, 100000, 50, -1 },
                { 2, 50000, 0, -1 },
                { 0, 100000, 5, -1 },
        };

        for (double[] tc : testCases) {
            int loanType = (int) tc[0];
            double loanAmount = tc[1];
            int yearLoan = (int) tc[2];
            double expected = tc[3];
            double result = CalcInterest.computeLoanInterest(loanAmount, yearLoan, loanType);

            boolean isPassed = Math.abs(result - expected) < DELTA;
            System.out.printf("Test Case [%d, %.0f, %d] -> Result: %.2f, Expected: %.2f, %s\n",
                    loanType, loanAmount, yearLoan, result, expected,
                    isPassed ? "PASSED" : "FAILED");
        }
    }
}
