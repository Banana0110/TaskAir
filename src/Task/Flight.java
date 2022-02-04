package Task;


public class Flight {

    private String number;
    private int size;
    private float price;
    private AirCraft info;

    public Flight() {
        number = "";
        size = 0;
        price = 0.f;
        info = null;
    }

    public Flight(String number, int size, float price, AirCraft info) {
        this.number = number;
        this.size = size;
        this.price = price;
        this.info = info;
    }


    public void show() {
        System.out.println("№" + number);
        info.show();
        System.out.println("Свободно мест: " + size);
        System.out.println("Стоимость одного билета: " + price + "\n");
    }


    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        this.number = number;
    }


    public int getSize() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }


    public float getPrice() {
        return price;
    }


    public void setPrice(float price) {
        this.price = price;
    }


    public AirCraft getInfo() {
        return info;
    }


    public void setInfo(AirCraft info) {
        this.info = info;
    }
}
