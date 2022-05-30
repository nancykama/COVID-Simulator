import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	//instance variables should be private
	private int x, y;
	private int width;
	private int vx = 0; 
	private int vy = 0;
	private int ay = 0;
	private Color color;
	private double area; //helps with width calculation
						 //as we consume other Cells
	//status?
	//healthy: 0, infected: 1, recovered: 2, dead: 3 
	int status = 0;
	//default-constructor - no param
	public Cell() {
		//job of constructor is to setup
		//instance variables
		width = 10; 
		x = 800/2-width/2;
		y = 600/2-width/2;
		vx = 0;
		vy = 0;
		
		vx = (int)(Math.random()*(7))+-3;
		vy = (int)(Math.random()*(7))+-3;
		
		/* randomize the color */
		// (int)(Math.random()*(range+1))+min;
		int red = (int)(Math.random()*256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		color = new Color(red, green, blue);
		
		
		//assign area!
		area = Math.PI*Math.pow(width/2, 2);
		
	}
	//non-default constructor - with params
	public Cell(int newX, int newY) {
			this();
			x = newX;
			y = newY;
	}
	
	//constructor for food?
	public Cell(Color c) {
		
	}
	
	
	
	
	
	int time = 0;
	public void paint(Graphics g) {
		vy += ay;
		x+=vx;
		y+=vy;
		g.setColor(color);
		g.fillOval(x, y, width, width);
		
		//switch case implementation 
		switch (status) {
		case 0: //detect when 0
			color = Color.green;
			break;
			
		case 1: //infected
			time += 16; // roughly updated every 16 ms
			color = Color.yellow;
			if (time > 5000) {
				if (Math.random() < 0.90) {
					status = 2;
				} else {
					status = 3;
				}
			}
			break;
			
		case 2: 
			color = Color.blue;
			break;
			
		case 3: 
			color = Color.red;
			break;
		case 4: 
			color = Color.PINK;
			break;
		}
		
		if (y >= 550) {
			vy *=-1; 
		}
		if (y <= 10) {
			vy *= -1;
		}
		if (x >= 750) {
			vx *= -1;
		}
		if (x <= 10) {
			vx *= -1;
		}
		
	}
	
	public boolean collide(Cell other) {
		
		//returns true if this Cell is colliding with the other Cell object
		
		int x1 = this.x+width/2; //center pointx
		int y1 = this.y+width/2;
		
		//other cell center point
		int x2 = other.x+other.width/2;
		int y2 = other.y+other.width/2;
		
		int d = (int)(Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
		int r1 = this.width/2;
		int r2 = other.width/2;
		
		//figure out which cell is bigger
		//increment it's size somehow
		if(r1+r2 > d*3/2) {
			
			if (Math.random() < 0.5) {
			if (other.status == 1 && this.status == 0) {
				this.status = 1;
			}
			if (this.status == 1 && other.status == 0) {
				other.status = 1;
			}
		}
			if(this.area > other.area) {
				//add other area to this area
				this.area += other.area; //eat other cell			
				//calculate new width based on new area
				int r = (int)(Math.sqrt(this.area/Math.PI));
				int oldWidth = width;
				this.width = r*2;
				this.x -= (this.width-oldWidth)/2;
				this.y -= (this.width-oldWidth)/2;
				
				other.reset();
				
			}else if(this.area < other.area) {
				//add other area to this area
				other.area += this.area; //eat other cell
				//calculate new width based on new area
				int r = (int)(Math.sqrt(other.area/Math.PI));
				
				int oldWidth = other.width;
				other.width = r*2;
				other.x -= (other.width-oldWidth)/2;
				other.y -= (other.width-oldWidth)/2;
				reset();				
				
			}
		}
		
		
		return false && (r1+r2)>d;
		
	}
	
	public void reset() {
		this.x = (int)(Math.random()*(2000))-1000;
		this.y = (int)(Math.random()*(2000))-1000;
		this.width = (int)(Math.random()*(30-10))+10;
	}
	
	
	
	
	
	//getter
	public int getX() {
		return x; //return this.x;
	}
	
	//setter 
	public void setX(int newX) {
		x = newX;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		
		int old = width;
		this.width = width;
		
		this.x -= (width-old)/2;
		this.y -= (width-old)/2;
		
	}

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
