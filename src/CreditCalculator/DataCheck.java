package CreditCalculator;

public class DataCheck {
    private String type, principal, periods, interest, payment;
    private Double dPrincipal, dPeriods, dInterest, dPayment;

    enum Flag {EMPTY, DIFF_PAY, ANN_PAY, PRINC, PERIOD};
    private Flag method;
    public DataCheck() {
        this.type = System.getProperty("type");
        this.principal = System.getProperty("principal"); // P
        this.periods = System.getProperty("periods"); // n
        this.interest = System.getProperty("interest"); // for i calc
        this.payment = System.getProperty("payment"); // A
        this.method = Flag.EMPTY;
    }

    public Flag getMethod() {
        return method;
    }

    public Double getdInterest() {
        return dInterest;
    }

    public Double getdPeriods() {
        return dPeriods;
    }

    public Double getdPrincipal() {
        return dPrincipal;
    }

    public Double getdPayment() {
        return dPayment;
    }

    public String getType() {
        return type;
    }

    public boolean isArgsCorrect(){
        int sum = 0;

        if (type==null || !(type.equals("diff") || type.equals("annuity")))
            return false;

        dInterest = parseDoublePositive(interest);
        if (dInterest.equals(-1.0))
            return false;

        dPrincipal = parseDoublePositive(principal);
        dPayment = parseDoublePositive(payment);
        dPeriods = parseDoublePositive(periods);

        if (type.equals("diff") ){
            if (payment != null){
                return false;
            }
            else if (dPrincipal.equals(-1.0) || dPeriods.equals(-1.0)){
                return false;
            }
            else {
                method = Flag.DIFF_PAY;
            }
        }
        if (type.equals("annuity")){
            if(payment == null) {
                if (dPrincipal.equals(-1.0) || dPeriods.equals(-1.0)) {
                    return false;
                } else {
                    method = Flag.ANN_PAY;
                }
            }
            if(principal == null) {
                if (dPayment.equals(-1.0) || dPeriods.equals(-1.0)) {
                    return false;
                } else {
                    method = Flag.PRINC;
                }
            }

            if(periods == null) {
                if (dPrincipal.equals(-1.0) || dPayment.equals(-1.0)) {
                    return false;
                } else {
                    method = Flag.PERIOD;
                }
            }
        }

        return true;
    }
    private double parseDoublePositive(String s){
        double d;

        try{
            d=Double.parseDouble(s);
        } catch (Exception e){
            d = -1.0;
        }
        if (d <= 0)
            d = -1.0;

        return d;
    }
    public void printArgs(){
        System.out.println("Type: " + type);
        System.out.println("Loan principal: " + dPrincipal);
        System.out.println("Periods: " + dPeriods);
        System.out.println("Interest: " + dInterest);
        System.out.println("Payment: " + dPayment);
        System.out.println("Method: " + method);
    }
}
