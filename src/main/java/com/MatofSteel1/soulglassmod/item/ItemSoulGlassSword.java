package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.init.ModItems;
import com.MatofSteel1.soulglassmod.reference.Names;
import com.MatofSteel1.soulglassmod.reference.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemSoulGlassSword extends ItemSword {

    public ItemSoulGlassSword(ToolMaterial SOULSHARD) {
        super(SOULSHARD);
        this.setUnlocalizedName(Names.Items.soulGlassSword);
        this.setTextureName(Reference.MOD_ID + ":" + Names.Items.soulGlassSword);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
    }



    @Override
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_, EntityLivingBase p_77644_3_) {
        p_77644_1_.damageItem(1, p_77644_3_);
        p_77644_3_.addPotionEffect(new PotionEffect(Potion.resistance.id, 1, 3));
        p_77644_3_.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
        if (p_77644_3_.getHeldItem().getItem() == ModItems.ITEM_SOUL_GLASS_SWORD){
            p_77644_3_.addPotionEffect(new PotionEffect(Potion.weakness.id, 1, 3));
        }
            //TODO clean up with a switch statement
            if (p_77644_2_.getHealth() < 10 && p_77644_2_.isEntityUndead()) {
                p_77644_2_.addPotionEffect(new PotionEffect(Potion.harm.id, 10, 100));
            }else if (p_77644_2_.getHealth() < 10 && !p_77644_2_.isEntityUndead()){
                p_77644_2_.addPotionEffect(new PotionEffect(Potion.heal.id, 10, 100));
            }else if (p_77644_2_.isPotionApplicable(new PotionEffect(Potion.poison.id, 220, 4))) {
                p_77644_2_.addPotionEffect(new PotionEffect(Potion.heal.id, 10, 100));
                p_77644_2_.addPotionEffect(new PotionEffect(Potion.poison.id, 190, 4));
            } else if (!p_77644_2_.isPotionApplicable(new PotionEffect(Potion.poison.id, 220, 4)) && p_77644_2_.isEntityUndead()) {
                p_77644_2_.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 4));
                p_77644_2_.addPotionEffect(new PotionEffect(Potion.wither.id, 190, 2));
            } else {
                p_77644_2_.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 4));
                p_77644_2_.addPotionEffect(new PotionEffect(Potion.wither.id, 148, 2));
        }
        return true;
    }
}
