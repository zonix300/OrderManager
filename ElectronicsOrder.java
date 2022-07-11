package rinka.com.order;

import java.util.Date;


public class ElectronicsOrder extends Order{
    private int guaranteeMonths;
    private int basePrice;
    private Date dateCreated;
    private String itemName;
    private String shipToCity;
    Customer customerOwned;




    public ElectronicsOrder(String itemName, Date dateCreated, String shipToCity, String shipFromCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipToCity, shipFromCity, basePrice, customerOwned);
        this.customerOwned = customerOwned;
        this.guaranteeMonths = guaranteeMonths;
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;


    }

    @Override
    public void validateOrder() {

        if ((getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков")
                && (getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Днепр" || getShipFromCity() == "Харьков")
                && customerOwned.getGender() != "Мужчина") {
            System.out.println("<-------------------------------------------------->");
            System.out.println("We're happy to say the package is on the way to your city");
            System.out.println("Full price: " + getTotalPrice());
            System.out.println("<-------------------------------------------------->");
        } else {
            System.out.println("<------------------------------------------------------------------------->");
            System.out.println("We're sorry to say but there's no opportunity to deliver your electronics");
            System.out.println("<------------------------------------------------------------------------->");
        }
    }

    @Override
    public void calculatePrice(int basePrice) {
        double totalPrice;
        if (basePrice>1000) {
            totalPrice = basePrice * 0.05;
        } else if (getShipToCity() == "Киев") {
            totalPrice = basePrice + basePrice * 0.15;
        } else if (getShipToCity() == "Одесса") {
            totalPrice = basePrice + basePrice * 0.15;
        } else {
            totalPrice = basePrice + basePrice * 0.10;
        }
        setTotalPrice(totalPrice);
    }

    public int getGuaranteeMonths() {
        return guaranteeMonths;
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
