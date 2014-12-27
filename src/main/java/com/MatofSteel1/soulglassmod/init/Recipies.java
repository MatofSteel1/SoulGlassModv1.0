package com.MatofSteel1.soulglassmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipies {
    public static void init(){
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEM_SOUL_GLASS_PICKAXE), "bbb", " s ", " s ", 's', new ItemStack(Items.stick), 'b', new ItemStack(ModBlocks.BlockSoulGlass));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockSoulGlass, 4), "ggg", "geg", "ggg", 'g', new ItemStack(Blocks.glass), 'e', new ItemStack(ModItems.ITEM_REFINED_SOUL_ESSENCE));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockSoulGlass), "ss", "ss", 's', new ItemStack(ModItems.ITEM_SOUL_GLASS_SHARD));
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEM_SOUL_GLASS_SHOVEL), " b ", " s ", " s ", 'b', new ItemStack(ModBlocks.BlockSoulGlass), 's', new ItemStack(Items.stick));
        GameRegistry.addRecipe(new ItemStack(ModItems.ITEM_SOUL_GLASS_SWORD), " b ", " b ", "<s<", 'b', new ItemStack(ModBlocks.BlockSoulGlass), 's', new ItemStack(Items.stick), '<', new ItemStack(ModItems.ITEM_SOUL_GLASS_SHARD));
    }
}