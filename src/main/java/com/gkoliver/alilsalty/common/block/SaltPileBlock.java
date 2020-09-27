package com.gkoliver.alilsalty.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class SaltPileBlock extends Block {
    private static final VoxelShape SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 1.0D, 13.0D);
    public SaltPileBlock(Properties properties) {
        super(properties);
        properties.tickRandomly();
    }
    public static void popOff(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        spawnDrops(state, worldIn, pos);
        worldIn.removeBlock(pos, false);
    }
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (worldIn.canSeeSky(pos) && worldIn.isRainingAt(pos)) {} ;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
