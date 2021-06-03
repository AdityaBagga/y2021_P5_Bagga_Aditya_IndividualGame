import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Ball extends Actor{
	
	private double dx;
	private double dy;
	
	public Ball() {
		String path = getClass().getClassLoader().getResource("resources/ball.png").toString();
		Image img = new Image(path);
		this.setImage(img);
		dx = 3.5;
		dy = -2;
	}
	
	public Ball(double dx, double dy) {
		String path = getClass().getClassLoader().getResource("resources/ball.png").toString();
		Image img = new Image(path);
		this.setImage(img);
		this.dx = dx;
		this.dy = dy;
	}


	@Override
	public void act(long now) {
		this.move(dx, dy);
		if(getX() <= 0) {
			dx = -dx;
		}
		if(getX() + getWidth() >= getWorld().getWidth()) {
			dx = -dx;
		}
		
		if(getY() <= 0) {
			dy = -dy;
		}
		if(getY() + getHeight() >= getWorld().getHeight()) {
			dy = -dy;
			((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getScoreCount()-1000);
		}

		if(getOneIntersectingObject(Brick.class)!=null){
			double x = getOneIntersectingObject(Brick.class).getX();
			double y = getOneIntersectingObject(Brick.class).getY();
			if(getX() >= x && getX() <= x + getOneIntersectingObject(Brick.class).getWidth()){
				dy = -dy;
			}
			else if(getY() >= y && getY() <= y + getOneIntersectingObject(Brick.class).getHeight()){
				dx = -dx;
			}
			else{
				dy = -dy;
				dx = -dx;
			}
			((BallWorld)getWorld()).getScore().setScore(((BallWorld)getWorld()).getScore().getScoreCount()+100);
			((BallWorld)getWorld()).setBricksRemoved(+1);
			
			
			RotateTransition rt = new RotateTransition();
			rt.setDuration(Duration.seconds(1));
			rt.setToAngle(90);
			rt.setNode(getOneIntersectingObject(Brick.class));
			//rt.play();
			
			TranslateTransition tt = new TranslateTransition(Duration.millis(2000), getOneIntersectingObject(Brick.class));
		    tt.setFromY(getOneIntersectingObject(Brick.class).getY());
		    tt.setToY(((BallWorld)getWorld()).getHeight());
		    tt.setAutoReverse(true);
		    
		    ParallelTransition pt = new ParallelTransition(getOneIntersectingObject(Brick.class),rt, tt);
		    pt.play();

		}

		if(getOneIntersectingObject(Paddle.class)!=null){
			double x = getOneIntersectingObject(Paddle.class).getX();
			double y = getOneIntersectingObject(Paddle.class).getY();
			Paddle paddle = getOneIntersectingObject(Paddle.class);

			if((paddle.getDx()==0 || paddle.getPos() == paddle.getX()) && getX() >= x && getX() <= x + getOneIntersectingObject(Paddle.class).getWidth()){
				dy = -dy;
			}
			if(paddle.getDx()!=0 || paddle.getPos() != paddle.getX()){
				if((paddle.getDx() < 0 || paddle.getPos() > paddle.getX()) &&
						getX() <= paddle.getX() + paddle.getWidth()/3){
					dx = -Math.abs(dx);
					dy = -dy;
				}
				else if(getX() <= paddle.getX() + (paddle.getWidth()*2)/3){
					dy = - dy;
				}
				else if(((paddle.getDx() > 0 || paddle.getPos() < paddle.getX())) &&
				getX() >= paddle.getX() + (paddle.getWidth()*2)/3){
					dx = Math.abs(dx);
					dy = -dy;
				}
			}
		}
	}

}
