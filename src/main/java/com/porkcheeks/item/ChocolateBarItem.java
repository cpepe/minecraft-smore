package com.porkcheeks.item;

import com.porkcheeks.SmoreBeastMod;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.world.World;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.component.type.FoodComponent;

import java.util.function.Consumer;


public class ChocolateBarItem extends Item {
    public static final FoodComponent CHOCOLATE_BAR_FOOD_COMPONENT = new FoodComponent(4, 1.0F,true);

    // public static final FoodComponent CHOCOLATE_BAR_FOOD_COMPONENT = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f)
    //         .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0f).build();

    public ChocolateBarItem(Settings settings) {
        super(settings.food(CHOCOLATE_BAR_FOOD_COMPONENT));
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
        tooltip.accept(Text.literal("Chocolate Bar").formatted(Formatting.GRAY));
    }
}

