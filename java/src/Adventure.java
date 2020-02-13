package adventure;

import processing.core.PApplet;	
import processing.core.PFont;	//calling font
import java.io.*;

public class Adventure extends PApplet{
	
	//these variable for reading text file and save date
	PrintWriter output;
	BufferedReader read;
	String[] profile;
	
	PFont font;
	
	private float side_margin, height_margin;
	private int clickcase = 0;
	private boolean saved = false;
	
	public void settings(){
				 
		size(displayWidth, displayHeight);
		
		side_margin = displayWidth/2 - 60;
		
		height_margin = displayHeight/2;
	}
	
	public void setup(){
		
		
		colorMode(HSB, 100);
		
		font = loadFont("menu_font.vlw");
		
		textFont(font);
		

		try{
			output = new PrintWriter(new BufferedWriter(new FileWriter("bin/data/savedata.txt", true)));;
		}catch(IOException e){
			System.out.println("file");
		}
		
		try{
			profile = loadStrings("bin/data/savedata.txt");
		}catch(Exception e){
			text("this error", 100, 200);
		}
		
		read = createReader("bin/data/savedata.txt");
	}
	
	public void draw(){
		if(clickcase == 0){
		
		fill(0, 0, 100);
				
		fill(0);
		
		textSize(60);
		text("Game Title",side_margin,height_margin/2);
		
		textSize(30);
		text("New Game", side_margin, height_margin);
		
		textSize(30);
		text("Load Game", side_margin, height_margin+200);
		
		textSize(30);
		text("Exit", side_margin, height_margin+400);
		
		
		fill(0, 100, 100);
		
		}else if(clickcase == 1){
			newGame();
			
		}else {
			load();
		}
		
		if(saved){
			text("No character detected, please start new game.", 220, 150);
		}
	}
	
	public void mousePressed(){
		float x = mouseX;
		float y = mouseY;
		
		if( (x >= side_margin && x <= side_margin+100) && (y >= height_margin-60 && y <= height_margin) ){
			clickcase = 1;
		}
		
		if( (x >= side_margin && x <= side_margin+100) && (y >= height_margin+140 && y <= height_margin+200) ){
			clickcase = 2;
		}
		
		if( (x >= side_margin && x <= side_margin+100) && (y >= height_margin+340 && y <= height_margin+400) ){
			exit();
		}
	}
	
	public void newGame(){
		
		
	}
	
	public void load(){
		
		if(profile.length != 0){
			for(int i = 0; i < profile.length; i++){
				text(profile[i], 300, 300);
			}
		}else{
			
			saved = true;
			clickcase = 0;
			
		}
	}
}