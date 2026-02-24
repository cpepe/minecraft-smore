package com.brickersnapper.smores;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

public class ModVillagerTrades {
    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 1, factories -> {
            factories.add(new VillagerTrades.ItemsForEmeralds(ModItems.CINNAMON, 1, 1, 10, 2));
        });
    }
}
