package kethas.railsplus.rail;

import kethas.railsplus.RailsPlus;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRailBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Kethas on 11/02/2017.
 */
public abstract class RailBase extends BlockRailBase {

    private final String name;

    protected final ItemBlock itemBlock;

    public static final PropertyEnum<BlockRailBase.EnumRailDirection> SHAPE = PropertyEnum.create("shape", BlockRailBase.EnumRailDirection.class);

    public RailBase(String name) {
        super(false);
        setDefaultState(this.blockState.getBaseState().withProperty(getShapeProperty(), BlockRailBase.EnumRailDirection.NORTH_SOUTH));
        setUnlocalizedName(RailsPlus.MODID + "." + name);
        setRegistryName(new ResourceLocation(RailsPlus.MODID, name));
        this.name = name;
        itemBlock = new ItemBlock(this);
        itemBlock.setRegistryName(new ResourceLocation(RailsPlus.MODID, name));
        itemBlock.setUnlocalizedName(RailsPlus.MODID + "." + name);
    }

    @Override
    public IProperty<EnumRailDirection> getShapeProperty() {
        return SHAPE;
    }

    @Override
    protected void updateState(IBlockState p_189541_1_, World p_189541_2_, BlockPos p_189541_3_, Block p_189541_4_) {

    }

    public ItemBlock getItemBlock(){
        return itemBlock;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, getShapeProperty());
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(getShapeProperty()).getMetadata();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(getShapeProperty(), BlockRailBase.EnumRailDirection.byMetadata(meta));
    }

    public String getName() {
        return name;
    }
}
