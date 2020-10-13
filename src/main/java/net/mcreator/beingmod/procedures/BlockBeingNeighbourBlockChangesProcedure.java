package net.mcreator.beingmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.BlockState;

import net.mcreator.beingmod.block.DessicatedbeingBlock;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class BlockBeingNeighbourBlockChangesProcedure extends BeingmodModElements.ModElement {
	public BlockBeingNeighbourBlockChangesProcedure(BeingmodModElements instance) {
		super(instance, 78);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BlockBeingNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BlockBeingNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BlockBeingNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BlockBeingNeighbourBlockChanges!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.canBlockSeeSky(new BlockPos((int) x, (int) y, (int) z)))) {
			if ((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
					.equals(new ResourceLocation("beingmod:collapsedesseforest")))) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = DessicatedbeingBlock.block.getDefaultState();
					world.setBlockState(_bp, _bs, 3);
				}
			}
		}
	}
}
