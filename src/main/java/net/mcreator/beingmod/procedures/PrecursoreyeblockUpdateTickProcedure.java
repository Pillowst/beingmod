package net.mcreator.beingmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.state.IProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.BlockState;

import net.mcreator.beingmod.block.PrecursoreyeblockdullBlock;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;
import java.util.Comparator;

@BeingmodModElements.ModElement.Tag
public class PrecursoreyeblockUpdateTickProcedure extends BeingmodModElements.ModElement {
	public PrecursoreyeblockUpdateTickProcedure(BeingmodModElements instance) {
		super(instance, 173);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PrecursoreyeblockUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PrecursoreyeblockUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PrecursoreyeblockUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PrecursoreyeblockUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double L = 0;
		double ML = 0;
		L = (double) 1;
		if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.NORTH)) {
			while ((((L) > 20) || (!(world.getBlockState(new BlockPos((int) (x - 0), (int) y, (int) (z - (L)))).isSolid())))) {
				if (((world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB((x - 0) - (1 / 2d), y - (1 / 2d), (z - (L)) - (1 / 2d), (x - 0) + (1 / 2d), y + (1 / 2d),
										(z - (L)) + (1 / 2d)),
								null)
						.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq((x - 0), y, (z - (L))))).findFirst()
						.orElse(null)) != null)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = PrecursoreyeblockdullBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_bs.has(_property))
								_bs = _bs.with(_property, (Comparable) entry.getValue());
						}
						world.setBlockState(_bp, _bs, 3);
					}
					ML = (double) 1;
					for (int index1 = 0; index1 < (int) ((L)); index1++) {
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d((x - 0), y, (z - (ML))), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/particle minecraft:dust 1 0.7 0 1 ~ ~ ~");
						}
						ML = (double) (1 + (ML));
					}
				} else {
					L = (double) (1 + (L));
				}
			}
		}
		if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.SOUTH)) {
			while ((((L) > 20) || (!(world.getBlockState(new BlockPos((int) (x - 0), (int) y, (int) (z + (L)))).isSolid())))) {
				if (((world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB((x - 0) - (1 / 2d), y - (1 / 2d), (z + (L)) - (1 / 2d), (x - 0) + (1 / 2d), y + (1 / 2d),
										(z + (L)) + (1 / 2d)),
								null)
						.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq((x - 0), y, (z + (L))))).findFirst()
						.orElse(null)) != null)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = PrecursoreyeblockdullBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_bs.has(_property))
								_bs = _bs.with(_property, (Comparable) entry.getValue());
						}
						world.setBlockState(_bp, _bs, 3);
					}
					ML = (double) 1;
					for (int index3 = 0; index3 < (int) ((L)); index3++) {
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d((x - 0), y, (z + (ML))), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/particle minecraft:dust 1 0.7 0 1 ~ ~ ~");
						}
						ML = (double) (1 + (ML));
					}
				} else {
					L = (double) (1 + (L));
				}
			}
		}
		if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.WEST)) {
			while ((((L) > 20) || (!(world.getBlockState(new BlockPos((int) (x - (L)), (int) y, (int) (z + 0))).isSolid())))) {
				if (((world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB((x - (L)) - (1 / 2d), y - (1 / 2d), (z + 0) - (1 / 2d), (x - (L)) + (1 / 2d), y + (1 / 2d),
										(z + 0) + (1 / 2d)),
								null)
						.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq((x - (L)), y, (z + 0)))).findFirst()
						.orElse(null)) != null)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = PrecursoreyeblockdullBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_bs.has(_property))
								_bs = _bs.with(_property, (Comparable) entry.getValue());
						}
						world.setBlockState(_bp, _bs, 3);
					}
					ML = (double) 1;
					for (int index5 = 0; index5 < (int) ((L)); index5++) {
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d((x - (ML)), y, (z + 0)), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/particle minecraft:dust 1 0.7 0 1 ~ ~ ~");
						}
						ML = (double) (1 + (ML));
					}
				} else {
					L = (double) (1 + (L));
				}
			}
		}
		if (((new Object() {
			public Direction getDirection(BlockPos pos) {
				try {
					BlockState _bs = world.getBlockState(pos);
					DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
					return _bs.get(property);
				} catch (Exception e) {
					return Direction.NORTH;
				}
			}
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.EAST)) {
			while ((((L) > 20) || (!(world.getBlockState(new BlockPos((int) (x + (L)), (int) y, (int) (z + 0))).isSolid())))) {
				if (((world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB((x + (L)) - (1 / 2d), y - (1 / 2d), (z + 0) - (1 / 2d), (x + (L)) + (1 / 2d), y + (1 / 2d),
										(z + 0) + (1 / 2d)),
								null)
						.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq((x + (L)), y, (z + 0)))).findFirst()
						.orElse(null)) != null)) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = PrecursoreyeblockdullBlock.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_bs.has(_property))
								_bs = _bs.with(_property, (Comparable) entry.getValue());
						}
						world.setBlockState(_bp, _bs, 3);
					}
					ML = (double) 1;
					for (int index7 = 0; index7 < (int) ((L)); index7++) {
						if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
							world.getWorld().getServer().getCommandManager().handleCommand(
									new CommandSource(ICommandSource.DUMMY, new Vec3d((x + (ML)), y, (z + 0)), Vec2f.ZERO, (ServerWorld) world, 4, "",
											new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
									"/particle minecraft:dust 1 0.7 0 1 ~ ~ ~");
						}
						ML = (double) (1 + (ML));
					}
				} else {
					L = (double) (1 + (L));
				}
			}
		}
	}
}
