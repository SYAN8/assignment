class Dog {
	//Indicates the horizontal axis of dog
	public int x;
	//Indicates the coordinate of dog
	public int y;

	public Dog(){
	//default value of cordinate is -1
		x = -1;
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
