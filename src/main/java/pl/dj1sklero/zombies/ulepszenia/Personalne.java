package pl.dj1sklero.zombies.ulepszenia;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.dj1sklero.zombies.Zombies;

public class Personalne {
    private Zombies plugin;

    public Personalne(Zombies plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void skrzynia(PlayerInteractEvent e, Player player){
    if (e.getAction() != Action.RIGHT_CLICK_BLOCK || e.getClickedBlock().getType() != Material.CHEST)
        Inventory inv = Bukkit.createInventory(null, 9, "ULEPSZENIA");

        ItemStack survival = new ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta survivalMeta = survival.getItemMeta();
        ItemStack creative = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta creativeMeta = creative.getItemMeta();

        survivalMeta.setDisplayName("Survival");
        survival.setItemMeta(survivalMeta);
        creativeMeta.setDisplayName("Creative");
        creative.setItemMeta(creativeMeta);

        inv.setItem(3, survival);
        inv.setItem(5, creative);

    player.openInvectory(inv)
    }





}
