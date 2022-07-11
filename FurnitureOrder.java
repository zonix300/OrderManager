package rinka.com.order;
import java.util.Date;

public class FurnitureOrder extends Order {
    String furnitureCode;
    private static int guaranteeMonths;
    private String customerCity = getCustomerOwned().getCity();
    private String customerName = getCustomerOwned().getName();
    private int basePrice;
    private String itemName;
    private Date dateCreated;
    private String shipToCity;

    public FurnitureOrder(String itemName, Date dateCreated, String shipToCity, String shipFromCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipToCity, shipFromCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;

    }
    @Override
    void validateOrder() {
        if ((getShipToCity() == "Киев" || getShipToCity() == "Харьков") && (getShipFromCity() == "Киев" || getShipFromCity() == "Харьков") && (customerName != "Тест" || basePrice >= 500)) {
            System.out.println("<-------------------------------------------------->");
            System.out.println("We're happy to say the package is on the way to your city");
            System.out.println("Full price: " + getTotalPrice());
            System.out.println("<-------------------------------------------------->");
        }
        else {
            System.out.println("<--------------------------------------------------------------------->");
            System.out.println("We're sorry to say but there's no opportunity to deliver your furniture");
            System.out.println("<--------------------------------------------------------------------->");
        }
    }
    @Override
    void calculatePrice(int basePrice) {
        double totalPrice;
        if (basePrice<5000) {
            totalPrice = basePrice + basePrice * 0.05;
        }
        else {
            totalPrice = basePrice + basePrice * 0.02;
        }
        setTotalPrice(totalPrice);
    }

    @Override
    public Date getDateCreated() {
        return dateCreated;
    }
    @Override
    public int getBasePrice() {
        return basePrice;
    }
    @Override
    public String getItemName() {
        return itemName;
    }
    @Override
    public String getShipToCity() {
        return shipToCity;
    }

}