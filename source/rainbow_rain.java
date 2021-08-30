import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class rainbow_rain extends PApplet {

drops d[];
public void setup(){

background(0);
d=new drops[500];
for(int i=0;i<500;i++){
d[i]=new drops();
}
}
public void draw(){
  fill(0,50);
  rect(0,0,width,height);
for(int i=0;i<500;i++){


if(d[i].y>d[i].endpose){d[i].end();}
else
d[i].display();
}

}
class drops{
float x,y,s;
float ellipsex,ellipsey,endpose;
int c;
drops(){
  init();
}
public void init(){x=random(width);
  y=random(-300,0);
  s=random(1,4)*4;
  c=color(random(255),random(255),random(255));
  ellipsex=0;
  ellipsey=0;
  endpose=height-100+(random(300));}
public void update(){
y=y+s;
}
public void display(){
fill(c);
noStroke();
rect(x,y,2,15);
update();
}
public void end(){
stroke(c);
noFill();
ellipse(x,y,ellipsex,ellipsey);
ellipsey=ellipsey+s/2;
ellipsex=ellipsex+s;
if(ellipsex>45){init();}
}
}
  public void settings() { 
size(1200,700); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "rainbow_rain" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
