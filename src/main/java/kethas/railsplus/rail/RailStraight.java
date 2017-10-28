package kethas.railsplus.rail;

import net.minecraft.block.BlockRailBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;

/**
 * Created by Kethas on 11/02/2017.
 */
public abstract class RailStraight extends RailBase{

    PropertyEnum<EnumRailDirection> SHAPE = PropertyEnum.create("shape", EnumRailDirection.class, EnumRailDirection.ASCENDING_NORTH, EnumRailDirection.ASCENDING_SOUTH, EnumRailDirection.ASCENDING_EAST, EnumRailDirection.ASCENDING_WEST);

    protected RailStraight(String name) {
        super(name);
    }

    @Override
    public IProperty<BlockRailBase.EnumRailDirection> getShapeProperty() {
        return SHAPE;
    }
}
