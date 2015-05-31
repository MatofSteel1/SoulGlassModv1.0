package com.MatofSteel1.soulglassmod.handler;

import com.MatofSteel1.soulglassmod.init.MobExtendedProperties;
import com.MatofSteel1.soulglassmod.init.ModItems;
import com.MatofSteel1.soulglassmod.item.ItemSoulEssence;
import com.MatofSteel1.soulglassmod.item.ItemSoulGlassShovel;
import com.google.common.eventbus.Subscribe;
import com.sun.istack.internal.FinalArrayList;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
        String string = event.drops.iterator().next().getItem().toString();
        net.minecraft.block.Block block = event.block;
        World world = event.world;
        int x = event.x;
        int y = event.y;
        int z = event.z;
        if (block.getUnlocalizedName().equals("tile.hellsand")) {
            if (event.drops.iterator().next().getItem().toString().equals("net.minecraft.item.ItemBlock@58496c97")) {
                event.drops.remove(event.drops.iterator().next());
            }
            for (int i = 0; i < rand.nextInt(4) + 1; i++) {
                world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.ITEM_SOUL_ESSENCE)));
            }
        }
    }
}
