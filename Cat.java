import java.util.Random;
import java.util.HashSet;
class Cat {
		//the amount of square
		public static final int MAX_SQUARE = 9;
		// the amount of cats
		public static final int MAX_CATS = 10;
		//an instance variable that tracks which square the Cat is on
		public int squareNumber;
		//the number of each cat pickes randomly ever turn
		public int moveNumber;
		// Indicates the horizontal axis of cats
		int x;
		//Indicates the coordinate of cats
		int y;
	    public static Cat[] cats = new Cat[MAX_CATS];
	    
	    public Cat(){
	    	//default value of cordinate is -1
			x = -1; 
			y = -1;
			squareNumber = 0;
			moveNumber = 0;
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
			//generate the corresponding square rely on the specificted(x,y)
			squareNumber = square(x,y);
			moveNumber = 0;
		}
		//cat moving via change its square
		public void setSquareNumber(int squareNumber){
			if(this.squareNumber != squareNumber && squareNumber != 0){
				this.squareNumber = squareNumber;
				//chang the coordinate value via related squarenumber
				coordinateCat(squareNumber);
			}
		}
		public int getSquareNumber(int squareNumber){
			return squareNumber;
		}

		//judge square according to (x,y), because the paintComponent method set the range of different square
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

	    // this method takes the Dog’s current square as anargument and updates the Cat’s square appropriately
	    public void move(int dogSquare){
	    	//at the start of each turn, if the Dog is on the same square with the cat, 
	    	//then the cat can move randomly to any adjacent square.
	    	if(this.squareNumber == dogSquare){
	    		switch(dogSquare){
	    			case 1:
	    				//array stores the adjacent squares of each square
	    				int[] array1 = adjacentNumbers(1);
	    				//select a random square from the array of the adjacent squares
	    				this.setSquareNumber(randomMoveSquare(array1));
	    				break;
	    			case 2:
	    				int[] array2 = adjacentNumbers(2);
	    				this.setSquareNumber(randomMoveSquare(array2));
	    				break;
	    			case 3:
	    				int[] array3 = adjacentNumbers(3);
	    				this.setSquareNumber(randomMoveSquare(array3));
	    				break;
	    			case 4:
	    				int[] array4 = adjacentNumbers(4);
	    				this.setSquareNumber(randomMoveSquare(array4));
	    				break;
	    			case 5:
	    				int[] array5 = adjacentNumbers(5);
	    				this.setSquareNumber(randomMoveSquare(array5));
	    				break;
	    			case 6:
	    				int[] array6 = adjacentNumbers(6);
	    				this.setSquareNumber(randomMoveSquare(array6));
	    				break;
	    			case 7:
	    				int[] array7 = adjacentNumbers(7);
	    				this.setSquareNumber(randomMoveSquare(array7));
	    				break;
	    			case 8:
	    				int[] array8 = adjacentNumbers(8);
	    				this.setSquareNumber(randomMoveSquare(array8));
	    				break;
	    			case 9:
	    				int[] array9 = adjacentNumbers(9);
	    				this.setSquareNumber(randomMoveSquare(array9));
	    				break;
	    		}
	    	}
	    	//Each Cat picks a number between 1 and 6 randomly at each turn
	    	Random movePosition = new Random();
	    	moveNumber = movePosition.nextInt(6)+1;
	    	//If the number is 1-3, then the cat moves away from the dog
	    	if(moveNumber > 0 && moveNumber <= 3){
	    		 //Exclude these meaningless situations,cat in 1,3,7 and 9 square,and dog in square 5
				  if(this.squareNumber != 1 && this.squareNumber != 3 && this.squareNumber != 7 && this.squareNumber != 9)
				  		{
			  				if(dogSquare != 5){
			  					switch (dogSquare){
			  						//when the dog moves in different grids, the moving destingnation of the cat in different grid 
			  						case 1: 
			  							if(this.squareNumber == 2){
			  								this.setSquareNumber(3);
			  							}else if(this.squareNumber == 4){
			  								this.setSquareNumber(7);
			  							}else if(this.squareNumber == 5){
			  								this.setSquareNumber(9);
			  							}break;
			  						case 2:
			  							if(this.squareNumber == 5){
			  								this.setSquareNumber(8);
			  							}break;
			  						case 3:
			  							if(this.squareNumber == 2){
			  								this.setSquareNumber(1);
			  							}else if(this.squareNumber == 5){
			  								this.setSquareNumber(7);
			  							}else if(this.squareNumber == 6){
			  								this.setSquareNumber(9);
			  							}break;
			  						case 4:
			  							if(this.squareNumber == 5){
			  								this.setSquareNumber(6);
			  							}break;
			  						case 6:
			  							if(this.squareNumber == 5){
			  								this.setSquareNumber(4);
			  							}break;
			  						case 7:
			  							if(this.squareNumber == 4){
			  								this.setSquareNumber(1);
			  							}else if(this.squareNumber == 5){
			  								this.setSquareNumber(3);
			  							}else if(this.squareNumber == 8){
			  								this.setSquareNumber(9);
			  							}break;
			  						case 8:
			  							if(this.squareNumber == 5){
			  								this.setSquareNumber(2);
			  							}break;
			  						case 9:
			  							if(this.squareNumber == 5){
			  								this.setSquareNumber(1);
			  							}else if(this.squareNumber == 6){
			  								this.setSquareNumber(3);
			  							}else if(this.squareNumber == 8){
			  								this.setSquareNumber(7);
			  							}break;
			  					}
			  				}

				  		}
			//If the number is 4 or 5, 
			//the Cat should move to a square adjacent to its start square and adjacent to the Dog
			}else if(moveNumber == 4 || moveNumber == 5){
				int m = 0;
				 switch (dogSquare){
				 	case 1:
				 		//To find the Intersection between dog and the cat
				 		m = compareIntersection(1,this.squareNumber);
				 		this.setSquareNumber(m);
				 		break;
				 	case 2:
				 		m = compareIntersection(2,this.squareNumber);
				 		this.setSquareNumber(m);
				 		break;
				 	case 3:
				 		m = compareIntersection(3,this.squareNumber);
				 		this.setSquareNumber(m);
				 		break;
				 	case 4:
				 		m = compareIntersection(4,this.squareNumber);
				 		this.setSquareNumber(m);
				 		break;
				 	case 5:
				 		m = compareIntersection(5,this.squareNumber);
				 		this.setSquareNumber(m);
				 		break;
				 	case 6:
				 		m = compareIntersection(6,this.squareNumber);
				 		this.setSquareNumber(m);
				 		break;
				 	case 7:
				 		m = compareIntersection(7,this.squareNumber);
				 		this.setSquareNumber(m);
				 		break;
				 	case 8:
				 		m = compareIntersection(8,this.squareNumber);
				 		this.setSquareNumber(m);
				 		break;
				 	case 9:
				 		m = compareIntersection(9,this.squareNumber);
				 		this.setSquareNumber(m);
				 		break;
				 }
			}else if(moveNumber == 6){
				this.setSquareNumber(dogSquare);
			}

	    }

	    //return random and same an element(a adjacent square adjacent to its and the Dog's)
	    public int compareIntersection(int ds, int sn){
	    	//To find the array of the adjacent squares of each grid
    		int[] array = adjacentNumbers(ds);
    		int same = 0;
	 		for(int i=0; i < array.length; i++){
	 			//Exclude the meaningless situations, cat is in the he adjacent squares of dog
	 			if(array[i] == sn){
	 				return this.squareNumber;
	 			}else{
	 				int[] array2 = adjacentNumbers(sn);
	 				//To get the Intersection in two arrays
		 			int[] sameElement = getIntersection(array,array2);
		 			//when the amount of intersection is more than 1, picks one randomly
		 			same = randomMoveSquare(sameElement);
	 			}
	 		}
	 		return same;
	    }

	    //when the amount of intersection is more than 1, picks one randomly
	    public int randomMoveSquare(int[] a){
	    	if(a.length>1){
				Random number = new Random();
				int n = number.nextInt(a.length);
				return a[n];
			}else{
				return a[0];
			}
	    }

	    //return an array with same elements in both arrays
	    public int[] getIntersection(int[] a, int[] b){ 
	    	////Used to store the same elements in both arrays 
	    	int [] same;
	    	int sameValue = 0;
	    	if(a.length < b.length){
	    		same = new int[a.length];   
	    	}else{
	    		same = new int[b.length];
	    	}			  
		    for (int i = 0; i < a.length; i++) {  
		       for (int j = 0; j < b.length; j++) {  
				    if(a[i] == b[j]){
			    		same[sameValue] = b[j];
			    		sameValue++;
				    } 
				} 
		    }  			  
			return same;   
		} 
	    //when cats pick 4 or 5, using array to build the collection of beside figures 
	    public int[] adjacentNumbers(int n){
	    	switch (n){
				 case 1: 
                        int[] array1 = {2,4};
               			return array1;
                 case 2:  
                        int[] array2 = {1,3,5};
                        return array2;
                 case 3:
                        int[] array3 = {2,6};
                        return array3;
                 case 4:  
                        int[] array4 = {1,5,7};
                        return array4;
                 case 5:  
                        int[] array5 = {2,4,6,8};
                        return array5;
                 case 6:  
                        int[] array6 = {3,5,9};
                        return array6;
                 case 7:  
                        int[] array7 = {4,8};
                        return array7;
                 case 8:  
                        int[] array8 = {5,7,9};
                        return array8;
                 case 9:  
                        int[] array9 = {6,8};   
                        return array9;          
			}
			return null;
	 	}
	 
	  //generate the random Coordinate value(x,y) of cats according to the squarenumber
      public void coordinateCat(int squareNumber){
            HerdingCatsGame changePosition = new HerdingCatsGame();
            switch (squareNumber){
                  case 1: 
                        this.x = changePosition.setSquareNumber(0,200);
                        this.y = changePosition.setSquareNumber(400,600);
                        break;
                  case 2:  
                        this.x = changePosition.setSquareNumber(200,400);
                        this.y = changePosition.setSquareNumber(400,600);
                        break;
                  case 3:
                        this.x = changePosition.setSquareNumber(400,600);
                        this.y = changePosition.setSquareNumber(400,600);
                        break;
                  case 4:  
                        this.x = changePosition.setSquareNumber(0,200);
                        this.y = changePosition.setSquareNumber(200,400);
                        break;
                  case 5:  
                        this.x = changePosition.setSquareNumber(200,400);
                        this.y = changePosition.setSquareNumber(200,400);
                        break;
                  case 6:  
                        this.x = changePosition.setSquareNumber(400,600);
                        this.y = changePosition.setSquareNumber(200,400);
                        break;
                  case 7:  
                        this.x = changePosition.setSquareNumber(0,200);
                        this.y = changePosition.setSquareNumber(0,200);
                        break;
                  case 8:  
                        this.x = changePosition.setSquareNumber(200,400);
                        this.y = changePosition.setSquareNumber(0,200);
                        break;
                  case 9:  
                        this.x = changePosition.setSquareNumber(400,600);
                        this.y = changePosition.setSquareNumber(0,200);               
                        break;
            }                    
      }

}
