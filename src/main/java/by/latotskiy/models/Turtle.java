package by.latotskiy.models;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@XmlRootElement(name = "turtle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Turtle implements Animal {

    private int id;
    private String name;
    private String type;
    private String description;
    private String color;

    private BigDecimal price;
    private int age;
    private double weight;
    private boolean isMale;

// Методы свойственные только для черепах
    public void hideHead(){
        System.out.println(this.getName() + " спрятал(а) свою голову в панцырь.");
    }

    public void showHead(){
        System.out.println(this.getName() + " достал(а) свою голову из панцыря.");
    }

    public void hideLimbs(){
        System.out.println(this.getName() + " спрятал(а) свои лапки и хвост в панцырь.");
    }

    public void showLimbs(){
        System.out.println(this.getName() + " достал(а) свои лапки и хвост из под панцыря.");
    }

    // Переопределенные методы интерфейса Animal
    @Override
    public void eat() {
        System.out.println(this.getName() + " схватил(а) кусочек травы ртом и съел(а) его.");
    }

    @Override
    public void sleep() {
        System.out.println(this.getName() + " закрыл(а) глаза, после чего спрятал(а) свои конечности в панцырь.");
    }

    @Override
    public void makeSound() {
        System.out.println(this.getName() + " открыл(а) рот и пытается издать звук, но ничего не получается.");
    }

    @Override
    public void move() {
        System.out.println(this.getName() + " двигает своими лапками и медленно перемещается.");
    }

    @Override
    public void reproduce() {
        System.out.println("18+");
    }


    // 3 конструктора

    public Turtle() {
    }


    public Turtle(String name, String type, String description, String color, BigDecimal price, int age, double weight, boolean isMale) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.color = color;
        this.price = price;
        this.age = age;
        this.weight = weight;
        this.isMale = isMale;
    }

    public Turtle(int id, String name, String type, String description, String color, BigDecimal price, int age, double weight, boolean isMale) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.color = color;
        this.price = price;
        this.age = age;
        this.weight = weight;
        this.isMale = isMale;
    }

    // Метод для создания черепахи без использования ID

    public static Turtle createTurtle(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя черепахи: ");
        String name = scanner.nextLine();
        System.out.println("Введите тип черепахи: ");
        String type = scanner.nextLine();
        System.out.println("Введите описание черепахи");
        String description = scanner.nextLine();
        System.out.println("Введите цвет черепахи: ");
        String color = scanner.nextLine();
        System.out.println("Введите пол черепахи(true - Мужской)");
        Boolean isMale = scanner.nextBoolean();
        System.out.println("Введите возраст черепахи: ");
        int age = scanner.nextInt();
        System.out.println("Введите вес черепахи: ");
        double weight = scanner.nextDouble();
        System.out.println("Введите цену черепахи: ");
        BigDecimal price = scanner.nextBigDecimal();
        return new Turtle(name, type, description, color, price, age, weight, isMale);

    }

    // Перегруженный метод для создания черепахи с использованием ID

    public static Turtle createTurtle(int id){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя черепахи: ");
        String name = scanner.nextLine();
        System.out.println("Введите тип черепахи: ");
        String type = scanner.nextLine();
        System.out.println("Введите описание черепахи");
        String description = scanner.nextLine();
        System.out.println("Введите цвет черепахи: ");
        String color = scanner.nextLine();
        System.out.println("Введите пол черепахи(true - Мужской)");
        Boolean isMale = scanner.nextBoolean();
        System.out.println("Введите возраст черепахи: ");
        int age = scanner.nextInt();
        System.out.println("Введите вес черепахи: ");
        double weight = scanner.nextDouble();
        System.out.println("Введите цену черепахи: ");
        BigDecimal price = scanner.nextBigDecimal();
        return new Turtle(id, name, type, description, color, price, age, weight, isMale);

    }

    // Метод для удаления черепахи по ID
    public static List<Turtle> deleteTurtle(List<Turtle> turtles, int id){
        for (Turtle turtle : turtles) {
            if (turtle.getId() == id) {
                turtles.remove(turtle);
                break; // Черепаха найдена, можно выйти из цикла
            }
        }
        int i = 0;
        for (Turtle turtle : turtles) {
            turtle.setId(i);
            i++;
        }

        return turtles;
    }

    // Метод для редактирования данных черепахи по ID
    public static List<Turtle> editTurtle(List<Turtle> turtles, int id){
        Scanner scanner = new Scanner(System.in);
        for (Turtle turtle : turtles) {
            if (turtle.getId() == id) {
                System.out.println("Что вы хотите изменить: ");
                System.out.println("1 - Имя черепахи.");
                System.out.println("2 - Вид черепахи.");
                System.out.println("3 - Описание черепахи.");
                System.out.println("4 - Цвет черепахи.");
                System.out.println("5 - Возраст черепахи.");
                System.out.println("6 - Вес черепахи.");
                System.out.println("7 - Пол черепахи.");
                System.out.println("8 - Цену черепахи");
                System.out.println("8 - Выйти.");

                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("Введите новое значение: ");
                    String data = scanner.nextLine();
                    turtle.setName(data);
                }
                else if (choice == 2) {
                    System.out.println("Введите новое значение: ");
                    String data = scanner.nextLine();
                    turtle.setType(data);
                }
                else if (choice == 3) {
                    System.out.println("Введите новое значение: ");
                    String data = scanner.nextLine();
                    turtle.setDescription(data);
                }
                else if (choice == 4) {
                    System.out.println("Введите новое значение: ");
                    String data = scanner.nextLine();
                    turtle.setColor(data);
                }
                else if (choice == 5) {
                    System.out.println("Введите новое значение: ");
                    int data = scanner.nextInt();
                    turtle.setAge(data);
                }
                else if (choice == 6) {
                    System.out.println("Введите новое значение: ");
                    double data = scanner.nextDouble();
                    turtle.setWeight(data);
                }
                else if (choice == 7) {
                    System.out.println("Введите новое значение: ");
                    boolean data = scanner.nextBoolean();
                    turtle.setMale(data);
                }
                else if (choice == 8) {
                    System.out.println("Введите новое значение: ");
                    BigDecimal price = scanner.nextBigDecimal();
                    turtle.setPrice(price);
                }

                else if (choice == 9) {
                    break;
                }

                break; // Черепаха найдена, можно выйти из цикла
            }
        }
        return turtles;
    }





    // Метод, который позволяет ознакомиться с возможностями выбранной черепахи
    public static void showPossibilities(List<Turtle> turtles){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите id черепахи, на которую вы хотите взглянуть поближе: ");
        for (Turtle turtle : turtles) {
            System.out.println(turtle);
        }
        int id = scanner.nextInt();
        for (Turtle turtle : turtles) {
            if (turtle.getId() == id) {
                System.out.println("Что вы хотите посмотреть? ");
                System.out.println("1 - Как черепаха питается.");
                System.out.println("2 - Как черепаха спит.");
                System.out.println("3 - Как черепаха общается.");
                System.out.println("4 - Как черепаха передвигается.");
                System.out.println("5 - Как черепаха размножается. (18+)");
                System.out.println("6 - Как черепаха прячет голову в панцырь.");
                System.out.println("7 - Как черепаха достает голову из панцыря.");
                System.out.println("8 - Как черепаха прячет лапки и хвост в панцырь.");
                System.out.println("9 - Как черепаха достает лапки и хвост из-под панцыря.");

                int secChoice = scanner.nextInt();
                switch (secChoice) {
                    case 1:
                        turtle.eat();
                        break;
                    case 2:
                        turtle.sleep();
                        break;
                    case 3:
                        turtle.makeSound();
                        break;
                    case 4:
                        turtle.move();
                        break;
                    case 5:
                        turtle.reproduce();
                        break;
                    case 6:
                        turtle.hideHead();
                        break;
                    case 7:
                        turtle.showHead();
                        break;
                    case 8:
                        turtle.hideLimbs();
                        break;
                    case 9:
                        turtle.showLimbs();
                        break;
                    default:
                        System.out.println("Некорректный выбор.");
                }
            }
        }
    }

    // Геттеры и сеттеры

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id != null) {
            this.id = id;
        }
    }

    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Переопределенный метод toString

    @Override
    public String toString() {
        return "Turtle{ " +
                "id: " + id +
                ", Имя: '" + name +
                ", Вид: '" + type +
                ", Описание: '" + description +
                ", Цвет: '" + color  +
                ", Возраст: " + age + " лет" +
                ", Вес: " + weight + " кг" +
                ", Пол: " + (isMale ? "Мужской " : "Женский ") +
                '}';
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        Turtle book = (Turtle) o;
//        return author.equals(book.author) &&
//                name.equals(book.name) &&
//                issueYear.equals(book.issueYear);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(author, name, issueYear);
//    }
}
