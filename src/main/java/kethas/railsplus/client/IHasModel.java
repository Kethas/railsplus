package kethas.railsplus.client;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IHasModel {

	/*
	 * It's really quite amazing, there is like nothing here. Almost.
	 * 
	 * - Kreezxil 11/6/2017
	 */
	@SideOnly(Side.CLIENT)
	public void registerModels();

}
