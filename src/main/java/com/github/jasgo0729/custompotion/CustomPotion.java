package com.github.jasgo0729.custompotion;

import io.papermc.paper.potion.PotionMix;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public final class CustomPotion extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        addNauseaPotionRecipe();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void addNauseaPotionRecipe() {
        NamespacedKey key = new NamespacedKey(this, "custompotion");
        ItemStack potion = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setBasePotionType(PotionType.AWKWARD);
        meta.addCustomEffect(new PotionEffect(PotionEffectType.NAUSEA, 1200, 1), true);
        meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOWNESS, 1200, 1), true);
        meta.addCustomEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 1200, 1), true);
        meta.setColor(Color.OLIVE);
        potion.setItemMeta(meta);

        PotionMix recipe = new PotionMix(key, potion, new RecipeChoice.ExactChoice(new ItemStack(Material.POTION)), new RecipeChoice.ExactChoice(new ItemStack(Material.POPPY)));
        Bukkit.getPotionBrewer().addPotionMix(recipe);
    }
}