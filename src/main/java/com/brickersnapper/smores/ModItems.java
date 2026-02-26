package com.brickersnapper.smores;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.function.Function;

public class ModItems {

        public static final Consumable REGEN_2_CONSUMABLE_COMPONENT = Consumables.defaultFood()
                        .onConsume(new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f))
                        .build();

        public static final Consumable COOKED_SMORE_CONSUMABLE_COMPONENT = Consumables.defaultFood()
                        .onConsume(new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000000, 7), 1.0f))
                        .build();

        public static final Item CHOCOLATE_BAR = register("chocolate_bar", Item::new, new Item.Properties()
                        .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).build(),
                                        REGEN_2_CONSUMABLE_COMPONENT));
        public static final Item CINNAMON = register("cinnamon", Item::new, new Item.Properties());
        public static final Item GRAHAM_CRACKER = register("graham_cracker", Item::new, new Item.Properties()
                        .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).build(),
                                        REGEN_2_CONSUMABLE_COMPONENT));
        public static final Item MARSHMALLOW = register("marshmallow", Item::new, new Item.Properties()
                        .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).build(),
                                        REGEN_2_CONSUMABLE_COMPONENT));
        public static final Item RAW_SMORE = register("raw_smore", Item::new, new Item.Properties());
        public static final Item COOKED_SMORE = register("cooked_smore", Item::new, new Item.Properties()
                        .food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build(),
                                        COOKED_SMORE_CONSUMABLE_COMPONENT));

        public static Item register(String name, Function<Item.Properties, Item> itemFactory,
                        Item.Properties settings) {
                // Create the item key.
                ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(Smores.MOD_ID, name));

                // Create the item instance.
                Item item = itemFactory.apply(settings.setId(itemKey));

                // Register the item.
                Registry.register(BuiltInRegistries.ITEM, itemKey, item);

                return item;
        }

        public static void initialize() {
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.CHOCOLATE_BAR));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.CINNAMON));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.GRAHAM_CRACKER));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.MARSHMALLOW));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.RAW_SMORE));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.COOKED_SMORE));
        }
}