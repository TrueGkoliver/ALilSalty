package com.gkoliver.alilsalty.core.registry;

import com.gkoliver.alilsalty.ALilSalty;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class LilSaltyItems {
    //ITEM PROPERTIES
    public static final Item.Properties P_SALT = new Item.Properties().maxStackSize(64).group(ItemGroup.MISC);

    //FOODS
    public static final Food F_CURED_PORK = new Food.Builder().effect(()->new EffectInstance(Effects.STRENGTH, 15*20), 1.0F).build();
    
    
    
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ALilSalty.MOD_ID);
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", ()->new Item(P_SALT));
}
