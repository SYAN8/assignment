import sheffield.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class HerdingCatsGame{
      public static int typeNumber;
      public static Dog dog;
      //store the position of dog in this class
      public static int x;
      public static int y;
      private static boolean isGameOver;
      private static int[] gameWine = new int[Cat.MAX_CATS];
	public static void main(String[] args){
            //default value of cordinate is -1
            x = -1;
            y = -1;
            isGameOver = false;
            int num = 0;
            //show frame only have cats
		Drawing mtg = new Drawing();
 		EasyReader keyboard = new EasyReader();
            while(!isGameOver){
                  typeNumber = keyboard.readInt("Please enter a number between 1 and 9 ");  
                  //generate the Coordinate value(x,y) of dog according to the related square       
                  coordinate(typeNumber);
                  if(x != -1 && y != -1){
                        Drawing mtg1 = new Drawing(dog);
                        //close the older window
                        mtg.setVisible(false);
                        for(int i = 0; i < Cat.MAX_CATS; i++){
                              Cat.cats[i].move(typeNumber);
                        }
                        Drawing mtg2 = new Drawing(dog);
                        mtg1.setVisible(false);
                        //judge the win by caculating cats'grid
                        for(int i = 0; i < Cat.MAX_CATS; i++){
                              gameWine[i] = Cat.cats[i].squareNumber;
                              while(i>0 && num<9){
                                   if(gameWine[i] - gameWine[i-1] == 0){
                                    num++;
                                   }break;
                              }
                        }
                        if(num==9){
                              System.out.println("You’ve won!");
                              isGameOver = true;
                        }
                  }
            } 
            //when game over, exit.
            if(isGameOver){
                  System.exit(0);
            }          

	}
      //generate the Coordinate value(x,y) of dog
      public static void coordinate(int typeNumber){
            HerdingCatsGame position = new HerdingCatsGame();
            switch (typeNumber){
                  case 1: 
                        x = position.setSquareNumber(0,200);
                        y = position.setSquareNumber(400,600);
                        break;
                  case 2:  
                        x = position.setSquareNumber(200,400);
                        y = position.setSquareNumber(400,600);
                        break;
                  case 3:
                        x = position.setSquareNumber(400,600);
                        y = position.setSquareNumber(400,600);
                        break;
                  case 4:  
                        x = position.setSquareNumber(0,200);
                        y = position.setSquareNumber(200,400);
                        break;
                  case 5:  
                        x = position.setSquareNumber(200,400);
                        y = position.setSquareNumber(200,400);
                        break;
                  case 6:  
                        x = position.setSquareNumber(400,600);
                        y = position.setSquareNumber(200,400);
                        break;
                  case 7:  
                        x = position.setSquareNumber(0,200);
                        y = position.setSquareNumber(0,200);
                        break;
                  case 8:  
                        x = position.setSquareNumber(200,400);
                        y = position.setSquareNumber(0,200);
                        break;
                  case 9:  
                        x = position.setSquareNumber(400,600);
                        y = position.setSquareNumber(0,200);               
                        break;
                  default:
                        System.out.println("Exiting");
                        isGameOver = true;
                        break;
            }
            if(!isGameOver){
                  dog = new Dog(x,y);     
            }
      }
      //generate the rang of coordinate of dog
      public int setSquareNumber(int x1, int x2){          
            Random squarePosition = new Random();
            int randomRange = squarePosition.nextInt(x2);
            while(randomRange < x1){
                  randomRange = squarePosition.nextInt(x2);
            }
            return randomRange;
      }
}



