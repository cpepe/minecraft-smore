package com.brickersnapper.smores;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.Optional;

public class ModVillagerTrades {
    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
            factories.add((entity, random) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    Optional.empty(),
                    new ItemStack(ModItems.CINNAMON, 1),
                    10,
                    2,
                    0.05f));
        });
    }
}
