package com.MatofSteel1.soulglassmod.init;

import com.MatofSteel1.soulglassmod.block.*;
import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.common.registry.FMLControlledNamespacedRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
    public static final BlockOreMod BlockSoulInfusedGlass = new BlockSoulInfusedGlass();
    public static final BlockSoulGlassMod BlockStackaBlock = new BlockStackaBlock();
    public static final BlockMulti_Texture BlockSoulForge = new BlockSoulForge();
    public static final BlockSoulSand BlockSoulSand = new BlockSoulSand();
    //TODO HarvestDropsEvent

    public static void init() {
        GameRegistry.registerBlock(BlockSoulInfusedGlass, Names.Blocks.soulGlass);
        GameRegistry.registerBlock(BlockStackaBlock, Names.Blocks.stackaBlock);
        GameRegistry.registerBlock(BlockSoulForge, Names.Blocks.soulForge);
        GameRegistry.registerBlock(BlockSoulSand, Names.Blocks.soulSand);
        //GameRegistry.addSubstitutionAlias("Soul Sand", GameRegistry.Type.BLOCK, new BlockSoulSand());
    }
}
