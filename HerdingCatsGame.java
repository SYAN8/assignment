# assignment
HerdingCatsGame
import sheffield.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class HerdingCatsGame{
  Graphics d;
	public static void main(String[] args){
		Drawing mtg = new Drawing();
 		EasyReader keyboard = new EasyReader();
 		int typeNumber = keyboard.readInt("Please enter a number between 1 and 9 ");         
		int x = 0;
            int y = 0;
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
                        System.out.println("game over");
                        mtg.setVisible(false);
		}
            Dog dog = new Dog(x,y);
            System.out.println("y :  "+y);
            Drawing mtg2 = new Drawing(dog);
		
	}
      public int setSquareNumber(int x1, int x2){          
            Random squarePosition = new Random();
            int randomRange = squarePosition.nextInt(x2);
            while(randomRange < x1){
                  randomRange = squarePosition.nextInt(x2);
            }
            return randomRange;
      }
}



