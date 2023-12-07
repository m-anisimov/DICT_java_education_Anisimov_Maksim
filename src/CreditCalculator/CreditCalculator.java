package CreditCalculator;

public class CreditCalculator {
    public static void main(String[] args) {

        String type = System.getProperty("type");
        String principal = System.getProperty("principal"); // P
        String periods = System.getProperty("periods"); // n
        String interest = System.getProperty("interest"); // for i calc
        String payment = System.getProperty("payment"); // A

        //calculatorLogic.dataAnalyze( type, principal, periods, interest, payment);
        CalculatorLogic calculatorLogic = new CalculatorLogic(type, principal, periods, interest, payment);

        System.out.println("Type: " + type);
        System.out.println("Loan principal: " + principal);
        System.out.println("Periods" + periods);
        System.out.println("Interest: " + interest);
        System.out.println("Payment: " + payment);
    }

}
