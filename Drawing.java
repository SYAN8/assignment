 
import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class Drawing  extends JFrame{
	public Drawing pd;
	MyPanel2 mp = null;
	//constructor
	public Drawing(){
		mp = new MyPanel2();
		
		this.add(mp);
		
		this.setTitle("Herding Cats!");
		// the size of windeow
		this.setSize(600,600);
		this.setVisible(true);
		// the location of windeow in the screen
		this.setLocation(300,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Drawing(Dog dog){
		mp = new MyPanel2(dog);
		
		this.add(mp);
		
		this.setTitle("Herding Cats!");
		// the size of windeow
		this.setSize(600,600);
		this.setVisible(true);
		// the location of windeow in the screen
		this.setLocation(300,0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}			
}

//我的面板。只有JPanel有画图方法，JFrame没有，故必须在JFrame中添加JPanel
class MyPanel2 extends JPanel{
	public static final int MAX_CATS = 10;
	Graphics g;
	//定义一个乌龟
	// Cat c = null;
	// Dog d = null;	
	//构造函数
    public MyPanel2(){	
		Cat[] catsPosition = new Cat[MAX_CATS];
    }
    public MyPanel2(Dog dog){	
    	this.dog = dog;
		
    }
    //cats' appearence
    public void drawCats(int x, int y, Graphics g){
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
    	if (x!=0 && y!=0){
    		//face fillOval(x,y,width,height)
	    	g.setColor(Color.black);
	    	g.fillOval(x, y, 50, 30);
	    	//mouth
	    	g.setColor(Color.red);
	    	//fillArc(int x, int y, int width, int height, int startAngle, int arcAngle)
	    	g.fillArc(x+10, y+17, 30, 10, 180, 180);
    	}
   }
	//paint method, Virtual machine system call
	//Graphics 是绘图的重要类。你可以把他理解成一只画笔
	public void paint(Graphics g){
			//1.调用父类函数完成初始化任务
			int x;
			int y;
			int squareNumber;
			Random randomPosition = new Random();
			//这句话不能少
			super.paint(g);
			//drawRect(int x, int y, int width, int height)
			//g.drawRect(0, 0, 900, 900);
			g.setColor(Color.pink);
			//column
			g.drawLine(0, 200, 600, 200);
			g.drawLine(0, 400, 600, 400);
			//row
			g.drawLine(200, 0, 200, 600);
			g.drawLine(400, 0, 400, 600);
			//paint cats
			for(int i = 0; i < MAX_CATS; i++){			
				x = randomPosition.nextInt(550);
				y = randomPosition.nextInt(550);
				squareNumber = randomPosition.nextInt(6);
				this.drawCats(x, y, g);
				catsPosition[i] = new Cat(x,y,squareNumber);
			}
			int dx = dog.x;
			int dy = dog.y;
			System.out.println("dy is  "+y);
			this.drawDog(dx, dy, g);
					
	}

	// public int squareNumber(int x, int y){
	// 	int square;
	// 	if(x<200 && y<200){
	// 		return square = 7;
	// 	}else if((x>=200 && x<400) && y<200){
	// 		return square = 8;
	// 	}else if(x>=400 && y<200){
	// 		return square = 9;
	// 	}else if(x<200 && (y>=200 &&y<400)){
	// 		return square = 4;
	// 	}else if((x>=200 && x<400) && (y>=200 && y<400)){
	// 		return square = 5;
	// 	}else if(x>=400 && (y>=200 && y<400)){
	// 		return square = 6;
	// 	}else if(x<200 && y>=400){
	// 		return square = 1;
	// 	}else if((x>=200 && x<400) && y>=400){
	// 		return square = 2;
	// 	}else if(x>=400 && y>=400){
	// 		return square = 3;
	// 	}			
	// }
	
}
 
