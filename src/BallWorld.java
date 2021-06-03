public class BallWorld extends World{

	private Score score;
	private int numBricks;
	private int numBricksRemoved;

	public BallWorld(){
		score = new Score();
		score.setX(30);
		score.setY(30);
		this.getChildren().add(score);
		numBricks = 0;
		numBricksRemoved = -1;
	}
	
	@Override
	public void act(long now) {
		
	}

	public Score getScore(){
		return score;
	}
	
	public void setBricks(int bricks) {
		numBricks += bricks;
	}
	
	public void setBricksRemoved(int bricks) {
		numBricksRemoved += bricks;
	}
	
	public int getBricks() {
		return numBricks;
	}
	
	public int getBricksRemoved() {
		return numBricksRemoved;
	}
}
