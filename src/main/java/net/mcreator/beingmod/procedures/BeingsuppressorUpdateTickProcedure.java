package net.mcreator.beingmod.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.IProperty;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.block.BlockState;

import net.mcreator.beingmod.block.DessicatedbeingBlock;
import net.mcreator.beingmod.block.BlockBeingBlock;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class BeingsuppressorUpdateTickProcedure extends BeingmodModElements.ModElement {
	public BeingsuppressorUpdateTickProcedure(BeingmodModElements instance) {
		super(instance, 81);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BeingsuppressorUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BeingsuppressorUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BeingsuppressorUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BeingsuppressorUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double BX = 0;
		double BY = 0;
		double BZ = 0;
		if (((new Object() {
			public int getEnergyStored(BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(new BlockPos((int) x, (int) y, (int) z))) >= 1000)) {
			BX = (double) (-3);
			for (int index0 = 0; index0 < (int) (6); index0++) {
				BY = (double) (-3);
				for (int index1 = 0; index1 < (int) (6); index1++) {
					BZ = (double) (-3);
					for (int index2 = 0; index2 < (int) (6); index2++) {
						if (((world.getBlockState(new BlockPos((int) (x + (BX)), (int) (y + (BY)), (int) (z + (BZ)))))
								.getBlock() == BlockBeingBlock.block.getDefaultState().getBlock())) {
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
								int _amount = (int) 1000;
								if (_ent != null)
									_ent.getCapability(CapabilityEnergy.ENERGY, null)
											.ifPresent(capability -> capability.extractEnergy(_amount, false));
							}
							{
								BlockPos _bp = new BlockPos((int) (x + (BX)), (int) (y + (BY)), (int) (z + (BZ)));
								BlockState _bs = DessicatedbeingBlock.block.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_bs.has(_property))
										_bs = _bs.with(_property, (Comparable) entry.getValue());
								}
								world.setBlockState(_bp, _bs, 3);
							}
							break;
						}
						BZ = (double) ((BZ) + 1);
					}
					BY = (double) ((BY) + 1);
				}
				BX = (double) ((BX) + 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, x, y, z, (int) 5, 6, 6, 6, 0);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.END_ROD, (x + 0.5), (y + 1), (z + 0.5), (int) 1, 0, 0.5, 0, 0);
			}
		}
	}
}
