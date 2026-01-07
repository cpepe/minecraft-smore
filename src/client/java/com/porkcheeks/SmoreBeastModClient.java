package com.porkcheeks;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import com.porkcheeks.item.ChocolateBarItem;
import net.minecraft.item.ItemStack;
import java.util.List;

public class SmoreBeastModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.

		// ItemTooltipCallback.EVENT.register((ItemStack stack, Item.TooltipContext context, Item.TooltipContext.Type type, List<Text> lines) -> {
		// 	if (stack.getItem() instanceof ChocolateBarItem) {
		// 		lines.add(Text.literal("This is a chocolate bar. Eat it, or find something else for it to do").formatted(Formatting.GRAY));
		// 	}
		// });
	}	
}

