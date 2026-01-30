package com.rainexael.fortnitefood;

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

        public static final FoodProperties BANANA_FOOD_COMPONENT = new FoodProperties.Builder()
                        .alwaysEdible()
                        .build();

        public static final Consumable BANANA_CONSUMABLE_COMPONENT = Consumables.defaultFood()
                        // The duration is in ticks, 20 ticks = 1 second
                        .onConsume(new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.REGENERATION, 25 * 20, 1), 1.0f))
                        .onConsume(new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.INSTANT_HEALTH, 1, 1), 1.0f))
                        .onConsume(new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.SPEED, 25 * 20, 1), 1.0f))
                        .onConsume(new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.JUMP_BOOST, 25 * 20, 2), 1.0f))
                        .build();

        public static final Consumable MED_HEAL_CONSUMABLE_COMPONENT = Consumables.defaultFood()
                        // The duration is in ticks, 20 ticks = 1 second
                        .onConsume(new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.REGENERATION, 20, 4), 1.0f))

                        .build();
        public static final Consumable SMALL_HEAL_CONSUMABLE_COMPONENT = Consumables.defaultFood()
                        // The duration is in ticks, 20 ticks = 1 second
                        .onConsume(new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.REGENERATION, 20, 3), 1.0f))

                        .build();

        public static final Consumable CHOCOLATE_BAR_CONSUMABLE_COMPONENT = Consumables.defaultFood()
                        .onConsume(new ApplyStatusEffectsConsumeEffect(
                                        new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1.0f))
                        .build();

        public static final Item SUSPICIOUS_SUBSTANCE = register("suspicious_substance", Item::new,
                        new Item.Properties());
        public static final Item FLOPPER = register("flopper", Item::new,
                        new Item.Properties().food(new FoodProperties.Builder().nutrition(6).build()));
        public static final Item SMALLFRY = register("small_fry", Item::new,
                        new Item.Properties().food(new FoodProperties.Builder().nutrition(3).build()));
        public static final Item SLURPFISH = register("slurp_fish", Item::new, new Item.Properties());

        public static final Item SLAPBERRY = register("slap_berry", Item::new, new Item.Properties());
        public static final Item SLAPJUICE = register("slap_juice", Item::new, new Item.Properties());
        public static final Item BANANAOFTHEGODS = register("banana_of_the_gods", Item::new,
                        new Item.Properties().food(BANANA_FOOD_COMPONENT, BANANA_CONSUMABLE_COMPONENT));
        public static final Item CHOCOLATE_BAR = register("chocolate_bar", Item::new, new Item.Properties()
                        .food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).build(),
                                        CHOCOLATE_BAR_CONSUMABLE_COMPONENT));

        public static Item register(String name, Function<Item.Properties, Item> itemFactory,
                        Item.Properties settings) {
                // Create the item key.
                ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(Fortnitefood.MOD_ID, name));

                // Create the item instance.
                Item item = itemFactory.apply(settings.setId(itemKey));

                // Register the item.
                Registry.register(BuiltInRegistries.ITEM, itemKey, item);

                return item;
        }

        public static void initialize() {
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.SUSPICIOUS_SUBSTANCE));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.FLOPPER));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.SMALLFRY));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.SLURPFISH));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.SLAPBERRY));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.SLAPJUICE));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.BANANAOFTHEGODS));
                ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                                .register((itemGroup) -> itemGroup.accept(ModItems.CHOCOLATE_BAR));
        }
}