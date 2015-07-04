package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.SoulGlassMod;
import com.MatofSteel1.soulglassmod.init.ModBlocks;
import com.MatofSteel1.soulglassmod.reference.Reference;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSoulForge extends BlockContainer {

    private final boolean isActive;
    private static boolean keepInventory;
    private Random random = new Random();

    @SideOnly(Side.CLIENT)
    private IIcon iconFront;

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;

    public BlockSoulForge(boolean isActive) {
        super(Material.rock);
        this.isActive = isActive;
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        this.blockIcon = reg.registerIcon(Reference.MOD_ID + ":" + "BlockSoulForge_Side");
        this.iconFront = reg.registerIcon(Reference.MOD_ID + ":" + (this.isActive ? "BlockSoulForge_FrontActive" : "BlockSoulForge_FrontIdle"));
        this.iconTop = reg.registerIcon(Reference.MOD_ID + ":" + "BlockSoulForge_Top");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return meta == 0 && side == 3 ? this.iconFront : (side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side != meta ? this.blockIcon : this.iconFront)));

    }

    @Override
    public Item getItemDropped(int par1, Random random, int par3) {
        return Item.getItemFromBlock(ModBlocks.BlockSoulForgeIdle);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }


    private void setDefaultDirection(World world, int x, int y, int z) {
        if (!world.isRemote){
            Block block1 = world.getBlock(x, y, z - 1);
            Block block2 = world.getBlock(x, y, z + 1);
            Block block3 = world.getBlock(x - 1, y, z);
            Block block4 = world.getBlock(x + 1, y, z);
            byte b0 = 3;

            if (block1.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 3;
            }

            if (block2.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 2;
            }

            if (block3.func_149730_j() && !block4.func_149730_j())
            {
                b0 = 5;
            }

            if (block4.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 2);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int l = MathHelper.floor_double((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5d) & 3;
        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }
        if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }
        if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
        if (itemStack.hasDisplayName()){
            ((TileEntityFurnace)world.getTileEntity(x, y, z)).func_145951_a(itemStack.getDisplayName());
        }
    }

    public static void updateSoulForgeBlockState(boolean active, World world, int xCoord, int yCoord, int zCoord)
    {
        int l = world.getBlockMetadata(xCoord, yCoord, zCoord);
        TileEntity tileentity = world.getTileEntity(xCoord, yCoord, zCoord);
        keepInventory = true;

        if (active)
        {
            world.setBlock(xCoord, yCoord, zCoord, ModBlocks.BlockSoulForgeActive);
        }
        else
        {
            world.setBlock(xCoord, yCoord, zCoord, ModBlocks.BlockSoulForgeIdle);
        }

        keepInventory = false;
        world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setTileEntity(xCoord, yCoord, zCoord, tileentity);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote){
            return true;
        }else {
            TileEntitySoulForge tileEntitySoulForge = (TileEntitySoulForge)world.getTileEntity(x, y, z);

            if (tileEntitySoulForge != null)
            {
                FMLNetworkHandler.openGui(player, SoulGlassMod.instance, SoulGlassMod.guiIDSoulForge, world, x, y, z);
            }

            return true;
        }
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int oldMetadata) {
        if (!keepInventory) {
            TileEntitySoulForge tileEntity = (TileEntitySoulForge)world.getTileEntity(x, y, z);

            if (tileEntity != null) {
                for (int i = 0; i < tileEntity.getSizeInventory(); i++) {
                    ItemStack itemStack = tileEntity.getStackInSlot(i);

                    if (itemStack != null) {
                        float f = this.random.nextFloat() * 0.8f + 0.1f;
                        float f1 = this.random.nextFloat() * 0.8f + 0.1f;
                        float f2 = this.random.nextFloat() * 0.8f + 0.1f;

                        while (itemStack.stackSize > 0) {
                            int j = this.random.nextInt(21) + 10;

                            if (j > itemStack.stackSize) {
                                j = itemStack.stackSize;
                            }

                            itemStack.stackSize -= j;

                            EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2),
                                    new ItemStack(itemStack.getItem(), j, itemStack.getItemDamage()));

                            if (itemStack.hasTagCompound()) {
                                item.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
                            }

                            float f3 = 0.05f;

                            item.motionX = (double)((float)this.random.nextGaussian() * f3);
                            item.motionY = (double)((float)this.random.nextGaussian() * f3 + 0.2f);
                            item.motionZ = (double)((float)this.random.nextGaussian() * f3);

                            world.spawnEntityInWorld(item);
                        }
                    }
                }
                world.removeTileEntity(x, y, z);
            }
        }
        super.breakBlock(world, x, y, z, block, oldMetadata);
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
        return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(x, y, z));
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(new BlockSoulForgeIdle());
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntitySoulForge();
    }
}
