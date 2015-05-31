package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.init.ModItems;
import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

public class ItemSoulEssence extends ItemSoulGlassMod {

    public ItemSoulEssence() {
        super();
        this.setTextureName(Names.Items.soulEssence).setUnlocalizedName(Names.Items.soulEssence);
    }
}
