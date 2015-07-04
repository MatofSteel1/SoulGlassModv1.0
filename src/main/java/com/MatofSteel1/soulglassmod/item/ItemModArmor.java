package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.init.ModItems;
import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class ItemModArmor extends ItemArmor{

    public static ItemArmor.ArmorMaterial WITHER = EnumHelper.addArmorMaterial("WITHER", 64, new int[]{2, 6, 5, 2}, 15);
    public static ItemArmor.ArmorMaterial SOULPLATING = EnumHelper.addArmorMaterial("SOULPLATING", -1, new int[]{2, 6, 5, 2}, 15);
    public String textureName;

    public ItemModArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
        super(material, 0, type);
        this.textureName = textureName;
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Reference.MOD_ID + ":" + unlocalizedName);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return Reference.MOD_ID + ":/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
    }

    /*
    Every tick that a player is wearing armor
    the game will check if you are wearing the full
    set of Soul Glass Armor. If so and you are sneaking
    only the pants of the armor will render and the player will
    become invisible.
    */

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean b) {
        EntityPlayer player = (EntityPlayer) entity;
        if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ModItems.ITEM_GLASS_HELMET) && player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ModItems.ITEM_GLASS_CHESTPLATE) &&
                player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ModItems.ITEM_GLASS_LEGGINGS) && player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ModItems.ITEM_GLASS_BOOTS)) {
            if (player.isSneaking()) {
                player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 5, 0));
                this.textureName = "NO_TEXTURE";
            } else {
                ItemStack thorny = new ItemStack(ModItems.ITEM_GLASS_CHESTPLATE);
                thorny.addEnchantment(Enchantment.thorns, 10);
                this.textureName = "SOULPLATING";
            }

        } else if (player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem().equals(ModItems.ITEM_WITHERS_GIFT)) {
            if (!player.capabilities.allowFlying) {
                player.capabilities.allowFlying = true;
                this.textureName = "WITHER";
                System.out.println("You should not take fall damage!");
            }
        } else if (player.inventory.armorItemInSlot(1) == null || !player.inventory.armorItemInSlot(1).getItem().equals(ModItems.ITEM_WITHERS_GIFT)) {
            if (player.capabilities.allowFlying) {
                player.capabilities.allowFlying = false;
                this.setTextureName(textureName);
                System.out.println("You should take fall damage!");
            }
        }
    }
}

