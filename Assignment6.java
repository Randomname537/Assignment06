package Assignment6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Assignment6 extends Application {
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle (ActionEvent actionEvent){
            if(actionEvent.getTarget() == submitButton){
                System.out.println(firstName.getText() + " " + lastName.getText());
                RadioButton temp = (RadioButton) pizzaSize.getSelectedToggle();
                System.out.println("Ordered a " + temp.getText() + " " + pizzaType.getValue() + "\nwith toppings:");
                if(rainbows.isSelected()){
                    System.out.println(rainbows.getText() + ", ");
                }
                if(stars.isSelected()){
                    System.out.print(stars.getText() + ", ");
                }
                if(horseshoes.isSelected()){
                    System.out.print(horseshoes.getText() + ", ");
                }
                if(hearts.isSelected()){
                    System.out.print(hearts.getText() + ", ");
                }
                if(clovers.isSelected()){
                    System.out.print(clovers.getText() + ", ");
                }
                if(redBalloons.isSelected()){
                    System.out.print(redBalloons.getText());
                }
                System.out.println("\nand comments:");
                System.out.println(comments.getText());
            }
        }
    }
    private Scene scene;
    private Label welcomeMessage;
    private ImageView logo;
    private ComboBox<String> pizzaType;
    private ToggleGroup pizzaSize;
    private RadioButton small, medium, large;
    private CheckBox rainbows, stars, horseshoes, hearts, clovers, redBalloons;
    private TextField firstName, lastName;
    private TextArea comments;
    private Button submitButton;

    @Override
    public void start(Stage primaryStage) {
        Font boldFont = Font.font("System", FontWeight.BOLD, 32.0);
        Font labelFont = Font.font("System", FontWeight.BOLD, 14.0);

        welcomeMessage = new Label("Welcome to PizzaLand!");
        welcomeMessage.setFont(boldFont);
        Image logoImage;
        try {
            // Provide the path to your image file
            FileInputStream inputStream = new FileInputStream("J:\\2430 OOP\\IDEA\\InclassActivities\\JavaFxProject\\src\\Assignment6\\pizzalandlogo.png");
            logoImage = new Image(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        logo = new ImageView(logoImage);
        logo.setPreserveRatio(true);
        logo.setFitWidth(300);

        Label pizzaTypeLabel = new Label("Pizza Type");
        pizzaTypeLabel.setFont(labelFont);
        pizzaType = new ComboBox<>();
        pizzaType.getItems().addAll("Plain", "Seafood", "Vegetarian", "Bacon", "Hawaiian", "Uni's Electric Rainbow Signature Pizza");

        Label pizzaSizeLabel = new Label("Pizza Size");
        pizzaSizeLabel.setFont(labelFont);
        pizzaSize = new ToggleGroup();
        small = new RadioButton("Small");
        small.setToggleGroup(pizzaSize);
        small.setPadding(new Insets(0, 8, 0, 0));
        medium = new RadioButton("Medium");
        medium.setToggleGroup(pizzaSize);
        large = new RadioButton("Large");
        large.setToggleGroup(pizzaSize);
        large.setPadding(new Insets(0, 7, 0, 0));

        Label toppingsLabel = new Label("Toppings");
        toppingsLabel.setFont(labelFont);
        rainbows = new CheckBox("Rainbows");
        rainbows.setPadding(new Insets(0, 5, 0, 0));
        stars = new CheckBox("stars");
        stars.setPadding(new Insets(0, 18, 0, 0));
        horseshoes = new CheckBox("Horseshoes");
        hearts = new CheckBox("Hearts");
        hearts.setPadding(new Insets(0, 17, 0, 0));
        clovers = new CheckBox("Clovers");
        clovers.setPadding(new Insets(0, 15, 0, 0));
        redBalloons = new CheckBox("Red Balloons");

        Label firstNameLabel = new Label("First Name");
        firstNameLabel.setFont(labelFont);
        firstName = new TextField();
        Label lastNameLabel = new Label("Last Name");
        lastNameLabel.setFont(labelFont);
        lastName = new TextField();

        Label commentsLabel = new Label("Comments");
        commentsLabel.setFont(labelFont);
        comments = new TextArea();

        ButtonHandler buttonHandler = new ButtonHandler();
        submitButton = new Button("Submit");
        submitButton.setOnAction(buttonHandler);

        VBox mainPane = new VBox();
        VBox titleLogo = new VBox();
        titleLogo.getChildren().addAll(welcomeMessage, logo);
        mainPane.getChildren().add(titleLogo);

        VBox inputFields = new VBox();
        HBox pizzaTypeHBox = new HBox();
        GridPane inputs = new GridPane();

        pizzaTypeHBox.getChildren().addAll(pizzaTypeLabel, pizzaType);
        inputFields.getChildren().add(pizzaTypeHBox);

        VBox pizzaSizeVBox = new VBox();
        pizzaSizeVBox.getChildren().addAll(pizzaSizeLabel, small, medium, large);
        inputs.add(pizzaSizeVBox,0,0);

        VBox toppingsVBox = new VBox();
        HBox toppingsRowOne = new HBox();
        toppingsRowOne.getChildren().addAll(rainbows,hearts);
        HBox toppingsRowTwo = new HBox();
        toppingsRowTwo.getChildren().addAll(stars,clovers);
        HBox toppingsRowThree = new HBox();
        toppingsRowThree.getChildren().addAll(horseshoes,redBalloons);
        toppingsVBox.getChildren().addAll(toppingsRowOne,toppingsRowTwo,toppingsRowThree);
        inputs.add(toppingsVBox,1, 0);

        VBox customerInformation = new VBox();
        HBox firstNameHBox = new HBox();
        firstNameHBox.getChildren().addAll(firstNameLabel,firstName);
        HBox lastNameHBox = new HBox();
        lastNameHBox.getChildren().addAll(lastNameLabel, lastName);
        customerInformation.getChildren().addAll(firstNameHBox,lastNameHBox);
        inputs.add(customerInformation, 0, 1);

        VBox commentsVBox = new VBox();
        commentsVBox.getChildren().addAll(commentsLabel, comments);
        inputs.add(commentsVBox,1, 1);

        inputFields.getChildren().add(inputs);

        mainPane.getChildren().add(inputFields);
        mainPane.getChildren().add(submitButton);

        scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setTitle("Student Registration Form");
        primaryStage.show();
    }
}
