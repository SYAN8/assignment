 
import java.awt.*;
import javax.swing.*;
import java.util.Random;
// this class is a frame and shows window
public class Drawing  extends JFrame{
	public static Dog dogDrawing;
	MyPanel2 myPanel = null;
	//constructor
	public Drawing(){
		//Instantiate a drawing board
		myPanel = new MyPanel2();
		//put myPanel in the frame
		this.add(myPanel);		
		this.setTitle("Herding Cats!");
		// the size of windeow
		this.setSize(600,600);
		this.setVisible(true);
		// the location of windeow in the screen
		this.setLocation(300,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//overload to draw dog
	public Drawing(Dog dog){
		dogDrawing = dog;
		myPanel = new MyPanel2(Drawing.dogDrawing.getX(),Drawing.dogDrawing.getY());
		this.add(myPanel);	
		this.setTitle("Herding Cats!");
		// the size of windeow
		this.setSize(600,600);
		this.setVisible(true);
		// the location of windeow in the screen
		this.setLocation(300,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
			
}

//Only JPanel has a drawing method, so must add JPanel in JFrame.
class MyPanel2 extends JPanel{
	//Instantiate cats in this class
	public static Cat [] catsDrawing = new Cat [Cat.MAX_CATS];
	Graphics g;
	//the coordinate of dog in this class
	int dx;
	int dy;	
	//构造函数
    public MyPanel2(){	
    	//default value is -1
		dx = -1;
		dy = -1;
    }
    public MyPanel2(int dx, int dy){	
		this.dx = dx;
		this.dy = dy;
    }

    //cats' appearence
    public void drawCats(int x, int y, Graphics g){
    	// prevent picture overflow boundary
    	if(x<50 || (x>200 && x<250) || (x>400 && x<450)){
    		x = x+30;
    	}else if((x>150 && x<200) || (x>350 && x<400) || x>550){
    		x = x-30;
    	}
    	if(y<50 || (y>200 && y<250) || (y>400 && y<450)){
    		y = y+30;
    	}else if((y>150 && y<200) || (y>350 && y<400) || y>550){
    		y = y-30;
    	}
    	//face fillOval(x,y,width,height)
    	g.setColor(Color.white);
    	g.fillOval(x, y, 50, 30);
    	// Moustache
    	g.setColor(Color.black);
    	g.drawLine(x-15, y+10, x+10, y+15);
    	g.drawLine(x-15, y+20, x+10, y+20);
    	g.drawLine(x-15, y+30, x+10, y+25);
    	g.drawLine(x+40, y+15, x+65, y+10);
    	g.drawLine(x+40, y+20, x+65, y+20);
    	g.drawLine(x+40, y+25, x+65, y+30);
    }
 	//dog's appearence
    public void drawDog(int x, int y, Graphics g){
    	// prevent picture overflow boundary
    	if(x<50 || (x>200 && x<250) || (x>400 && x<450)){
    		x = x+30;
    	}else if((x>150 && x<200) || (x>350 && x<400) || x>550){
    		x = x-30;
    	}
    	if(y<50 || (y>200 && y<250) || (y>400 && y<450)){
    		y = y+30;
    	}else if((y>150 && y<200) || (y>350 && y<400) || y>550){
    		y = y-30;
    	}
		//face fillOval(x,y,width,height)
    	g.setColor(Color.black);
    	g.fillOval(x, y, 50, 30);
    	//mouth
    	g.setColor(Color.red);
    	//fillArc(int x, int y, int width, int height, int startAngle, int arcAngle)
    	g.fillArc(x+10, y+17, 30, 10, 180, 180);
    }

	//paint method, Virtual machine system call
	//Graphics g is a brush
	public void paintComponent(Graphics g){
			//store the random number as the coordinate of cats
			int x;
			int y;
			Random randomPosition = new Random();
			//it has to be writen
			super.paintComponent(g);
			//drawRect(int x, int y, int width, int height)
			g.setColor(Color.pink);
			//column,set the different square
			g.drawLine(0, 200, 600, 200);
			g.drawLine(0, 400, 600, 400);
			//row,set the different square
			g.drawLine(200, 0, 200, 600);
			g.drawLine(400, 0, 400, 600);
			//generate the the random number as the coordinate of cats
			if(dx == -1 && dy == -1){
				//only paint cats
				for(int i = 0; i < Cat.MAX_CATS; i++){
					x = randomPosition.nextInt(600);
					y = randomPosition.nextInt(600);
					this.drawCats(x, y, g);
					Cat.cats[i] = new Cat(x,y);
					catsDrawing[i] = new Cat(x,y);

				}
			}else{
				//when there are the coordinate of dog
				for(int i = 0; i < catsDrawing.length; i++){
					//Redraw cats depends on the previous coordinates
					x=catsDrawing[i].getX();
					y=catsDrawing[i].getY();
					this.drawCats(x, y, g);
				}
				this.drawDog(dx,dy,g);
			}	
			Cat.cats = catsDrawing;
	}
	
}
 
