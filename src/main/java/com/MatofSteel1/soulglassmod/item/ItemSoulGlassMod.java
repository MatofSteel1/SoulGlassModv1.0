package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.inventory.ItemInventory;
import com.MatofSteel1.soulglassmod.reference.Reference;
import com.MatofSteel1.soulglassmod.utility.InventoryUtils;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class ItemSoulGlassMod extends Item {

    public ItemSoulGlassMod() {
        super();
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }


    @SubscribeEvent
    public void onItemPickUp(EntityItemPickupEvent evt) {

        final EntityPlayer player = evt.entityPlayer;
        final ItemStack pickedStack = evt.item.getEntityItem();

        if (pickedStack == null || player == null) return;

        boolean foundMatchingContainer = false;

        for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
            ItemStack stack = player.inventory.getStackInSlot(i);

            if (stack != null &&  stack.getItem() == (this)) {
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
    }

    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
        stack.stackSize++;
        return true;
    }
}