package com.MatofSteel1.soulglassmod.init;

import com.MatofSteel1.soulglassmod.item.*;
import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
    public static final ItemGlassHelmet ITEM_GLASS_HELMET = new ItemGlassHelmet();
    public static final ItemGlassChestplate ITEM_GLASS_CHESTPLATE  = new ItemGlassChestplate();
    public static final ItemGlassLeggings ITEM_GLASS_LEGGINGS  = new ItemGlassLeggings();
    public static final ItemGlassBoots ITEM_GLASS_BOOTS = new ItemGlassBoots();
    public static final ItemSoulGlassPickaxe ITEM_SOUL_GLASS_PICKAXE = new ItemSoulGlassPickaxe(EnumHelper.addToolMaterial("SOULGLASS", 2, 1024, 10.0F, 2.0F, 0));
    public static final ItemSoulGlassShovel ITEM_SOUL_GLASS_SHOVEL = new ItemSoulGlassShovel(EnumHelper.addToolMaterial("SOULGLASS", 2, 1024, 10.0F, 2.0F, 0));
    public static final ItemSoulGlassSword ITEM_SOUL_GLASS_SWORD = new ItemSoulGlassSword(EnumHelper.addToolMaterial("SOULSHARD", 3, 700, 20.0F, -3.9F, 0));
    public static final ItemRefinedSoulEssence ITEM_REFINED_SOUL_ESSENCE = new ItemRefinedSoulEssence();
    public static final ItemSoulGlassShard ITEM_SOUL_GLASS_SHARD = new ItemSoulGlassShard();
    public static final ItemEternalFood ITEM_ETERNAL_FOOD = new ItemEternalFood();
    public static final ItemStackaBlockPlacer ITEM_STACKA_BLOCK_PLACER = new ItemStackaBlockPlacer();
    public static final ItemSoulEssence ITEM_SOUL_ESSENCE = new ItemSoulEssence();
    public static final ItemWithersGift ITEM_WITHERS_GIFT = new ItemWithersGift();

    public static void init() {
        GameRegistry.registerItem(ITEM_GLASS_HELMET, Names.Items.glassHelmet);
        GameRegistry.registerItem(ITEM_GLASS_CHESTPLATE, Names.Items.glassChestplate);
        GameRegistry.registerItem(ITEM_GLASS_LEGGINGS, Names.Items.glassLeggings);
        GameRegistry.registerItem(ITEM_GLASS_BOOTS, Names.Items.glassBoots);
        GameRegistry.registerItem(ITEM_SOUL_GLASS_PICKAXE, Names.Items.soulGlassPickaxe);
        GameRegistry.registerItem(ITEM_SOUL_GLASS_SHOVEL, Names.Items.soulGlassShovel);
        GameRegistry.registerItem(ITEM_SOUL_GLASS_SWORD, Names.Items.soulGlassSword);
        GameRegistry.registerItem(ITEM_REFINED_SOUL_ESSENCE, Names.Items.refinedSoulEssence);
        GameRegistry.registerItem(ITEM_SOUL_GLASS_SHARD, Names.Items.soulGlassShard);
        GameRegistry.registerItem(ITEM_ETERNAL_FOOD, Names.Items.eternalFood);
        GameRegistry.registerItem(ITEM_STACKA_BLOCK_PLACER, Names.Items.stackaBlockPlacer);
        GameRegistry.registerItem(ITEM_SOUL_ESSENCE, Names.Items.soulEssence);
        GameRegistry.registerItem(ITEM_WITHERS_GIFT, Names.Items.withersGift);
    }
}