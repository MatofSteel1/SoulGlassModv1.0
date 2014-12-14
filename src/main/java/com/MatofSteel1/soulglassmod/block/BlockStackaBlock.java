package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.inventory.ItemInventory;
import com.MatofSteel1.soulglassmod.inventory.PlayerItemInventory;
import com.MatofSteel1.soulglassmod.item.ItemSoulGlassMod;
import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.utility.InventoryUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import java.util.Random;


public class BlockStackaBlock extends BlockSoulGlassMod {
    public BlockStackaBlock(){
        super();
        this.setBlockName(Names.Blocks.stackaBlock).setBlockTextureName(Names.Blocks.stackaBlock).setHardness(0f).setResistance(0f).setStepSound(soundTypeStone).isToolEffective("Fist", 0);


        boolean slotTaken = false;
        for(int i = 0; i < 44; i++)
        {
            if (this.getItemIconName() == "BlockStackaBlock") {
                if (slotTaken) {
                    if (this.getItemIconName() == null) {
                    }
                } else {
                    slotTaken = true;
                }
            }
        }
    }


    /*@SubscribeEvent
    public void onItemPickUp(EntityItemPickupEvent evt) {

        final EntityPlayer player = evt.entityPlayer;
        final ItemStack pickedStack = evt.item.getEntityItem();

        if (pickedStack == null || player == null) return;

        boolean foundMatchingContainer = false;

        for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
            ItemStack stack = player.inventory.getStackInSlot(i);

            if (stack != null &&  stack.getItem() == Item.getItemFromBlock(this)) {
                ItemInventory inventory = new ItemInventory(stack, 1);
                ItemStack containedStack = inventory.getStackInSlot(0);
                if (containedStack != null) {
                    boolean isMatching = InventoryUtils.areItemAndTagEqual(pickedStack, containedStack);
                    if (isMatching) {
                        foundMatchingContainer = true;
                        InventoryUtils.tryInsertStack(inventory, 0, pickedStack, true);
                    }
                }
            }
        }

        if (foundMatchingContainer) pickedStack.stackSize = 0;
    }*/

    @Override
    public int quantityDropped(Random random) {
    return random.nextInt(4) + 1;
    }
}
