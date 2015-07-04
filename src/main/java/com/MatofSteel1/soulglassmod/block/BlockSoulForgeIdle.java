package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Names;

public class BlockSoulForgeIdle extends BlockSoulForge {

    public BlockSoulForgeIdle(){
        super(false);
        this.setBlockName(Names.Blocks.soulForgeIdle).setBlockTextureName(Names.Blocks.soulForgeIdle).setHardness(3.5F);
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
    }
}
