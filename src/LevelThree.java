import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LevelThree extends BallWorld {
	
	Application game;
	
	public LevelThree(Application game) {
		this.game = game;
        this.setPrefSize(500, 500);

        Ball ball = new Ball();
        ball.setX(250);
        ball.setY(250);
        
        Ball ball2 = new Ball(3, 2);
        ball2.setX(250);
        ball2.setY(250);
        
        Ball ball3 = new Ball(2, -3);
        ball3.setX(250);
        ball3.setY(250);

        Paddle paddle = new Paddle();
        paddle.setX(250);
        paddle.setY(this.getPrefHeight() - paddle.getHeight());

        double brickX = 40;
        double brickY = 150;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                Brick brick = new Brick("resources/brick2.png");
                brick.setX(brickX);
                brick.setY(brickY);
                brickX += 40;
                setBricks(1);
                this.add(brick);
                
            }
            brickX = 40;
            brickY += 10;
        }
        setBricksRemoved(1);

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
        this.add(ball2);
        this.add(ball3);
        this.add(paddle);
        this.start();

        this.requestFocus();

    }
	
	@Override
	public void act(long now) {
		if(getBricksRemoved() >= getBricks()){
			System.out.println("Level 3 Completed");
			((TopGame) game).setHighScore(getScore());
			((TopGame) game).setGameOver();
			this.stop();
		}
		
	}

}
