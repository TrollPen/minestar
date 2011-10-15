package net.minestar;

import net.minestar.entity.Player;
import net.minestar.entity.ServerPlayer;
import net.minestar.net.SessionRegistry;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.DefaultChannelGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author zml2008
 */
public class Server implements GameCore {
    private static final Logger logger = Logger.getLogger("Minestar");
    private final List<ServerWorld> worlds = new ArrayList<ServerWorld>();
    private final SessionRegistry sessions = new SessionRegistry();
    
    /**
     * The {@link org.jboss.netty.bootstrap.ServerBootstrap} used to initialize Netty.
     */
    private final ServerBootstrap bootstrap = new ServerBootstrap();

    /**
     * A group containing all of the channels.
     */
    private final ChannelGroup group = new DefaultChannelGroup();

    /**
     * The network executor service - Netty dispatches events to this thread
     * pool.
     */
    private final ExecutorService executor = Executors.newCachedThreadPool();
    
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
            player.sendMessage(message);
        }
    }
    
    public SessionRegistry getSessionRegistry() {
        return sessions;
    }
    
    public ChannelGroup getChannelGroup() {
        return group;
    }
}
