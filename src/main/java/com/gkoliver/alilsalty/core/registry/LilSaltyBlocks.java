package com.gkoliver.alilsalty.core.registry;

import com.gkoliver.alilsalty.ALilSalty;
import com.gkoliver.alilsalty.common.block.SaltBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LilSaltyBlocks {
    public static RegistryObject<Block> generateItemAndBlock(String name, Block blockIn, ItemGroup groupIn) {
        RegistryObject<Block> tbr = BLOCKS.register(name, ()->blockIn);
        Item.Properties prop = new Item.Properties().maxStackSize(64).group(groupIn);
        RegistryObject<Item> itemBlock = LilSaltyItems.ITEMS.register(name, ()->new BlockItem(blockIn, prop));
        return tbr;
    }
    //NOTE TO FUTURE VIEWERS: I have no clue what .func_235861_h_() does.
    public static final AbstractBlock.Properties P_SALT_BLOCK = AbstractBlock.Properties.create(Material.ROCK).func_235861_h_().harvestTool(ToolType.SHOVEL);
    public static final AbstractBlock.Properties P_SALT_ORE = AbstractBlock.Properties.create(Material.ROCK);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ALilSalty.MOD_ID);
    public static final RegistryObject<Block> SALT_BLOCK = generateItemAndBlock("salt_block", new SaltBlock(P_SALT_BLOCK), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> SALT_ORE = generateItemAndBlock("salt_ore", new SaltBlock(P_SALT_ORE), ItemGroup.BUILDING_BLOCKS);
}
