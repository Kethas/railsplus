package kethas.railsplus.proxy;

import kethas.railsplus.fuel.FuelHandler;
import kethas.railsplus.item.ItemCoke;
import kethas.railsplus.item.ItemSteelIngot;
import kethas.railsplus.rail.RailSteel;
import kethas.railsplus.rail.RailSteelPowered;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by Kethas on 11/02/2017.
 */
public class CommonProxy {

    public static FuelHandler fuelHandler;

    //creative tabs
    public static CreativeTabs railsPlus;
    public static CreativeTabs railsPlusTransportation;

    //items
    public static ItemSteelIngot itemSteelIngot;
    public static ItemCoke itemCoke;

    //rails
    public static RailSteel railSteel;
    public static RailSteelPowered railSteelPowered;

    public void preInit(FMLPreInitializationEvent event) {
        railsPlus = new CreativeTabs("railsplus.general") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(itemSteelIngot);
            }
        };

        railsPlusTransportation = new CreativeTabs("railsplus.transportation") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(ItemBlock.getItemFromBlock(railSteelPowered));
            }
        };

        itemSteelIngot = new ItemSteelIngot();
        itemCoke = new ItemCoke();

        railSteel = new RailSteel();
        railSteelPowered = new RailSteelPowered();

        fuelHandler = new FuelHandler();
        GameRegistry.registerFuelHandler(fuelHandler);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void init(FMLInitializationEvent event) {
        registerRecipes();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    protected void onRegisterItems(RegistryEvent.Register<Item> e) {
        IForgeRegistry<Item> registry = e.getRegistry();

        registry.register(itemSteelIngot);

        registry.register(itemCoke);

        registry.register(railSteel.getItemBlock());
        registry.register(railSteelPowered.getItemBlock());
    }

    @SubscribeEvent
    protected void onRegisterBlocks(RegistryEvent.Register<Block> e) {
        IForgeRegistry<Block> registry = e.getRegistry();

        registry.register(railSteel);
        registry.register(railSteelPowered);
    }

    protected void registerRecipes() {
        OreDictionary.registerOre("ingotSteel", itemSteelIngot);
        OreDictionary.registerOre("coke", itemCoke);

        GameRegistry.addSmelting(Items.COAL, new ItemStack(itemCoke, 1), 0);
        GameRegistry.addSmelting(Items.IRON_INGOT, new ItemStack(itemSteelIngot, 1), 0);
    }
}
