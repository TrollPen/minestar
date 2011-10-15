package net.minestar.entity;

import net.minestar.GameCore;
import net.minestar.net.Session;

/**
 * @author zml2008
 */
public class ServerPlayer extends Player {
    private final Session session;
    
    public ServerPlayer(GameCore game, Session session, String name) {
        super(game, name);
        this.session = session;
    }
    
    public Session getSession() {
        return session;
    }
}
