package com.wan.minecraft.springBowel.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;

public class ItemInfo extends CommandBase {
    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/info";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayer player = null;
        if (sender.getCommandSenderEntity() instanceof EntityPlayer) {
            player = (EntityPlayer) sender.getCommandSenderEntity();
        } else {
            return;
        }
        Item item = player.getHeldItem(EnumHand.MAIN_HAND).getItem();
        String registerName = item.getRegistryName().toString();
        String transName = item.getRegistryName().toString();
        player.sendMessage(new TextComponentString("该物品信息如下："));
        player.sendMessage(new TextComponentString("注册名：" + registerName));
        player.sendMessage(new TextComponentString("本地化名：" + transName));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
