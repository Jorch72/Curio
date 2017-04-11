package net.darkhax.curio;

import net.darkhax.curio.lib.Constants;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.VERSION_NUMBER)
public class Curio {
    
    @Mod.Instance(Constants.MOD_ID)
    public static Curio instance;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        
    }
}