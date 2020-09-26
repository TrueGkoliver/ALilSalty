package com.gkoliver.alilsalty.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

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
    public static boolean isTouching(Block toLookFor, World reader, BlockPos pos) {
        BlockPos stateNorth = pos.north();
        BlockPos stateSouth = pos.south();
        BlockPos stateWest = pos.west();
        BlockPos stateEast = pos.east();
        BlockPos stateUp = pos.up();
        BlockPos stateDown = pos.down();
        if (reader.getBlockState(stateNorth).getBlock()==toLookFor) return true;
        if (reader.getBlockState(stateSouth).getBlock()==toLookFor) return true;
        if (reader.getBlockState(stateWest).getBlock()==toLookFor) return true;
        if (reader.getBlockState(stateEast).getBlock()==toLookFor) return true;
        if (reader.getBlockState(stateUp).getBlock()==toLookFor) return true;
        if (reader.getBlockState(stateDown).getBlock()==toLookFor) return true;
        return false;
    }
    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down())) && pos.getY() >= 0) {
            if (!isTouching(Blocks.WATER, worldIn, pos)) {
                FallingBlockEntity fallingblockentity = new FallingBlockEntity(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
                this.onStartFalling(fallingblockentity);
                worldIn.addEntity(fallingblockentity);
            }
        }
    }
}
