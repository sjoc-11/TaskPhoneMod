package com.santi.taskphone.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.client.player.ClientPlayerBlockBreakEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import com.santi.taskphone.item.TaskPhoneItem;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.util.ActionResult;

public class TaskPhoneClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            ItemStack stack = player.getStackInHand(hand);
            if (stack.getItem() instanceof TaskPhoneItem) {
                MinecraftClient.getInstance().setScreen(new TaskPhoneScreen());
            }
            return ActionResult.PASS;
        });
    }
}