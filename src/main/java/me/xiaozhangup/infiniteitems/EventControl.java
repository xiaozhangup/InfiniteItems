package me.xiaozhangup.infiniteitems;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
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
        if (!itemStack.getItemMeta().hasCustomModelData()) return;
        if (itemStack.getItemMeta().getCustomModelData() != 87346) return;
        e.getPlayer().setItemInHand(itemStack);
    }

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent e) {
        if (!e.getPlayer().hasPermission("inf.item.pickup")) return;
        ItemStack itemStack = e.getPlayer().getItemInHand();
        if (!itemStack.getItemMeta().hasCustomModelData()) return;
        if (itemStack.getItemMeta().getCustomModelData() != 87346) return;
        e.getPlayer().setItemInHand(itemStack);
    }

    @EventHandler
    public void onPlayerUse(PlayerItemDamageEvent e) {
        if (!e.getPlayer().hasPermission("inf.item.pickup")) return;
        ItemStack itemStack = e.getPlayer().getItemInHand();
        if (!itemStack.getItemMeta().hasCustomModelData()) return;
        if (itemStack.getItemMeta().getCustomModelData() != 87346) return;
        e.getPlayer().setItemInHand(itemStack);
    }




    //This model is item translate
    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (p.hasPermission("inf.item.pickup")) {
            ItemStack itemStack = e.getItem().getItemStack();
            itemStack.addUnsafeEnchantment(Enchantment.ARROW_INFINITE , 1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setCustomModelData(87346);
            itemStack.setItemMeta(itemMeta);
            e.getItem().setItemStack(itemStack);
        }
    }

}
