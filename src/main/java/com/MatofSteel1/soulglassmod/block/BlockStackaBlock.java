package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.item.ItemSoulGlassMod;
import com.MatofSteel1.soulglassmod.item.ItemSoulGlassShard;
import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;


public class BlockStackaBlock extends BlockSoulGlassMod {

    public BlockStackaBlock() {
        super();
        this.setBlockName(Names.Blocks.stackaBlock).setBlockTextureName(Names.Blocks.stackaBlock).setHardness(0f).setResistance(0f).setStepSound(soundTypeStone).isToolEffective("Fist", 0);
        //TODO make like a creative type block
    }

    /*BlockEvent.PlaceEvent
    placeEvent() {
        return ;
    }*/
}
