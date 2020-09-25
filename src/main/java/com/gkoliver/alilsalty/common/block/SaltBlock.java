package com.gkoliver.alilsalty.common.block;

import net.minecraft.block.FallingBlock;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class SaltBlock extends FallingBlock {
    public SaltBlock(Properties properties) {
        super(properties);
    }
    public static final Random RAND = new Random();
    public static final float AMT = 0.5F;
    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entityIn;
            if (living.getCreatureAttribute()== CreatureAttribute.UNDEAD||entityIn instanceof SlimeEntity) {
                if (living.getArmorCoverPercentage()<=0.0F) {
                    entityIn.attackEntityFrom(DamageSource.SWEET_BERRY_BUSH, AMT);
                } else {
                    entityIn.getArmorInventoryList().forEach((stackIn)->{
                        if (RAND.nextInt(4)==3) {
                            stackIn.attemptDamageItem(RAND.nextInt(10), RAND, null);
                        }
                    });
                }

            }
        }
    }
}
