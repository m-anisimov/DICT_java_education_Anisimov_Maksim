package CreditCalculator;

// command lines:
//javac CreditCalculator\*.java
//java -Dprincipal=1000000 -Dperiods=60 -Dinterest=10 CreditCalculator\CreditCalculator.java
//java -Dtype=diff  -Dprincipal=1000000  -Dinterest=10  -Dpayment=100000 CreditCalculator\CreditCalculator.java
//java -Dtype=annuity  -Dprincipal=1000000  -Dpayment=10400  -Dperiods=8 CreditCalculator\CreditCalculator.java
//java -Dtype=annuity -Dprincipal=1000000 -Dpayment CreditCalculator\CreditCalculator.java
//java -Dtype=diff  -Dprincipal=30000  -Dperiods=-14  -Dinterest=10 CreditCalculator\CreditCalculator.java
//java -Dtype=diff  -Dprincipal=1000000  -Dpayment=104000 CreditCalculator\CreditCalculator.java

//java -Dtype=diff -Dprincipal=1000000 -Dperiods=10 -Dinterest=10 CreditCalculator\CreditCalculator.java
//java -Dtype=diff  -Dprincipal=500000  -Dperiods=8  -Dinterest="7.8" CreditCalculator\CreditCalculator.java
//java -Dtype=annuity  -Dprincipal=1000000  -Dperiods=60  -Dinterest=10 CreditCalculator\CreditCalculator.java
//java -Dtype=annuity  -Dpayment=8722  -Dperiods=120  -Dinterest="5.6" CreditCalculator\CreditCalculator.java
//java -Dtype=annuity  -Dprincipal=500000  -Dpayment=23000  -Dinterest="7.8" CreditCalculator\CreditCalculator.java
//java -Dtype=annuity  -Dprincipal=1000000  -Dpayment=15000  -Dinterest="10" CreditCalculator\CreditCalculator.java

public class CreditCalculator {
    public static void main(String[] args) {
        DataCheck dataCheck = new DataCheck();

        if (!dataCheck.isArgsCorrect()) {
            System.out.println("Incorrect parameters");
            return;
        }
        CalculatorLogic calculatorLogic = new CalculatorLogic();
        DataCheck.Flag calc = dataCheck.getMethod();
        switch(calc){
            case DIFF_PAY : calculatorLogic.calcDiffPay(dataCheck.getdPrincipal(), dataCheck.getdInterest(), dataCheck.getdPeriods()); break;
            case ANN_PAY : calculatorLogic.calcAnnuityPay(dataCheck.getdPrincipal(), dataCheck.getdInterest(), dataCheck.getdPeriods()); break;
            case PRINC : calculatorLogic.calcPrincipal(dataCheck.getdPayment(), dataCheck.getdInterest(), dataCheck.getdPeriods()); break;
            case PERIOD : calculatorLogic.calcPeriod(dataCheck.getdPrincipal(), dataCheck.getdPayment(), dataCheck.getdInterest()); break;
        }
    }
}
