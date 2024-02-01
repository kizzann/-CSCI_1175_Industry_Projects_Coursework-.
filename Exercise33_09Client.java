import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Exercise33_09Client extends Application {
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    private TextArea taServer = new TextArea();
    private TextArea taClient = new TextArea();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        taServer.setWrapText(true);
        taClient.setWrapText(true);
        taServer.setDisable(true);

        BorderPane pane1 = new BorderPane();
        pane1.setTop(new Label("History"));
        pane1.setCenter(new ScrollPane(taServer));
        BorderPane pane2 = new BorderPane();
        pane2.setTop(new Label("New Message"));
        pane2.setCenter(new ScrollPane(taClient));

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(pane1, pane2);

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        taClient.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    String clientMessage = taClient.getText().trim();

                    toServer.writeUTF(clientMessage);
                    toServer.flush();

                    taClient.setText("");
                    taServer.appendText("C: " + clientMessage + "\n");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        try {
            Socket socket = new Socket("localhost", 8000);
            toServer = new DataOutputStream(socket.getOutputStream());
            fromServer = new DataInputStream(socket.getInputStream());

            new Thread(() -> {
                try {
                    while(true) {
                        String message = fromServer.readUTF();
                        taServer.appendText("S: " + message + "\n");
                    }
                }
                catch(IOException ex) {
                    ex.printStackTrace();
                }
            }).start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
