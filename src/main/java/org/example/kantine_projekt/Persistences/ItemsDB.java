package org.example.kantine_projekt.Persistences;

import org.example.kantine_projekt.Domains.Items;

import java.util.List;

public class ItemsDB implements ItemsDBInterface {
    private List<Items> items;

    @Override
    public int getPriceOfItem(int itemID) {
        return 0;
    }

    @Override
    public List<Items> getAllItems() {
        return items;
    }

    @Override
    public Items getItem(int itemID) {
        return null;
    }

    @Override
    public void createItem(Items item) {

    }

    @Override
    public void updateItem(Items item) {

    }

    @Override
    public void deleteItem(int itemID) {

    }
}
