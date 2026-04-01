module JavaIICoursework {
        requires javafx.controls;
        requires javafx.fxml;

        opens Week6Chapter12 to javafx.fxml;
        exports Week6Chapter12 to javafx.graphics;

        opens ProgrammingChallenge8 to javafx.fxml;
        exports ProgrammingChallenge8 to javafx.graphics;

        opens Chapter13Week8 to javafx.fxml;
        exports Chapter13Week8 to javafx.graphics;

        opens sources to javafx.graphics;
        exports Chapter13Week9 to javafx.graphics;
        opens Chapter13Week9 to javafx.fxml;
}