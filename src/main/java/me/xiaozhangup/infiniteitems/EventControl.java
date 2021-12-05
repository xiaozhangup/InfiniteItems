package me.xiaozhangup.infiniteitems;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventControl implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        ItemStack itemStack = e.getItemInHand();
        if (itemStack.getItemMeta().getCustomModelData() != 87346) return;
        e.getPlayer().setItemInHand(itemStack);
    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("inf.item.pickup")) {
            ItemStack itemStack = e.getItem().getItemStack();
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setCustomModelData(87346);
            itemStack.setItemMeta(itemMeta);
            e.getItem().setItemStack(itemStack);
        }
    }

}
