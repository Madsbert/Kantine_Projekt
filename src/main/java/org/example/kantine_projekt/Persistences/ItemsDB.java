package org.example.kantine_projekt.Persistences;

import org.example.kantine_projekt.Domains.Items;
import org.example.kantine_projekt.Foundation.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ItemsDB implements ItemsDBInterface {
    private List<Items> items;

    @Override
    public int getPriceOfItem(int itemID) {
        return 0;
    }

    @Override
    public List<Items> getAllItems() {
        String sp = "{call get_all_items_procedure(?)}";
        Connection conn = DBConnection.getConnection();
        try(CallableStatement cstmt = conn.prepareCall(sp)) {
            List<Items> itemsList = new ArrayList<Items>();
            ResultSet rs = cstmt.executeQuery();
            while(rs.next()) {
                itemsList.add(new Items(rs.getInt("fldItemID"),rs.getString("fldName"),rs.getInt("fldSupplierID"), rs.getDouble("fldUnitprice"),rs.getInt("fldMinStock"), rs.getInt("fldCurrentStock"),rs.getInt("fldReorderAmount")));
            }
            return itemsList;

        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("something went wrong in  makeOrder");
            throw new RuntimeException(e);
        }
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
