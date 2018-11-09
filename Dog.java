class Dog {
	public int x;
	public int y;

	public Dog(){
		//表示乌龟的横坐标
		x = -1;

		//表示乌龟的纵坐标
		y = -1;
	}
	public Dog(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;	
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}

}
