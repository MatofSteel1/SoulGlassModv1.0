package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.block.material.Material;

public class BlockSoulForge extends BlockMulti_Texture {
    public BlockSoulForge() {
        super(Material.rock);
        this.setBlockName(Names.Blocks.soulForge);
        //TODO make multi textured and a tile entity
    }
}
