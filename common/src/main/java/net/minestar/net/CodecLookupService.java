package net.minestar.net;

import java.util.HashMap;
import java.util.Map;

import net.minestar.msg.Message;
import net.minestar.net.codec.*;

/**
 * A class used to lookup message codecs.
 * @author Graham Edgecombe
 */
public final class CodecLookupService {

    /**
     * A table which maps opcodes to codecs. This is generally used to map
     * incoming packets to a codec.
     */
    private static MessageCodec<?>[] opcodeTable = new MessageCodec<?>[256];

    /**
     * A table which maps messages to codecs. This is generally used to map
     * outgoing packets to a codec.
     */
    private static Map<Class<? extends Message>, MessageCodec<?>> classTable = new HashMap<Class<? extends Message>, MessageCodec<?>>();

    /**
     * Populates the opcode and class tables with codecs.
     */
    static {
        try {
            
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Binds a codec by adding entries for it to the tables.
     * @param clazz The codec's class.
     * @param <T> The type of message.
     * @param <C> The type of codec.
     * @throws InstantiationException if the codec could not be instantiated.
     * @throws IllegalAccessException if the codec could not be instantiated due
     * to an access violation.
     */
    private static <T extends Message, C extends MessageCodec<T>> void bind(Class<C> clazz) throws InstantiationException, IllegalAccessException {
        MessageCodec<T> codec = clazz.newInstance();

        opcodeTable[codec.getOpcode()] = codec;
        classTable.put(codec.getType(), codec);
    }

    /**
     * Finds a codec by opcode.
     * @param opcode The opcode.
     * @return The codec, or {@code null} if it could not be found.
     */
    public static MessageCodec<?> find(int opcode) {
        return opcodeTable[opcode];
    }

    /**
     * Finds a codec by message class.
     * @param clazz The message class.
     * @param <T> The type of message.
     * @return The codec, or {@code null} if it could not be found.
     */
    @SuppressWarnings("unchecked")
    public static <T extends Message> MessageCodec<T> find(Class<T> clazz) {
        return (MessageCodec<T>) classTable.get(clazz);
    }

    /**
     * Default private constructor to prevent insantiation.
     */
    private CodecLookupService() {

    }

}
