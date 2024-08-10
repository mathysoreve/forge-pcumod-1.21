package net.awaren.pcu_mod.painting;

import net.awaren.pcu_mod.PCUMod;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {

    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, PCUMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> IDRIS = PAINTINGS.register("idris", () -> new PaintingVariant(64, 64));

    public static final RegistryObject<PaintingVariant> JNOUNEX = PAINTINGS.register("jnounex", () -> new PaintingVariant(16, 32));

    //public static final RegistryObject<PaintingVariant> ROULROUL = PAINTINGS.register("roulroul", () -> new PaintingVariant(64, 64));

    public static void register(IEventBus eventBus) {
        PAINTINGS.register(eventBus);
    }
}
