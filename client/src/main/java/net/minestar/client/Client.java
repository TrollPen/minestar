package net.minestar.client;

import net.minestar.GameCore;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import java.util.logging.Logger;

/**
 * @author zml2008
 */
public class Client implements GameCore {
    private static final Logger logger = Logger.getLogger("MineStar");
    private float color = 0.5F;
    private int counter;
    
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
        while (true) {
            if (!client.pulse()) break;
        }
        
    }

    public Logger getLogger() {
        return logger;
    }

    public void start() {
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 600, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }
    
    public boolean pulse() {
        if (++counter < 50) return true;
        counter = 0;
        
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
		
	    // set the color of the quad (R,G,B,A)
	    GL11.glColor3f(0.5f,0.5f,1.0f);
	    	
	    // draw quad
	    GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(100,100);
		GL11.glVertex2f(100+200,100);
		GL11.glVertex2f(100+200,100+200);
		GL11.glVertex2f(100,100+200);
	    GL11.glEnd();

        if (color <= 1.0F) {
            color += 0.1F;
        } else {
            color = 0F;
        }
        
        // set the color of the quad (R,G,B,A)
	    GL11.glColor3f(color, 1.0f, 0.5f);
	    	
	    // draw quad
	    GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(300,100);
		GL11.glVertex2f(300+200,100);
		GL11.glVertex2f(300+200,100+200);
		GL11.glVertex2f(300,100+200);
        
        Display.update();
        if (Display.isCloseRequested()) {
            Display.destroy();
            return false;
        }
        return true;
    }
}
