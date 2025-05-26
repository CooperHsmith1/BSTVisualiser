package main.bst;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;



import java.io.IOException;

public class BSTVisualiser extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        BST bst = new BST();
        Canvas  canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        TextField inputfield = new TextField();
        Button insert = new Button ("Insert");
        Button delete = new Button ("Delete");

        VBox layout = new VBox();
        layout.getChildren().addAll(inputfield, insert, delete, canvas);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("BST Visualiser");
        stage.show();

        insert.setOnAction(e -> {
            try {
                parse

            }

        });
    }

    public static void main(String[] args) {
        launch();
    }
}