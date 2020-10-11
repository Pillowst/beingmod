package net.mcreator.beingmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.IProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class WebpotionBulletHitsLivingEntityProcedure extends BeingmodModElements.ModElement {
	public WebpotionBulletHitsLivingEntityProcedure(BeingmodModElements instance) {
		super(instance, 51);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure WebpotionBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure WebpotionBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure WebpotionBulletHitsLivingEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure WebpotionBulletHitsLivingEntity!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 0))).isSolid()))) {
			{
				BlockPos _bp = new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 0));
				BlockState _bs = Blocks.COBWEB.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_bs.has(_property))
						_bs = _bs.with(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if ((!(world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0))).isSolid()))) {
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y + 0), (int) (z + 0));
				BlockState _bs = Blocks.COBWEB.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_bs.has(_property))
						_bs = _bs.with(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if ((!(world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 0))).isSolid()))) {
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 0));
				BlockState _bs = Blocks.COBWEB.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_bs.has(_property))
						_bs = _bs.with(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if ((!(world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0))).isSolid()))) {
			{
				BlockPos _bp = new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0));
				BlockState _bs = Blocks.COBWEB.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_bs.has(_property))
						_bs = _bs.with(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if ((!(world.getBlockState(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0))).isSolid()))) {
			{
				BlockPos _bp = new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0));
				BlockState _bs = Blocks.COBWEB.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_bs.has(_property))
						_bs = _bs.with(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if ((!(world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 1))).isSolid()))) {
			{
				BlockPos _bp = new BlockPos((int) (x + 0), (int) (y + 0), (int) (z + 1));
				BlockState _bs = Blocks.COBWEB.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_bs.has(_property))
						_bs = _bs.with(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if ((!(world.getBlockState(new BlockPos((int) (x + 0), (int) (y + 0), (int) (z - 1))).isSolid()))) {
			{
				BlockPos _bp = new BlockPos((int) (x + 0), (int) (y + 0), (int) (z - 1));
				BlockState _bs = Blocks.COBWEB.getDefaultState();
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
