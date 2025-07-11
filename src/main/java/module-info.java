module org.firsttrack.firsttrack {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens org.firsttrack.firsttrack to javafx.fxml;
    exports org.firsttrack.firsttrack;
    exports org.firsttrack.firsttrack.controller;
    opens org.firsttrack.firsttrack.controller to javafx.fxml;
}