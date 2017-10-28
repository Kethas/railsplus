package kethas.railsplus.rail;

import kethas.railsplus.proxy.CommonProxy;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;

/**
 * Created by Kethas on 11/02/2017.
 */
public class RailSteel extends RailBase {

    public RailSteel() {
        super("rail_steel");
        setCreativeTab(CommonProxy.railsPlusTransportation);
    }

    @Override
    public float getRailMaxSpeed(World world, EntityMinecart cart, BlockPos pos) {
        return super.getRailMaxSpeed(world, cart, pos) * 2;
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);

        boolean shift = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
        if (!shift){
            tooltip.add("\u00A79[SHIFT] for more info");
        }else {
            tooltip.add("\u00A79Information:");
            tooltip.add("\u00A79Rail Material: Steel");
            tooltip.add("\u00A79Sleeper Material: Wood");
            tooltip.add("\u00A79Speed: 2 x Vanilla Rails");
            tooltip.add("\u00A79Bugginess: Buggy");
        }
    }
}
