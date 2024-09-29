import java.util.Scanner;

public class CalcInterest {

    public static void main(String[] args) {
        // Collect user input
        try ( // Create a Scanner object to read user input
                Scanner scanner = new Scanner(System.in)) {
            // Collect user input
            System.out.print("Enter loan type (1 for Home, 2 for Property): ");
            int loanType = scanner.nextInt();
            System.out.print("Enter loan amount: ");
            double loanAmount = scanner.nextDouble();
            System.out.print("Enter loan duration in years: ");
            int yearLoan = scanner.nextInt();
            // Compute the interest
            double interest = computeLoanInterest(loanAmount, yearLoan, loanType);
            double interestRate = determineInterestRate(loanAmount, yearLoan, loanType);
            // Output the result
            if (interest == -1 || interestRate == -1) {
                System.out.println("Error: Invalid input. Please check your loan amount, duration, or type.");
            } else {
                System.out.println("Interest Rate Used: " + (interestRate * 100) + "%");
                System.out.println("Total Interest to be paid: $" + interest);
            }
            // Close the scanner
        }
    }

    public static double computeLoanInterest(double loanAmount, int yearLoan, int loanType) {
        if (loanAmount <= 0 || yearLoan <= 0 || yearLoan > 30 || (loanType != 1 && loanType != 2)) {
            return -1;  // Error check for invalid inputs
        }

        double interestRate = determineInterestRate(loanAmount, yearLoan, loanType);
        if (interestRate == -1) {
            return -1;  // Return -1 if no valid rate found
        }

        return loanAmount * interestRate * yearLoan;  // Calculate simple interest
    }

    public static double determineInterestRate(double loanAmount, int yearLoan, int loanType) {
        if (loanType == 1) {  // Home loan
            if (loanAmount < 100000) {
                if (yearLoan <= 5) {
                    return 0.08;
                }
                return 0.065;  // Assuming same rate for > 5 years as no rate specified for > 5 and < 10
            } else if (loanAmount < 500000) {
                return 0.065;  // Assuming this rate for all years <= 10 as per previous condition
            } else {
                return 0.055;  // Assuming this rate for all years >= 11
            }
        } else if (loanType == 2) {  // Property loan
            if (loanAmount < 100000) {
                if (yearLoan <= 5) {
                    return 0.12;
                }
                return 0.085;  // Assuming this rate for years > 5 and <= 10
            } else if (loanAmount < 500000) {
                return 0.085;  // Assuming this rate for all years <= 10
            } else {
                return 0.07;  // Assuming this rate for all years >= 11
            }
        }
        return -1;  // Invalid loan type
    }
}