package net.mcreator.beingmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.IProperty;
import net.minecraft.block.BlockState;

import net.mcreator.beingmod.block.StalstopBlock;
import net.mcreator.beingmod.block.BeingstaltopBlock;
import net.mcreator.beingmod.block.BeingstalbotBlock;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class BeingStalGrowthProcedure extends BeingmodModElements.ModElement {
	public BeingStalGrowthProcedure(BeingmodModElements instance) {
		super(instance, 15);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BeingStalGrowth!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BeingStalGrowth!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BeingStalGrowth!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BeingStalGrowth!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).isSolid())
				&& (world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z)).isSolid())))) {
			if ((!((world.getBlockState(new BlockPos((int) x, (int) (y + 6), (int) z))).getBlock() == BeingstaltopBlock.block.getDefaultState()
					.getBlock()))) {
				if ((Math.random() < 0.2)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
						BlockState _bs = BeingstalbotBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_bs.has(_property))
								_bs = _bs.with(_property, (Comparable) entry.getValue());
						}
						world.setBlockState(_bp, _bs, 3);
					}
				} else {
					if ((Math.random() < 0.2)) {
						{
							BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
							BlockState _bs = StalstopBlock.block.getDefaultState();
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
