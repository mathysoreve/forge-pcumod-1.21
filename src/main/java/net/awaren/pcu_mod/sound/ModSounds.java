package net.awaren.pcu_mod.sound;

import net.awaren.pcu_mod.PCUMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PCUMod.MOD_ID);

    // Music
    public static final RegistryObject<SoundEvent> PCU_THEME_SONG = registerSoundEvents("pcu_theme_song");
    public static final RegistryObject<SoundEvent> EL_MARIACHI_SONG = registerSoundEvents("el_mariachi_song");
    public static final RegistryObject<SoundEvent> LCP_THEME_SONG = registerSoundEvents("lcp_theme_song");

    public static final RegistryObject<SoundEvent> BLOOD_FLAVOURED_ROMANCE_SONG = registerSoundEvents("blood_flavoured_romance_song");
    public static final RegistryObject<SoundEvent> LOVE_AT_LAST_SIGHT_SONG = registerSoundEvents("love_at_last_sight_song");
    public static final RegistryObject<SoundEvent> NOT_GUILTY_SONG = registerSoundEvents("not_guilty_song");

    public static final RegistryObject<SoundEvent> REGEDIT_SONG = registerSoundEvents("regedit_song");
    public static final RegistryObject<SoundEvent> PCU_THEME_PERSO_SONG = registerSoundEvents("pcu_theme_perso_song");

    // Mob Sounds

    // Archibot
    public static final RegistryObject<SoundEvent> ARCHIBOT_AMBIENT = registerSoundEvents("archibot_ambient");
    public static final RegistryObject<SoundEvent> ARCHIBOT_HURT = registerSoundEvents("archibot_hurt");
    public static final RegistryObject<SoundEvent> ARCHIBOT_DEATH = registerSoundEvents("archibot_death");
    public static final RegistryObject<SoundEvent> ARCHIBOT_STEP = registerSoundEvents("archibot_step");

    // Archisentinel
    public static final RegistryObject<SoundEvent> ARCHISENTINEL_AMBIENT = registerSoundEvents("archisentinel_ambient");
    public static final RegistryObject<SoundEvent> ARCHISENTINEL_HURT = registerSoundEvents("archisentinel_hurt");
    public static final RegistryObject<SoundEvent> ARCHISENTINEL_DEATH = registerSoundEvents("archisentinel_death");
    public static final RegistryObject<SoundEvent> ARCHISENTINEL_STEP = registerSoundEvents("archisentinel_step");


    public static final RegistryObject<SoundEvent> GUN_FIRE = registerSoundEvents("gun_fire");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PCUMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
