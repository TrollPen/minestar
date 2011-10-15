package net.minestar.entity;

import net.minestar.GameCore;

/**
 * @author zml2008
 */
public class HumanEntity extends LivingEntity {
    private final String name;
    
    public HumanEntity(GameCore game, String name) {
        super(game);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
