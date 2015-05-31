package com.MatofSteel1.soulglassmod;

import com.MatofSteel1.soulglassmod.handler.ConfigurationHandler;
import com.MatofSteel1.soulglassmod.handler.SoulGlassModEventHandler;
import com.MatofSteel1.soulglassmod.init.ModBlocks;
import com.MatofSteel1.soulglassmod.init.ModItems;
import com.MatofSteel1.soulglassmod.init.Recipies;
import com.MatofSteel1.soulglassmod.proxy.IProxy;
import com.MatofSteel1.soulglassmod.reference.Reference;
import com.MatofSteel1.soulglassmod.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class SoulGlassMod {
    @Mod.Instance(Reference.MOD_ID)
    public static SoulGlassMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy iProxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent preEvent) {
        ConfigurationHandler.init(preEvent.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        ModItems.init();
        ModBlocks.init();
        iProxy.registerKeyBindings();
        LogHelper.info("Pre Initialization Complete!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        Recipies.init();
        // the majority of events use the MinecraftForge event bus:
        MinecraftForge.EVENT_BUS.register(new SoulGlassModEventHandler());
        // but some are on the FML bus:
        FMLCommonHandler.instance().bus().register(new SoulGlassModEventHandler());

        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent postEvent){

        LogHelper.info("Post Initialization Complete!");
    }

    //public BlockEvent.HarvestDropsEvent
}
