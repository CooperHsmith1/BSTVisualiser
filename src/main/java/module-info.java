module main.bst {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens main.bst to javafx.fxml;
    exports main.bst;
}