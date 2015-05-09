package com.MatofSteel1.soulglassmod.handler;

import com.MatofSteel1.soulglassmod.init.MobExtendedProperties;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;

public class SoulGlassModEventHandler {
    @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event){
        if (event.entity instanceof EntityLivingBase)
            MobExtendedProperties.register((EntityLivingBase) event.entity);
    }
}
