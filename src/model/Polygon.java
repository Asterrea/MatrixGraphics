package model;
/*
 * Chris McCoy
 * Graphics Period 6
 * Matrix Program
 *
 *
 * This program allows the user to draw a polygon on a screen and
 * then perform a number of operations on it, including: translate
 * rotate, scale and shear
 *
 * To draw the polygon: click on each vertex, when done double click
 *                      in the same place
 *
 * Rotate,Shear, Scale - self explanatory, enter into x, y + angle fields
 *
 * To do combinations - check the combo button, do all operations wanted
 *                      except last one, uncheck combo button, do last
 *                      operation
 *
 * Web Site: http://www.mbhs.edu/~cmccoy/Polygon/Polygon.html
 *
 */

import java.awt.*;
import java.applet.Applet;
import java.lang.Math;

public class Polygon  extends Applet {

  Graphics g;
  Button scale = new Button("Scale");
  Button rotate = new Button("Rotate");
  Button translate = new Button("Translate");
  Button shear = new Button("Shear");
  Checkbox combo = new Checkbox("Combo",null, false);
  TextField xval = new TextField("0",3);
  TextField yval = new TextField("0",3);
  Label xlabel = new Label("X: ");
  Label ylabel = new Label("Y: ");
  Label rlabel = new Label("Angle:");
  TextField angle = new TextField("0", 5);
  Panel choices = new Panel();
  Panel input = new Panel();
  Button erase = new Button("Erase");
  Choice color = new Choice();
  int width;
  int height;
  int xpoints[] = {0,0,0,0,0,0,0,0,0,0};
  int ypoints[] = {0,0,0,0,0,0,0,0,0,0};
  int txpoints[] = {0,0,0,0,0,0,0,0,0,0};
  int typoints[] = {0,0,0,0,0,0,0,0,0,0};
  int npoints = 0;
  int x = 0;
  int y = 0;
  int firsty;
  int firstx;
  int xmult;
  int ymult;
  int ang;
  matrice mat = new matrice();


//-----------------------------------------------------------------------
  public void init()
  {

    //Adds Components to the screen

    color.addItem("Red");
    color.addItem("Green");
    color.addItem("Blue");
    color.addItem("Yellow");

    //Gets width and height of the applet
    width = Integer.parseInt(getParameter("width"));
    height = Integer.parseInt(getParameter("height"));

    g = getGraphics();
    g.setColor(Color.red);
    setBackground(Color.white);
    setForeground(Color.blue);
    choices.add(scale);
    choices.add(translate);
    choices.add(shear);
    choices.add(rotate);
    choices.add(erase);
    choices.add(combo);
    choices.add(color);
    input.add(xlabel);
    input.add(xval);
    input.add(ylabel);
    input.add(yval);
    input.add(rlabel);
    input.add(angle);

    //Sets up size for panels
    choices.reshape(10,10, width -10, 100);
    input.reshape(10,110, width - 10, 100);  
    choices.setBackground(Color.gray);
    input.setBackground(Color.gray);
    add(choices);
    add(input);
    g.setColor(Color.red);
    setTemp();
    mat.init();
  }//end Init
  


//------------------------------------------------------------
  public boolean mouseDown(Event e, int x, int y)
  {
  //Determines coordinates + draws polygon

    if((x == firstx && y == firsty) || (npoints == 9))
    {
      xpoints[npoints] = xpoints[0];
      ypoints[npoints] = ypoints[0];
      npoints++;
      g.drawPolygon(xpoints, ypoints, npoints);
    }
    else
    {
      xpoints[npoints] = x;
      ypoints[npoints] = y;
      g.drawLine(x,y,x,y);
      npoints++;
    }
    firstx = x;
    firsty = y;
    setTemp();
    return true;
  } //end MouseDown
  


//---------------------------------------------------------
  public void setTemp()
  {
  //Sets Temporary points = to actual points

    for(int a = 0; a < npoints; a++)
    {
      txpoints[a] = xpoints[a];
      typoints[a] = ypoints[a];
    }
  }//end SetTemp

//--------------------------------------------------------
public boolean action (Event e, Object o)
{ 
  xmult = Integer.parseInt (xval.getText ());
  ymult = Integer.parseInt (yval.getText ());
  ang = Integer.parseInt(angle.getText() );

  //Scales from the first coordinate of the polygon
  //Does not use matrices b/c of this

  if(o.equals("Scale"))
  {  
    for(int a = 1; a <= (npoints-1); a++)
    {
      if(xmult != 0)
        txpoints[a] = txpoints[a] + (xmult -1) * (txpoints[a] - txpoints[0]);
      else
        txpoints[a] = txpoints[a];

      if(ymult != 0)
        typoints[a] = typoints[a] + (ymult -1)  * (typoints[a] - typoints[0]);
      else
        typoints[a] = typoints[a];
     }
     if(combo.getState() == false)
     {
       mat.init();
       g.drawPolygon(txpoints, typoints, npoints);
       setTemp();
     }
  }


  //Shears relative to position - does not use matrices b/c of this

  if(o.equals("Shear"))
  {  
    for(int a = 1; a <= (npoints-1); a++)
    {
      if(xmult > 1)
        txpoints[a] = txpoints[a] + (xmult) * (typoints[a] - typoints[a-1]);
      else
        txpoints[a] = txpoints[a];

      if(ymult > 1)
        typoints[a] = typoints[a] + (ymult)  * (txpoints[a] - txpoints[a-1]);
      else
        typoints[a] = typoints[a];
     }

     txpoints[0] = txpoints[npoints - 1];
     typoints[0] = typoints[npoints - 1];

     if(combo.getState() == false)
     {
       mat.init();
       g.drawPolygon(txpoints, typoints, npoints);
       setTemp();
     }
  }



  //Translates polygon 

  if(o.equals("Translate"))
  {
    mat.transform(xmult, ymult);
    for(int a = 0; a < (npoints); a++)
    {
      txpoints[a] = mat.multx(txpoints[a], typoints[a]);
      typoints[a] = mat.multy(txpoints[a], typoints[a]);
    }
    if(combo.getState() == false)
    {
      g.drawPolygon(txpoints, typoints, npoints);
      mat.init();
      setTemp();
    }
  }


  if(o.equals("Rotate"))
  {
    //mat.rotate(ang);
    for(int a = 0; a < npoints; a++)
    {
      txpoints[a] = (int)(txpoints[a] * Math.cos(ang * Math.PI / 180) + 
(-1) * typoints[a] * Math.sin(ang * Math.PI / 180) );
      typoints[a] = (int)(txpoints[a] * Math.sin(ang * Math.PI / 180)
 + typoints[a] * Math.cos(ang * Math.PI / 180) );
    }
    if(combo.getState() == false)
    {
      g.drawPolygon(txpoints, typoints, npoints);
      mat.init();
      setTemp();
    }
  }




  //Erases screen, sets up for new polygon

  if(o.equals("Erase"))
  {
    npoints = 0;
    repaint();
    setTemp();
  } 


  //Changes line color

  if(color.getSelectedItem() == "Red")
    g.setColor(Color.red);
  if(color.getSelectedItem() == "Green")
    g.setColor(Color.green);
  if(color.getSelectedItem() == "Blue")
    g.setColor(Color.blue);
  if(color.getSelectedItem() == "Yellow")
    g.setColor(Color.yellow);
  return true;

  }//end Action

} //end Matrix



//Contains Polygon operations
class matrice {

  int coord[][] = new int[2][3];
  private int temp;


  //Sets the Polygon to the identity Polygon
  void init()
  {
    coord[0][0] = 1;
    coord[0][1] = 0;
    coord[0][2] = 0;
    coord[1][0] = 0;
    coord[1][1] = 1;
    coord[1][2] = 0;    
  }


  //Matrix multiplication for the x coordinate
  int multx(int x, int y)
  {
    //private int temp;
    temp = x * coord[0][0] + y * coord[0][1] + coord[0][2];
    return temp;
  }

  //Matrix multiplication for the y coordinate
  int multy(int x, int y)
  {
    //private int temp;
    temp =  x * coord[1][0] + y * coord[1][1] + coord[1][2];
    return temp;
  }

  //Sets up Polygon for translating
  void transform(int x, int y)
  {
    coord[0][2] += x;
    coord[1][2] += y;
  }


  //A Matrix that would be used for shear
  void shear(int x, int y)
  {
    coord[0][1] += x;
    coord[1][0] += y;
  }

 //Sets up Polygon for rotating
 void rotate(int ang)
 {
   coord[0][0] = (int)Math.cos( (ang * Math.PI)/ 180 );
   coord[0][1] = (int)Math.sin( (ang * Math.PI)/ 180 );
   coord[1][0] = (int)Math.cos( (ang * Math.PI)/ 180 ) * - 1;
   coord[1][1] = (int)Math.sin( (ang * Math.PI)/ 180 );
 }

}