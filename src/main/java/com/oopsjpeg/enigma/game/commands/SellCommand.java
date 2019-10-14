package com.oopsjpeg.enigma.game.commands;

import com.oopsjpeg.enigma.Enigma;
import com.oopsjpeg.enigma.game.Game;
import com.oopsjpeg.enigma.game.obj.Item;
import com.oopsjpeg.enigma.util.Command;
import com.oopsjpeg.enigma.util.Util;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.MessageChannel;
import discord4j.core.object.entity.User;

public class SellCommand implements Command {
    @Override
    public void execute(Message message, String alias, String[] args) {
        User author = message.getAuthor().orElse(null);
        MessageChannel channel = message.getChannel().block();
        Game game = Enigma.getInstance().getPlayer(author).getGame();
        Game.Member member = game.getMember(author);

        if (channel.equals(game.getChannel()) && member.equals(game.getCurrentMember())) {
            message.delete().block();
            if (game.getGameState() == 0)
                Util.sendFailure(channel, "You cannot sell items until the game has started.");
            else {
                Item item = Item.fromName(String.join(" ", args));
                if (item == null)
                    Util.sendFailure(channel, "Invalid item.");
                else if (!member.getData().contains(item))
                    Util.sendFailure(channel, "You don't have a(n) **" + item.getName() + "**.");
                else
                    member.act(game.new SellAction(item));
            }
        }
    }

    @Override
    public String getName() {
        return "sell";
    }
}
