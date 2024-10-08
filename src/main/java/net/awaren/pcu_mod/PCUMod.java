package net.awaren.pcu_mod;

import com.mojang.logging.LogUtils;
import net.awaren.pcu_mod.block.ModBlocks;
import net.awaren.pcu_mod.block.entity.ModBlockEntities;
import net.awaren.pcu_mod.entity.ModEntities;
import net.awaren.pcu_mod.entity.client.archibot.ArchibotEntityRenderer;
import net.awaren.pcu_mod.entity.client.archibullet.ArchibulletProjectileEntityRenderer;
import net.awaren.pcu_mod.entity.client.archisentinel.ArchisentinelEntityRenderer;
import net.awaren.pcu_mod.item.ModCreativeModeTabs;
import net.awaren.pcu_mod.item.ModItems;
import net.awaren.pcu_mod.painting.ModPaintings;
import net.awaren.pcu_mod.recipe.ModRecipes;
import net.awaren.pcu_mod.screen.EnclumeAlliageScreen;
import net.awaren.pcu_mod.screen.FusionneurScreen;
import net.awaren.pcu_mod.screen.ModMenuTypes;
import net.awaren.pcu_mod.sound.ModSounds;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PCUMod.MOD_ID)
public class PCUMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "pcu_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public PCUMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        // Register the items
        ModItems.register(modEventBus);

        // Register the blocks
        ModBlocks.register(modEventBus);

        // Register the sounds
        ModSounds.register(modEventBus);

        // Register the entities
        ModEntities.register(modEventBus);

        // Register the paintings
        ModPaintings.register(modEventBus);

        // Register the block entities
        ModBlockEntities.register(modEventBus);

        // Register the menu types
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            MenuScreens.register(ModMenuTypes.ENCLUME_ALLIAGE_MENU.get(), EnclumeAlliageScreen::new);

            MenuScreens.register(ModMenuTypes.FUSIONNEUR_MENU.get(), FusionneurScreen::new);

            EntityRenderers.register(ModEntities.ARCHIBOT.get(), ArchibotEntityRenderer::new);
            EntityRenderers.register(ModEntities.ARCHISENTINEL.get(), ArchisentinelEntityRenderer::new);
            EntityRenderers.register(ModEntities.ARCHIBULLET_PROJECTILE.get(), ArchibulletProjectileEntityRenderer::new);
        }
    }
}
