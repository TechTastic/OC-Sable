package io.github.techtastic.ocsable.oc;

import io.github.techtastic.ocsable.init.Items;
import li.cil.oc.api.driver.item.Slot;
import li.cil.oc.api.network.EnvironmentHost;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.prefab.DriverItem;
import net.minecraft.world.item.ItemStack;

public class SableCardDriver extends DriverItem {
    public SableCardDriver() {
        super(Items.SABLE_UPGRADE.toStack());
    }

    @Override
    public ManagedEnvironment createEnvironment(ItemStack stack, EnvironmentHost host) {
        if ((host.getEnvironmentLevel() != null && host.getEnvironmentLevel().isClientSide))
            return null;
        return new SableEnvironment(host);
    }

    @Override
    public String slot(ItemStack stack) {
        return Slot.Card;
    }

    @Override
    public int tier(ItemStack stack) {
        return 2;
    }
}
