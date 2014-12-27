package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.item.ItemPickaxe;

public class ItemSoulGlassPickaxe extends ItemPickaxe{
    public ItemSoulGlassPickaxe(ToolMaterial SOULGLASS) {
        super(SOULGLASS);
        this.setUnlocalizedName(Names.Items.soulGlassPickaxe);
        this.setTextureName(Reference.MOD_ID + ":" + Names.Items.soulGlassPickaxe);
        this.maxStackSize = 1;
    }
}
