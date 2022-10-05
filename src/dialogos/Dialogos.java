/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package dialogos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class Dialogos extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Creating buttons
        Button btnNoModal = new Button();
        btnNoModal.setText("Diálogo no modal");
        Button btnModalApp = new Button();
        btnModalApp.setText("Diálogo modal (aplicación)");
        Button btnModalWin = new Button();
        btnModalWin.setText("Diálogo modal (ventana)");
        Button btnOpacity = new Button();
        btnOpacity.setText("Diálogo Opacity");
        Button btnLogin = new Button();
        btnLogin.setText("Diálogo Login");

        //Button Event (NonModal)
        btnNoModal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage1 = new Stage();
                Scene pagina1 = new Scene(new StackPane(new Text(100, 100, "Esto es un dialogo no modal")));
                //Modality
                stage1.initModality(Modality.NONE);
                stage1.setScene(pagina1);
                stage1.show();
            }
        });

        //Button Event (ModalApp)
        btnModalApp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage2 = new Stage();
                Scene pagina2 = new Scene(new StackPane(new Text(100, 100, "Esto es un dialogo Modal(App)")));
                //Modality
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setScene(pagina2);
                stage2.show();
            }

        });
        
        //Button Event (ModalWin)
        btnModalWin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage3 = new Stage();
                Scene pagina3 = new Scene(new StackPane(new Text(100,100, "Esto es un dialogo Modal(Win)")));
                //Modality
                stage3.initModality(Modality.WINDOW_MODAL);
                stage3.setScene(pagina3);
                stage3.show();
        }
        });
        
        //Button Event (Opacity)
        btnOpacity.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage4 = new Stage();
                Scene pagina4 = new Scene(new StackPane(new Text(100,100, "Esto es un dialogo con opacidad 0.80")));
                //Opacity
                stage4.setOpacity(.80);
                stage4.setScene(pagina4);
                stage4.show();
        }
        });
        
        //Button Event (Login)
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage5 = new Stage();
                Group root = new Group();
                Scene pagina5 = new Scene(root, 250, 150);
                stage5.setScene(pagina5);
                GridPane gridpane = new GridPane();
                gridpane.setPadding(new Insets(5));
                gridpane.setHgap(5);
                gridpane.setVgap(5);

                Label userNameLbl = new Label("User Name: ");
                gridpane.add(userNameLbl, 0, 1);

                Label passwordLbl = new Label("Password: ");
                gridpane.add(passwordLbl, 0, 2);
                final TextField userNameFld = new TextField("Admin");
                gridpane.add(userNameFld, 1, 1);

                final PasswordField passwordFld = new PasswordField();
                passwordFld.setText("password");
                gridpane.add(passwordFld, 1, 2);

                Button login = new Button("Change");
                login.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {
                        stage5.close();
                    }
                    
                });
                gridpane.add(login, 1, 3);
                GridPane.setHalignment(login, HPos.RIGHT);
                root.getChildren().add(gridpane);
                stage5.show();
        }
        });
        
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(btnNoModal);
        root.getChildren().add(btnModalApp);
        root.getChildren().add(btnModalWin);
        root.getChildren().add(btnOpacity);
        root.getChildren().add(btnLogin);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Diálogos");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
