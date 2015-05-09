package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Random;

public class BlockOreMod extends Block {
    private Item drop;
    private int meta;
    private int least_quantity;
    private int most_quantity;

    protected BlockOreMod(String unlocalizedName, Material mat, Item drop, int meta, int least_quantity, int most_quantity) {
        super(mat);
        this.drop = drop;
        this.meta = meta;
        this.least_quantity = least_quantity;
        this.most_quantity = most_quantity;
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(Reference.MOD_ID + ":" + unlocalizedName);
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
        this.setStepSound(soundTypeStone);
        this.setHardness(10.0f);
        this.setResistance(20.0f);
        this.setHarvestLevel("pickaxe", 2);
    }

    protected BlockOreMod(String unlocalizedName, Material mat, Item drop, int least_quantity, int most_quantity) {
        this(unlocalizedName, mat, drop, 0, least_quantity, most_quantity);
    }

    protected BlockOreMod(String unlocalizedName, Material mat, Item drop) {
        this(unlocalizedName, mat, drop, 1, 1);
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return this.drop;
    }

    @Override
    public int damageDropped(int metadata) {
        return this.meta;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        if (this.least_quantity >= this.most_quantity)
            return this.least_quantity;
        return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
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
