package kethas.railsplus.proxy;

import kethas.railsplus.RailsPlus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Kethas on 11/02/2017.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        registerRailRenderers();
        registerItemRenderers();
        registerBlockRenderers();
    }

    private void registerRailRenderers() {
        registerRenderer(railSteel.getItemBlock(), railSteel.getName());
        registerRenderer(itemBlockRailSteelPowered, itemBlockRailSteelPowered.getRegistryName().getResourcePath());
    }


    public void registerItemRenderers() {
        registerRenderer(itemSteelIngot, itemSteelIngot.getName());
        registerRenderer(itemCoke, itemCoke.getName());
    }

    private void registerBlockRenderers() {

    }

    public static void registerRenderer(Item item, String name)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(item, 0, new ModelResourceLocation(RailsPlus.MODID + ":" + name, "inventory"));
    }



}
