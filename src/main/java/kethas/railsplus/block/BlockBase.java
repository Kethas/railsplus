package kethas.railsplus.block;

import kethas.railsplus.RailsPlus;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Kethas on 11/02/2017.
 */
public abstract class BlockBase extends Block{

    private final String name;

    protected final ItemBlock itemBlock;

    public BlockBase(String name, Material materialIn) {
        super(materialIn);
        setUnlocalizedName(name);
        setRegistryName(new ResourceLocation(RailsPlus.MODID, name));
        this.name = name;
        itemBlock = new ItemBlock(this);
        itemBlock.setRegistryName(name);
        itemBlock.setUnlocalizedName(name);
    }

    public BlockBase(String name, Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
        setUnlocalizedName(name);
        setRegistryName(new ResourceLocation(RailsPlus.MODID, name));
        this.name = name;
        itemBlock = new ItemBlock(this);
        itemBlock.setRegistryName(name);
        itemBlock.setUnlocalizedName(name);
    }

    public String getName() {
        return name;
    }

    public ItemBlock getItemBlock(){
        return itemBlock;
    }
}
