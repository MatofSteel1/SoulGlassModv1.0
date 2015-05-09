package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.init.ModBlocks;
import com.MatofSteel1.soulglassmod.init.ModItems;
import com.MatofSteel1.soulglassmod.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockSoulInfusedGlass extends BlockOreMod {

    @Override
    public boolean isOpaqueCube(){
        return false;
    }


    public int canRenderInPass(){
        return 1;
    }

    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }
    @Override
    public int getRenderBlockPass(){
        return 1;
    }

    public boolean shouldSideBeRendered(){
        return false;
    }

    public BlockSoulInfusedGlass() {
        super("SoulInfusedGlass", Material.glass, ModItems.ITEM_SOUL_GLASS_SHARD, 0, 1, 3);
        this.setBlockName(Names.Blocks.soulGlass).setBlockTextureName(Names.Blocks.soulGlass).setHardness(0.1F).setResistance(2000.0F).setStepSound(soundTypeGlass).setLightOpacity(0).isOpaqueCube();
        this.canRenderInPass();
        this.renderAsNormalBlock();
        this.getRenderBlockPass();
        this.shouldSideBeRendered();

    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
        return p_149646_5_ == 0 && this.minY > 0.0D ? true : (p_149646_5_ == 1 && this.maxY < 1.0D ? true : (p_149646_5_ == 2 && this.minZ > 0.0D ? true : (p_149646_5_ == 3 && this.maxZ < 1.0D ? true : (p_149646_5_ == 4 && this.minX > 0.0D ? true : (p_149646_5_ == 5 && this.maxX < 1.0D ? true : !p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_).isAssociatedBlock(ModBlocks.BlockSoulInfusedGlass))))));
    }
}