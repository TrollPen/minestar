package net.minestar.entity;

import net.minestar.GameCore;

/**
 * @author zml2008
 */
public abstract class Player extends HumanEntity {
    
    public Player(GameCore game, String name) {
        super(game, name);
    }
    
    public abstract void sendMessage(String message);
}
