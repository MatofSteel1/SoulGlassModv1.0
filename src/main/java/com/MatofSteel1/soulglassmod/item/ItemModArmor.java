package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.client.settings.Keybindings;
import com.MatofSteel1.soulglassmod.init.ModItems;
import com.MatofSteel1.soulglassmod.reference.Key;
import com.MatofSteel1.soulglassmod.reference.Reference;
import com.MatofSteel1.soulglassmod.utility.LogHelper;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import org.lwjgl.input.Keyboard;

public class ItemModArmor extends ItemArmor{

    public EntityPlayer player_2;
    public static ItemArmor.ArmorMaterial SOULPLATING = EnumHelper.addArmorMaterial("SOULPLATING", 64, new int[]{2, 6, 5, 2}, 15);
    public String textureName;
    public boolean pressTrigger = false;

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

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ModItems.ITEM_GLASS_HELMET) && player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ModItems.ITEM_GLASS_CHESTPLATE) &&
        player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ModItems.ITEM_GLASS_LEGGINGS) && player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ModItems.ITEM_GLASS_BOOTS)) {

            if (hitEntity(itemStack, player, player_2)){
                player_2.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
            }

            if (!player.isPotionActive(Potion.invisibility.id))
                player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 20, 0));
                //TODO make keybind and toggle when functional. Add this.textureName = "NO_TEXTURE";
        }
    }
}

