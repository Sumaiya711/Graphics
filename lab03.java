/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author sajib
 */
public class lab03 implements GLEventListener {
    /**
     * Interface to the GLU library.
     */
    private GLU glu;

    /**
     * Take care of initialization here.
     * @param gld
     */
    @Override
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    }

    /**
     * Take care of drawing here.
     * @param drawable
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        /*
         * put your code here
         */
       //points should be in the same zone
        DrawMPL(gl,0,700,800,700);
        DrawMPL(gl,0,100,800,100);
        DrawMPL(gl,0,100,0,700);
        DrawMPL(gl,800,100,800,700);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //do nothing
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        //do nothing
    }
    
    int dx, dy, b;
    private void DrawMPL(GL2 gl, int x1, int y1, int x2, int y2) {
       //write your own code
       gl.glPointSize(2.0f);
       gl.glColor3d(255, 0, 127);
      
                    
       gl.glBegin(GL2.GL_POINTS); 
       int zone=findZone(x1,y1,x2,y2);
       if(zone==1) 
       {
           x1=convertX(x1,y1,1);
           x2=convertX(x2,y2,1);
           y1=convertY(x1,y1,1);
           y2=convertY(x2,y2,1);
       }
           
 
 
 else if(zone==2) 
 {
           x1=convertX(x1,y1,2);
           x2=convertX(x2,y2,2);
           y1=convertY(x1,y1,2);
           y2=convertY(x2,y2,2);
           
 }
  
 else if(zone==3) {
     x1=convertX(x1,y1,3);
           x2=convertX(x2,y2,3);
           y1=convertY(x1,y1,3);
           y2=convertY(x2,y2,3);
           
 }
  
 else if(zone==4) {
     x1=convertX(x1,y1,4);
           x2=convertX(x2,y2,4);
           y1=convertY(x1,y1,4);
           y2=convertY(x2,y2,4);
           
 }
  
 else if(zone==5) {
     x1=convertX(x1,y1,5);
           x2=convertX(x2,y2,5);
           y1=convertY(x1,y1,5);
           y2=convertY(x2,y2,5);
           
 }
  
 else if(zone==6) {
  x1=convertX(x1,y1,6);
           x2=convertX(x2,y2,6);
           y1=convertY(x1,y1,6);
           y2=convertY(x2,y2,6);
           
 }
 else if(zone==7){
     x1=convertX(x1,y1,7);
           x2=convertX(x2,y2,7);
           y1=convertY(x1,y1,7);
           y2=convertY(x2,y2,7);
           
 }
  
 
       
       int dx,dy,d,incE,incNE,x,y;
       dx=x2-x1;
       dy=y2-y1;
       d=2*dy-dx;
       incE=2*dy;
       incNE=2*(dy-dx);
       y=y1;
       
       for(x=x1;x<=x2;x++)
       {
           if(zone==1)
           {
           gl.glVertex2d(y,x);
           }
           else if(zone==2)
           {
               gl.glVertex2d(-y,x);
               
           }
           else if(zone==3)
           {
               gl.glVertex2d(-x,y);
               
           }
           else if(zone==4)
           {
               gl.glVertex2d(-x,-y);
               
           }
           else if(zone==5)
           {
               gl.glVertex2d(-y,-x);
               
           }
           else if(zone==6)
           {
               gl.glVertex2d(y,-x);
               
           }
           else if(zone==7)
           {
               gl.glVertex2d(x,-y);
               
           }
           else
           {
               gl.glVertex2d(x,y);
               
           }
           
           
           
           
           
           
           
           
           if(d>0)
           {
               d=d+incNE;
               y=y+1;
           }
           else
           {
               d=d+incE;
           }
           }
       
               
       
       
      
       gl.glEnd();
    }
    
    //y=mx+b
    private int func(int x, float y){
        return (int)(dy*x - y*dx + b*dx);
    }
    
    
    int findZone(int x1, int y1, int x2, int y2) {
        int zone = 0;
        int dx,dy;
        dx=x2-x1;
        dy=y2-y1;
        if(dx>=0 && dy>=0)
        {
            if(dx>0){
                zone=0;
            }
            else{
                zone=1;
            }
        }
        else if (dx<0 && dy>=0)
        {
            if(Math.abs(dx)>= Math.abs(dy))
            {
                zone=3;
            }
            else
            {
                zone=2;
            }
        }
        else if (dx<0 && dy<0)
        {
            if(Math.abs(dx)>= Math.abs(dy))
            {
                zone=4;
            }
            else
            {
                zone=5;
            }
        }
        else if (dx>=0 && dy<0)
        {
            if(Math.abs(dx)>= Math.abs(dy))
            {
                zone=7;
            }
            else
            {
                zone=6;
            }
        }
        
        return zone ;
    }
    
    int convertX(int x, int y, int zone){
         int convertedX;
        if(zone==1)
        {
              convertedX=y;
        }
        else if(zone==2)
        {
              convertedX=-y;
        }
        else if(zone==3)
        {
              convertedX=-x;
        }
        else if(zone==4)
        {
              convertedX=-x;
        }
        else if(zone==5)
        {
              convertedX=-y;
        }
        else if(zone==6)
        {
              convertedX=y;
        }
        else
        {
              convertedX=x;
        }
              
        
        
            
        
        return convertedX;
    }
    
    int convertY(int x, int y, int zone){
       int convertedY=0;
       if(zone==1)
       {
           convertedY=x;
       }
       else if(zone==2)
       {
           convertedY=x;
       }
       else if(zone==3)
       {
           convertedY=y;
       }
       else if(zone==4)
       {
           convertedY=-y;
       }
       else if(zone==5)
       {
           convertedY=-x;
       }
       else if(zone==6)
       {
           convertedY=-x;
       }
       else 
       {
           convertedY=-y;
       }
       
       
           
       
       
       return convertedY;
    }
    
    
    public void dispose(GLAutoDrawable arg0) {
        //do nothing
    }
}

