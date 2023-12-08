package CreditCalculator;

public class CalculatorLogic {
    private String type;
    private String principal;
    private String periods;
    private String interest;
    private String payment;

    public Integer i;
    public CalculatorLogic(String type, String principal, String periods, String interest, String payment){
        this.type = type;
        this.principal = principal;
        this.periods = periods;
        this.interest = interest;
        this.payment = payment;
    }
    public void dataAnalyze(String type, String principal, String periods, String interest, String payment){
        if (type.equals("diff"))
            paymentCalcDiff();
        else
            paymentCalcAnnuity();

    }
    public int paymentCalcDiff(){
        // 𝐷𝑚 = 𝑃/𝑛 + 𝑖 ∗ (𝑃 − 𝑃 ∗ (𝑚 − 1)/𝑛 )
        // 𝐷𝑚 - m-й диференційований платіж;  𝑚  - поточний місяць погашення;
        // 𝑃  - основна сума кредиту; 𝑖  - номінальна процентна ставка;  𝑛  - кількість платежів;

        int Dm=0;

        //for (int k=1; k<n)
        return Dm;
    }
    public void paymentCalcAnnuity(){
        ;
    }
}
