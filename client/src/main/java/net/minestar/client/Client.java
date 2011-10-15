package net.minestar.client;

import net.minestar.GameCore;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.logging.Logger;

/**
 * @author zml2008
 */
public class Client implements GameCore {
    private static final Logger logger = Logger.getLogger("MineStar");
    
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
    }
    
    public boolean pulse() {
        Display.update();
        if (Display.isCloseRequested()) {
            Display.destroy();
            return false;
        }
        return true;
    }
}
