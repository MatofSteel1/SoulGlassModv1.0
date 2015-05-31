package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemEternalFood extends ItemSoulGlassMod {

    public ItemEternalFood() {
        super();
        this.setUnlocalizedName(Names.Items.eternalFood).setMaxStackSize(1);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, net.minecraft.entity.Entity entity, int par4, boolean par5) {
        super.onUpdate(stack, world, entity, par4, par5);
        EntityPlayer player = (EntityPlayer) entity;
        if (player.getFoodStats().getFoodLevel() < 18) {
            player.getFoodStats().setFoodLevel(20);
            player.getFoodStats().setFoodSaturationLevel(10f);
            player.addPotionEffect(new PotionEffect(Potion.poison.id, 40, 2));
        }
    }
}
