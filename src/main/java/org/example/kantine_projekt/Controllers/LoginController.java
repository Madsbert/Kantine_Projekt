package org.example.kantine_projekt.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.kantine_projekt.CanteenApplication;
import org.example.kantine_projekt.Domains.AccessLevels;
import org.example.kantine_projekt.Domains.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * class to login
 */
public class LoginController {
    @FXML
    private TextField EmployeeIDTextfield;
    @FXML
    private RadioButton itemCatalogRadioButton;
    @FXML
    private RadioButton orderCatalogRadioButton;

    ToggleGroup group = new ToggleGroup();


    @FXML
    private Label ErrorLabel;

    List<Employee> employees = new ArrayList<>();

    /**
     * initializes employee List and groups
     */
    public void initialize() {

        employees.add(new Employee("Jakob", 100, AccessLevels.CanteenBoss));
        employees.add(new Employee("Mads", 10, AccessLevels.CanteenWorker));
        employees.add(new Employee("Mikkel", 1, AccessLevels.Employee));

        itemCatalogRadioButton.setToggleGroup(group);
        orderCatalogRadioButton.setToggleGroup(group);

    }


    /**
     * logins to the website if you have the clearance and gives right clearence.
     * It gives the current employee that is logged in to the next scene.
     * @param actionEvent an event
     * @throws IOException
     */
    public void LoginButtonClicked (ActionEvent actionEvent) throws IOException {
        String employeeID = EmployeeIDTextfield.getText();
        Employee foundEmployee = findEmployeeById(Integer.parseInt(employeeID));

        if (foundEmployee != null) {
            // Switch on the access level
            switch (foundEmployee.getAccessLevel()) {
                case Employee:
                    if (itemCatalogRadioButton.isSelected()){
                        ErrorLabel.setText("You do not have access to the item catalog");}
                    else if (orderCatalogRadioButton.isSelected()){
                        ErrorLabel.setText("You do not have access to the order catalog");
                    }
                    break;

                case CanteenWorker:
                    if (itemCatalogRadioButton.isSelected()){
                    switchToSceneItemCatalog(actionEvent,foundEmployee);}
                    else if (orderCatalogRadioButton.isSelected()){
                        ErrorLabel.setText("The Order catalog is not supported at this time");
                    }

                    System.out.println("Logged in as Canteen Worker");
                    break;

                case CanteenBoss:
                    if (itemCatalogRadioButton.isSelected()){
                        switchToSceneItemCatalog(actionEvent,foundEmployee);}
                    else if (orderCatalogRadioButton.isSelected()){
                        ErrorLabel.setText("The Order catalog is not supported at this time");
                    }

                    System.out.println("Logged in as Canteen Boss");
                    break;

                default:
                    // Handle unknown access level
                    System.out.println("Unknown access level");
            }
        }
        else {ErrorLabel.setText("Please enter a valid employee ID");}
    }

    /**
     * finds employee acording to ID
     * @param id employee id
     * @return
     */
    private Employee findEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getEmployeeID() == id) {
                return emp;
            }
        }
        return null;
    }

    /**
     * switches scene
     * @param actionEvent
     * @param employee
     * @throws IOException
     */
    public void switchToSceneItemCatalog(ActionEvent actionEvent,Employee employee) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(CanteenApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 975, 615);

        // Get controller and set employee
        ItemCatalogController controller = fxmlLoader.getController();
        controller.setCurrentEmployee(employee);
        controller.prepare();

        stage.setTitle("Item Catalog");
        stage.setScene(scene);
        stage.show();
    }














}
