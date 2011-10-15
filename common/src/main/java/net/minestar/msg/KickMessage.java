package net.minestar.msg;

/**
 * @author zml2008
 */
public class KickMessage extends Message {
    private final String message;
    
    public KickMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
