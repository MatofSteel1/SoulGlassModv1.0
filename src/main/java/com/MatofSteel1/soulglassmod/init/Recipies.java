package com.MatofSteel1.soulglassmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipies {
    public static void init(){
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEM_SOUL_GLASS_PICKAXE), "bbb", " s ", " s ", 's', new ItemStack(Items.stick), 'b', new ItemStack(ModBlocks.BlockSoulInfusedGlass));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockSoulInfusedGlass, 4), "ggg", "geg", "ggg", 'g', new ItemStack(Blocks.glass), 'e', new ItemStack(ModItems.ITEM_REFINED_SOUL_ESSENCE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockSoulInfusedGlass), "ss", "ss", 's', new ItemStack(ModItems.ITEM_SOUL_GLASS_SHARD));
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEM_SOUL_GLASS_SHOVEL), " b ", " s ", " s ", 'b', new ItemStack(ModBlocks.BlockSoulInfusedGlass), 's', new ItemStack(Items.stick));
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEM_SOUL_GLASS_SWORD), " b ", " b ", "<s<", 'b', new ItemStack(ModBlocks.BlockSoulInfusedGlass), 's', new ItemStack(Items.stick), '<', new ItemStack(ModItems.ITEM_SOUL_GLASS_SHARD));
        GameRegistry.addRecipe(new ItemStack(Blocks.soul_sand), "ee", "ee", 'e', new ItemStack(ModItems.ITEM_SOUL_ESSENCE));
        GameRegistry.addSmelting(Blocks.soul_sand, new ItemStack(ModItems.ITEM_REFINED_SOUL_ESSENCE), 5f);
    }
}