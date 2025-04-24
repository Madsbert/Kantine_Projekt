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
}
