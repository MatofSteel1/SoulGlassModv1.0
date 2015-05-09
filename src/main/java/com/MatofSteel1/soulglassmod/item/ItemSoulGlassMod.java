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
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class ItemSoulGlassMod extends Item{
    public ItemSoulGlassMod() {
        super();
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
    }

    public static ToolMaterial SOULGLASS = EnumHelper.addToolMaterial("SOULGLASS", 2, 1024, 10.0F, 2.0F, 0);
    public static ToolMaterial SOULSHARD = EnumHelper.addToolMaterial("SOULSHARD", 3, 700, 20.0F, -3.9F, 22);
    public static ItemArmor.ArmorMaterial SOULPLATING = EnumHelper.addArmorMaterial("SOULPLATING", 240, new int[]{2, 6, 5, 2}, 15);
    public static ItemArmor.ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("TUTORIAL", 16, new int[] {3, 8, 6, 3}, 30);

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

    public void getCurrentHealth() {
        
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

}