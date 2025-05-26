module main.bst {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.bst to javafx.fxml;
    exports main.bst;
}