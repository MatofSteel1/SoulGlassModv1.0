package com.MatofSteel1.soulglassmod.block;

import com.MatofSteel1.soulglassmod.reference.Names;

import java.util.Random;

public class BlockSoulGlass extends BlockSoulGlassMod {

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

    public BlockSoulGlass() {
        super();
        this.setBlockName(Names.Blocks.soulGlass).setBlockTextureName(Names.Blocks.soulGlass).setHardness(0.1F).setResistance(2000.0F).setStepSound(soundTypeGlass).setLightOpacity(0).isOpaqueCube();
        this.canRenderInPass();
        this.renderAsNormalBlock();
        this.getRenderBlockPass();
        this.shouldSideBeRendered();
        //this.quantityDroppedWithBonus(2, random);
    }
}

    //@Override
    //public int quantityDropped(Random random) {
        //return random.nextInt(4) + 1;
    //}


    //public Item getItemDropped(int metadata, Random random, int fortune) {
/*        switch (seed.nextInt(4)) {
            case 0:case 1:case 2:
                return ModItems.ITEM_SOUL_GLASS_SHARD;
            case 3:
                return ModItems.ITEM_SOUL_GLASS_SHARD;
            default:
                return ModItems.ITEM_GLASS_CHESTPLATE;
        }
        if (getItemDropped() == ModItems.ITEM_SOUL_GLASS_SHARD){

        }*/
        /*if (fortune == 0) {
            return ModItems.ITEM_SOUL_GLASS_SHARD;}
        else if (fortune <= 1) {
            quantityDropped(Random, rand);
            return ModItems.ITEM_SOUL_GLASS_SHARD;}
        else if (fortune <= 2) {
            return ModItems.ITEM_SOUL_GLASS_SHARD;}
        else if (fortune <= 3) {
            return ModItems.ITEM_SOUL_GLASS_SHARD;
        } else {
            return ModItems.ITEM_GLASS_CHESTPLATE;*/
        //}

    //}
//}