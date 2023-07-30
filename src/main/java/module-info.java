module com.example.prog3_mco2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.prog3_mco2 to javafx.fxml;
    exports com.example.prog3_mco2;
}