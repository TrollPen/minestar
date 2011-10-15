package net.minestar.net.handler;

import net.minestar.entity.Player;
import net.minestar.msg.Message;
import net.minestar.net.Session;

// mport net.minestar.entity.GlowPlayer;
//import net.minestar.net.Session;

public abstract class MessageHandler<T extends Message> {

    public abstract void handle(Session session, Player player, T message);

}
