package CreditCalculator;

public class CalculatorLogic {
    public CalculatorLogic(){
    }
    public void calcDiffPay(double p, double i, double n){
        double sumPay = 0.0;
        double dm = 0.0;

        i = i / (12 * 100);
        for (int m = 1; m <= n; m++){
            dm = Math.ceil( p / n + i * (p - p * (m - 1) / n) );
            sumPay += dm;
            System.out.println("Month " + m +": payment is " + (int)dm);
        }
        System.out.println("Overpayment = " + (int)(sumPay - p));
    }
    public void calcAnnuityPay(double p, double i, double n){
        double mp;

        i = i / (12 * 100);
        mp = Math.ceil( p * i * Math.pow(1 + i, n) / (Math.pow(1 + i, n) - 1) );
        System.out.println("Your monthly payment = " + (int)mp + "!");
    }
    public void calcPrincipal(double mp, double i, double n){
        double p;

        i = i / (12 * 100);
        p = Math.floor( mp / (i * Math.pow(1 + i, n)/(Math.pow(1 + i, n)-1)) );
        System.out.println("Your loan principal = " + (int)p + "!");
    }
    public void calcPeriod(double p, double mp, double i){
        double n;
        int year, month;
        String s;

        i = i / (12 * 100);
        n = Math.ceil( Math.log(mp / (mp - i * p)) / Math.log(1 + i) );
        year = (int) (n / 12);
        month = (int) (n - year * 12);
        s = "It will take ";
        if (year > 0){
            s += year + " years ";
            s = month > 0 ? s+= "and " : s;
        }
        s = month > 0 ? s += month + " months " : s;
        s += "to repay this loan!";

        System.out.println(s);
    }
}
