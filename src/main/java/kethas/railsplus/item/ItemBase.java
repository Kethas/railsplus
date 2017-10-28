package kethas.railsplus.item;

import kethas.railsplus.RailsPlus;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Kethas on 11/02/2017.
 */
public abstract class ItemBase extends Item {

    private final String name;

    public ItemBase(String name){
        setRegistryName(new ResourceLocation(RailsPlus.MODID, name));
        this.name = name;
        super.setUnlocalizedName(RailsPlus.MODID + "." + name);
    }

    public String getName() {
        return name;
    }
}
