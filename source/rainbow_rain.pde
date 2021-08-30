drops d[];
void setup(){
size(1200,700);
background(0);
d=new drops[500];
for(int i=0;i<500;i++){
d[i]=new drops();
}
}
void draw(){
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
color c;
drops(){
  init();
}
void init(){x=random(width);
  y=random(-300,0);
  s=random(1,4)*4;
  c=color(random(255),random(255),random(255));
  ellipsex=0;
  ellipsey=0;
  endpose=height-100+(random(300));}
void update(){
y=y+s;
}
void display(){
fill(c);
noStroke();
rect(x,y,2,15);
update();
}
void end(){
stroke(c);
noFill();
ellipse(x,y,ellipsex,ellipsey);
ellipsey=ellipsey+s/2;
ellipsex=ellipsex+s;
if(ellipsex>45){init();}
}
}
