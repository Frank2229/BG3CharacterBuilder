module com.advantageplay.bg3characterbuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.advantageplay.bg3characterbuilder to javafx.fxml;
    exports com.advantageplay.bg3characterbuilder;
}