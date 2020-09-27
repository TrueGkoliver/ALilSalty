package com.gkoliver.alilsalty.common.world;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.ArrayList;
import java.util.Random;

public class SaltBedStructure extends Feature {
    public SaltBedStructure(Codec codecIn) {
        super(codecIn);
    }
    ArrayList<Block> SALT_FLAT_BLOCKS = new ArrayList<Block>() {
        {
            add(Blocks.GRASS_BLOCK);
            add(Blocks.DIRT);
            add(Blocks.COARSE_DIRT);
            add(Blocks.SAND);
        }
    };
    @Override
    public boolean func_230362_a_(ISeedReader seedReaderIn, StructureManager structureManagerIn, ChunkGenerator chunkGeneratorIn, Random randomIn, BlockPos posIn, IFeatureConfig featureConfigIn) {
        while(seedReaderIn.isAirBlock(posIn) && posIn.getY() > 2) {
            posIn = posIn.down();
        }
        if (!SALT_FLAT_BLOCKS.contains(seedReaderIn.getBlockState(posIn).getBlock())) {
            return false;
        } else {

        }
        return true;
    }
    public boolean checkForCapability() {
        return false;
    }
}
