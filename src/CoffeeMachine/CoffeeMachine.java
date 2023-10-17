package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        State state = new State();

        while (!state.getState().equals("exit")){
            if (state.getState().equals("action")) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                state.setUser_choice(scn.nextLine());
            }
            if (state.getState().equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back to main menu:");
                state.setUser_choice(scn.nextLine());
            }
        }
    }

}
class Resources {
    private Integer water;
    private Integer milk;
    private Integer beans;
    private Integer cups;
    private Integer money;

    public Resources(){

    }
    public Resources(Integer water, Integer milk, Integer beans, Integer cups, Integer money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }
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
        System.out.println("\nThe coffee machine has:");
        System.out.println(getWater() + " of water");
        System.out.println(getMilk() + " of milk");
        System.out.println(getBeans() + " of coffee beans");
        System.out.println(getCups() + " of disposable cups");
        System.out.println(getMoney() + " of money\n");
    }
}
class State{
    private String user_choice;
    private String state;
    private final String[] menu_coffee = {"espresso", "latte", "cappuccino", "back"};
    private Resources remaining = new Resources(400, 540, 120, 9, 550);

    public State(){
        this.state = "action";
    }

    public String getState() {
        return state;
    }

    public void setUser_choice(String user_choice) {
        this.user_choice = user_choice;
        f_analysis();
    }

    private void f_analysis() {
        if (state.equals("action")) {
            switch (user_choice) {
                case "buy" -> state="buy";
                case "fill" -> f_fill();
                case "take" -> f_take();
                case "remaining" -> remaining.remaining_print();
                case "exit" -> state = "exit";
            }
        } else if (state.equals("buy")) {
            if ("1234".contains(user_choice) && user_choice.length()==1){
                switch (user_choice) {
                    case "1" -> f_do_coffee(menu_coffee[0]);
                    case "2" -> f_do_coffee(menu_coffee[1]);
                    case "3" -> f_do_coffee(menu_coffee[2]);
                }
                state = "action";
            }
        }
    }
    private void f_take()
    {
        System.out.println("I gave you " + remaining.getMoney());
        remaining.setMoney((-1) * remaining.getMoney());

        remaining.remaining_print();
    }
    private void f_fill()
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        remaining.setWater(scn.nextInt());

        System.out.println("Write how many ml of milk you want to add:");
        remaining.setMilk(scn.nextInt());

        System.out.println("Write how many grams of coffee beans you want to add:");
        remaining.setBeans(scn.nextInt());

        System.out.println("Write how many disposable coffee cups you want to add:");
        remaining.setCups(scn.nextInt());

        remaining.remaining_print();
    }
    private void f_do_coffee(String coffee_type) {
        Resources espresso = new Resources(250, 0, 16, 1, 4);
        Resources latte = new Resources(350, 75, 20, 1, 7);
        Resources cappuccino = new Resources(200, 100, 12, 1, 6);
        Resources coffee = new Resources();

        boolean rez = true;

        if (remaining.getCups()<1){
            rez = false;
            System.out.println("Sorry, not enough cups!");
        }
        else {
            switch (coffee_type) {
                case "espresso" -> coffee = espresso;
                case "latte" -> coffee = latte;
                case "cappuccino" -> coffee = cappuccino;
            }

            if (remaining.getWater() - coffee.getWater() < 0) {
                rez = false;
                System.out.println("Sorry, not enough water!");
            } else if (remaining.getBeans() - coffee.getBeans() < 0) {
                rez = false;
                System.out.println("Sorry, not enough coffee beans!");
            } else if (remaining.getMilk() - coffee.getMilk() < 0 ) {
                rez = false;
                System.out.println("Sorry, not enough milk!");
            }
        }

        if (rez) {
            System.out.println("I have enough resources, making you a coffee!");
            remaining.setWater((-1) * coffee.getWater());
            remaining.setMilk((-1) * coffee.getMilk());
            remaining.setBeans((-1) * coffee.getBeans());
            remaining.setCups(-1);
            remaining.setMoney(coffee.getMoney());
        }
        remaining.remaining_print();
    }
}