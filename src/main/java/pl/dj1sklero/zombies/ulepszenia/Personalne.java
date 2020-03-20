package pl.dj1sklero.zombies.ulepszenia;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.dj1sklero.zombies.Zombies;

import java.util.ArrayList;

public class Personalne implements Listener {
    private Zombies plugin;


    public Personalne(Zombies plugin) {
        this.plugin = plugin;
    }



    @EventHandler
    public void skrzynia(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getClickedBlock().getType() == Material.CHEST) {
            Inventory inv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "ULEPSZENIA");


               ItemStack survival = new ItemStack(Material.DIAMOND_BLOCK);
               ItemMeta survivalMeta = survival.getItemMeta();
               ItemStack creative = new ItemStack(Material.REDSTONE_BLOCK);
               ItemMeta creativeMeta = creative.getItemMeta();

                survivalMeta.setDisplayName("Survival");

                ArrayList<String> lore = new ArrayList<>();
                lore.add("lore 1");
                lore.add("lore 2");
                lore.add("lore 3");
                survivalMeta.setLore(lore);
                survival.setItemMeta(survivalMeta);
                creativeMeta.setDisplayName("Creative");
                creative.setItemMeta(creativeMeta);

               inv.setItem(3, survival);
               inv.setItem(5, creative);



            e.getPlayer().openInventory(inv);
            }
        if (e.getItem().getType()==Material.STONE){
            e.getPlayer().sendMessage("test");
        }

    }






}
