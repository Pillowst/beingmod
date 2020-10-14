package net.mcreator.beingmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;

import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class PlasmacutterRightClickedInAirProcedure extends BeingmodModElements.ModElement {
	public PlasmacutterRightClickedInAirProcedure(BeingmodModElements instance) {
		super(instance, 113);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PlasmacutterRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PlasmacutterRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PlasmacutterRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PlasmacutterRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PlasmacutterRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double DIST = 0;
		double X1 = 0;
		double X2 = 0;
		double Y2 = 0;
		double Z1 = 0;
		double Z2 = 0;
		double Y1 = 0;
		double AMOUNT = 0;
		double O = 0;
		double P = 0;
		double R = 0;
		double AMOUNTPART = 0;
		double AMOUNTLOG = 0;
		double X3 = 0;
		double Y3 = 0;
		double Z3 = 0;
		X1 = (double) x;
		Y1 = (double) y;
		Z1 = (double) z;
		X2 = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX());
		Y2 = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY());
		Z2 = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ());
		DIST = (double) Math.sqrt((Math.pow(((X1) - (X2)), 2) * (Math.pow(((Y1) - (Y2)), 2) * Math.pow(((Z1) - (Z2)), 2))));
		AMOUNT = (double) Math.round(((DIST) * 100));
		P = (double) (entity.rotationYaw);
		O = (double) (entity.rotationPitch);
		AMOUNTPART = (double) ((DIST) / (AMOUNT));
		AMOUNTLOG = (double) (AMOUNTPART);
		for (int index0 = 0; index0 < (int) ((AMOUNT)); index0++) {
			AMOUNTLOG = (double) ((AMOUNTLOG) + (AMOUNTPART));
			X3 = (double) ((AMOUNTLOG) * (Math.sin((O)) * Math.cos((P))));
			Y3 = (double) ((AMOUNTLOG) * (Math.sin((O)) * Math.sin((P))));
			Z3 = (double) ((AMOUNTLOG) * Math.sin((O)));
			world.addParticle(ParticleTypes.FLAME, ((X3) + (X1)), ((Y3) + (X1)), ((Z3) + (Z1)), 0, 0, 0);
		}
		Block.spawnDrops(world.getBlockState(new BlockPos((int) (X2), (int) (Y2), (int) (Z2))), world.getWorld(),
				new BlockPos((int) (X2), (int) (Y2), (int) (Z2)));
		world.destroyBlock(new BlockPos((int) (X2), (int) (Y2), (int) (Z2)), false);
	}
}
