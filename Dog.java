class Dog {
	private int x;
	private int y;

	public Dog(){
		//表示乌龟的横坐标
		this.x = 0;

		//表示乌龟的纵坐标
		this.y = 6;
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
		System.out.println("y is  "+y);
		return y;
	}

}
