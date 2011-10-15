package net.minestar.net;

import net.minestar.Server;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.StaticChannelPipeline;

/**
 * A {@link ChannelPipelineFactory} for the Minecraft protocol.
 * @author Graham Edgecombe
 */
public final class MinecraftPipelineFactory implements ChannelPipelineFactory {

    /**
     * The server.
     */
    private final Server server;

    /**
     * Creates a new Minecraft pipeline factory.
     * @param server The server.
     */
    public MinecraftPipelineFactory(Server server) {
        this.server = server;
    }

    public ChannelPipeline getPipeline() throws Exception {
        return new StaticChannelPipeline(
            new NetworkDecoder(),
            new MinestarEncoder(),
            new MinecraftHandler(server)
        );
    }

}
