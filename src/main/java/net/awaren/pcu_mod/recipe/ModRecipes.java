package net.awaren.pcu_mod.recipe;

import net.awaren.pcu_mod.PCUMod;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, PCUMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<EnclumeAlliageRecipe>> ENCLUME_ALLIAGE_SERIALIZER =
            SERIALIZERS.register("enclume_alliage", () -> EnclumeAlliageRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<FusionneurRecipe>> FUSIONNEUR_SERIALIZER =
            SERIALIZERS.register("fusionneur", () -> FusionneurRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }

}
