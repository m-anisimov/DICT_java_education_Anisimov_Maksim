package CreditCalculator;
// javac CreditCalculator\*.java
//java -Dprincipal=1000000 -Dperiods=60 -Dinterest=10 CreditCalculator\CreditCalculator.java
// java  -Dtype=diff  -Dprincipal=1000000  -Dinterest=10  -Dpayment=100000 CreditCalculator\CreditCalculator.java
// java  -Dtype=annuity  -Dprincipal=1000000  -Dpayment=10400  -Dperiods=8 CreditCalculator\CreditCalculator.java
// java -Dtype=annuity -Dprincipal=1000000 -Dpayment CreditCalculator\CreditCalculator.java
//java  -Dtype=diff  -Dprincipal=30000  -Dperiods=-14  -Dinterest=10 CreditCalculator\CreditCalculator.java
//java  -Dtype=diff  -Dprincipal=1000000  -Dpayment=104000 CreditCalculator\CreditCalculator.java

//java -Dtype=diff -Dprincipal=1000000 -Dperiods=10 -Dinterest=10 CreditCalculator\CreditCalculator.java
//java -Dtype=diff  -Dprincipal=500000  -Dperiods=8  -Dinterest="7.8" CreditCalculator\CreditCalculator.java
//java -Dtype=annuity  -Dprincipal=1000000  -Dperiods=60  -Dinterest=10 CreditCalculator\CreditCalculator.java
//java -Dtype=annuity  -Dpayment=8722  -Dperiods=120  -Dinterest="5.6" CreditCalculator\CreditCalculator.java
//java  -Dtype=annuity  -Dprincipal=500000  -Dpayment=23000  -Dinterest="7.8" CreditCalculator\CreditCalculator.java

public class CreditCalculator {
  //  static String type, principal, periods, interest, payment;
    public static void main(String[] args) {

/*        type = System.getProperty("type");
        principal = System.getProperty("principal"); // P
        periods = System.getProperty("periods"); // n
        interest = System.getProperty("interest"); // for i calc
        payment = System.getProperty("payment"); // A
        */
        DataCheck dc = new DataCheck();
        //DataCheck dataCheck = new DataCheck(type, principal, periods, interest, payment);

        //printArgs();

        if (!dc.isArgsCorrect()) {
            System.out.println("Incorrect parameters");
            //return;
        }
        dc.printArgs();
        //CalculatorLogic calculatorLogic = new CalculatorLogic(type, principal, periods, interest, payment);

    }
/*    private static void printArgs(){
        System.out.println("Type: " + type);
        System.out.println("Loan principal: " + principal);
        System.out.println("Periods" + periods);
        System.out.println("Interest: " + interest);
        System.out.println("Payment: " + payment);
    }*/

}
