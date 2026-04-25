package com.github.jasgo0729.custompotion;

import io.papermc.paper.potion.PotionMix;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
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
        addSplashNauseaPotionRecipe();
        addLingeringNauseaPotionRecipe();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ItemStack nauseaPotion() {
        ItemStack resultPotion = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) resultPotion.getItemMeta();

        if (meta != null) {
            meta.setBasePotionType(PotionType.AWKWARD);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.NAUSEA, 1200, 1), true);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOWNESS, 1200, 1), true);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 1200, 1), true);
            meta.setColor(Color.OLIVE);
            meta.displayName(net.kyori.adventure.text.Component.text("기분이 좋아지는 무언가"));
            meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            resultPotion.setItemMeta(meta);
        }

        return resultPotion;
    }

    public void addNauseaPotionRecipe() {
        NamespacedKey key = new NamespacedKey(this, "nausea_potion");

        ItemStack resultPotion = nauseaPotion();

        RecipeChoice inputChoice = new RecipeChoice.MaterialChoice(Material.POTION);
        RecipeChoice ingredientChoice = new RecipeChoice.MaterialChoice(Material.POPPY);

        PotionMix recipe = new PotionMix(key, resultPotion, inputChoice, ingredientChoice);
        Bukkit.getPotionBrewer().addPotionMix(recipe);
    }

    public void addSplashNauseaPotionRecipe() {
        NamespacedKey key = new NamespacedKey(this, "splash_nausea_potion");

        ItemStack resultPotion = new ItemStack(Material.SPLASH_POTION);
        PotionMeta meta = (PotionMeta) resultPotion.getItemMeta();

        if (meta != null) {
            meta.setBasePotionType(PotionType.AWKWARD);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.NAUSEA, 1200, 1), true);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOWNESS, 1200, 1), true);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 1200, 1), true);
            meta.setColor(Color.OLIVE);
            meta.displayName(net.kyori.adventure.text.Component.text("투척용 기분이 좋아지는 무언가"));
            meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            resultPotion.setItemMeta(meta);
        }

        RecipeChoice inputChoice = new RecipeChoice.ExactChoice(nauseaPotion());
        RecipeChoice ingredientChoice = new RecipeChoice.MaterialChoice(Material.GUNPOWDER);

        PotionMix recipe = new PotionMix(key, resultPotion, inputChoice, ingredientChoice);
        Bukkit.getPotionBrewer().addPotionMix(recipe);
    }

    public void addLingeringNauseaPotionRecipe() {
        NamespacedKey key = new NamespacedKey(this, "lingering_nausea_potion");

        ItemStack resultPotion = new ItemStack(Material.LINGERING_POTION);
        PotionMeta meta = (PotionMeta) resultPotion.getItemMeta();

        if (meta != null) {
            meta.setBasePotionType(PotionType.AWKWARD);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.NAUSEA, 1200, 1), true);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOWNESS, 1200, 1), true);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 1200, 1), true);
            meta.setColor(Color.OLIVE);
            meta.displayName(net.kyori.adventure.text.Component.text("잔류형 기분이 좋아지는 무언가"));
            meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            resultPotion.setItemMeta(meta);
        }

        RecipeChoice inputChoice = new RecipeChoice.ExactChoice(nauseaPotion());
        RecipeChoice ingredientChoice = new RecipeChoice.MaterialChoice(Material.DRAGON_BREATH);

        PotionMix recipe = new PotionMix(key, resultPotion, inputChoice, ingredientChoice);
        Bukkit.getPotionBrewer().addPotionMix(recipe);
    }
}