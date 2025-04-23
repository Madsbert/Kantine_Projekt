module org.example.kantine_projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.kantine_projekt to javafx.fxml;
    exports org.example.kantine_projekt;
    exports org.example.kantine_projekt.View;
    opens org.example.kantine_projekt.View to javafx.fxml;
    exports org.example.kantine_projekt.Controllers;
    opens org.example.kantine_projekt.Controllers to javafx.fxml;
}