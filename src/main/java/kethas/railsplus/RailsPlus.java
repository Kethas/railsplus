package kethas.railsplus;

import kethas.railsplus.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Kethas on 11/02/2017.
 */
@Mod(modid = RailsPlus.MODID, name = RailsPlus.NAME, version = RailsPlus.VERSION)
public class RailsPlus {

    public static final String MODID = "railsplus";
    public static final String NAME = "Rails Plus";
    public static final String VERSION = "1.0.2";

    @SidedProxy(clientSide = "kethas.railsplus.proxy.ClientProxy", serverSide = "kethas.railsplus.proxy.ServerProxy", modId = MODID)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }



}
