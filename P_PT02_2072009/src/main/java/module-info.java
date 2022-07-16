module com.example.p_pt02_2072009 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.p_pt02_2072009 to javafx.fxml;
    exports com.example.p_pt02_2072009;

    opens com.example.p_pt02_2072009.model to javafx.fxml;
    exports com.example.p_pt02_2072009.model;
}