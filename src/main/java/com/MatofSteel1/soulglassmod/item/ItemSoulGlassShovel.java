package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class ItemSoulGlassShovel extends ItemSpade {
    public ItemSoulGlassShovel(Item.ToolMaterial SOULGLASS) {
        super(SOULGLASS);
        this.setUnlocalizedName(Names.Items.soulGlassShovel);
        this.setTextureName(Reference.MOD_ID + ":" + Names.Items.soulGlassShovel);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
    }
}
