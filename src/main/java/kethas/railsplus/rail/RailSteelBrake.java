package kethas.railsplus.rail;

import kethas.railsplus.RailsPlus;
import kethas.railsplus.proxy.CommonProxy;
import net.minecraft.block.BlockRailPowered;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class RailSteelBrake extends BlockRailPowered {

    private ItemBlock itemBlock;

    public RailSteelBrake() {
        super();
        setRegistryName(new ResourceLocation(RailsPlus.MODID, "rail_steel_brake"));
        setUnlocalizedName(RailsPlus.MODID + ".rail_steel_brake");
        setCreativeTab(CommonProxy.railsPlusTransportation);

        itemBlock = new ItemBlock(this);
        itemBlock.setRegistryName(new ResourceLocation(RailsPlus.MODID, "rail_steel_brake"));
        itemBlock.setUnlocalizedName(RailsPlus.MODID + ".rail_steel_brake");
    }

    @Override
    public float getRailMaxSpeed(World world, EntityMinecart cart, BlockPos pos) {
        return super.getRailMaxSpeed(world, cart, pos) * 2;
    }

    @Override
    public void onMinecartPass(World world, EntityMinecart cart, BlockPos pos) {
        if (!world.getBlockState(pos).getValue(BlockRailPowered.POWERED))
            return;

        double d15 = Math.sqrt(cart.motionX * cart.motionX + cart.motionZ * cart.motionZ);

        if (d15 > 0.01D) {
            cart.motionX -= cart.motionX / d15 * 0.06D;
            cart.motionZ -= cart.motionZ / d15 * 0.06D;
        } else {
            cart.motionX = 0;
            cart.motionY = 0;
            cart.motionZ = 0;
        }
    }

    @Override
    public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);

        tooltip.add("\u00A7cSlows down minecarts when powered");

        boolean shift = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
        if (!shift) {
            tooltip.add("\u00A79[SHIFT] for more info");
        } else {
            tooltip.add("\u00A79Information:");
            tooltip.add("\u00A79Rail Material: Steel");
            tooltip.add("\u00A79Sleeper Material: Wood");
            tooltip.add("\u00A79Speed: 2 x Vanilla Rails");
            tooltip.add("\u00A79Bugginess: Buggy");
        }
    }

    public ItemBlock getItemBlock() {
        return itemBlock;
    }
}