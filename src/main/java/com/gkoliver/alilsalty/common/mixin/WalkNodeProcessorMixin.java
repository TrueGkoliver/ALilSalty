package com.gkoliver.alilsalty.common.mixin;

import com.gkoliver.alilsalty.core.registry.LilSaltyBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.WalkNodeProcessor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WalkNodeProcessor.class)
public class WalkNodeProcessorMixin {
    private static final Block SALT = LilSaltyBlocks.SALT_BLOCK.get();
    @Inject(method="func_237238_b_", at=@At("HEAD"))
    protected static void evaluate(IBlockReader blockReader, BlockPos pos, CallbackInfoReturnable<PathNodeType> ci) {
        BlockState blockstate = blockReader.getBlockState(pos);
        PathNodeType type = blockstate.getAiPathNodeType(blockReader, pos);
        if (type != null) ci.setReturnValue(type);
        Block block = blockstate.getBlock();
        Material material = blockstate.getMaterial();
        if (block==SALT) {
            ci.setReturnValue(PathNodeType.UNPASSABLE_RAIL);
        }
    }
}
