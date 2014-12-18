package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class BlockSoulGlassMod extends Block {

    public BlockSoulGlassMod(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
    }

    public BlockSoulGlassMod() {
        this(Material.rock);
    }

    private ItemStack itemDropped;
    private int quantityDropped;

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }
    public void setItemDroppedAndQuantity(ItemStack par1ItemStack,int par2){
        this.itemDropped = par1ItemStack;
        this.quantityDropped = par2;
    }

    //public int idDropped(int par1, Random par2Random, int par3) {
      //  return this.itemDropped != null ? this.itemDropped.getItem() : this.getItemDropped();
    //}
    public int quantityDropped(Random par1Random){
        return this.quantityDropped;
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}