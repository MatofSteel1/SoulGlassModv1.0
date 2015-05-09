package com.MatofSteel1.soulglassmod.MultiTexture;


import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MultitextureBlock extends Block {

    protected MultitextureBlock(String unlocalizedName, Material material)
    {
        super(material);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Reference.MOD_ID + ":" + unlocalizedName);
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
        this.setHardness(2.0F);
        this.setResistance(6.0F);
        this.setStepSound(soundTypeStone);
    }
}