package com.rainexael.fortnitefood;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class CookedSmoreItem extends Item {
    public CookedSmoreItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        // If the entity is a player, check for the effect first
        if (livingEntity instanceof Player && !level.isClientSide()) {
            // Check if the player already has the Health Boost effect
            if (livingEntity.hasEffect(MobEffects.HEALTH_BOOST)) {
                // If they have it, do nothing (consume the item but don't apply effect or maybe
                // don't consume?)
                // PRD says: "Attempting to consume... will have no effect."
                // Standard Item.finishUsingItem consumes the item.
                // If we want "no effect", we allow it to be eaten but apply no bonus.
                // To strictly follow "persist until death", we just don't apply it again.
            } else {
                // Apply Health Boost: Amplifier 7 (~ +16 hearts / 32 HP), Duration 1000000
                // ticks (~13.8 hours)
                livingEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000000, 7));
            }
        }

        // Call super to handle hunger/saturation and decrement stack
        return super.finishUsingItem(stack, level, livingEntity);
    }
}
