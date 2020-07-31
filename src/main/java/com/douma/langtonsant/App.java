package com.douma.langtonsant;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

import java.awt.*;

public class App extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Langton's ant");
        stage.setResizable(false);
        Pane root = new Pane();

        StackPane holder = new StackPane();
        Canvas canvas = new Canvas(500,  500);
        canvas.setScaleX(2);
        canvas.setScaleY(2);

        holder.getChildren().add(canvas);
        root.getChildren().add(holder);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        holder.setStyle("-fx-background-color: black");
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        drawShapes(gc);
    }

    private void drawShapes(GraphicsContext gc )
    {
        new Thread(() -> {
            try
            {
                Ant ant = new Ant(new Position(330,330), new TurnDegree(0));
                Board board = new Board(ant,32000);
                board.moveAnt();
                gc.setLineWidth(1);

                for(MarkedPosition position : board.positions()) {
                    if(position.isMarked()) {
                        gc.setFill(Color.WHITE);
                        gc.setStroke(Color.WHITE);
                    } else {
                        gc.setFill(Color.BLACK);
                        gc.setStroke(Color.BLACK);
                    }

                    gc.strokeLine(position.position().x(), position.position().y(),
                            position.position().x(), position.position().y());

                    Thread.sleep(1);
                }
            }
            catch(Exception e){}
        }).start();
    }
}
