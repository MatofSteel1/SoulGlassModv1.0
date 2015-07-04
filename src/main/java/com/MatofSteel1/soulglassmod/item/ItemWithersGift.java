package com.MatofSteel1.soulglassmod.item;

import com.MatofSteel1.soulglassmod.creativetab.CreativeTabSGM;
import com.MatofSteel1.soulglassmod.init.ModItems;
import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.client.model.ModelWither;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ItemWithersGift extends ItemModArmor {

    public String textureName;
    public IIcon[] icons = new IIcon[6];
    public EntityPlayer player;

    public void registerBlockIcons(IIconRegister reg) {
        for (int i = 0; i < 6; i++) {
            this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
        }
    }

    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }

    public ItemWithersGift() {
        super(Names.Items.withersGift, ArmorMaterial.valueOf("WITHER"), "WITHER", 2);
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
        this.setCreativeTab(CreativeTabSGM.SoulGlassMod_TAB);
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add("I feel lighter...");
    }
}
