package com.MatofSteel1.soulglassmod.client.gui;

import com.MatofSteel1.soulglassmod.handler.ConfigurationHandler;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.*;

public class ModGuiConfig extends GuiConfig{
public ModGuiConfig(GuiScreen guiScreen){
    super (guiScreen,
            new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
            Reference.MOD_ID,
            false,
            false,
            GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));

    }
}
