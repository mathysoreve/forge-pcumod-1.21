package net.awaren.pcu_mod.screen;

import net.awaren.pcu_mod.PCUMod;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, PCUMod.MOD_ID);

    public static final RegistryObject<MenuType<EnclumeAlliageMenu>> ENCLUME_ALLIAGE_MENU =
            registerMenuType("enclume_alliage_menu", EnclumeAlliageMenu::new);

    public static final RegistryObject<MenuType<FusionneurMenu>> FUSIONNEUR_MENU =
            registerMenuType("fusionneur_menu", FusionneurMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
