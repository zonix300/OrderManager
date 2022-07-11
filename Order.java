package rinka.com.order;

import java.util.Date;

public abstract class Order {
    private static String itemName;
    private static Date dateCreated;
    private static Date dateConfirmed;
    private static Date dateShipped;
    private static String shipFromCity;
    private static String shipToCity;
    private static int basePrice;
    private static double totalPrice;
    private static Customer customerOwned = new Customer("Женя", "Киев", "Женщина");



    public Order(String itemName, Date dateCreated, String shipToCity, String shipFromCity, int basePrice, Customer customerOwned) {
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipToCity = shipToCity;
        this.shipFromCity = shipFromCity;
        this.basePrice = basePrice;
        this.customerOwned = customerOwned;

        calculatePrice(basePrice);
        validateOrder();
        confirmShipping();
    }

    public Order(String itemName, Date dateCreated, String shipToCity, String shipFromCity, double fullPrice, Customer customerOwned) {
    }


    public Date getDateConfirmed() {
        return dateConfirmed;
    }

    public void setDateConfirmed(Date dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public String getItemName(){
        return itemName;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public Date getDateShipped(){
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped){
        this.dateShipped = dateShipped;
    }

    public String getShipFromCity(){
        return shipFromCity;
    }


    public String getShipToCity(){
        return shipToCity;
    }

    public int getBasePrice(){
        return basePrice;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomerOwned(){
        return customerOwned;
    }


    abstract void validateOrder();
    abstract void calculatePrice(int basePrice);

    void confirmShipping() {
        setDateConfirmed(new Date());
    }



}



