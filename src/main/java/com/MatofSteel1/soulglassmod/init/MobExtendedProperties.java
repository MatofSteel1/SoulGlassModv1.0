package com.MatofSteel1.soulglassmod.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class MobExtendedProperties implements IExtendedEntityProperties{

    public final static String EXT_PROP_NAME = "ExtendedMob";

    private final EntityLivingBase entity;

    private EntityPlayer player;

    public boolean isHit;

    public MobExtendedProperties(EntityLivingBase entity){
        this.entity = entity;
    }

    public static final void register(EntityLivingBase entity){
        entity.registerExtendedProperties(MobExtendedProperties.EXT_PROP_NAME, new MobExtendedProperties(entity));
    }

    public static final MobExtendedProperties get(EntityLivingBase entity) {
        return (MobExtendedProperties) entity.getExtendedProperties(EXT_PROP_NAME);
    }

    @Override
    public void saveNBTData(NBTTagCompound compound){
        compound.setBoolean("isHit", true);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound){
        this.isHit = compound.getBoolean("isHit");
        //System.out.println("[LIVING BASE] isHit from NBT: " + this.isHit);
    }

    @Override
    public void init(Entity entity, World world){
        if (entity.hitByEntity(player)){
            this.isHit = true;
        }
    }
}
