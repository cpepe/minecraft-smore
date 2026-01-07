package com.porkcheeks.item;

import com.porkcheeks.SmoreBeastMod;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import java.util.List;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;


public class ChocolateBarItem extends Item {
    public static final FoodComponent CHOCOLATE_BAR_FOOD_COMPONENT = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0f).build();

    public ChocolateBarItem(Settings settings) {
        super(settings.food(CHOCOLATE_BAR_FOOD_COMPONENT));
    }
}

