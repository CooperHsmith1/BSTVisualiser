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

import javafx.scene.shape.Circle;




import java.io.IOException;

public class BSTVisualiser extends Application
{
    double width;
    double height;

    private BST bst;
    private Canvas canvas;
    private GraphicsContext gc;

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
                int intValue = Integer.parseInt(inputfield.getText());
                bst.insert(intValue);
                drawtree();

            } catch (NumberFormatException ex) {
                System.out.println("invalid Number!");
            }

        });
        delete.setOnAction(e -> {
            try{
                int intValue = Integer.parseInt(inputfield.getText());
                bst.delete(intValue);
                drawtree();
            } catch (NumberFormatException ex) {
                System.out.println("node not found!");
            }
        });

    }
    private void drawtree() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if (bst.root != null)
        {
            double StartX = canvas.getWidth()/2;
            double StartY = 50;
            double HorizontalOffset = 100;
            double Verticalstep = 80;
            drawNode(bst.root,StartX,StartY,HorizontalOffset, Verticalstep);
        }

    }

    private void drawNode(TreeNode root, double startX, double startY, double horizontalOffset, double verticalstep) {
        if (root == null) {
            return;
        }
        else
        {
            Circle circle = new Circle();
            circle.setCenterX(startX);
            circle.setCenterY(startY);
            

        }
    }


    public static void main(String[] args) {
        launch();
    }
}