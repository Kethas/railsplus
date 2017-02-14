package kethas.railsplus.proxy;

import kethas.railsplus.fuel.FuelHandler;
import kethas.railsplus.item.ItemCoke;
import kethas.railsplus.item.ItemSteelIngot;
import kethas.railsplus.rail.RailSteel;
import kethas.railsplus.rail.RailSteelPowered;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

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

    //itemblocks
    public static ItemBlock itemBlockRailSteelPowered;

    //rails
    public static RailSteel railSteel;
    public static RailSteelPowered railSteelPowered;

    public void preInit(FMLPreInitializationEvent event){
        railsPlus = new CreativeTabs("rails_plus") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(itemSteelIngot);
            }
        };

        railsPlusTransportation = new CreativeTabs("rails_plus_transportation") {
            @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(ItemBlock.getItemFromBlock(railSteelPowered));
            }
        };

        fuelHandler = new FuelHandler();
        GameRegistry.registerFuelHandler(fuelHandler);

        registerItems();
        registerRails();
        registerBlocks();
    }

    public void init(FMLInitializationEvent event){
        registerRecipes();
    }

    public void postInit(FMLPostInitializationEvent event){

    }

    protected void registerRails(){
        railSteel = new RailSteel();
        GameRegistry.register(railSteel);
        GameRegistry.register(railSteel.getItemBlock());

        railSteelPowered = new RailSteelPowered();
        GameRegistry.register(railSteelPowered);
        itemBlockRailSteelPowered = getItemBlockFromBlock(railSteelPowered);
        GameRegistry.register(itemBlockRailSteelPowered);

    }

    protected void registerItems(){
        itemSteelIngot = new ItemSteelIngot();
        GameRegistry.register(itemSteelIngot);

        itemCoke = new ItemCoke();
        GameRegistry.register(itemCoke);
    }

    protected void registerBlocks(){

    }

    protected void registerRecipes(){
        OreDictionary.registerOre("ingotSteel", itemSteelIngot);
        OreDictionary.registerOre("coke", itemCoke);

        GameRegistry.addRecipe(new ItemStack(railSteel, 5),
                "S S",
                         "SWS",
                         "S S",
                         'S', itemSteelIngot,
                         'W', Items.STICK);

        GameRegistry.addRecipe(new ItemStack(railSteelPowered, 5),
                "RTR",
                "BTB",
                "RTR",
                'R', Items.REDSTONE,
                'T', railSteel,
                'B', Items.BLAZE_POWDER);

        GameRegistry.addSmelting(Items.COAL, new ItemStack(itemCoke, 1), 0);
        GameRegistry.addSmelting(Items.IRON_INGOT, new ItemStack(itemSteelIngot, 1), 0);
    }

    private static ItemBlock getItemBlockFromBlock(Block block){
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName().getResourcePath());
        itemBlock.setUnlocalizedName(block.getRegistryName().getResourcePath());
        return itemBlock;
    }


}
