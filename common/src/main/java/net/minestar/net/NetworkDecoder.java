package net.minestar.net;

import java.io.IOException;
import java.util.logging.Logger;

import net.minestar.net.codec.MessageCodec;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.replay.ReplayingDecoder;
import org.jboss.netty.handler.codec.replay.VoidEnum;

/**
 * A {@link ReplayingDecoder} which decodes {@link ChannelBuffer}s into
 * game {@link net.minestar.msg.Message}s.
 */
public class NetworkDecoder extends ReplayingDecoder<VoidEnum> {
	private static final Logger logger = Logger.getLogger("${project.name}");

    private int previousOpcode = -1;

    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel c, ChannelBuffer buf, VoidEnum state) throws Exception {
        int opcode = buf.readUnsignedByte();
        int length = buf.readInt();

        MessageCodec<?> codec = CodecLookupService.find(opcode);
        if (codec == null) {
            logger.warning("Unknown operation code: " + opcode + " (previous opcode: " + previousOpcode + ").");
            buf.readBytes(length);
        }

        previousOpcode = opcode;

        return codec.decode(buf);
    }

}
