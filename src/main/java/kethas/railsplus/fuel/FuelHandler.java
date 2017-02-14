package kethas.railsplus.fuel;

import kethas.railsplus.proxy.CommonProxy;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

/**
 * Created by Kethas on 12/02/2017.
 */
public class FuelHandler implements IFuelHandler {
    @Override
    public int getBurnTime(ItemStack fuel) {
        return fuel.getItem() == CommonProxy.itemCoke ? 3200 : 0;
    }
}
