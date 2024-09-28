import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalcInterestTest {

    // Home Loan Test Cases
    @Test
    public void testHomeLoanCase_TC_HB1() {
        assertEquals(39999.60, CalcInterest.computeLoanInterest(99999, 5, 1), 0.01, "TC_HB1 failed");
    }

    @Test
    public void testHomeLoanCase_TC_HB2() {
        assertEquals(32500.00, CalcInterest.computeLoanInterest(100000, 5, 1), 0.01, "TC_HB2 failed");
    }

    @Test
    public void testHomeLoanCase_TC_HB3() {
        assertEquals(39000.00, CalcInterest.computeLoanInterest(100000, 6, 1), 0.01, "TC_HB3 failed");
    }

    @Test
    public void testHomeLoanCase_TC_HB4() {
        assertEquals(324999.35, CalcInterest.computeLoanInterest(499999, 10, 1), 0.01, "TC_HB4 failed");
    }

    @Test
    public void testHomeLoanCase_TC_HB5() {
        assertEquals(302500.00, CalcInterest.computeLoanInterest(500000, 11, 1), 0.01, "TC_HB5 failed");
    }

    // Property Loan Test Cases
    @Test
    public void testPropertyLoanCase_TC_PB1() {
        assertEquals(59999.40, CalcInterest.computeLoanInterest(99999, 5, 2), 0.01, "TC_PB1 failed");
    }

    @Test
    public void testPropertyLoanCase_TC_PB2() {
        assertEquals(42500.00, CalcInterest.computeLoanInterest(100000, 5, 2), 0.01, "TC_PB2 failed");
    }

    @Test
    public void testPropertyLoanCase_TC_PB3() {
        assertEquals(382499.15, CalcInterest.computeLoanInterest(499999, 9, 2), 0.1, "TC_PB3 failed");
    }

    @Test
    public void testPropertyLoanCase_TC_PB4() {
        assertEquals(385000.00, CalcInterest.computeLoanInterest(500000, 11, 2), 0.01, "TC_PB4 failed");
    }

    @Test
    public void testPropertyLoanCase_TC_PB5() {
        assertEquals(630000.00, CalcInterest.computeLoanInterest(600000, 15, 2), 0.01, "TC_PB5 failed");
    }

    // Error Handling Test Cases
    @Test
    public void testInvalidLoanType_TC_E1() {
        assertEquals(-1, CalcInterest.computeLoanInterest(100000, 5, 3), 0.01, "TC_E1 failed");
    }

    @Test
    public void testNegativeLoanAmount_TC_E2() {
        assertEquals(-1, CalcInterest.computeLoanInterest(-10000, 5, 1), 0.01, "TC_E2 failed");
    }

    @Test
    public void testNegativeYearLoan_TC_E3() {
        assertEquals(-1, CalcInterest.computeLoanInterest(100000, -5, 1), 0.01, "TC_E3 failed");
    }

    @Test
    public void testUnrealisticYearLoan_TC_E4() {
        assertEquals(-1, CalcInterest.computeLoanInterest(100000, 50, 1), 0.01, "TC_E4 failed");
    }

    @Test
    public void testYearLoanZero_TC_E5() {
        assertEquals(-1, CalcInterest.computeLoanInterest(50000, 0, 2), 0.01, "TC_E5 failed");
    }

    @Test
    public void testInvalidLoanTypeZero_TC_E6() {
        assertEquals(-1, CalcInterest.computeLoanInterest(100000, 5, 0), 0.01, "TC_E6 failed");
    }
}
