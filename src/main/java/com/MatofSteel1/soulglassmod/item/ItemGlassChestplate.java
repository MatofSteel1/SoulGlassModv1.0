package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemGlassChestplate extends ItemArmor {

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return Reference.MOD_ID + ":armor/" + this.textureName
                //+ "_" + (this.armorType == 2 ? "2" : "1")
                + ".png";
    }

    public void registerBlockIcons(IIconRegister reg) {
        for (int i = 0; i < 6; i ++) {
            this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
        }
    }

    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }

    public String textureName;
    public IIcon[] icons = new IIcon[6];

    public ItemGlassChestplate(ArmorMaterial SOULPLATING){
        super(SOULPLATING, 0, 1);
        this.setUnlocalizedName(Names.Items.glassChestplate);
        this.setTextureName(Reference.MOD_ID + ":" + Names.Items.glassChestplate);
        this.textureName = "SOULPLATING";
        this.maxStackSize = 1;
        this.setMaxDamage(100);
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
    }
}
