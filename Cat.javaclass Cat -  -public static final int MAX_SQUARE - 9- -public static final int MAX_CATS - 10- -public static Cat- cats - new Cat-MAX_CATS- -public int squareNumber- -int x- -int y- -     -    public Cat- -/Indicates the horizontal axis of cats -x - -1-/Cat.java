class Cat {

		public static final int MAX_SQUARE = 9;
		public static final int MAX_CATS = 10;
		public static Cat[] cats = new Cat[MAX_CATS];
		public int squareNumber;
		int x;
		int y;
	    
	    public Cat(){
	    	//Indicates the horizontal axis of cats
			x = -1; 
			//Indicates the ordinate of cats
			y = -1;
			squareNumber = 0;
	    }

		public int getX() {
			return x;
		}
 
		public void setX(int x) {
			this.x = x;
		}
 
		public int getY() {
			return y;
		}
 
		public void setY(int y) {
			this.y = y;
		}
		public Cat(int x, int y){
			this.x = x;
			this.y = y;
			squareNumber = square(x,y);
			System.out.println("x : "+x+"y : "+y);
		}

		public int square(int x, int y){
				if(x<200 && y<200){
		 			return squareNumber = 7;
			 	}else if((x>=200 && x<400) && y<200){
			 		return squareNumber = 8;
			 	}else if(x>=400 && y<200){
			 		return squareNumber = 9;
			 	}else if(x<200 && (y>=200 &&y<400)){
			 		return squareNumber = 4;
			 	}else if((x>=200 && x<400) && (y>=200 && y<400)){
			 		return squareNumber = 5;
			 	}else if(x>=400 && (y>=200 && y<400)){
			 		return squareNumber = 6;
			 	}else if(x<200 && y>=400){
			 		return squareNumber = 1;
			 	}else if((x>=200 && x<400) && y>=400){
			 		return squareNumber = 2;
			 	}else if(x>=400 && y>=400){
			 		return squareNumber = 3;
			 	}else{
			 		return squareNumber = 0;
			 	}			
	    }
}
