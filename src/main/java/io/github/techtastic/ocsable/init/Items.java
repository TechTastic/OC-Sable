package io.github.techtastic.ocsable.init;

import li.cil.oc.Constants;
import li.cil.oc.client.KeyBindings;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static io.github.techtastic.ocsable.OCSable.MODID;

public class Items {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredItem<Item> SABLE_UPGRADE =
            ITEMS.register("sable_card", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    if (tooltipFlag.hasShiftDown() || tooltipFlag.isAdvanced()) {
                        tooltipComponents.add(Component.translatable("item.ocsable.sable_card.tooltip").withStyle(ChatFormatting.GRAY));
                    } else {
                        tooltipComponents.add(Component.translatable("ocsable.tooltip.toolong", KeyBindings.extendedTooltip().getKey().getDisplayName()));
                    }
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
