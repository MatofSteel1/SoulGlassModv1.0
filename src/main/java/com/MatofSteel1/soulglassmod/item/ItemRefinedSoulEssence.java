package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemRefinedSoulEssence extends ItemSoulGlassMod {

    public ItemRefinedSoulEssence() {
        super();
        this.setUnlocalizedName(Names.Items.refinedSoulEssence);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, net.minecraft.entity.Entity entity, int par4, boolean par5) {
        super.onUpdate(stack, world, entity, par4, par5);
        EntityPlayer player = (EntityPlayer) entity;
        if (Potion.moveSlowdown.getEffectiveness() > 0.0  && Potion.hunger.getEffectiveness() > 0.0){
            player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 5, 3));
            player.addPotionEffect(new PotionEffect(Potion.hunger.id, 5, 1));
            if (player.getDisplayName().equals("Soaryn")){
                player.addPotionEffect(new PotionEffect(Potion.hunger.id, 100, 100));
            }
        }
    }
}