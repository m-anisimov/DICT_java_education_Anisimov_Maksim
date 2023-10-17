package CoffeeMachine;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CoffeeMachine {
    public static Scanner scn = new Scanner(System.in);
    static String[] menu_main = {"buy", "fill", "take"};
    static String[] menu_coffee = {"espresso", "latte", "cappuccino"};
    public static Resourсes remaining = new Resourсes(400, 540, 120, 9, 550);

    public static void main(String[] args) {
        String answer=" ";


        remaining.remaining_print();
        Set<String> menu_main_set = Arrays.stream(menu_main).collect(Collectors.toSet());

        while ( !menu_main_set.contains(answer)){
            System.out.println("Write action (buy, fill, take):");
            answer = scn.nextLine();
            //System.out.println(answer);
        }
        switch (answer){
            case "buy" : f_buy(); break;
            case "fill" : f_fill(); break;
            case "take" : f_take(); break;
        }


    }
    public static void f_fill()
    {
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
    public static void f_buy()
    {
        Integer choice_coffee=0;

        while ( choice_coffee<1 && choice_coffee > 3){
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            choice_coffee = scn.nextInt();
            //System.out.println(answer);
        }
        f_do_coffee(menu_coffee[choice_coffee-1]);
    }
    public static void f_take()
    {
        System.out.println("I gave you " + remaining.getMoney() + "\n");
        remaining.setMoney((-1) * remaining.getMoney());

        remaining.remaining_print();
    }
    public static void f_do_coffee(String coffee_type) {
        Resourсes espresso = new Resourсes(250, 0, 16, 1, 4);
        Resourсes latte = new Resourсes(350, 75, 20, 1, 7);
        Resourсes cappuccino = new Resourсes(200, 100, 12, 1, 6);
        Resourсes coffee = new Resourсes();

        boolean rezult = true;


        Integer water = 0;
        Integer milk = 0;
        Integer beans = 0;
        Integer money = 0;

        if (remaining.getCups()<1){
            rezult = false;
            System.out.println("Sorry, not enough cups!");
        }
        else {

            switch (coffee_type) {
                case "espresso":
                    if (remaining.getWater() - 250 < 0) {
                        rezult = false;
                        System.out.println("Sorry, not enough water!");
                    } else if (remaining.getBeans() - 16 < 0) {
                        rezult = false;
                        System.out.println("Sorry, not enough coffee beans!");
                    }
                    break;
                case "latte":

                    break;
                case "cappuccino":

                    break;
            }
        }

        if (rezult==true)
            System.out.println("I have enough resources, making you a coffee!");

    }

}
class Resourсes {
    private Integer water; // = 400;
    private Integer milk; // = 540;
    private Integer beans; // = 120;
    private Integer cups; // = 9;
    private Integer money; // = 550;

    public Resourсes(){

    }
    public Resourсes(Integer water, Integer milk, Integer beans, Integer cups, Integer money) {
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
        System.out.println("The coffee machine has:");
        System.out.println(getWater() + " of water");
        System.out.println(getMilk() + " of milk");
        System.out.println(getBeans() + " of coffee beans");
        System.out.println(getCups() + " of disposable cups");
        System.out.println(getMoney() + " of money");
    }
}