package net.minestar.entity;

import net.minestar.GameCore;
import net.minestar.World;

/**
 * @author zml2008
 */
public class Entity {
    private final GameCore game;
    private World world;
    
    public Entity(GameCore game) {
        this.game = game;
    }
    
    public GameCore getGame() {
        return game;
    }
    
    public World getWorld() {
        return world;
    }
}
