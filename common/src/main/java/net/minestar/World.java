package net.minestar;

import net.minestar.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zml2008
 */
public abstract class World {
    
    public abstract List<? extends Player> getRawPlayers();
}
