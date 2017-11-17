package kethas.railsplus.item;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class InitItems {
	//base classes are now more generalized so that we can easily create all kinds of
	//rails based on all kinds materials
	//the same for fuels
	//ingots and nuggets
    public static final Item itemSteelIngot = new ItemIngot("ingot_steel", Material.IRON);
    public static final Item itemCoke = new ItemFuel("coke");
    public static final Item itemSteelNugget = new ItemNugget("nugget_steel", Material.IRON);
    public static List<Item> ITEMS = Lists.newArrayList(
    	itemSteelIngot,
    	itemCoke,
    	itemSteelNugget
    );
}