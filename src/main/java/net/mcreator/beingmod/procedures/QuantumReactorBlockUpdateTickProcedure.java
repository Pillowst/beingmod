package net.mcreator.beingmod.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class QuantumReactorBlockUpdateTickProcedure extends BeingmodModElements.ModElement {
	public QuantumReactorBlockUpdateTickProcedure(BeingmodModElements instance) {
		super(instance, 97);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure QuantumReactorBlockUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure QuantumReactorBlockUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure QuantumReactorBlockUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure QuantumReactorBlockUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.DOWN)) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 0), (int) (y + 1), (int) (z + 0)));
				int _amount = (int) 5;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, ((new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								return _bs.get(property);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos((int) x, (int) y, (int) z))).getOpposite()))
							.ifPresent(capability -> capability.receiveEnergy(_amount, false));
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.UP)) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 0), (int) (y - 1), (int) (z + 0)));
				int _amount = (int) 5;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, ((new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								return _bs.get(property);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos((int) x, (int) y, (int) z))).getOpposite()))
							.ifPresent(capability -> capability.receiveEnergy(_amount, false));
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
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 0), (int) (y - 0), (int) (z - 1)));
				int _amount = (int) 5;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, ((new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								return _bs.get(property);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos((int) x, (int) y, (int) z))).getOpposite()))
							.ifPresent(capability -> capability.receiveEnergy(_amount, false));
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
		}.getDirection(new BlockPos((int) x, (int) y, (int) z))) == Direction.NORTH)) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 0), (int) (y - 0), (int) (z + 1)));
				int _amount = (int) 5;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, ((new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								return _bs.get(property);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos((int) x, (int) y, (int) z))).getOpposite()))
							.ifPresent(capability -> capability.receiveEnergy(_amount, false));
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
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 1), (int) (y - 0), (int) (z + 0)));
				int _amount = (int) 5;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, ((new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								return _bs.get(property);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos((int) x, (int) y, (int) z))).getOpposite()))
							.ifPresent(capability -> capability.receiveEnergy(_amount, false));
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
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 1), (int) (y - 0), (int) (z + 0)));
				int _amount = (int) 5;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, ((new Object() {
						public Direction getDirection(BlockPos pos) {
							try {
								BlockState _bs = world.getBlockState(pos);
								DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
								return _bs.get(property);
							} catch (Exception e) {
								return Direction.NORTH;
							}
						}
					}.getDirection(new BlockPos((int) x, (int) y, (int) z))).getOpposite()))
							.ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
		}
	}
}
