package org.example.kantine_projekt.Controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import org.example.kantine_projekt.Domains.AccessLevels;
import org.example.kantine_projekt.Domains.Employee;
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

    private Employee currentEmployee;

    List<Item> items = new ArrayList<>();
    @FXML
    public VBox vBoxForItems;

    public void initialize()
    {
        items.add(new Item("Æble", -1, 6, 20, 32, 40));
        items.add(new Item("Banana", -1, 8, 20, 27, 40));
        items.add(new Item("Salat", -1, 22, 10, 14, 25));
    }

    public void prepare()
    {
        updateDisplayedItems();
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
        if (currentEmployee.getAccessLevel() != AccessLevels.CanteenBoss)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Access Denied");
            alert.setHeaderText("Access Denied");
            alert.setContentText("You are not allowed to add an item");
            alert.showAndWait();
            return;
        }

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
                        -1,
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
            updateDisplayedItems();
        });
    }

    private void createAllowed()
    {
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

    public void updateDisplayedItems()
    {
        vBoxForItems.getChildren().clear();
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.add(new Label("Name"), 0, 0);
        grid.add(new Label("Supplier"), 1, 0);
        grid.add(new Label("Unit Price"), 2, 0);
        grid.add(new Label("Minimum Quantity"), 3, 0);
        grid.add(new Label("Current Quantity"), 4, 0);
        grid.add(new Label("Reorder Amount"), 5, 0);


        grid.setPadding(new Insets(20, 20, 20, 20));
        GridPane.setMargin(grid, new Insets(200, 20, 20, 20));
        grid.setAlignment(Pos.CENTER);

        int i = 1;
        for (Item item : items)
        {
            TextField nameField = new TextField(item.getName());
            nameField.setPromptText("Name");
            TextField supplierField = new TextField("" + item.getSupplierID());
            supplierField.setPromptText("Supplier");
            TextField unitPriceField = new TextField("" + item.getUnitPrice());
            unitPriceField.setPromptText("Unit Price");
            TextField minimumQuantityField = new TextField("" + item.getMinimumQuantity());
            minimumQuantityField.setPromptText("Minimum Quantity");
            TextField currentQuantityField = new TextField("" + item.getCurrentQuantity());
            currentQuantityField.setPromptText("Current Quantity");
            TextField reorderAmountField = new TextField("" + item.getReorderAmount());
            reorderAmountField.setPromptText("Reorder Amount");

            if (currentEmployee != null && currentEmployee.getAccessLevel() != AccessLevels.CanteenBoss)
            {
                nameField.setDisable(true);
                supplierField.setDisable(true);
                unitPriceField.setDisable(true);
                minimumQuantityField.setDisable(true);
                currentQuantityField.setDisable(true);
                reorderAmountField.setDisable(true);
            }

            grid.add(nameField, 0, i);
            grid.add(supplierField, 1, i);
            grid.add(unitPriceField, 2, i);
            grid.add(minimumQuantityField, 3, i);
            grid.add(currentQuantityField, 4, i);
            grid.add(reorderAmountField, 5, i);

            nameField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!nameField.getText().matches("[a-zA-ZæøåÆØÅ]+"))
                {
                    nameField.setStyle("-fx-background-color: red");
                }
                else
                {
                    nameField.setStyle("");
                }
            });

            supplierField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!supplierField.getText().matches("[a-zA-ZæøåÆØÅ]+"))
                {
                    supplierField.setStyle("-fx-background-color: red");
                }
                else
                {
                    supplierField.setStyle("");
                }
            });

            unitPriceField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!unitPriceField.getText().matches("[0-9]+"))
                {
                    unitPriceField.setStyle("-fx-background-color: red");
                }
                else
                {
                    unitPriceField.setStyle("");
                }
            });

            minimumQuantityField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!minimumQuantityField.getText().matches("[0-9]+"))
                {
                    minimumQuantityField.setStyle("-fx-background-color: red");
                }
                else
                {
                    minimumQuantityField.setStyle("");
                }
            });

            currentQuantityField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!currentQuantityField.getText().matches("[0-9]+"))
                {
                    currentQuantityField.setStyle("-fx-background-color: red");
                }
                else
                {
                    currentQuantityField.setStyle("");
                }
            });

            reorderAmountField.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!reorderAmountField.getText().matches("[0-9]+"))
                {
                    reorderAmountField.setStyle("-fx-background-color: red");
                }
                else
                {
                    reorderAmountField.setStyle("");
                }
            });

            i++;
        }

        vBoxForItems.getChildren().add(grid);
    }

    public void logOut(){}

    public void setCurrentEmployee(Employee currentEmployee){
        this.currentEmployee = currentEmployee;
    }








}

