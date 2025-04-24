package org.example.kantine_projekt.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.example.kantine_projekt.Domains.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class ItemCatalogController {

    List<Item> items = new ArrayList<>();
    @FXML
    private VBox vBoxForItems;

    public void initialize()
    {

    }

    boolean nameValid = false;
    boolean supplierValid = false;
    boolean unitPriceValid = false;
    boolean minimumQuantityValid = false;
    boolean currentQuantityValid = false;
    boolean reorderAmountValid = false;
    Node createButton = null;
    public void addNewItem()
    {
        Dialog<Item> dialog = new Dialog<>();
        dialog.setTitle("Create New Item");
        dialog.setHeaderText("Enter the details for your new item:");

        // 3) Add “Create” and “Cancel” buttons
        ButtonType createButtonType = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

        // 4) Create the form (GridPane with Labels + TextFields)
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField supplierField = new TextField();
        supplierField.setPromptText("Supplier");
        TextField unitPriceField = new TextField();
        unitPriceField.setPromptText("Unit Price");
        TextField minimumQuantityField = new TextField();
        minimumQuantityField.setPromptText("Minimum Quantity");
        TextField currentQuantityField = new TextField();
        currentQuantityField.setPromptText("Current Quantity");
        TextField reorderAmountField = new TextField();
        reorderAmountField.setPromptText("Reorder Amount");

        grid.add(new Label("Name:"),        0, 0);
        grid.add(nameField,                1, 0);
        grid.add(new Label("Supplier:"), 0, 1);
        grid.add(supplierField,                1, 1);
        grid.add(new Label("Unit Price:"), 0, 2);
        grid.add(unitPriceField,          1, 2);
        grid.add(new Label("Minimum Quantity:"), 0, 3);
        grid.add(minimumQuantityField,         1, 3);
        grid.add(new Label("Current Quantity:"), 0, 4);
        grid.add(currentQuantityField,          1, 4);
        grid.add(new Label("Reorder Amount:"), 0, 5);
        grid.add(reorderAmountField,         1, 5);

        dialog.getDialogPane().setContent(grid);



        // 5) Disable the Create button until name is non-empty
        createButton = dialog.getDialogPane().lookupButton(createButtonType);
        createButton.setDisable(true);

        nameField.textProperty().addListener((observable, oldValue, newValue) -> {
            nameValid = nameField.getText().matches("[a-zA-ZæøåÆØÅ]+");
            createAllowed();
        });

        supplierField.textProperty().addListener((observable, oldValue, newValue) -> {
            supplierValid = supplierField.getText().matches("[a-zA-ZæøåÆØÅ]+");
            createAllowed();
        });

        unitPriceField.textProperty().addListener((observable, oldValue, newValue) -> {
            unitPriceValid = unitPriceField.getText().matches("[0-9]+");
            createAllowed();
        });

        minimumQuantityField.textProperty().addListener((observable, oldValue, newValue) -> {
            minimumQuantityValid = minimumQuantityField.getText().matches("[0-9]+");
            createAllowed();
        });

        currentQuantityField.textProperty().addListener((observable, oldValue, newValue) -> {
            currentQuantityValid = currentQuantityField.getText().matches("[0-9]+");
            createAllowed();
        });

        reorderAmountField.textProperty().addListener((observable, oldValue, newValue) -> {
            reorderAmountValid = reorderAmountField.getText().matches("[0-9]+");
            createAllowed();
        });

        // 6) Convert the result when Create is clicked
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButtonType) {
                return new Item(
                        nameField.getText(),
                        supplierField.getText(),
                        Integer.parseInt(unitPriceField.getText()),
                        Integer.parseInt(minimumQuantityField.getText()),
                        Integer.parseInt(currentQuantityField.getText()),
                        Integer.parseInt(reorderAmountField.getText())
                );
            }
            return null;
        });

        // 7) Show the dialog and handle the result
        Optional<Item> result = dialog.showAndWait();
        result.ifPresent(item -> {
            // e.g. add to your ObservableList or otherwise use the new item
            items.add(item);
            System.out.println("Created: " + item);
        });
    }

    private void createAllowed()
    {
        System.out.println("nameValid : " + nameValid);
        System.out.println("supplierValid : " + supplierValid);
        System.out.println("unitPriceValid : " + unitPriceValid);
        System.out.println("minimumQuantityValid : " + minimumQuantityValid);
        System.out.println("currentQuantityValid : " + currentQuantityValid);
        System.out.println("reorderAmountValid : " + reorderAmountValid);
        if (nameValid && supplierValid && unitPriceValid && minimumQuantityValid && currentQuantityValid && reorderAmountValid )
        {
            createButton.setDisable(false);
            return;
        }
        createButton.setDisable(true);
    }

    public void updateItem(){}

    public void deleteItem(){}

    public void saveChanges(){}

    public void switchSceneToOrderCatalog(){}


    public void getItems()
    {

    }

    public void logOut(){}









}

