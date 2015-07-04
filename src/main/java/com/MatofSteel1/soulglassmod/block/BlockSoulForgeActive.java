package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Names;

public class BlockSoulForgeActive extends BlockSoulForge {

    public BlockSoulForgeActive() {
        super(true);
        this.setBlockName(Names.Blocks.soulForgeActive).setBlockTextureName(Names.Blocks.soulForgeActive).setHardness(3.5F);
        this.setLightLevel(0.9F).setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB).setLightLevel(0.9f);
    }
}
