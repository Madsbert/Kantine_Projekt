package org.example.kantine_projekt.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.kantine_projekt.Domains.Employee;

public class ItemCatalogController {

    private Employee currentEmployee;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize() {}

    public void addNewItem(){}

    public void updateItem(){}

    public void deleteItem(){}

    public void saveChanges(){}

    public void switchSceneToOrderCatalog(){}

    public void logOut(){}

    public void setCurrentEmployee(Employee currentEmployee){
        this.currentEmployee = currentEmployee;
    }








}

