package net.awaren.pcu_mod.item;

import net.awaren.pcu_mod.PCUMod;
import net.awaren.pcu_mod.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
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

    // Lutecium Ingot
    public static final RegistryObject<Item> LUTECIUM_INGOT = ITEMS.register("lutecium_ingot", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    // Pyrite Ingot
    public static final RegistryObject<Item> PYRITE_INGOT = ITEMS.register("pyrite_ingot", () -> new Item(new Item.Properties()));

    // Cavalite Ingot
    public static final RegistryObject<Item> CAVALITE_INGOT = ITEMS.register("cavalite_ingot", () -> new Item(new Item.Properties()));

    // Negrium Shard
    public static final RegistryObject<Item> NEGRIUM_SHARD = ITEMS.register("negrium_shard", () -> new Item(new Item.Properties()));

    // Divinite Shard
    public static final RegistryObject<Item> DIVINITE_SHARD = ITEMS.register("divinite_shard", () -> new Item(new Item.Properties()));

    // Negrium
    public static final RegistryObject<Item> NEGRIUM = ITEMS.register("negrium", () -> new Item(new Item.Properties()));

    // Divinite
    public static final RegistryObject<Item> DIVINITE = ITEMS.register("divinite", () -> new Item(new Item.Properties()));

    // Amadeum
    public static final RegistryObject<Item> AMADEUM = ITEMS.register("amadeum", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELBALITE = ITEMS.register("elbalite", () -> new Item(new Item.Properties()));


    // Note : le calcul des ticks c'est:
    // Total des secondes de la musique * 20

    public static final RegistryObject<Item> PCU_THEME_DISC = ITEMS.register("pcu_theme_disc",
            () -> new RecordItem(6, ModSounds.PCU_THEME_SONG, new Item.Properties().stacksTo(1), 3980));

    public static final RegistryObject<Item> EL_MARIACHI_DISC = ITEMS.register("el_mariachi_disc",
            () -> new RecordItem(6, ModSounds.EL_MARIACHI_SONG, new Item.Properties().stacksTo(1), 4780));

    public static final RegistryObject<Item> LCP_THEME_DISC = ITEMS.register("lcp_theme_disc",
            () -> new RecordItem(6, ModSounds.LCP_THEME_SONG, new Item.Properties().stacksTo(1), 960));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }


}
