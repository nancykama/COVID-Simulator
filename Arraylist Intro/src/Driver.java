import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer; 

public class Driver extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
	//instance variables
	private ArrayList<Cell> cells = new ArrayList<Cell>();

	

	public void paint(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 1000);

	
		for(Cell thisCell : cells) {
			thisCell.paint(g);
		}
		
		for (int i = 0; i < cells.size (); i++) {
			for (int j = i+1; j < cells.size(); j++) { 
				Cell one = cells.get(i);
				Cell two = cells.get(j);
				one.collide(two);
			}
		}

		
	}
	//tan t = 
	
	public static void main(String[] arg) {
		
		//find a way to run the constructor of the Driver class
		Driver d  = new Driver(); //will this invoke a constructor?
		
		//1D array declaration and instantiation
		int [] arr = new int [4];
		
		//print the length in console
		System.out.println(arr.length);
		
		//writing to a spot in array
		arr[0] = 1;
		//reading from a spot
		System.out.println(arr[0]);
		
		//new syntax: ArrayList can only hold objects
		ArrayList<Integer> myList = new ArrayList<Integer>();
		ArrayList<Double> myList2 = new ArrayList<Double>();
		ArrayList<Boolean> myList3 = new ArrayList<Boolean>();
		
		//size of a list
		System.out.println(myList.size());
		
		//writing/adding
		myList.add(1);
		myList.add(7);
		System.out.println(myList);
		
		//adding at an index
		myList.add(0, 13); //add 13 at pos. 0
		//existing elements will shift to the right
		
		//replace?
		myList.set(0, 24); //set affects
		
		//reading/getting element
		
		System.out.println(myList.get(0));
		System.out.println(myList);

	
	
	}	
	
	//1) add a Driver constructor
		public Driver() {
			JFrame frame = new JFrame("ArrayList stuff");
			frame.setSize(800,600);
			frame.add(this);
			
			//this part makes sure the x button closes the program
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//connect the mouseListener
			frame.addMouseListener(this);
			frame.addMouseMotionListener(this);
			//the 1d array is an instance variable
			//job of the constructor is to setup the instance
			//variables
			for(int i =0; i < 1; i++) {
				
				int x = (int)(Math.random()*800);
				int y = (int)(Math.random()*600);
				Cell temp = new Cell(x, y);
				// add it to the ArrayList
			    cells.add(temp); //call the add method of an ArrayList
				
			}
			
	
			
			t.start();
			//make the frame show up
			frame.setVisible(true);
					
		}
		
	// for re-infection
	Timer t = new Timer(16, this);
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		Cell temp = new Cell(arg0.getX()-15, arg0.getY()-35);
		temp.status = 1;
		
		cells.add(temp);
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	int mx  =0, my = 0;
	@Override
	public void mouseDragged(MouseEvent m) {
		// create a new Cell on a click
		
		Cell myCell = new Cell (m.getX(), m.getY());
		
		cells.add(myCell);
		

		
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {

		
		
	}
}



