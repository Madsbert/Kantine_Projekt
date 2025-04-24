package org.example.kantine_projekt.Domains;

public class Items {
    private int itemId;
    private String name;
    private int supplierID;
    private double unitPrice;
    private int minimumQuantity;
    private int currentQuantity;
    private int reorderAmount;


    public int getItemId() {
        return itemId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getReorderAmount() {
        return reorderAmount;
    }

    public void setReorderAmount(int reorderAmount) {
        this.reorderAmount = reorderAmount;
    }

    public Items(int itemId, String name, int supplierID, double unitPrice, int minimumQuantity, int currentQuantity, int reorderAmount) {
        this.itemId = itemId;
        this.name = name;
        this.supplierID = supplierID;
        this.unitPrice = unitPrice;
        this.minimumQuantity = minimumQuantity;
        this.currentQuantity = currentQuantity;
        this.reorderAmount = reorderAmount;
    }

}
