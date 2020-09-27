package com.gkoliver.alilsalty.core.registry;

import net.minecraft.block.BlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class LilSaltyFeatures {
    public static final BlockState HALITE_ORE = LilSaltyBlocks.SALT_ORE.get().getDefaultState();
    public static final ConfiguredFeature SALT_ORE_FEATURE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, HALITE_ORE, 17)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128)));
    public static void addSaltOreSpawn(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SALT_ORE_FEATURE);
    }
    public static void saltOreAddLoop() {
        for (Map.Entry<ResourceLocation, Biome> entry : ForgeRegistries.BIOMES.getEntries()) {
            if (BiomeDictionary.hasType(entry.getValue(), BiomeDictionary.Type.OVERWORLD)) {
                addSaltOreSpawn(entry.getValue());
            }
        }
    }
}
