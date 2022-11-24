module com.example.nrdb7 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires mongo.java.driver;
    requires java.logging;

    opens com.example.nrdb7 to javafx.fxml;
    exports com.example.nrdb7;
}