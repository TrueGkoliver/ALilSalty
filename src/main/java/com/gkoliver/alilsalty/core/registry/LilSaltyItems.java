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
    public static final Item.Properties P_FOOD = new Item.Properties().maxStackSize(64).group(ItemGroup.FOOD);
    //FOODS
    public static final Food F_CURED_BEEF = new Food.Builder().effect(()->new EffectInstance(Effects.STRENGTH, 15*20), 1.0F).hunger(8).saturation(0.8F).meat().build();
    public static final Food F_CURED_PORK = new Food.Builder().effect(()->new EffectInstance(Effects.REGENERATION, 15*20), 1.0F).hunger(8).saturation(0.8F).meat().build();
    public static final Food F_CURED_MUTTON = new Food.Builder().effect(()->new EffectInstance(Effects.RESISTANCE, 15*20), 1.0F).hunger(6).saturation(0.8F).meat().build();
    public static final Food F_CURED_CHICKEN = new Food.Builder().effect(()->new EffectInstance(Effects.SLOW_FALLING, 15*20), 1.0F).hunger(6).saturation(0.6F).meat().build();
    public static final Food F_CURED_COD = new Food.Builder().effect(()->new EffectInstance(Effects.HASTE, 15*20), 1.0F).hunger(5).saturation(0.6F).build();
    public static final Food F_CURED_SALMON = new Food.Builder().effect(()->new EffectInstance(Effects.SPEED, 15*20), 1.0F).hunger(6).saturation(0.8F).build();
    public static final Food F_CURED_RABBIT = new Food.Builder().effect(()->new EffectInstance(Effects.LUCK, 15*20), 1.0F).hunger(5).saturation(0.6F).meat().build();
    
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ALilSalty.MOD_ID);
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", ()->new Item(P_SALT));

    //Food items
    public static final RegistryObject<Item> CURED_BEEF = ITEMS.register("cured_beef", ()->new Item(P_FOOD.food(F_CURED_BEEF)));
    public static final RegistryObject<Item> CURED_PORK = ITEMS.register("cured_pork", ()->new Item(P_FOOD.food(F_CURED_PORK)));
    public static final RegistryObject<Item> CURED_MUTTON = ITEMS.register("cured_mutton", ()->new Item(P_FOOD.food(F_CURED_MUTTON)));
    public static final RegistryObject<Item> CURED_CHICKEN = ITEMS.register("cured_chicken", ()->new Item(P_FOOD.food(F_CURED_CHICKEN)));
    public static final RegistryObject<Item> CURED_COD = ITEMS.register("cured_cod", ()->new Item(P_FOOD.food(F_CURED_COD)));
    public static final RegistryObject<Item> CURED_SALMON = ITEMS.register("cured_salmon", ()->new Item(P_FOOD.food(F_CURED_SALMON)));
    public static final RegistryObject<Item> CURED_RABBIT = ITEMS.register("cured_rabbit", ()->new Item(P_FOOD.food(F_CURED_RABBIT)));
}
