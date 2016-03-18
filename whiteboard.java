import objectdraw.*;

/**
 * Create a whiteboard for handwritting the digits. Calls DrawArc class to show the draws
 */
public class whiteboard extends WindowController {

	int[][] img_array = new int[28][28]; // create 28*28 array to record the handwritten digits' image
	int left_up_corner_x = 0; // the x of the left up corner of the 56*56 frame
	int left_up_corner_y = 0; // the y of the left up corner of the 56*56 frame
	boolean pressing = false;
 
  /**
   * When the mouse press on the canvas, it calls this function automatically
   */	
  public void begin() {
	  
    DrawingCanvas myCanvas = canvas; 
    new DrawArc(0.0,0.0,canvas);
    
  }
  
  /**
   * When the mouse press on the canvas, it calls this function automatically
   * @param point - the Location where mouse presses
   */	
  public void  onMousePress(Location point) { // mouse listener
	    
	  int mouse_x = (int)point.getX();
	  int mouse_y = (int)point.getY();
	  // if start click in the next frame
	  if ( mouse_x> left_up_corner_x+56 ) { 
	  	create_img_array();
	  	Calculator.process_pre = true;
	  }
	  // record the place mouse drags
	  Calculator.process_pre = false;
	  for (int i= -2; i<2; i++) {
	  	for (int j = -2; j<2; j++){
	  		int x = (mouse_x-left_up_corner_x + i)/2;
	  		int y = (mouse_y-left_up_corner_y + j)/2;
	  		if (x >=0 && x<28 && y>=0 && y<28) {
	  			// System.out.println(x+"  "+y);
	  			img_array[y][x] = 250;    
	  		}   
	  	}
	  } 
	  // show on canvas
	  DrawArc t1 = new DrawArc(mouse_x,mouse_y,canvas);
  }
  
    /**
     * modify the array that contains the info of handwritten digits
     */ 
    public void create_img_array() {
    	new create_img_array(img_array);
	  	left_up_corner_x += 56;
	  	img_array = new int[28][28]; 	
    }
    
    /**
     * When the mouse drags on the canvas, it calls this function automatically
     * @param point - the Location where mouse drags
     */ 
	public void  onMouseDrag(Location point) { // mouse listener 			
		
	  int mouse_x = (int)point.getX();
	  int mouse_y = (int)point.getY();
	  // if start click in the next frame
	  if ( mouse_x> left_up_corner_x+56 ) { 
	  	create_img_array();
	  	Calculator.process_pre = true;
	  }
	  // record the place mouse drags
	  Calculator.process_pre = false;
	  for (int i= -2; i<2; i++) {
	  	for (int j = -2; j<2; j++){
	  		int x = (mouse_x-left_up_corner_x + i)/2;
	  		int y = (mouse_y-left_up_corner_y + j)/2;
	  		if (x >=0 && x<28 && y>=0 && y<28) {
	  			// System.out.println(x+"  "+y);
	  			img_array[y][x] = 250;    
	  		}   
	  	}
	  }
	  // show on canvas
	  DrawArc t1 = new DrawArc(mouse_x,mouse_y,canvas);
    }
}  
