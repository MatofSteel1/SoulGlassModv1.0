package com.MatofSteel1.soulglassmod.handler;

import com.MatofSteel1.soulglassmod.block.TileEntitySoulForge;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiSoulForge extends GuiContainer{

    public static final ResourceLocation gui = new ResourceLocation(Reference.MOD_ID, "textures/gui/SoulForgeGui.png");

    public TileEntitySoulForge soulForge;

    public GuiSoulForge(InventoryPlayer inventoryPlayer, TileEntitySoulForge entity) {
        super(new ContainerSoulForge(inventoryPlayer, entity));
        this.soulForge = entity;

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        String name = this.soulForge.isInvNameLocalized() ? this.soulForge.getInventoryName() : I18n.format(this.soulForge.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(name, this.guiTop, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1f, 1f, 1f, 1f);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        Minecraft.getMinecraft().getTextureManager().bindTexture(gui);

        drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

        if (this.soulForge.isBurning())
        {
            int i1 = this.soulForge.getBurnTimeRemainingScaled(13);
            this.drawTexturedModalRect(k + 57, l + 37 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
            i1 = this.soulForge.getCookProgressScaled(24);
            this.drawTexturedModalRect(k + 80, l + 16, 176, 14, i1 + 1, 16);
        }
    }
}
