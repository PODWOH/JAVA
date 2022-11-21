package jaba4lab;
import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator {
    private static final int MAX_ITERATIONS = 2000;



    public void getInitialRange(Rectangle2D.Double range){
        range.x=-2;
        range.y=-1.5;
        range.width=3;
        range.height=3;
    }

    public int numIterations(double x, double y){
        double currentY=0;
        double currentX=0;
        int iterationCount=0;
        while(iterationCount<MAX_ITERATIONS){
            iterationCount++;
            double newX = currentX*currentX-currentY*currentY+x;
            double newY = 2*currentX*currentY+y;
            currentX=newX;
            currentY=newY;

            if(currentX*currentX+currentY*currentY>4){
                break;
            }

        }
        if( iterationCount==MAX_ITERATIONS){
            return -1;

        }
        else {
            return iterationCount;
        }

        
    }


}
