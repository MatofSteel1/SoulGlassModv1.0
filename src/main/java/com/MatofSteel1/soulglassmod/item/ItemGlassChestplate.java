package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ItemGlassChestplate extends ItemModArmor {

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

    public ItemGlassChestplate(){
        super(Names.Items.glassChestplate, ArmorMaterial.valueOf("SOULPLATING"), "SOULPLATING", 1);
        this.maxStackSize = 1;
        this.setMaxDamage(100);
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
    }
}
