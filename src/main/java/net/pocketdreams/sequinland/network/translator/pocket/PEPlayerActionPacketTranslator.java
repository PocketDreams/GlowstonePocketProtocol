package net.pocketdreams.sequinland.network.translator.pocket;

import com.flowpowered.network.Message;

import net.glowstone.net.message.play.player.ClientStatusMessage;
import net.pocketdreams.sequinland.network.PocketSession;
import net.pocketdreams.sequinland.network.protocol.packets.GamePacket;
import net.pocketdreams.sequinland.network.protocol.packets.PlayerActionPacket;
import net.pocketdreams.sequinland.network.translator.PEToPCTranslator;

public class PEPlayerActionPacketTranslator implements PEToPCTranslator<GamePacket> {
    @Override
    public Message[] translate(PocketSession session, GamePacket packet) {
        PlayerActionPacket pePacket = (PlayerActionPacket) packet;
        int val = -1;
        switch (pePacket.action) {
        case 7:
            val = 0;
            break;
        }
        if (val != -1) {
            ClientStatusMessage pkStatus = new ClientStatusMessage(val);
            return new Message[] { pkStatus };
        } else {
            return new Message[] {};
        }
    }
}
