module org.example.kantine_projekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.kantine_projekt to javafx.fxml;
    exports org.example.kantine_projekt;
    exports org.example.kantine_projekt.View;
    opens org.example.kantine_projekt.View to javafx.fxml;
}