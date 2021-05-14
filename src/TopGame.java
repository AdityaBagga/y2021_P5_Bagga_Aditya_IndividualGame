import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TopGame extends Application {
	
	Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    	this.stage = stage;
        stage.setTitle("Aditya's Breakout");

        /*
        BorderPane rootNode = new BorderPane();

        BallWorld ballWorld = new BallWorld();
        ballWorld.setPrefSize(500, 500);
        rootNode.setCenter(ballWorld);

        Ball ball = new Ball();
        ball.setX(250);
        ball.setY(250);

        Paddle paddle = new Paddle();
        paddle.setX(250);
        paddle.setY(ballWorld.getPrefHeight() - paddle.getHeight());

        double brickX = 40;
        double brickY = 150;
        for (int i = 0; i < 10; i++) {
            for (int j = 10; j > i; j--) {
                Brick brick = new Brick();
                brick.setX(brickX);
                brick.setY(brickY);
                brickX += 40;
                ballWorld.add(brick);
            }
            brickX = 40;
            brickY += 10;
        }

        ballWorld.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //paddle.setMoving(true);
                if (event.getX() <= ballWorld.getWidth() - paddle.getWidth()) paddle.setX(event.getX());
                paddle.setDx(event.getX() - paddle.getX());
                paddle.setPos(event.getX());
            }
        });


        ballWorld.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                ballWorld.addKey((event.getCode()));
                double speed = paddle.getWidth() / 3;
                if (paddle.getX() >= speed / 2 && event.getCode() == KeyCode.LEFT) paddle.move(-speed, 0);
                if (paddle.getX() <= ballWorld.getWidth() - paddle.getWidth() - speed / 2 && event.getCode() == KeyCode.RIGHT)
                    paddle.move(speed, 0);
            }
        });

        ballWorld.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                ballWorld.removeKey((event.getCode()));
                paddle.setDx(0);
            }
        });


        ballWorld.add(ball);
        ballWorld.add(paddle);
        ballWorld.start();
        
        */

        MainMenu rootNode = new MainMenu(this);
        
        Scene scene = new Scene(rootNode, 500, 500);
        stage.setScene(scene);
        stage.show();

        //ballWorld.requestFocus();

    }
    
    public void setLevelOne() {
    	System.out.println("hi");
    	
    	Game level1 = new Game();
        //level1.setPrefSize(500, 500);
    	Scene scene = new Scene(level1, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

}
