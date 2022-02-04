package Task;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Jet {

    ArrayList<Flight> flights;
    ArrayList<Ticket> tickets;

    public Jet() {
        flights = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public void addFlight() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите дату вылета: ");
            AirCraft air = new AirCraft();
            air.setDate(LocalDate.parse(sc.nextLine()));
            System.out.print("Откуда вылет: ");
            air.setFrom(sc.nextLine());
            System.out.print("Куда перелет: ");
            air.setTo(sc.nextLine());
            System.out.print("Номер рейса: ");
            Flight fl = new Flight();
            fl.setNumber(sc.nextLine());
            System.out.print("Кол-во свободных мест: ");
            fl.setSize(Integer.parseInt(sc.nextLine()));
            System.out.print("Стоимость одного билета: ");
            fl.setPrice(Float.parseFloat(sc.nextLine()));
            fl.setInfo(air);
            flights.add(fl);
            System.out.println("Рейс был успешно добавлен");
        } catch (Exception ex) {
            System.out.println("Ошибка при вводе данных");
        }
    }


    public void buyTicket() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Укажите номер рейса: ");
            String number = sc.nextLine();
            for (int i = 0; i < flights.size(); i++) {
                Flight f = flights.get(i);
                if (f.getNumber() == null ? number == null : f.getNumber().equals(number)) {
                    if (f.getSize() > 0) {
                        f.setSize(f.getSize() - 1); //уменьшаем кол-во свободных билетов по рейсу
                        Ticket t = new Ticket();
                        System.out.print("Введите имя пассажира: ");
                        t.setName(sc.nextLine());
                        t.setFlight(number);
                        tickets.add(t);
                        System.out.println("Билет был успешно куплен!");
                    } else {
                        System.out.println("Увы, но по данному рейсу все билеты уже распроданы");
                    }
                    return;
                }
            }
            System.out.println("Не удалось найти указанный номер рейса");
        } catch (Exception ex) {
            System.out.println("Ошибка при вводе данных");
        }
    }


    public void showFlights() {
        if (flights.size() > 0) {
            for (int i = 0; i < flights.size(); i++) {
                flights.get(i).show();
            }
        } else {
            System.out.println("Список пуст");
        }
    }


    public void showTickets() {
        if (tickets.size() > 0) {
            for (int i = 0; i < tickets.size(); i++) {
                tickets.get(i).show();
            }
        } else {
            System.out.println("Список пуст");
        }
    }

    public void printReport() {
        try {
            FileWriter fw = new FileWriter("report.txt");
            fw.write("Номер рейса      Билетов продано     Свободно\n");
            for (int i = 0; i < flights.size(); i++) {
                Flight f = flights.get(i);
                int size = 0;
                for (int j = 0; j < tickets.size(); j++) {
                    if (tickets.get(j).getFlight() == null ? f.getNumber() == null : tickets.get(j).getFlight().equals(f.getNumber())) {
                        size++;
                    }
                }
                fw.write(String.format("%6s%18d%18d\n", f.getNumber(), size, f.getSize()));
            }
            fw.close();
            System.out.println("Данные были успешно добавлены в файл report.txt");
        } catch (Exception ex) {
            System.out.println("Ошибка записи данных в файл report.txt");
        }
    }

    public Flight findFlight() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Укажите номер билета: ");
            int number = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < tickets.size(); i++) {
                Ticket t = tickets.get(i);
                if (t.getNumber() == number) {
                    for (int j = 0; j < flights.size(); j++) {
                        if (flights.get(j).getNumber() == null ? t.getFlight() == null : flights.get(j).getNumber().equals(t.getFlight())) {
                            return flights.get(j);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка при вводе данных");
        }
        return null;
    }

    public void removeTickets() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Укажите номер рейса: ");
            String number = sc.nextLine();
            int size = 0;
            Iterator<Ticket> iter = tickets.iterator();
            while (iter.hasNext()) {
                Ticket p = iter.next();
                if (p.getFlight() == null ? number == null : p.getFlight().equals(number)) {
                    iter.remove();
                    size++;
                }
            }
            for (int i = 0; i < flights.size(); i++) {
                if (flights.get(i).getNumber() == null ? number == null : flights.get(i).getNumber().equals(number)) {
                    int oldSize = flights.get(i).getSize();
                    flights.get(i).setSize(oldSize + size);
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка при вводе данных");
        }
    }
}
