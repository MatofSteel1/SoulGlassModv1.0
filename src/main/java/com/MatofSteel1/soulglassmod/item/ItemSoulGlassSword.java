package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.item.ItemSword;

public class ItemSoulGlassSword extends ItemSword {



    public ItemSoulGlassSword(ToolMaterial SOULSHARD) {
        super(SOULSHARD);
        this.setUnlocalizedName(Names.Items.soulGlassSword);
        this.setTextureName(Reference.MOD_ID + ":" + Names.Items.soulGlassSword);
        this.maxStackSize = 1;
    }
}
