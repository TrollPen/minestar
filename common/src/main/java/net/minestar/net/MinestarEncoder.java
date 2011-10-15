package net.minestar.net;

import java.io.IOException;

import net.minestar.msg.Message;
import net.minestar.net.codec.MessageCodec;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

/**
 * A {@link OneToOneEncoder} which encodes Minecraft {@link Message}s into
 * {@link ChannelBuffer}s.
 */
public class MinestarEncoder extends OneToOneEncoder {

    @SuppressWarnings("unchecked")
    @Override
    protected Object encode(ChannelHandlerContext ctx, Channel c, Object msg) throws Exception {
        if (msg instanceof Message) {
            Message message = (Message) msg;

            Class<? extends Message> clazz = message.getClass();
            MessageCodec<Message> codec = (MessageCodec<Message>) CodecLookupService.find(clazz);
            if (codec == null) {
                throw new IOException("Unknown message type: " + clazz + ".");
            }

            ChannelBuffer opcodeBuf = ChannelBuffers.buffer(3);
            opcodeBuf.writeByte(codec.getOpcode());
            
            
            ChannelBuffer codecBuf = codec.encode(message);
            opcodeBuf.writeInt(codecBuf.capacity());

            return ChannelBuffers.wrappedBuffer(opcodeBuf, codecBuf);
        }
        return msg;
    }

}
