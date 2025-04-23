package org.example.kantine_projekt.Persistences;

import org.example.kantine_projekt.Domains.Items;

import java.util.List;

public interface ItemsDBInterface {
    public int getPriceOfItem(int itemID);

    public List<Items> getAllItems();

    public Items getItem(int itemID);

    public void createItem(Items item);

    public void updateItem(Items item);

    public void deleteItem(int itemID);
}
