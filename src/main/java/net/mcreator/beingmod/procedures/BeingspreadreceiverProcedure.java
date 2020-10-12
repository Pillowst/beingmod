package net.mcreator.beingmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.state.IProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.beingmod.block.NeriumoreBlock;
import net.mcreator.beingmod.block.BlockOrcaniteBlock;
import net.mcreator.beingmod.block.BlockBeingBlock;
import net.mcreator.beingmod.block.BeingredstoneBlock;
import net.mcreator.beingmod.block.BeinglapisBlock;
import net.mcreator.beingmod.block.BeingironBlock;
import net.mcreator.beingmod.block.BeinggoldBlock;
import net.mcreator.beingmod.block.BeingemeraldBlock;
import net.mcreator.beingmod.block.BeingdiamondBlock;
import net.mcreator.beingmod.block.BeingcoalBlock;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class BeingspreadreceiverProcedure extends BeingmodModElements.ModElement {
	public BeingspreadreceiverProcedure(BeingmodModElements instance) {
		super(instance, 28);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Beingspreadreceiver!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Beingspreadreceiver!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Beingspreadreceiver!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Beingspreadreceiver!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).isSolid())) {
			if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("Being_Mod:Being").toLowerCase(java.util.Locale.ENGLISH)))
					.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())))) {
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlockHardness(world,
						new BlockPos((int) x, (int) y, (int) z))) < 2)) {
					if ((Math.random() < 0.2)) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = BlockBeingBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					} else if ((Math.random() < 0.01)) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = NeriumoreBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					} else {
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = BlockOrcaniteBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.COAL_ORE.getDefaultState()
						.getBlock())) {
					if ((Math.random() < 0.2)) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = BeingcoalBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.IRON_ORE.getDefaultState()
						.getBlock())) {
					if ((Math.random() < 0.2)) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = BeingironBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GOLD_ORE.getDefaultState()
						.getBlock())) {
					if ((Math.random() < 0.2)) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = BeinggoldBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.DIAMOND_ORE.getDefaultState()
						.getBlock())) {
					if ((Math.random() < 0.2)) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = BeingdiamondBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.EMERALD_ORE.getDefaultState()
						.getBlock())) {
					if ((Math.random() < 0.2)) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = BeingemeraldBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.LAPIS_ORE.getDefaultState()
						.getBlock())) {
					if ((Math.random() < 0.2)) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = BeinglapisBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.REDSTONE_ORE.getDefaultState()
						.getBlock())) {
					if ((Math.random() < 0.2)) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							BlockState _bs = BeingredstoneBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					}
				}
			}
		}
	}
}
