package net.mcreator.beingmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.IProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.beingmod.block.NoxiousbloomerBlock;
import net.mcreator.beingmod.block.CrystalBeingBlock;
import net.mcreator.beingmod.block.BlockOrcaniteBlock;
import net.mcreator.beingmod.block.BlockBeingBlock;
import net.mcreator.beingmod.block.BeingstaltopBlock;
import net.mcreator.beingmod.block.BeingstalbotBlock;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class BeingSpreadProcedure extends BeingmodModElements.ModElement {
	public BeingSpreadProcedure(BeingmodModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BeingSpread!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BeingSpread!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BeingSpread!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BeingSpread!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.AIR.getDefaultState().getBlock()))
				|| ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
						|| (true))
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
								.getBlock()) || (true))))) {
			if ((!((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == CrystalBeingBlock.block.getDefaultState()
							.getBlock()))
					|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BeingstalbotBlock.block.getDefaultState()
							.getBlock())
							|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BeingstaltopBlock.block
									.getDefaultState().getBlock()))))) {
				if ((Math.random() < 0.2)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
						BlockState _bs = BlockBeingBlock.block.getDefaultState();
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
						BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
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
			}
			if ((!((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BeingstalbotBlock.block.getDefaultState()
							.getBlock()))
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == BeingstaltopBlock.block.getDefaultState()
							.getBlock())))) {
				if ((Math.random() < 0.2)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
						BlockState _bs = BlockBeingBlock.block.getDefaultState();
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
						BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
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
			}
			if ((!((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == CrystalBeingBlock.block.getDefaultState()
							.getBlock()))
					|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BeingstalbotBlock.block.getDefaultState()
							.getBlock())
							|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BeingstaltopBlock.block
									.getDefaultState().getBlock()))))) {
				if ((Math.random() < 0.2)) {
					{
						BlockPos _bp = new BlockPos((int) (x + 1), (int) y, (int) z);
						BlockState _bs = BlockBeingBlock.block.getDefaultState();
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
						BlockPos _bp = new BlockPos((int) (x + 1), (int) y, (int) z);
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
			}
			if ((!((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == CrystalBeingBlock.block.getDefaultState()
							.getBlock()))
					|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BeingstalbotBlock.block.getDefaultState()
							.getBlock())
							|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BeingstaltopBlock.block
									.getDefaultState().getBlock()))))) {
				if ((Math.random() < 0.2)) {
					{
						BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) z);
						BlockState _bs = BlockBeingBlock.block.getDefaultState();
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
						BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) z);
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
			}
			if ((!((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == CrystalBeingBlock.block.getDefaultState()
							.getBlock()))
					|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BeingstalbotBlock.block.getDefaultState()
							.getBlock())
							|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BeingstaltopBlock.block
									.getDefaultState().getBlock()))))) {
				if ((Math.random() < 0.2)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z + 1));
						BlockState _bs = BlockBeingBlock.block.getDefaultState();
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
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z + 1));
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
			}
			if ((!((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == CrystalBeingBlock.block.getDefaultState()
							.getBlock()))
					|| (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BeingstalbotBlock.block.getDefaultState()
							.getBlock())
							|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == BeingstaltopBlock.block
									.getDefaultState().getBlock()))))) {
				if ((Math.random() < 0.2)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z - 1));
						BlockState _bs = BlockBeingBlock.block.getDefaultState();
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
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z - 1));
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
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				if ((Math.random() < 0.2)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
						BlockState _bs = CrystalBeingBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_bs.has(_property))
								_bs = _bs.with(_property, (Comparable) entry.getValue());
						}
						world.setBlockState(_bp, _bs, 3);
					}
				} else if ((Math.random() < 0.4)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
						BlockState _bs = NoxiousbloomerBlock.block.getDefaultState();
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
			if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				if ((Math.random() < 0.2)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
						BlockState _bs = BeingstaltopBlock.block.getDefaultState();
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
