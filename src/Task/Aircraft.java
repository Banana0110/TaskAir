package Task;


import java.time.LocalDate;

class AirCraft {

    private String from;
    private String to;
    private LocalDate date;

    public AirCraft() {
        from = "";
        to = "";
        date = LocalDate.now();
    }

    public AirCraft(String from, String to, LocalDate date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }


    public void show() {
        System.out.println("Откуда: " + from);
        System.out.println("Куда: " + to);
        System.out.println("Дата вылета: " + date);
    }


    public String getFrom() {
        return from;
    }


    public void setFrom(String from) {
        this.from = from;
    }


    public String getTo() {
        return to;
    }


    public void setTo(String to) {
        this.to = to;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }
}
