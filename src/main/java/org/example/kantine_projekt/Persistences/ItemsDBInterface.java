package org.example.kantine_projekt.Persistences;

import org.example.kantine_projekt.Domains.Item;

import java.util.List;

public interface ItemsDBInterface {
    public String getSupplierFromItemID(int itemID);

    public int getPriceOfItem(int itemID);

    public List<Item> getAllItems();

    public Item getItem(int itemID);

    public void createItem(Item item);

    public void updateItem(Item item);

    public void deleteItem(int itemID);

}
