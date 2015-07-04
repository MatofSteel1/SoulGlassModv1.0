package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStackaBlockPlacer extends ItemSoulGlassMod {

    public ItemStackaBlockPlacer() {
        super();
        this.setTextureName(Names.Items.stackaBlockPlacer).setUnlocalizedName(Names.Items.stackaBlockPlacer);
    }

    //TODO make item place stackablock where looking
    @Override
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
        return super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata);
    }
}
