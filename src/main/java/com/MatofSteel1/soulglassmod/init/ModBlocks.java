package com.MatofSteel1.soulglassmod.init;

import com.MatofSteel1.soulglassmod.block.BlockSoulGlass;
import com.MatofSteel1.soulglassmod.block.BlockSoulGlassMod;
import com.MatofSteel1.soulglassmod.block.BlockStackaBlock;
import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {
    public static final BlockSoulGlassMod BlockSoulGlass = new BlockSoulGlass();
    public static final BlockSoulGlassMod BlockStackaBlock = new BlockStackaBlock();

    public static void init() {
        GameRegistry.registerBlock(BlockSoulGlass, Names.Blocks.soulGlass);
        GameRegistry.registerBlock(BlockStackaBlock, Names.Blocks.stackaBlock);
    }
}
