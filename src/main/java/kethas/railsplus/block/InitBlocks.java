package kethas.railsplus.block;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class InitBlocks {
	public static final Block blockSteel = new BlockSteel("block_steel", Material.ANVIL);
	public static final Block blockBlastFurnace = new BlockBlastFurnace(false);
	public static List<Block> BLOCKS = Lists.newArrayList(
		blockSteel,
		blockBlastFurnace
	);
}