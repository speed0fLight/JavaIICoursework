// justin N
package Chapter13Week8;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Use buttons, check boxes, and/or lists to complete the
 * assignment.
 * -
 * Create an application that calculates the registration fees
 * for a conference.
 * -
 * The general conference registration fee is $895 per person,
 * and student registration is $495 per person.
 * -
 * There is also an optional opening night dinner with
 * a keynote speech for $30 per person. In addition, the
 * optional preconference workshops listed in Table 13-10
 * are available.
 * -
 * The application should allow the user to select the
 * registration type, the optional opening night dinner
 * and keynote speech, and as many preconference workshops
 * as desired.
 * -
 * The total cost should be displayed.
 */


public class ConferenceRegistrationSystem extends Application {
    // Constants
    private static final double NORMAL_REGISTRATION_FEE = 895;
    private static final double STUDENT_REGISTRATION_FEE = 495;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {
        // Label for workshop selection (Left side)
        Label workshopListLabel = new Label("Optional Events List (Use control keys for multiple selection.)");
        // Listview of workshops
        ObservableList<String> workshops = FXCollections.observableArrayList(
                "Introduction to E-commerce (Workshop) - $295",
                "The Future of the Web (Workshop) - $295",
                "Advanced Java Programming (Workshop) - $395",
                "Network Security (Workshop) - $395",
                "Opening night dinner - 30$"
        );

        ListView<String> workshopList = new ListView<String>(workshops);
        workshopList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        VBox workshopListVBox = new VBox();
        workshopListVBox.setPadding(new Insets(10));
        workshopListVBox.setAlignment(Pos.TOP_CENTER);
        workshopListVBox.getChildren().addAll(workshopListLabel, workshopList);

        // ---------- Button for calculating registration fee (Bottom side) ----------
        Button submitButton = new Button("Apply Registration");

        HBox submitButtonHBox = new HBox();
        submitButtonHBox.setAlignment(Pos.BOTTOM_CENTER);
        submitButtonHBox.getChildren().add(submitButton);

        // ---------- General Conference attendee setup (Middle) ---------
        Label conferenceHeaderLabel = new Label("Add your attendees for the General Conference.");

        // Add fields with drop down lists for adding people.
        Label conferenceSelection1Label = new Label("Non-Students: ");
        ChoiceBox<Integer> conferenceSelection1NumberList = new ChoiceBox<Integer>();
        conferenceSelection1NumberList.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        conferenceSelection1NumberList.setValue(0);
        HBox conferenceSelection1HBox = new HBox();
        conferenceSelection1HBox.setPadding(new Insets(10));
        conferenceSelection1HBox.getChildren().addAll(conferenceSelection1Label, conferenceSelection1NumberList);

        Label conferenceSelection2Label = new Label("Students: ");
        ChoiceBox<Integer> conferenceSelection2NumberList = new ChoiceBox<Integer>();
        conferenceSelection2NumberList.getItems().addAll(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        conferenceSelection2NumberList.setValue(0);
        HBox conferenceSelection2HBox = new HBox();
        conferenceSelection2HBox.setPadding(new Insets(10));
        conferenceSelection2HBox.getChildren().addAll(conferenceSelection2Label, conferenceSelection2NumberList);

        // Encases the fields within a vbox
        VBox conferenceSelectionVBox = new VBox();
        conferenceSelectionVBox.setPadding(new Insets(10));
        conferenceSelectionVBox.setAlignment(Pos.TOP_CENTER);
        conferenceSelectionVBox.getChildren().addAll(conferenceHeaderLabel,conferenceSelection1HBox, conferenceSelection2HBox);

        // Total cost of purchases (Right side)

        Label itemizedCostLabel = new Label("Itemized Cost");

        TextArea itemizedCostText = new TextArea();
        itemizedCostText.setEditable(false);
        itemizedCostText.setPrefRowCount(20);

        VBox itemizedCostVBox = new VBox();
        itemizedCostVBox.setMaxWidth(400);
        itemizedCostVBox.setPadding(new Insets(10));
        itemizedCostVBox.setAlignment(Pos.TOP_CENTER);
        itemizedCostVBox.getChildren().addAll(itemizedCostLabel, itemizedCostText);

        // Application: Create a window to hold the content.

        GridPane windowPane = new GridPane();
        windowPane.setHgap(10);
        windowPane.setMinSize(800, 400);
        windowPane.setPadding(new Insets(10));

        // Add elements to the main window grid
        windowPane.add(submitButtonHBox, 2, 2);
        windowPane.add(workshopListVBox, 1, 1);
        windowPane.add(conferenceSelectionVBox, 2, 1);
        windowPane.add(itemizedCostVBox, 3, 1);

        // Connection for submit
        submitButton.setOnAction(e -> {
            // Get counts from ChoiceBoxes
            int nonStudentCount = conferenceSelection1NumberList.getValue();
            int studentCount = conferenceSelection2NumberList.getValue();

            // Calculate Costs
            double nsGCACost = nonStudentCount * NORMAL_REGISTRATION_FEE;
            double sGCACost = studentCount * STUDENT_REGISTRATION_FEE;

            // Calculate Workshop and Dinner Costs
            double workshopCost = 0;
            double openingNightDinnersCost = 0;

            ObservableList<String> selectedItems = workshopList.getSelectionModel().getSelectedItems();

            for (String item : selectedItems) {
                if (item.contains("Opening night dinner")) {
                    openingNightDinnersCost += 30 * (nonStudentCount + studentCount);
                } else if (item.contains("295")) {
                    workshopCost += 295;
                } else if (item.contains("395")) {
                    workshopCost += 395;
                }
            }

            updateItemizedList(itemizedCostText, nsGCACost, sGCACost, workshopCost, openingNightDinnersCost);
        });


        Scene mainWindow = new Scene(windowPane);

        primaryStage.setTitle("Conference Registration - By Justin N");
        primaryStage.setScene(mainWindow);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * updateItemizedList             : This method updates the UI with the current selection.
     * @param itemizedCostText        : The text area for the itemized list.
     * @param nsGCACost               : total cost of Non-student general conference attendees.
     * @param sGCACost                : total cost of Student general conference attendees
     * @param workshopCost            : total cost of selected pre-conference workshops.
     * @param openingNightDinnersCost : total cost of night dinners
     */
    private void updateItemizedList(TextArea itemizedCostText, double nsGCACost, double sGCACost, double workshopCost, double openingNightDinnersCost) {
        double total = nsGCACost + sGCACost + workshopCost + openingNightDinnersCost;

        String itemizedCostString = String.format(
                                "General Conference Attendees (Non-students): $%.2f\n" +
                                "General Conference Attendees (Students): $%.2f\n" +
                                "Workshops: $%.2f\n" +
                                "Opening night dinner: $%.2f\n" +
                                "Total cost: $%.2f",
                                nsGCACost,
                                sGCACost,
                                workshopCost,
                                openingNightDinnersCost,
                                total
        );

        itemizedCostText.setText(itemizedCostString);
    }
}
