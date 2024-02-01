// Exercise31_01Server.java: The server can communicate with
// multiple clients concurrently using the multiple threads
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise33_01Server extends Application {
    // Text area for displaying contents
    private TextArea ta = new TextArea();

    private int clientNumber = 0;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        ta.setWrapText(true);

        // Create a scene and place it in the stage
        Scene scene = new Scene(new ScrollPane(ta), 400, 200);
        primaryStage.setTitle("Exercise31_01Server"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        new Thread( () -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(() ->
                        ta.appendText("MultiThreadServer began at " + new Date() + "\n"));

                Socket socket = serverSocket.accept();

                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while(true) {
                    Date clientConnection = new Date();

                    double annualInterestRate = inputFromClient.readDouble();
                    int numberOfYears = inputFromClient.readInt();
                    double loanAmount = inputFromClient.readDouble();

                    double monthlyInterestRate = annualInterestRate / 1200;
                    double monthlyPayment =loanAmount * monthlyInterestRate / (1 -
                            (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
                    double totalPayment = monthlyPayment * numberOfYears * 12;

                    outputToClient.writeDouble(monthlyPayment);
                    outputToClient.writeDouble(totalPayment);

                    Platform.runLater(() -> {
                        ta.appendText("Connected to client at " + clientConnection + "\n");
                        ta.appendText("Annual Interest Rate: " + annualInterestRate + "\n");
                        ta.appendText("Number of years: " + numberOfYears + "\n");
                        ta.appendText("Loan Amount: " + loanAmount + "\n");
                        ta.appendText("Monthly Payment: " + monthlyPayment + "\n");
                        ta.appendText("Total Payment: " + totalPayment + "\n");
                    });
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
