package com.MatofSteel1.soulglassmod.handler;

import com.MatofSteel1.soulglassmod.block.TileEntitySoulForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ContainerSoulForge extends Container {

    private TileEntitySoulForge soulForge;

    /** The number of ticks that the furnace will keep burning */
    public int lastBurnTime;
    /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
    public int lastItemBurnTime;
    /** The number of ticks that the current item has been cooking for */
    public int lastCookTime;

    public ContainerSoulForge(InventoryPlayer inventory, TileEntitySoulForge tileEntity) {
        this.soulForge = tileEntity;

        this.addSlotToContainer(new Slot(tileEntity, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileEntity, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnace(inventory.player, tileEntity, 2, 116, 16));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18));
            }
        }

        for (int i = 0; i < 9 ; i++) {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142));
        }
    }

    @Override
    public void addCraftingToCrafters(ICrafting iCrafting) {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, this.soulForge.cookTime);
        iCrafting.sendProgressBarUpdate(this, 1, this.soulForge.burnTime);
        iCrafting.sendProgressBarUpdate(this, 2, this.soulForge.currentItemBurnTime);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.soulForge.cookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.soulForge.cookTime);
            }

            if (this.lastBurnTime != this.soulForge.burnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.soulForge.burnTime);
            }

            if (this.lastItemBurnTime != this.soulForge.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.soulForge.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.soulForge.cookTime;
        this.lastBurnTime = this.soulForge.burnTime;
        this.lastItemBurnTime = this.soulForge.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int newValue) {
        if (slot == 0) this.soulForge.cookTime = newValue;
        if (slot == 1) this.soulForge.burnTime = newValue;
        if (slot == 2) this.soulForge.currentItemBurnTime = newValue;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int clickedSlotNumber) {
        ItemStack itemStack = null;
        Slot slot = (Slot) this.inventorySlots.get(clickedSlotNumber);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (clickedSlotNumber == 2) {
                if (!this.mergeItemStack(itemStack1, 3, 39, true)) {
                    return null;
                }

                slot.onSlotChange(itemStack1, itemStack);

            } else if (clickedSlotNumber != 1 && clickedSlotNumber != 0) {
                if (itemStack1.getUnlocalizedName().equals(new ItemStack(Item.getItemFromBlock(Blocks.soul_sand)).getUnlocalizedName())) {
                    if (!this.mergeItemStack(itemStack1, 0, 1, false)) {
                        return null;
                    }
                } else if (TileEntitySoulForge.isItemFuel(itemStack1)) {
                    if (!this.mergeItemStack(itemStack1, 1, 2, false)) {
                        return null;
                    }
                } else if (clickedSlotNumber >= 3 && clickedSlotNumber < 30) {
                    if (!mergeItemStack(itemStack1, 30, 39, false)) {
                        return null;
                    }
                } else if (clickedSlotNumber >= 30 && clickedSlotNumber < 39) {
                    if (!mergeItemStack(itemStack1, 3, 30, false)) {
                        return null;
                    }
                }
            } else if (!mergeItemStack(itemStack1, 3, 38, false)) {
                return null;
            }

            if (itemStack1.stackSize == 0) {
                slot.putStack(null);
            }else {
                slot.onSlotChanged();
            }

            if (itemStack1.stackSize == itemStack.stackSize) {
                return null;
            }
            slot.onPickupFromSlot(entityPlayer, itemStack1);
        }
        return itemStack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.soulForge.isUseableByPlayer(entityPlayer);
    }
}
