import objectdraw.*;
import java.awt.Color;

/**
 * DrawArc draws a circle at a given location.
 */
public class DrawArc{
  private double x, y;
  private DrawingCanvas canvas;
  FilledArc fa;
  FramedRect fb;
  private final int ARC_SIZE = 2;
  int pattern_size = 56;

  /**
   * Draw frames. Give user the region to draw numbers. The frame is 56*56
   * @param x - x starting location for the arc
   * @param y - y starting location for the arc
   * @param canvas - the canvas to draw the arc in. Should be provided by objectdraw
   */
  public DrawArc(double x, double y, DrawingCanvas canvas) {

    this.x = x;
    this.y = y;
    this.canvas = canvas;

    // draw six frames. the user should draw one number in one frame.
    FramedRect f1 = new FramedRect(0.0,0.0,pattern_size,pattern_size,canvas);
    f1.setColor(Color.LIGHT_GRAY);
    FramedRect f2 = new FramedRect(56.0,0.0,pattern_size,pattern_size,canvas);
    f2.setColor(Color.LIGHT_GRAY);
    FramedRect f3 = new FramedRect(112.0,0.0,pattern_size,pattern_size,canvas);
    f3.setColor(Color.LIGHT_GRAY);
    FramedRect f4 = new FramedRect(168.0,0.0,pattern_size,pattern_size,canvas);
    f4.setColor(Color.LIGHT_GRAY);
    FramedRect f5 = new FramedRect(224.0,0.0,pattern_size,pattern_size,canvas);
    f5.setColor(Color.LIGHT_GRAY);
    FramedRect f6 = new FramedRect(280.0,0.0,pattern_size,pattern_size,canvas);
    f6.setColor(Color.LIGHT_GRAY);    
    FramedRect f7 = new FramedRect(336.0,0.0,pattern_size,pattern_size,canvas);
    f7.setColor(Color.LIGHT_GRAY);
    FramedRect f8 = new FramedRect(392.0,0.0,pattern_size,pattern_size,canvas);
    f8.setColor(Color.LIGHT_GRAY);
    }
  
  
  /**
   * Draw circle on the place where mouse drags or presses.
   * @param x - x starting location for the arc
   * @param y - y starting location for the arc
   * @param canvas - the canvas to draw the arc in. Should be provided by objectdraw
   */  
  public DrawArc(int x, int y, DrawingCanvas canvas) {
	    this.x = x;
	    this.y = y;

	    int startAngle = 0;
	    int stopAngle = 360;
	    this.canvas = canvas;

	    fa = new FilledArc(this.x, this.y, ARC_SIZE, ARC_SIZE, startAngle, stopAngle, canvas);
	    fa.setColor(Color.BLUE);	  
  }
}
