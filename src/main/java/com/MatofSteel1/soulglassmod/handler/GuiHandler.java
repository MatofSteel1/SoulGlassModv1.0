package com.MatofSteel1.soulglassmod.handler;

import com.MatofSteel1.soulglassmod.SoulGlassMod;
import com.MatofSteel1.soulglassmod.block.TileEntitySoulForge;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity != null) {
            switch (ID) {
                case SoulGlassMod.guiIDSoulForge:
                    if (entity instanceof TileEntitySoulForge) {
                        return new ContainerSoulForge(player.inventory, (TileEntitySoulForge) entity);
                    }
            }
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity entity = world.getTileEntity(x, y, z);

        if (entity != null) {
            switch (ID) {
                case SoulGlassMod.guiIDSoulForge:
                    if (entity instanceof TileEntitySoulForge) {
                        return new GuiSoulForge(player.inventory, (TileEntitySoulForge) entity);
                    }
            }
        }

        return null;
    }
}
