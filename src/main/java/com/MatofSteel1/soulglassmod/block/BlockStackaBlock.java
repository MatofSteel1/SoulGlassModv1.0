package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.init.ModBlocks;
import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class BlockStackaBlock extends BlockSoulGlassMod {

    public BlockStackaBlock() {
        super();
        this.setBlockName(Names.Blocks.stackaBlock).setBlockTextureName(Names.Blocks.stackaBlock).setHardness(0f).setResistance(0f).setStepSound(soundTypeStone).isToolEffective("Fist", 0);
        //TODO make like a creative type block
    }

    public static void onUpdate(EntityPlayer player) {
        if (player.getCurrentEquippedItem() != null) {
            String item = player.getCurrentEquippedItem().toString();
            String check = new ItemStack(ModBlocks.BlockStackaBlock).toString();
            if (item.equals(check)) {
                player.capabilities.allowEdit = true;
            }
        }
    }
}
