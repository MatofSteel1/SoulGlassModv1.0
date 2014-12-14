package com.MatofSteel1.soulglassmod.handler;

import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    public static Configuration configuration;
    public static boolean testValue = false;

    public static void init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
        }
    }

        @SubscribeEvent
        public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

            if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
                loadConfiguration();
            }
        }
    private static void loadConfiguration(){
        testValue = configuration.getBoolean("configValue", configuration.CATEGORY_GENERAL, false, "ExampleComment");
        if (configuration.hasChanged()){
         configuration.save();
        }
    }
}