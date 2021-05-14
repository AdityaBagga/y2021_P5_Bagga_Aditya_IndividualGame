import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game extends BallWorld {
	
	public Game() {
        this.setPrefSize(500, 500);

        Ball ball = new Ball();
        ball.setX(250);
        ball.setY(250);

        Paddle paddle = new Paddle();
        paddle.setX(250);
        paddle.setY(this.getPrefHeight() - paddle.getHeight());

        double brickX = 40;
        double brickY = 150;
        for (int i = 0; i < 10; i++) {
            for (int j = 10; j > i; j--) {
                Brick brick = new Brick();
                brick.setX(brickX);
                brick.setY(brickY);
                brickX += 40;
                this.add(brick);
            }
            brickX = 40;
            brickY += 10;
        }

        this.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //paddle.setMoving(true);
                if (event.getX() <= getWidth() - paddle.getWidth()) paddle.setX(event.getX());
                paddle.setDx(event.getX() - paddle.getX());
                paddle.setPos(event.getX());
            }
        });


        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                addKey((event.getCode()));
                double speed = paddle.getWidth() / 3;
                if (paddle.getX() >= speed / 2 && event.getCode() == KeyCode.LEFT) paddle.move(-speed, 0);
                if (paddle.getX() <= getWidth() - paddle.getWidth() - speed / 2 && event.getCode() == KeyCode.RIGHT)
                    paddle.move(speed, 0);
            }
        });

        this.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                removeKey((event.getCode()));
                paddle.setDx(0);
            }
        });


        this.add(ball);
        this.add(paddle);
        this.start();

        this.requestFocus();

    }

}
