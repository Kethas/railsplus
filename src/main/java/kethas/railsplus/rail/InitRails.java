package kethas.railsplus.rail;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;

public class InitRails {
	public static Block railSteelPowered = new RailsPowered("rail_steel_powered");
	public static Block railSteel = new RailsUnpowered("rail_steel");
	public static List<Block> RAILS = Lists.newArrayList(
		railSteelPowered,
		railSteel
	);
}