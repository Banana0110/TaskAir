package Task;

import java.util.Scanner;

public class Task {

    public static void main(String[] args) {

        int choice = 0;
        Scanner sc = new Scanner(System.in);
        Jet jet = new Jet();
        do {
            try {
                menu();
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: {
                        jet.addFlight();
                        break;
                    }
                    case 2: {
                        jet.buyTicket();
                        break;
                    }
                    case 3: {
                        jet.showFlights();
                        break;
                    }
                    case 4: {
                        jet.printReport();
                        break;
                    }
                    case 5: {
                        Flight f = jet.findFlight();
                        if (f != null) {
                            System.out.println("Вот что удалось найти:");
                            f.show();
                        } else {
                            System.out.println("Не удалось найти рейс по номеру билета");
                        }
                        break;
                    }
                    case 6: {
                        jet.removeTickets();
                        break;
                    }
                    case 7: {
                        jet.showTickets();
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Ошибка ввода данных");
            }
            System.out.println();
        } while (choice != 8);
    }

    public static void menu() {
        System.out.println("1 - Добавить рейс");
        System.out.println("2 - Купить билет по номеру рейса");
        System.out.println("3 - Просмотр всех рейсов");
        System.out.println("4 - Сформировать отчет по рейсам");
        System.out.println("5 - Поиск рейса по номеру билета");
        System.out.println("6 - Удалить все билеты по номеру рейса");
        System.out.println("7 - Просмотр всех билетов");
        System.out.println("8 - Выход");
        System.out.print(">> ");
    }
}
