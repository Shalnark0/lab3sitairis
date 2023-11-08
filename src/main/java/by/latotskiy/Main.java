package by.latotskiy;

import by.latotskiy.models.Order;
import by.latotskiy.models.Turtle;
import by.latotskiy.repository.TurtleXMLProcessor;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Turtle> turtles = new ArrayList<Turtle>();
        Scanner scanner = new Scanner(System.in);
        TurtleXMLProcessor xmlProcessor = new TurtleXMLProcessor();
        String filePath = "src/main/resources/turtles.xml";
        Order order = new Order();

        // Проверка наличия файла и создание, если он не существует
        File file = new File(filePath);
        if (!file.exists()) {
            try {    //////////////////////////////
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Ошибка при создании файла turtles.xml: " + e.getMessage());
                return;
            }
        }

        while (true) {

            // Загрузите существующие черепахи из XML файла, если он существует
            try {
                turtles = xmlProcessor.unmarshalTurtles(filePath);
            } catch (JAXBException e) {
                // Если файл не найден или возникла ошибка при загрузке, продолжите с пустым списком
                System.out.println("Ошибка при загрузке данных из файла.");
            }

            System.out.println("Что вы хотите сделать?");
            System.out.println("1 - Посмотреть всех черепах");
            System.out.println("2 - Добавить новую черепаху");
            System.out.println("3 - Удалить черепаху");
            System.out.println("4 - Изменить черепаху");
            System.out.println("5 - Посмотреть возможности черепахи: ");
            System.out.println("6 - Купить черепаху");
            System.out.println("7 - Выйти из программы");

            int choice = scanner.nextInt();

            if (choice == 1) {
                // При отсутствии записей о черепахах выведет уведомление
                if (turtles.isEmpty()) {
                    System.out.println("Ни одной черепахи пока не было добавлено");
                    continue;
                }
                try {
                    turtles = xmlProcessor.unmarshalTurtles(filePath);
                } catch (JAXBException e) {
                    System.out.println("Ошибка при чтении данных из файла.");
                }

                for (Turtle turtle : turtles) {
                    System.out.println(turtle);
                }
            } else if (choice == 2) {
                // Добавление черепахи
                turtles.add(Turtle.createTurtle(turtles.size()));
                // Сохраните список черепах в XML файл после добавления новой черепахи
                try {
                    xmlProcessor.marshalTurtles(turtles, filePath);
                    System.out.println("Черепаха успешно добавлена и сохранена в файле.");
                } catch (JAXBException e) {
                    System.out.println("Ошибка при сохранении данных в файл.");
                }

            } else if (choice == 3) {
                // Удаление черепахи
                for (Turtle turtle : turtles) {
                    System.out.println(turtle);
                }
                System.out.println("Введите id той черепахи, которую хотите удалить: ");
                int idToDelete = scanner.nextInt();
                Turtle.deleteTurtle(turtles, idToDelete);
                try {
                    xmlProcessor.marshalTurtles(turtles, filePath);
                } catch (JAXBException e) {
                    System.out.println("Ошибка при сохранении данных в файл.");
                }


            } else if (choice == 4) {
                // Редактирование черепахи
                for (Turtle turtle : turtles) {
                    System.out.println(turtle);
                }
                System.out.println("Введите id той черепахи, которую хотите изменить: ");
                int idToEdit = scanner.nextInt();
                Turtle.editTurtle(turtles, idToEdit);
                try {
                    xmlProcessor.marshalTurtles(turtles, filePath);
                } catch (JAXBException e) {
                    System.out.println("Ошибка при сохранении данных в файл.");
                }

            } else if (choice == 5) {
                // Просмотр возможностей черепах
                Turtle.showPossibilities(turtles);
            } else if (choice == 6) {

                System.out.println("1 - Добавить черепаху");
                System.out.println("2 - Оформить заказ");
                int buyChoice = scanner.nextInt();
                if(buyChoice == 1) {

                    Turtle obj = Order.addTurtleToOrder(turtles);
                    order.setListOfTurtles(obj);
                    order.addPrice(obj.getPrice());

                    System.out.println(order);
                } else if (buyChoice == 2){
                    order.makeOrder();
                }

            }
        }
    }
}