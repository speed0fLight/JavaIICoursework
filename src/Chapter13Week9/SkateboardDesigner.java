package Chapter13Week9;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Use only combo boxes for the four lists.
 * In addition, have a "clear" button that resets
 * the total back to 0. Also have a "print receipt"
 * button that simply does the same thing as the clear
 * button.
 */

public class SkateboardDesigner extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {

        ObservableList<String> SelectableDecksList = FXCollections.observableArrayList(
                "The Master Thrasher - $60",
                "The Dictator - $45",
                "The Street King - $50"
        );
        ComboBox<String> SelectableDecksBox = new ComboBox<String>(SelectableDecksList);

        ObservableList<String> SelectableTruckAsmList = FXCollections.observableArrayList(
                "7.75-inch axle - $35",
                "8-inch axle - $40",
                "8.5-inch axle - $45"
        );
        ComboBox<String> SelectableTrucksAsmBox = new ComboBox<>(SelectableTruckAsmList);

        ObservableList<String> SelectableWheelsList = FXCollections.observableArrayList(
                "51 mm - $20",
                "55 mm - $22",
                "58 mm - $24",
                "61 mm - $28"
        );
        ComboBox<String> SelectableWheelsBox = new ComboBox<>(SelectableWheelsList);

        //TODO: Add the miscellaneous products as well.

        GridPane grid = new GridPane();


        Scene window = new Scene(grid);
        primaryStage.setTitle("Skateboard Designer");
        primaryStage.setScene(window);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
