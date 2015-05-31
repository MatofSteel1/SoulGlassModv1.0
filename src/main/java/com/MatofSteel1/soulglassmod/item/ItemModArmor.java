package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.init.ModItems;
import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemModArmor extends ItemArmor{

    public static ItemArmor.ArmorMaterial SOULPLATING = EnumHelper.addArmorMaterial("SOULPLATING", 64, new int[]{2, 6, 5, 2}, 15);
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
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ModItems.ITEM_GLASS_HELMET) && player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ModItems.ITEM_GLASS_CHESTPLATE) &&
        player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ModItems.ITEM_GLASS_LEGGINGS) && player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ModItems.ITEM_GLASS_BOOTS) && player.isSneaking()) {
            player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 5, 0));
            this.textureName = "NO_TEXTURE";
        }else {
            this.textureName = "SOULPLATING";
        }
    }
}

