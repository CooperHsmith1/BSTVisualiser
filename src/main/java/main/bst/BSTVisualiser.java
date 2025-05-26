package main.bst;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BSTVisualiser extends Application {
    private BST bst;
    private Canvas canvas;
    private GraphicsContext gc;

    @Override
    public void start(Stage stage) {
        // Initialize class variables instead of local ones
        bst = new BST();
        canvas = new Canvas(800, 600);
        gc = canvas.getGraphicsContext2D();

        TextField inputField = new TextField();
        Button insert = new Button("Insert");
        Button delete = new Button("Delete");

        VBox layout = new VBox();
        layout.getChildren().addAll(inputField, insert, delete, canvas);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("BST Visualiser");
        stage.show();

        insert.setOnAction(e -> {
            try {
                int val = Integer.parseInt(inputField.getText());
                bst.insert(val);
                drawtree();
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number");
            }
        });

        delete.setOnAction(e -> {
            try {
                int val = Integer.parseInt(inputField.getText());
                bst.delete(val);
                drawtree();
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number");
            }
        });
    }

    private void drawtree() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if (bst.root != null) {
            double startX = canvas.getWidth() / 2;
            double startY = 50;
            double horizontalOffset = 100;
            double verticalStep = 80;
            drawNode(bst.root, startX, startY, horizontalOffset, verticalStep);
        }
    }

    private void drawNode(TreeNode node, double x, double y, double horizontalOffset, double verticalStep) {
        if (node == null) return;

        double radius = 20;
        gc.strokeOval(x - radius, y - radius, radius * 2, radius * 2);
        gc.strokeText(String.valueOf(node.value), x - 6, y + 4);

        if (node.left != null) {
            double newX = x - horizontalOffset;
            double newY = y + verticalStep;
            gc.strokeLine(x, y, newX, newY);
            drawNode(node.left, newX, newY, horizontalOffset, verticalStep);
        }
        if (node.right != null) {
            double newX = x + horizontalOffset;
            double newY = y + verticalStep;
            gc.strokeLine(x, y, newX, newY);
            drawNode(node.right, newX, newY, horizontalOffset, verticalStep);
        }
    }


    public static void main(String[] args) {
        launch();
    }
}