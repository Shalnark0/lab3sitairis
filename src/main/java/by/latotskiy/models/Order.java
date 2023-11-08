package by.latotskiy.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Order {



    private List<Turtle> listOfTurtles = new ArrayList<>();

    private String wishes;

    private BigDecimal totalPrice;

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void addPrice(BigDecimal price) {
        if (this.totalPrice == null) {
            this.totalPrice = price;
        } else {
            this.totalPrice = this.totalPrice.add(price);
        }
    }

    public List<Turtle> getListOfTurtles() {
        return listOfTurtles;
    }

    public void setListOfTurtles(List<Turtle> listOfTurtles) {
        this.listOfTurtles = listOfTurtles;
    }

    public void setListOfTurtles(Turtle turtle){
        this.listOfTurtles.add(turtle);
    }

    public String getWishes() {
        return wishes;
    }

    public void setWishes(String wishes) {
        this.wishes = wishes;
    }

    public Order() {
    }

    public Order(List<Turtle> listOfTurtles, String wishes) {
        this.listOfTurtles = listOfTurtles;
        this.wishes = wishes;
    }

    public static Turtle addTurtleToOrder(List<Turtle> turtles){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберите черепашку(id): ");

        for(Turtle turtle : turtles ) {
            System.out.println("Id = " + turtle.getId());
            System.out.println("Имя черепахи: " + turtle.getName());
            System.out.println("Вид черепахи: " + turtle.getType());
            System.out.println("Цена: " + turtle.getPrice());
            System.out.println("====================================");
        }

        int choice = sc.nextInt();

        Optional<Turtle> foundTurtle = turtles.stream()
                .filter(turtle -> turtle.getId() == choice)
                .findFirst();

        if (foundTurtle.isPresent()) {
            System.out.println("Найдена черепаха с id " + choice);
            return foundTurtle.get();
        } else {
            System.out.println("Черепаха с id " + choice + " не найдена");
        }

        return null;
    }



    public void makeOrder(){
        System.out.println("Ваш итоговый заказ: ");
        for(Turtle turtle: this.listOfTurtles) {
            System.out.println("Черепаха: " + turtle.getName() + ". " + turtle.getType() + ".Цена = " + turtle.getPrice());
        }
        System.out.println("Итоговая стоимость = " + this.getTotalPrice());
    }


    @Override
    public String toString() {
        return "Order{" +
                "listOfTurtles=" + listOfTurtles +
                ", wishes='" + wishes + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
