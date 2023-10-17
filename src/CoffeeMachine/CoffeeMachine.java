package CoffeeMachine;

public class CoffeeMachine {
    static String[] menu_main = {"buy", "fill", "take"};
    static String[] menu_coffee = {"espresso", "latte", "cappuccino"};

    public static void main(String[] args) {

        Remaining remaining = new Remaining(400, 540, 120, 9, 550);
        remaining.remaining_print();
    }


}
class Remaining {
    private Integer water; // = 400;
    private Integer milk; // = 540;
    private Integer beans; // = 120;
    private  Integer cups; // = 9;
    private  Integer money; // = 550;

    public Remaining(Integer water, Integer milk, Integer beans, Integer cups, Integer money){
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    };
    public Integer getWater() {
        return water;
    }
    public void setWater(Integer water) {
        this.water += water;
    }
    public Integer getMilk() {
        return milk;
    }
    public void setMilk(Integer milk) {
        this.milk += milk;
    }

    public Integer getBeans() {
        return beans;
    }

    public void setBeans(Integer beans) {
        this.beans += beans;
    }

    public Integer getCups() {
        return cups;
    }

    public void setCups(Integer cups) {
        this.cups += cups;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money += money;
    }
    public void remaining_print() {
        System.out.println("The coffee machine has:");
        System.out.println( getWater() + " of water");
        System.out.println( getMilk() + " of milk");
        System.out.println( getBeans() + " of coffee beans");
        System.out.println( getCups() + " of disposable cups");
        System.out.println( getMoney() + " of money");
    }

}