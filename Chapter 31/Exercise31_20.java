
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;

public class Exercise31_20 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();


        RadioButton top = new RadioButton("Top");
        RadioButton left = new RadioButton("Left");
        RadioButton right = new RadioButton("Right");
        RadioButton bottom = new RadioButton("Bottom");



        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10, 10, 0, 10));
        hBox.getChildren().addAll(top, left, right, bottom);
        pane.setBottom(hBox);

        ToggleGroup group = new ToggleGroup();
        top.setToggleGroup(group);
        left.setToggleGroup(group);
        right.setToggleGroup(group);
        bottom.setToggleGroup(group);


        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Line");
        StackPane pane1 = new StackPane();
        pane1.getChildren().add(new Line(10, 10, 80, 80));
        tab1.setContent(pane1);
        Tab tab2 = new Tab("Rectangle");
        tab2.setContent(new Rectangle(10, 10, 200, 200));
        Tab tab3 = new Tab("Circle");
        tab3.setContent(new Circle(50, 50, 20));
        Tab tab4 = new Tab("Ellipse");
        tab4.setContent(new Ellipse(10, 10, 100, 80));
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
        tabPane.setPadding(new Insets(5, 5, 15, 5));

        pane.setCenter(tabPane);

        top.setOnAction(e ->
                tabPane.setRotate(0));
        left.setOnAction(e ->
                tabPane.setRotate(-90));
        right.setOnAction(e ->
                tabPane.setRotate(90));
        bottom.setOnAction(e ->
                tabPane.setRotate(180));



        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("DisplayFigure"); // Set the window title
        primaryStage.setScene(scene); // Place the scene in the window
        primaryStage.show(); // Display the window
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     * line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
