package kethas.railsplus.init;

import kethas.railsplus.block.InitBlocks;
import kethas.railsplus.client.IHasModel;
import kethas.railsplus.item.InitItems;
import kethas.railsplus.rail.InitRails;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/*
 * Shadows_of_Fire helped me quite a bit with my own mods and this was a class
 * he used quite frequently. I had to figure out what was going on through osmosis.
 * This class uses @ annotations to the tell compiler that there is another entry point
 * into the mod. You might already be familiary with SubscriberEvents, but what it does
 * is that when Minecraft needs to know how to register a thing, it comes here to look for
 * the code we told it to use.
 * 
 * - Kreezxil 11/6/2017
 */
@EventBusSubscriber
public class Registrar {

	@SubscribeEvent
	public static void onItemRegister(Register<Item> event) {
		for (Item item : InitItems.ITEMS) {
			event.getRegistry().register(item);
		}
	}

	@SubscribeEvent
	public static void onBlockRegister(Register<Block> event) {
		for (Block block : InitBlocks.BLOCKS) {
			event.getRegistry().register(block);
			ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
			
		}
		for (Block block : InitRails.RAILS) {
			event.getRegistry().register(block);
			ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
	}

	/*
	 * This bit of code is going to use a strange implementation that I have yet to
	 * wrap my brain around. But it tells the client you have a model for it to use.
	 * 
	 * In some ways I feel 1.12.x is a bit more complicated and in others I feel it
	 * is more simple.
	 * 
	 * I think they are trying to lean towards simplicity so that more people can do
	 * modding.
	 * 
	 * - Kreezxil 11/6/2017
	 */
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent e) {
		for (Item i : InitItems.ITEMS) {
			if (i instanceof IHasModel)
				((IHasModel) i).registerModels();
		}
		for (Block b : InitBlocks.BLOCKS) {
			if (b instanceof IHasModel)
				((IHasModel) b).registerModels();
		}
		for (Block b : InitRails.RAILS) {
			if (b instanceof IHasModel)
				((IHasModel) b).registerModels();
		}
	}

}
