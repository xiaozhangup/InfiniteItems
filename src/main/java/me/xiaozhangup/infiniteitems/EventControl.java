package me.xiaozhangup.infiniteitems;

import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventControl implements Listener {

    //event pass
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (!e.getPlayer().hasPermission("inf.item.pickup")) return;
        ItemStack itemStack = e.getItemInHand();
        e.getPlayer().setItemInHand(itemStack);
    }

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent e) {
        if (!e.getPlayer().hasPermission("inf.item.pickup")) return;
        ItemStack itemStack = e.getPlayer().getItemInHand();
        e.getPlayer().setItemInHand(itemStack);
    }

    @EventHandler
    public void onPlayerUse(PlayerItemDamageEvent e) {
        if (!e.getPlayer().hasPermission("inf.item.pickup")) return;
        ItemStack itemStack = e.getPlayer().getItemInHand();
        e.getPlayer().setItemInHand(itemStack);
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (!e.getPlayer().hasPermission("inf.item.pickup")) return;
        ItemStack itemStack = e.getItemDrop().getItemStack();
        e.setCancelled(true);
        p.getWorld().dropItemNaturally(p.getLocation() , itemStack);
    }




    //This model is item translate
    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        ItemStack itemStack = e.getItem().getItemStack();
        if (p.hasPermission("inf.item.pickup")) {
            if (itemStack.getItemMeta().hasDisplayName()) return;
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setCustomModelData(87346);
            itemStack.setItemMeta(itemMeta);
            e.getItem().setItemStack(itemStack);
        } else {
            if ( itemStack.getItemMeta().hasCustomModelData() && itemStack.getItemMeta().getCustomModelData() == 87346) {
                ItemMeta itemMeta = itemStack.getItemMeta();
                itemMeta.setCustomModelData(null);
                itemStack.setItemMeta(itemMeta);
                e.getItem().setItemStack(itemStack);

            }
        }
    }

}
