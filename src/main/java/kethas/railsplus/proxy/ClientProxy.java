package kethas.railsplus.proxy;

import kethas.railsplus.RailsPlus;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Kethas on 11/02/2017.
 */
public class ClientProxy extends CommonProxy {

    public static void registerRenderer(Item item, String name) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(RailsPlus.MODID + ":" + name, "inventory"));
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @SubscribeEvent
    public void onRegisterRenderers(ModelRegistryEvent e) {
        registerRailRenderers();
        registerItemRenderers();
        registerBlockRenderers();
    }


    public void registerItemRenderers() {
        registerRenderer(itemSteelIngot, itemSteelIngot.getName());
        registerRenderer(itemCoke, itemCoke.getName());
    }

    private void registerBlockRenderers() {

    }

    private void registerRailRenderers() {
        registerRenderer(railSteel.getItemBlock(), railSteel.getName());
        registerRenderer(railSteelPowered.getItemBlock(), railSteelPowered.getItemBlock().getRegistryName().getResourcePath());
        registerRenderer(railSteelBrake.getItemBlock(), railSteelBrake.getItemBlock().getRegistryName().getResourcePath());
    }



}
