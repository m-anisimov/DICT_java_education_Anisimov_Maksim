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
        if (type.equals("diff")){

        }

    }

}
