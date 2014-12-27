package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemGlassChestplate extends ItemArmor {

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return Reference.MOD_ID + ":armor/" + this.textureName
                //+ "_" + (this.armorType == 2 ? "2" : "1")
                + ".png";
    }

    public String textureName;

    public ItemGlassChestplate(ArmorMaterial SOULPLATING){
        super(SOULPLATING, 0, 1);
        this.setUnlocalizedName(Names.Items.glassChestplate);
        this.setTextureName(Reference.MOD_ID + ":" + Names.Items.glassChestplate);
        this.textureName = "SOULPLATING";
        this.maxStackSize = 1;
        this.setMaxDamage(100);
    }
}
