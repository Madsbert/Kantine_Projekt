package org.example.kantine_projekt.Domains;

public class Item {
    private int itemId;
    private String name;
    private String supplierID;
    private int unitPrice;
    private int minimumQuantity;
    private int currentQuantity;
    private int reorderAmount;

    public Item(int itemId, String name, String supplierID, int unitPrice, int minimumQuantity, int currentQuantity, int reorderAmount) {
        this.itemId = itemId;
        this.name = name;
        this.supplierID = supplierID;
        this.unitPrice = unitPrice;
        this.minimumQuantity = minimumQuantity;
        this.currentQuantity = currentQuantity;
        this.reorderAmount = reorderAmount;
    }

    public Item(String name, String supplierID, int unitPrice, int minimumQuantity, int currentQuantity, int reorderAmount) {
        this.name = name;
        this.supplierID = supplierID;
        this.unitPrice = unitPrice;
        this.minimumQuantity = minimumQuantity;
        this.currentQuantity = currentQuantity;
        this.reorderAmount = reorderAmount;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
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
}
