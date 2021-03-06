package net.pocketdreams.sequinland.network.translator.pocket;

import com.flowpowered.network.Message;

import net.glowstone.GlowServer;
import net.glowstone.net.message.handshake.HandshakeMessage;
import net.glowstone.net.message.login.LoginStartMessage;
import net.pocketdreams.sequinland.network.PocketSession;
import net.pocketdreams.sequinland.network.protocol.packets.GamePacket;
import net.pocketdreams.sequinland.network.protocol.packets.LoginPacket;
import net.pocketdreams.sequinland.network.translator.PEToPCTranslator;

public class PELoginPacketTranslator implements PEToPCTranslator<GamePacket> {
    @Override
    public Message[] translate(PocketSession session, GamePacket packet) {
        LoginPacket pePacket = (LoginPacket) packet;
        HandshakeMessage handshake = new HandshakeMessage(GlowServer.PROTOCOL_VERSION, pePacket.serverAddress, 25565, 2); // 2 = PLAY
        LoginStartMessage login = new LoginStartMessage(pePacket.username);
        return new Message[] { handshake, login };
    }
}
