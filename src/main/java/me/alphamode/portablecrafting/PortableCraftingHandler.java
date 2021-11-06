package me.alphamode.portablecrafting;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.TranslatableText;

public class PortableCraftingHandler extends CraftingScreenHandler {

    public PortableCraftingHandler(int i, PlayerInventory playerInventory, ScreenHandlerContext screenHandlerContext) {
        super(i, playerInventory, screenHandlerContext);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return player.getInventory().contains(PortableCrafting.WORKBENCH);
    }

    public static void openTable(PlayerEntity player) {
        player.openHandledScreen(new SimpleNamedScreenHandlerFactory((syncId, inventory, playerEntity) -> new PortableCraftingHandler(syncId, inventory, ScreenHandlerContext.create(playerEntity.world, playerEntity.getBlockPos())), new TranslatableText("container.crafting")));
        player.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
    }
}
