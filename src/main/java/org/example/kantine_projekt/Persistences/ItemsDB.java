package org.example.kantine_projekt.Persistences;

import org.example.kantine_projekt.Domains.Item;
import org.example.kantine_projekt.Foundation.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemsDB implements ItemsDBInterface {
    private List<Item> items;

    @Override
    public int getPriceOfItem(int itemID) {
        return 0;
    }

    @Override
    public List<Item> getAllItems() {
        String sp = "{call get_all_items_procedure(?)}";
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

    @Override
    public String getSupplierFromItemID(int itemID){
        String sp = "{call get_supplier_from_itemID(?)}";
        Connection conn = DBConnection.getConnection();
        try(CallableStatement cstmt = conn.prepareCall(sp)){
            cstmt.setInt(1, itemID);
            ResultSet rs = cstmt.executeQuery();

            if(rs.next()) {
                return rs.getString("fldSupplierName");
            }else{
                return null;
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("something went wrong in getSupplierFromItemID");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Item getItem(int itemID) {
        return null;
    }

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

    @Override
    public void updateItem(Item item) {

    }

    @Override
    public void deleteItem(int itemID) {

    }
}
