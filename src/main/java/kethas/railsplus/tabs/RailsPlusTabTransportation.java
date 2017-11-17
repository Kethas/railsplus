package kethas.railsplus.tabs;

import kethas.railsplus.RailsPlus;
import kethas.railsplus.rail.InitRails;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RailsPlusTabTransportation extends CreativeTabs {
	
	public RailsPlusTabTransportation() {
		super(RailsPlus.MODID + "_tab_transportation");
		setBackgroundImageName("item_search.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(InitRails.railSteel));
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
}
