package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ItemModArmor extends ItemArmor{


    public static ItemArmor.ArmorMaterial SOULPLATING = EnumHelper.addArmorMaterial("SOULPLATING", 240, new int[]{2, 6, 5, 2}, 15);
    public String textureName;

    public ItemModArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
        super(material, 0, type);
        this.textureName = textureName;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Reference.MOD_ID + ":" + unlocalizedName);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return Reference.MOD_ID + ":/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }
}
