module com.juilliardwu.homework4 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.juilliardwu.homework4 to javafx.fxml, com.google.gson;
    exports com.juilliardwu.homework4;
    requires com.google.gson;
}
