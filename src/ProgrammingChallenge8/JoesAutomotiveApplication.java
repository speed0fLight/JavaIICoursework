package ProgrammingChallenge8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This application displays the costs of a
 * visit to Joe's automotive.
 */
public class JoesAutomotiveApplication extends Application {
    /*
        Step 1: Define the base application
     */
    public static void main(String[] args) { launch(args); }

    /**
     * start            : This method creates the main window.
     * @param mainStage : the default window shown.
     */
    @Override
    public void start(Stage mainStage) {
        /*
            Step 2: Create elements to be used on the window.

            There will be a label for hours, submit button, and multichoice box
            for the service type.
         */

        final Label label = new Label("Please select your service:");
        final ChoiceBox<String> serviceSelectionBox = new ChoiceBox<>();
        serviceSelectionBox.getItems().addAll(
                "Oil change",
                "Lube job",
                "Radiator flush",
                "Transmission flush",
                "Inspection",
                "Muffler replacement",
                "Tire rotation"
        );

        final VBox fieldsContainer = new VBox(8);
        fieldsContainer.getChildren().addAll(label, serviceSelectionBox);

        // Right side (Descripton of service)
        final Label infoHeaderLabel = new Label("Select a service to begin.");
        infoHeaderLabel.setMinHeight(20);
        infoHeaderLabel.setStyle("-fx-font-weight: bold");

        final TextArea infoBox = new TextArea();
        infoBox.setEditable(false);
        infoBox.setText("Nothing here...");

        final VBox infoContainer = new VBox(8);
        infoContainer.getChildren().addAll(infoHeaderLabel, infoBox);

        // Setting up the grid to organize the elements.
        GridPane windowGrid = new GridPane();
        windowGrid.setMinSize(800, 400);
        windowGrid.setPadding(new Insets(10));
        windowGrid.setHgap(20);
        windowGrid.add(fieldsContainer, 1, 0);
        windowGrid.add(infoContainer, 2, 0);
        /*
            Step 2a: Add connections to the ui interface.
            (Service is selected -> update ui)
         */
        serviceSelectionBox.setOnAction((event) -> {
            evaluateFields(serviceSelectionBox.getValue(), infoHeaderLabel, infoBox);
        });

        /*
            Step 3: Set up the window.
         */
        Scene mainWindow = new Scene(windowGrid);
        /*
            Step 4: Show the window.
         */
        mainStage.setScene(mainWindow);
        mainStage.setTitle("Joe's Automotive");
        mainStage.show();
    }

    /**
     * evaluateFields    : This method displays information
     * of the service and displays it.
     * @param service    : The service that was selected
     * @param infoHeader : passes the label object through for the header.
     * @param infoBox    : Textbox passed through for applying description of the service
     */
    private void evaluateFields(String service, Label infoHeader, TextArea infoBox) {
        // Set the service header
        infoHeader.setText(service);

        if (service.equals("Oil change")) {
            infoBox.setText("Price: $35.00\nHourly rate: 60$\nHours: 1\nTotal: $95.00");
        } else if (service.equals("Lube job")) {
            infoBox.setText("Price: $25.00\nHourly rate: 60$\nHours: 1\nTotal: $85.00");
        } else if (service.equals("Radiator flush")) {
            infoBox.setText("Price: $55.00\nHourly rate: 60$\nHours: 2\nTotal: $175.00");
        } else if (service.equals("Transmission flush")) {
            infoBox.setText("Price: $120.00\nHourly rate: 60$\nHours: 3\nTotal: $300.00");
        } else if (service.equals("Inspection")) {
            infoBox.setText("Price: $35.00\nHourly rate: 60$\nHours: 1\nTotal: $95.00");
        } else if (service.equals("Muffler replacement")) {
            infoBox.setText("Price: $200.00\nHourly rate: 60$\nHours: 3\nTotal: $380.00");
        } else if (service.equals("Tire rotation")) {
            infoBox.setText("Price: $20.00\nHourly rate: 60$\nHours: 1\nTotal: $80.00");
        }

    }
}
