package com.MatofSteel1.soulglassmod.creativetab;

import com.MatofSteel1.soulglassmod.init.ModItems;
import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabSGM {
public static final CreativeTabs SoulGlassMod_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
    @Override
    public Item getTabIconItem() {
        return ModItems.ITEM_REFINED_SOUL_ESSENCE;
        }
    };
}