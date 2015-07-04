package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.init.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySoulForge extends TileEntity implements ISidedInventory{

    private String localizedName;

    private static final int[] slots_top = new int[]{0};
    private static final int[] slots_bottom = new int[]{2, 1};
    private static final int[] slots_sides = new int[]{1};

    private ItemStack[] slots = new ItemStack[3];

    public int furnaceSpeed = 300;
    /** The number of ticks that the furnace will keep burning */
    public int burnTime;
    /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
    public int currentItemBurnTime;
    /** The number of ticks that the current item has been cooking for */
    public int cookTime;

    public int getSizeInventory() {
        return this.slots.length;
    }

    public String NBT;

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.slots[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.slots[i] != null) {
            ItemStack itemStack;

            if (this.slots[i].stackSize <= j) {
                itemStack = this.slots[i];
                this.slots[i] = null;
                return itemStack;
            }else {
                itemStack = this.slots[i].splitStack(j);

                if (this.slots[i].stackSize == 0) {
                    this.slots[i] = null;
                }

                return itemStack;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.slots[i] != null) {
            ItemStack itemStack = this.slots[i];
            this.slots[i] = null;
            return itemStack;
        }

        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.slots[i] = itemStack;

        if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName() {
        return "Soul Forge";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return this.NBT != null && this.NBT.length() > 0;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    private boolean canSmelt()
    {
        if (this.slots[0] == null)
        {
            return false;
        }else {
            ItemStack soulSand = new ItemStack(Item.getItemFromBlock(Blocks.soul_sand));
            ItemStack itemstack = this.slots[0];

            if (itemstack.getItem() == soulSand.getItem()) return true;
            if (this.slots[2] == null) return true;
            if (!this.slots[2].isItemEqual(itemstack)) return false;
            int result = slots[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.slots[2].getMaxStackSize();
        }
    }

    public boolean isBurning()
    {
        return this.burnTime > 0;
    }

    @Override
    public void updateEntity()
    {
        boolean flag = this.burnTime > 0;
        boolean flag1 = false;

        if (this.burnTime > 0)
        {
            this.burnTime--;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.burnTime != 0 || this.slots[1] != null && this.slots[0] != null)
            {
                if (this.burnTime == 0 && this.canSmelt())
                {
                    this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);

                    if (this.burnTime > 0)
                    {
                        flag1 = true;

                        if (this.slots[1] != null)
                        {
                            this.slots[1].stackSize--;

                            if (this.slots[1].stackSize == 0)
                            {
                                this.slots[1] = slots[1].getItem().getContainerItem(slots[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.cookTime;

                    if (this.cookTime == 200)
                    {
                        this.cookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.cookTime = 0;
                }
            }

            if (flag != this.burnTime > 0)
            {
                flag1 = true;
                BlockSoulForge.updateSoulForgeBlockState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    public void smeltItem()
    {
        if (FurnaceRecipes.smelting().getSmeltingResult(slots[0]).getItem() == ModItems.ITEM_REFINED_SOUL_ESSENCE && this.canSmelt()) {

            ItemStack itemstack = new ItemStack(ModItems.ITEM_REFINED_SOUL_ESSENCE);

            if (this.slots[2] == null) {
                this.slots[2] = itemstack.copy();
            } else if (this.slots[2].getItem() == itemstack.getItem()) {
                this.slots[2].stackSize += itemstack.stackSize;
            }

            this.slots[0].stackSize--;

            if (this.slots[0].stackSize <= 0) {
                this.slots[0] = null;

            }
        }
    }

    public static int getItemBurnTime(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        } else {
            Item item = itemStack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 18;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 37;
                }

                if (block == Blocks.coal_block)
                {
                    return 2000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 25;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 25;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 25;
            if (item == Items.stick) return 50;
            if (item == Items.coal) return 200;
            if (item == Items.lava_bucket) return 2500;
            if (item == Items.blaze_rod) return 300;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 50;
            return GameRegistry.getFuelValue(itemStack) / 8;
        }
    }

    public static boolean isItemFuel(ItemStack itemStack) {
        return getItemBurnTime(itemStack) > 0;
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return p_94041_1_ != 2 && (p_94041_1_ == 1 ? isItemFuel(p_94041_2_) : true);
    }

    public String getInvName() {
        return this.isInvNameLocalized() ? this.localizedName : "Soul Forge";
    }

    public boolean isInvNameLocalized() {
        return this.localizedName != null && this.localizedName.length() > 0;
    }

    public void setGuiDisplayName(String displayName) {
        this.localizedName = displayName;

    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return p_94128_1_ == 0 ? slots_bottom : (p_94128_1_ == 1 ? slots_top : slots_sides);
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return p_102008_3_ != 0 || p_102008_1_ != 1 || p_102008_2_.getItem() == Item.getItemById(325);
    }

    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int p_145953_1_)
    {
        return this.cookTime * p_145953_1_ / 200;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int p_145955_1_)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.burnTime * p_145955_1_ / this.currentItemBurnTime;
    }

    @Override
    public void readFromNBT(NBTTagCompound NBT)
    {
        super.readFromNBT(NBT);
        NBTTagList nbttaglist = NBT.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.slots.length)
            {
                this.slots[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.burnTime = NBT.getShort("BurnTime");
        this.cookTime = NBT.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.slots[1]);

        if (NBT.hasKey("CustomName", 8))
        {
            this.NBT = NBT.getString("CustomName");
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound NBT)
    {
        super.writeToNBT(NBT);
        NBT.setShort("BurnTime", (short) this.burnTime);
        NBT.setShort("CookTime", (short) this.cookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.slots.length; ++i)
        {
            if (this.slots[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.slots[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        NBT.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            NBT.setString("CustomName", this.NBT);
        }
    }


}