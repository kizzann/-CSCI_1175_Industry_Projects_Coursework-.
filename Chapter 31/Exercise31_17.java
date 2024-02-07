import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

public class Exercise31_17 extends Application {
    private TextField investmentText = new TextField();
    private TextField yearsText = new TextField();
    private TextField annualInterestText = new TextField();
    private TextField futureValueText = new TextField();
    private Button calculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuBar menuBar = new MenuBar();

        Menu operation = new Menu("Operation");
        menuBar.getMenus().add(operation);

        MenuItem menuItemCalculate = new MenuItem("Calculate");
        MenuItem exit = new MenuItem("Exit");
        operation.getItems().addAll(menuItemCalculate, exit);

        futureValueText.setEditable(false);

        VBox vBox = new VBox(menuBar);

        GridPane gp = new GridPane();
        gp.setVgap(5);
        gp.setHgap(5);
        gp.add(new Label("Investment Amount:"), 0, 1);
        gp.add(investmentText, 1, 1);
        gp.add(new Label("Number of Years:"), 0, 2);
        gp.add(yearsText, 1, 2);
        gp.add(new Label("Annual Interest Rate:"), 0, 3);
        gp.add(annualInterestText, 1, 3);
        gp.add(new Label("Future Value:"), 0, 4);
        gp.add(futureValueText, 1, 4);
        gp.add(calculate, 1, 5);
        gp.getChildren().add(vBox);

        calculate.setOnAction(e -> futureValue());

        menuItemCalculate.setOnAction(e -> futureValue());


        Scene scene = new Scene(gp, 300, 250);
        primaryStage.setTitle("Exercise32_17");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    private void futureValue() {
        double investment = Double.parseDouble(investmentText.getText());
        int years = Integer.parseInt(yearsText.getText());
        double annualInterest = Double.parseDouble(annualInterestText.getText());
        futureValueText.setText(String.format("$%.2f", (investment * (1 + annualInterest) * years * 12)));
    }
}
