class Cat {
		public int squareNumber;
		//Indicates the horizontal axis of cats
		int dogx = 0; 
		//Indicates the ordinate of cats
		int y = 0;
		
		public int getX() {
			return this.x;
		}
 
		public void setX(int x) {
			this.x = x;
		}
 
		public int getY() {
			return this.y;
		}
 
		public void setY(int y) {
			this.y = y;
		}
		public Cat(int x, int y, int squareNumber){
			this.x = x;
			this.y = y;
			this.squareNumber = squareNumber;
			//System.out.println("x : "+this.x+"y : "+this.y);
		}
}
