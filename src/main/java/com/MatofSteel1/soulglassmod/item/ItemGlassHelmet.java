package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ItemGlassHelmet extends ItemModArmor {

    public void registerBlockIcons(IIconRegister reg) {
        for (int i = 0; i < 6; i ++) {
            this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
        }
    }

    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }

    public String textureName;
    public IIcon[] icons = new IIcon[6];

    public ItemGlassHelmet(){
        super(Names.Items.glassHelmet, ArmorMaterial.valueOf("SOULPLATING"), "SOULPLATING", 0);
        this.maxStackSize = 1;
        this.setMaxDamage(100);
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
    }
}
