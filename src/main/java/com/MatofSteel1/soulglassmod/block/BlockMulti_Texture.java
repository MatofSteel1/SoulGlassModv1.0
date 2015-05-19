package com.MatofSteel1.soulglassmod.block;


import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockMulti_Texture extends Block {

    protected BlockMulti_Texture(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
        this.setHardness(2.0F);
        this.setResistance(6.0F);
        this.setStepSound(soundTypeStone);
    }

    public IIcon[] icons = new IIcon[6];

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        for (int i = 0; i < 6; i ++) {
            this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }
}