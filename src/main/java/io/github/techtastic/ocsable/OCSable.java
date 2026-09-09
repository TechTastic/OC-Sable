package io.github.techtastic.ocsable;

import io.github.techtastic.ocsable.init.Items;
import io.github.techtastic.ocsable.oc.JOMLConverter;
import io.github.techtastic.ocsable.oc.SableCardDriver;
import io.github.techtastic.ocsable.oc.SableConverters;
import li.cil.oc.api.Driver;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(OCSable.MODID)
public class OCSable {
    public static final String MODID = "ocsable";
    public static final Logger LOGGER = LogUtils.getLogger();

    public OCSable(IEventBus modEventBus, ModContainer modContainer) {
        Items.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Driver.add(new SableCardDriver());
            Driver.add(new JOMLConverter());
            Driver.add(new SableConverters());
        });
    }
}
