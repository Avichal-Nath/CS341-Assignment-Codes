import java.util.Scanner;
// Q1 Main Program 
// method implementation with allowing user to enter there paramters and get interest calculated.
public class CalcInterest {

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

    private static double determineInterestRate(double loanAmount, int yearLoan, int loanType) {
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

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continueLoop = true;

            while (continueLoop) {
                // Input section
                System.out.println("Enter loan type (1 for Home, 2 for Property): ");
                int loanType = scanner.nextInt();

                System.out.println("Enter loan amount: ");
                double loanAmount = scanner.nextDouble();

                System.out.println("Enter loan year: ");
                int yearLoan = scanner.nextInt();

                // Process the interest rate and loan
                double interest = computeLoanInterest(loanAmount, yearLoan, loanType);
                double interestRate = determineInterestRate(loanAmount, yearLoan, loanType);

                if (interest == -1) {
                    System.out.println("Invalid input. Please check the loan type, amount, or year.");
                } else {
                    System.out.println("Interest rate used: " + (interestRate * 100) + "%");
                    System.out.println("Total interest: $" + interest);
                }

                // Check if the user wants to continue
                System.out.println("Do you want to calculate again? (yes/no): ");
                String userResponse = scanner.next();

                if (!userResponse.equalsIgnoreCase("yes")) {
                    continueLoop = false;
                }
            }
        }
        System.out.println("Thank you for using the interest calculator!");
    }
}