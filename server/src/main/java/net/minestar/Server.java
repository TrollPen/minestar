package net.minestar;

import net.minestar.entity.Player;
import net.minestar.entity.ServerPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author zml2008
 */
public class Server implements GameCore {
    private static final Logger logger = Logger.getLogger("Minestar");
    private final List<ServerWorld> worlds = new ArrayList<ServerWorld>();
    
    public Logger getLogger() {
        return logger;
    }
    
    public ServerPlayer[] getOnlinePlayers() {
        List<ServerPlayer> players = new ArrayList<ServerPlayer>();
        for (ServerWorld world : worlds) {
            players.addAll(world.getRawPlayers());
        }
        return players.toArray(new ServerPlayer[players.size()]);
    }
    
    public void broadcastMessage(String message) {
        for (Player player : getOnlinePlayers()) {
            player
        }
    }
}
