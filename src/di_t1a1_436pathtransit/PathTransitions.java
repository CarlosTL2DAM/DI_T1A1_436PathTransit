/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a1_436pathtransit;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * 2ºDAM DI
 * @author Carlos Torres Liñán
 * 04/10/2021
 */
public class PathTransitions extends Application {
    //Atributos
    Pane root;
    Scene scene;
    Circle circulo;
    Rectangle rectangulo;
    PathTransition animacion;
    
    @Override
    public void start(Stage primaryStage) {
        //Declaramos como será el Layout
        root = new Pane();
        //Creamos la escena
        scene = new Scene(root, 300, 250);
        
        //Creamos el circulo, añadimos borde negro y interior blanco
        circulo = new Circle(125, 100, 50);
        circulo.setFill(Color.WHITE);
        circulo.setStroke(Color.BLACK);
        
        
        
        //Creamos rectangulo, añadimos color naranja
        rectangulo = new Rectangle(25,50);
        rectangulo.setFill(Color.ORANGE);
        
        
        //Creamos el PathTransitions, en el contructor le añadimos duracion, el path y el nodo
        animacion = new PathTransition(Duration.millis(4000), circulo, rectangulo);
        //Escogemos como orientacion que sea de Ortognoal a tangente
        animacion.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        //Decimos que el ciclo sea indefinido
        animacion.setCycleCount(Timeline.INDEFINITE);
        //Escogemos que la animacion cuando pasen los 4000 milisegundos, invierta el sentido
        animacion.setAutoReverse(true);
        //Damos comienzo a la animacion
        animacion.play();
        
        //Evento que provoca la pausa de la animación si pulsamos sobre el circulo
        circulo.setOnMousePressed(e ->{
            animacion.pause();
        });
        
        //Evento que provoca la renaudación de la animación si despulsamos sobre el circulo
        circulo.setOnMouseReleased(e -> {
            animacion.play();
        });
        
        //Añadimos tanto el circulo como el rectangulo al root
        root.getChildren().addAll(circulo,rectangulo);
        
        //Escogemos titulo para nuestra ventana
        primaryStage.setTitle("Ejercicio 4.3.6 PathTransition in Animation");
        //Escogemos la escena para la ventna
        primaryStage.setScene(scene);
        //Mostramos la ventana
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
