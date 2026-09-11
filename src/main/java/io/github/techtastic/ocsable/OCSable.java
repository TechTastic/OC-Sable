package io.github.techtastic.ocsable;

import io.github.techtastic.ocsable.init.Items;
import io.github.techtastic.ocsable.oc.JOMLConverter;
import io.github.techtastic.ocsable.oc.SableCardDriver;
import io.github.techtastic.ocsable.oc.SableConverters;
import li.cil.oc.Constants;
import li.cil.oc.OpenComputers;
import li.cil.oc.api.Driver;
import li.cil.oc.api.Manual;
import li.cil.oc.api.manual.ContentProvider;
import li.cil.oc.api.manual.PathProvider;
import li.cil.oc.api.manual.TabIconRenderer;
import li.cil.oc.api.prefab.ResourceContentProvider;
import li.cil.oc.api.prefab.SpriteTabIconRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.LanguageInfo;
import net.minecraft.client.resources.language.LanguageManager;
import net.minecraft.core.BlockPos;
import net.minecraft.locale.Language;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.server.LanguageHook;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

import java.util.List;
import java.util.Objects;

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

    @EventBusSubscriber(value = { Dist.CLIENT })
    static class Client {
        @SubscribeEvent
        private static void commonSetup(FMLCommonSetupEvent event) {
            event.enqueueWork( () -> {
                li.cil.oc.api.Items.registerStack(Items.SABLE_UPGRADE.toStack(), "", Constants.SectionName$.MODULE$.Component());

                Manual.addProvider(new PathProvider() {
                    @Override
                    public String pathFor(ItemStack stack) {
                        if (stack.is(Items.SABLE_UPGRADE.asItem()))
                            return "ocsable";
                        return null;
                    }

                    @Override
                    public String pathFor(Level world, BlockPos pos) {
                        return null;
                    }
                });

                Manual.addProvider(new ResourceContentProvider(MODID, "doc/"));

                Manual.addTab(graphics -> graphics.renderFakeItem(Items.SABLE_UPGRADE.toStack(), 0, 0), "tab.ocsable.manual", "ocsable/%LANGUAGE%/index.md");
            });
        }
    }
}
