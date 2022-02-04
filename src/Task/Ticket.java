package Task;


public class Ticket {

    public static int id = 1;
    private int number;
    private String flight;
    private String name;

    public Ticket() {
        number = id++;
        flight = "";
        name = "";
    }

    public Ticket(String flight, String name) {
        number = id++;
        this.flight = flight;
        this.name = name;
    }


    void show(){
        System.out.println("Номер билета: " + number);
        System.out.println("Номер рейса: " + flight);
        System.out.println("Имя пассажира: " + name + "\n");
    }


    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }


    public String getFlight() {
        return flight;
    }


    public void setFlight(String flight) {
        this.flight = flight;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

}
