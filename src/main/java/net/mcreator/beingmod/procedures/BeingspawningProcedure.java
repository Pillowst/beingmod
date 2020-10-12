package net.mcreator.beingmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.beingmod.block.BlockBeingBlock;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class BeingspawningProcedure extends BeingmodModElements.ModElement {
	public BeingspawningProcedure(BeingmodModElements instance) {
		super(instance, 57);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Beingspawning!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Beingspawning!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Beingspawning!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Beingspawning!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean t = false;
		double BX = 0;
		double BY = 0;
		double BZ = 0;
		BX = (double) (-3);
		t = (boolean) (false);
		for (int index0 = 0; index0 < (int) (4); index0++) {
			BY = (double) (-2);
			for (int index1 = 0; index1 < (int) (4); index1++) {
				BZ = (double) (-2);
				for (int index2 = 0; index2 < (int) (4); index2++) {
					if (((world.getBlockState(new BlockPos((int) (x + (BX)), (int) (y + (BY)), (int) (z + (BZ))))).getBlock() == BlockBeingBlock.block
							.getDefaultState().getBlock())) {
						t = (boolean) (true);
					}
					BZ = (double) ((BX) + 1);
				}
				BY = (double) ((BX) + 1);
			}
			BX = (double) ((BX) + 1);
		}
		return (t);
	}
}
