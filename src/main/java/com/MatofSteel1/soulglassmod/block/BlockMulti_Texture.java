package com.MatofSteel1.soulglassmod.block;


import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockMulti_Texture extends Block {

    protected BlockMulti_Texture(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
        this.setHardness(2.0F);
        this.setResistance(6.0F);
        this.setStepSound(soundTypeStone);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }


    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}