package org.example.kantine_projekt.Persistences;

import org.example.kantine_projekt.Domains.Item;
import org.example.kantine_projekt.Foundation.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD operations for item
 */
public class ItemsDB implements ItemsDBInterface {
    private List<Item> items;

    @Override
    public int getPriceOfItem(int itemID) {
        return 0;
    }

    /**
     * Get all items in the database
     * @return
     */
    @Override
    public List<Item> getAllItems() {
        String sp = "{call get_all_items_procedure()}";
        Connection conn = DBConnection.getConnection();
        try(CallableStatement cstmt = conn.prepareCall(sp)) {
            List<Item> itemsList = new ArrayList<Item>();
            ResultSet rs = cstmt.executeQuery();
            while(rs.next()) {
                itemsList.add(new Item(rs.getInt("fldItemID"),rs.getString("fldName"),rs.getInt("fldSupplierID"), rs.getDouble("fldUnitprice"),rs.getInt("fldMinStock"), rs.getInt("fldCurrentStock"),rs.getInt("fldReorderAmount")));
            }
            return itemsList;

        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("something went wrong in getAllItems");
            throw new RuntimeException(e);
        }
    }

    /**
     * gets the supplier from the ID of an Item
     * @param itemID itemID
     * @return a string of the suppliers name
     */
    @Override
    public String getSupplierFromItemID(int itemID){
        String sp = "{call get_supplier_from_itemID(?)}";
        Connection conn = DBConnection.getConnection();
        try(CallableStatement cstmt = conn.prepareCall(sp)){
            cstmt.setInt(1, itemID);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("SupplierName");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("something went wrong in getSupplierFromItemID");
            throw new RuntimeException(e);
        }
        return "Failure";
    }

    @Override
    public Item getItem(int itemID) {
        return null;
    }

    /**
     * Creates an item
     * @param item an item
     */
    @Override
    public void createItem(Item item) {
        String sp = "{call create_new_item(?,?,?,?,?,?)}";
        Connection conn = DBConnection.getConnection();
        try (CallableStatement cstmt = conn.prepareCall(sp)){
            cstmt.setInt(1, item.getSupplierID());
            cstmt.setString(2, item.getName());
            cstmt.setDouble(3, item.getUnitPrice());
            cstmt.setInt(4,item.getMinimumQuantity());
            cstmt.setInt(5, item.getCurrentQuantity());
            cstmt.setInt(6, item.getReorderAmount());
            cstmt.executeUpdate();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("something went wrong in createItem");
            throw new RuntimeException(e);
        }

    }

    /**
     * Takes an item, looks up that item based on itemID
     * and updates the old item, with the new one provided.
     * @param item
     */
    @Override
    public void updateItem(Item item) {
        String sp = "{call update_item(?,?,?,?,?,?)}";
        Connection conn = DBConnection.getConnection();
        try (CallableStatement cstmt = conn.prepareCall(sp)){
            cstmt.setInt(1, item.getItemId());
            cstmt.setString(2, item.getName());
            cstmt.setDouble(3, item.getUnitPrice());
            cstmt.setInt(4,item.getMinimumQuantity());
            cstmt.setInt(5, item.getCurrentQuantity());
            cstmt.setInt(6, item.getReorderAmount());
            int affectedRows = cstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Item updated successfully");
                System.out.println(affectedRows + " rows affected");
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("something went wrong in Update Item");
            throw new RuntimeException(e);
        }

    }

    /**
     * deletes an item
     * @param itemID
     */
    @Override
    public void deleteItem(int itemID) {

    }
}
