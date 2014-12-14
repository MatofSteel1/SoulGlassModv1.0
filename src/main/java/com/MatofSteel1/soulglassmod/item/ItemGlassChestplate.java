package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.reference.Names;

public class ItemGlassChestplate extends ItemSoulGlassMod {

    public ItemGlassChestplate(){
        super();
        this.setUnlocalizedName(Names.Items.glassChestplate);
        this.maxStackSize = 1;
        this.setMaxDamage(100);
    }
}
