package Week6Chapter12;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
    This application displays a window with a
    label on the left and two pictures on the right.
 */
public class DisplayTheFlags extends Application {
    // launch the application
    public static void main(String[] args) {
        launch(args);
    }

    /**
     Start : this method creates the window.
     */
    @Override
    public void start(Stage primaryStage) {
        /*
         * First, source the items.
         */

        Image finlandFlagImage = new Image(getClass().getResourceAsStream("/sources/Finland.png"));
        Image germanyFlagImage = new Image(getClass().getResourceAsStream("/sources/Germany.png"));

        ImageView finlandFlagIView = new ImageView(finlandFlagImage);
        ImageView germanyFlagIView = new ImageView(germanyFlagImage);

        finlandFlagIView.setFitWidth(200);
        finlandFlagIView.setPreserveRatio(true);

        germanyFlagIView.setFitWidth(200);
        germanyFlagIView.setPreserveRatio(true);

        // Set up the text label
        Label textOnLeftSide = new Label("Flags of Finland and Germany");
        textOnLeftSide.setAlignment(Pos.CENTER_LEFT);

        // Set up the vbox element
        VBox flagFrame = new VBox(10);
        flagFrame.getChildren().addAll(finlandFlagIView, germanyFlagIView);
        flagFrame.setAlignment(Pos.CENTER_RIGHT);

        // Set up the GridPane
        GridPane layoutFrame = new GridPane(20, 20);
        layoutFrame.setPadding(new Insets(20));
        layoutFrame.add(textOnLeftSide, 1, 0);
        layoutFrame.add(flagFrame, 2, 0);

        // Display the GridPane
        Scene scene = new Scene(layoutFrame);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Justin N");
        primaryStage.show();


    }
}
