package kethas.railsplus.tabs;

import kethas.railsplus.RailsPlus;
import kethas.railsplus.item.InitItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RailsPlusTabNormal extends CreativeTabs {

	private static Item itemIcon;
	
	public RailsPlusTabNormal() {
		super(RailsPlus.MODID + "_tab_normal");
		setBackgroundImageName("item_search.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(InitItems.itemSteelNugget);
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
}