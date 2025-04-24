package org.example.kantine_projekt.Persistences;

import org.example.kantine_projekt.Domains.Item;

import java.util.List;

public class ItemsDB implements ItemsDBInterface {
    private List<Item> items;

    @Override
    public int getPriceOfItem(int itemID) {
        return 0;
    }

    @Override
    public List<Item> getAllItems() {
        return items;
    }

    @Override
    public Item getItem(int itemID) {
        return null;
    }

    @Override
    public void createItem(Item item) {

    }

    @Override
    public void updateItem(Item item) {

    }

    @Override
    public void deleteItem(int itemID) {

    }
}
