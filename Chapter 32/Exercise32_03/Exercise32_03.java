import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise32_03 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();

        // Add an image view and add it to pane
        ImageView imageView = new ImageView("image/us.gif");
        pane.getChildren().add(imageView);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("FlagRisingAnimation");
        primaryStage.setScene(scene);

        FlagRisingThread animationThread = new FlagRisingThread(imageView);
        animationThread.start();

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
class FlagRisingThread extends Thread {
    private final ImageView imageView;

    public FlagRisingThread(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public void run() {
        PathTransition pt = new PathTransition(Duration.millis(10000),
                new Line(100, 200, 100, 0), imageView);

        pt.setCycleCount(5);
        pt.play(); // Start animation

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Platform.runLater(() -> {
            System.out.println("Animation completed");
        });
    }
}
