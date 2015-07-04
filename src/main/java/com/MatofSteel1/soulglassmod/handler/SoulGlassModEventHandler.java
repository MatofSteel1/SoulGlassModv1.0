package com.MatofSteel1.soulglassmod.handler;

import com.MatofSteel1.soulglassmod.init.MobExtendedProperties;
import com.MatofSteel1.soulglassmod.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.util.Random;

public class SoulGlassModEventHandler {

    Random rand = new Random();

    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event){
        if (event.entity instanceof EntityLivingBase)
            MobExtendedProperties.register((EntityLivingBase) event.entity);
    }

    @SubscribeEvent
    public void onBlockHarvested(BlockEvent.HarvestDropsEvent event) {
        net.minecraft.block.Block block = event.block;
        World world = event.world;
        int x = event.x;
        int y = event.y;
        int z = event.z;
        if (block.getUnlocalizedName().equals("tile.hellsand")) {
            if (event.drops.iterator().next().getItem() == Item.getItemFromBlock(Blocks.soul_sand)) {
                event.drops.remove(event.drops.iterator().next());
            }
            for (int i = 0; i < rand.nextInt(4) + 1; i++) {
                world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.ITEM_SOUL_ESSENCE)));
            }
        }
    }

    @SubscribeEvent
    public void onLivingUpdateEvent(LivingEvent.LivingUpdateEvent event)
    {
        if (event.entityLiving != null)
        {
            if(event.entityLiving instanceof EntityPlayer)
            {
                EntityPlayer player = ((EntityPlayer)event.entityLiving);
                if (player.worldObj.isRemote){
                    if(player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem().equals(ModItems.ITEM_WITHERS_GIFT)) {
                        if (!player.capabilities.allowFlying) {
                            player.capabilities.allowFlying = true;
                            System.out.println("You should be flying now!");
                        }
                    }else if(player.inventory.armorItemInSlot(1) == null || !player.inventory.armorItemInSlot(1).getItem().equals(ModItems.ITEM_WITHERS_GIFT)) {
                        if(player.capabilities.allowFlying && !player.capabilities.isCreativeMode) {
                            player.capabilities.allowFlying = false;
                            player.capabilities.disableDamage = false;
                            System.out.println("You took off the gift!");
                        }
                    }
                }
            }
        }
    }
}
