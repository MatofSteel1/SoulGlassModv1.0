package com.MatofSteel1.soulglassmod.init;

import com.MatofSteel1.soulglassmod.item.*;
import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static final ItemGlassChestplate ITEM_GLASS_CHESTPLATE  = new ItemGlassChestplate();
    public static final ItemRefinedSoulEssence ITEM_REFINED_SOUL_ESSENCE = new ItemRefinedSoulEssence();
    public static final ItemSoulGlassPickaxe ITEM_SOUL_GLASS_PICKAXE = new ItemSoulGlassPickaxe();
    public static final ItemSoulGlassShovel ITEM_SOUL_GLASS_SHOVEL = new ItemSoulGlassShovel();
    public static final ItemSoulGlassShard ITEM_SOUL_GLASS_SHARD = new ItemSoulGlassShard();

    public static void init(){
        GameRegistry.registerItem(ITEM_GLASS_CHESTPLATE, Names.Items.glassChestplate);
        GameRegistry.registerItem(ITEM_REFINED_SOUL_ESSENCE, Names.Items.refinedSoulEssence);
        GameRegistry.registerItem(ITEM_SOUL_GLASS_PICKAXE, Names.Items.soulGlassPickaxe);
        GameRegistry.registerItem(ITEM_SOUL_GLASS_SHOVEL, Names.Items.soulGlassShovel);
        GameRegistry.registerItem(ITEM_SOUL_GLASS_SHARD, Names.Items.soulGlassShard);
    }
}