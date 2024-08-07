package net.awaren.pcu_mod.item;

import net.awaren.pcu_mod.PCUMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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
    public static final RegistryObject<Item> NEODYME_INGOT = ITEMS.register("neodyme_ingot", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    // Ytterbium Ingot
    public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    // Lutecium Ingot
    public static final RegistryObject<Item> LUTECIUM_INGOT = ITEMS.register("lutecium_ingot", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    // Scandium Ingot
    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    // Pyrite Ingot
    public static final RegistryObject<Item> PYRITE_INGOT = ITEMS.register("pyrite_ingot", () -> new Item(new Item.Properties()));

    // Cavalite Ingot
    public static final RegistryObject<Item> CAVALITE_INGOT = ITEMS.register("cavalite_ingot", () -> new Item(new Item.Properties()));

    // Pyregrite Ingot
    public static final RegistryObject<Item> PYREGRITE_INGOT = ITEMS.register("pyregrite_ingot", () -> new Item(new Item.Properties()));

    // Pygalite Ingot
    public static final RegistryObject<Item> PYGALITE_INGOT = ITEMS.register("pygalite_ingot", () -> new Item(new Item.Properties()));

    // Cavarite Ingot
    public static final RegistryObject<Item> CAVARITE_INGOT = ITEMS.register("cavarite_ingot", () -> new Item(new Item.Properties()));

    // Cadinite Ingot
    public static final RegistryObject<Item> CADINITE_INGOT = ITEMS.register("cadinite_ingot", () -> new Item(new Item.Properties()));

    // Negrium Shard
    public static final RegistryObject<Item> NEGRIUM_SHARD = ITEMS.register("negrium_shard", () -> new Item(new Item.Properties()));

    // Regalium Shard
    public static final RegistryObject<Item> REGALIUM_SHARD = ITEMS.register("regalium_shard", () -> new Item(new Item.Properties()));

    // Connerite Shard
    public static final RegistryObject<Item> CONNERITE_SHARD = ITEMS.register("connerite_shard", () -> new Item(new Item.Properties()));

    // Divinite Shard
    public static final RegistryObject<Item> DIVINITE_SHARD = ITEMS.register("divinite_shard", () -> new Item(new Item.Properties()));

    // Negrium
    public static final RegistryObject<Item> NEGRIUM = ITEMS.register("negrium", () -> new Item(new Item.Properties()));

    // Regalium
    public static final RegistryObject<Item> REGALIUM = ITEMS.register("regalium", () -> new Item(new Item.Properties()));

    // Connerite
    public static final RegistryObject<Item> CONNERITE = ITEMS.register("connerite", () -> new Item(new Item.Properties()));

    // Divinite
    public static final RegistryObject<Item> DIVINITE = ITEMS.register("divinite", () -> new Item(new Item.Properties()));

    // Amadeum
    public static final RegistryObject<Item> AMADEUM = ITEMS.register("amadeum", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELBALITE = ITEMS.register("elbalite", () -> new Item(new Item.Properties()));





    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }


}
