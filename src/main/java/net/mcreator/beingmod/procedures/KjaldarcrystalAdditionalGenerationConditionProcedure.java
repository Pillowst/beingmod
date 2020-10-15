package net.mcreator.beingmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class KjaldarcrystalAdditionalGenerationConditionProcedure extends BeingmodModElements.ModElement {
	public KjaldarcrystalAdditionalGenerationConditionProcedure(BeingmodModElements instance) {
		super(instance, 122);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure KjaldarcrystalAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure KjaldarcrystalAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure KjaldarcrystalAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure KjaldarcrystalAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double BX = 0;
		double BY = 0;
		double BZ = 0;
		boolean T = false;
		BX = (double) (-3);
		T = (boolean) (false);
		for (int index0 = 0; index0 < (int) (6); index0++) {
			BY = (double) (-3);
			for (int index1 = 0; index1 < (int) (6); index1++) {
				BZ = (double) (-3);
				for (int index2 = 0; index2 < (int) (6); index2++) {
					if (((world.getBlockState(new BlockPos((int) (x + (BX)), (int) (y + (BY)), (int) (z + (BZ))))).getBlock() == Blocks.LAVA
							.getDefaultState().getBlock())) {
						if ((y <= 20)) {
							T = (boolean) (true);
						}
					}
					BZ = (double) ((BZ) + 1);
				}
				BY = (double) ((BY) + 1);
			}
			BX = (double) ((BX) + 1);
		}
		return (T);
	}
}
