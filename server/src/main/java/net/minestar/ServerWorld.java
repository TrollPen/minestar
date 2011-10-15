package net.minestar;

import net.minestar.entity.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zml2008
 */
public class ServerWorld extends World {
    private final List<ServerPlayer> rawPlayers = new ArrayList<ServerPlayer>();
    
    public List<ServerPlayer> getRawPlayers() {
        return rawPlayers;
    }
}
