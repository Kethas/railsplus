package kethas.railsplus.item;

import kethas.railsplus.proxy.CommonProxy;

/**
 * Created by Kethas on 11/02/2017.
 */
public class ItemSteelIngot extends ItemBase {

    public ItemSteelIngot() {
        super("ingot_steel");
        setCreativeTab(CommonProxy.railsPlus);
    }

}
