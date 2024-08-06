package net.awaren.pcu_mod.item;

import net.awaren.pcu_mod.PCUMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{

    // Liste des items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PCUMod.MOD_ID);

    // Barrium Ingot
    public static final RegistryObject<Item> BARRIUM_INGOT = ITEMS.register("barrium_ingot", () -> new Item(new Item.Properties()));

    // Raw Terbium
    public static final RegistryObject<Item> RAW_TERBIUM = ITEMS.register("raw_terbium", () -> new Item(new Item.Properties()));

    // Malachite
    public static final RegistryObject<Item> MALACHITE = ITEMS.register("malachite", () -> new Item(new Item.Properties()));

    // Neodyme Ingot
    public static final RegistryObject<Item> NEODYME_INGOT = ITEMS.register("neodyme_ingot", () -> new Item(new Item.Properties()));

    // Ytterbium Ingot
    public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot", () -> new Item(new Item.Properties()));

    // Lutecium Ingot
    public static final RegistryObject<Item> LUTECIUM_INGOT = ITEMS.register("lutecium_ingot", () -> new Item(new Item.Properties()));

    // Scandium Ingot
    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }


}
