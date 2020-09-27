package com.gkoliver.alilsalty;

import com.gkoliver.alilsalty.core.registry.LilSaltyBlocks;
import com.gkoliver.alilsalty.core.registry.LilSaltyFeatures;
import com.gkoliver.alilsalty.core.registry.LilSaltyItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ALilSalty.MOD_ID)
@Mod.EventBusSubscriber(modid=ALilSalty.MOD_ID)
public class ALilSalty
{
    public static final String MOD_ID = "alilsalty";
    private static final Logger LOGGER = LogManager.getLogger();

    public ALilSalty() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        LilSaltyItems.ITEMS.register(eventBus);
        LilSaltyBlocks.BLOCKS.register(eventBus);
    }

    private void setup(final FMLCommonSetupEvent event)  {
        LilSaltyFeatures.saltOreAddLoop();
    }
}
