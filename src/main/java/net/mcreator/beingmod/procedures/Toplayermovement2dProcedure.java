package net.mcreator.beingmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;
import java.util.Comparator;

@BeingmodModElements.ModElement.Tag
public class Toplayermovement2dProcedure extends BeingmodModElements.ModElement {
	public Toplayermovement2dProcedure(BeingmodModElements instance) {
		super(instance, 151);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Poisonslimeonentitytick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Poisonslimeonentitytick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Poisonslimeonentitytick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Poisonslimeonentitytick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Poisonslimeonentitytick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double aX = 0;
		double aZ = 0;
		double bX = 0;
		double bZ = 0;
		double Rl = 0;
		double Y = 0;
		double m = 0;
		if (((entity.getPersistentData().getDouble("timer")) == 90)) {
			if (((world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB(x - 10 / 2, y - 10 / 2, z - 10 / 2, x + 10 / 2, y + 10 / 2, z + 10 / 2), null)
					.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)) != null)) {
				aX = (double) (entity.getPosX());
				aZ = (double) (entity.getPosZ());
				bX = (double) ((world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB(x - 10 / 2, y - 10 / 2, z - 10 / 2, x + 10 / 2, y + 10 / 2, z + 10 / 2), null)
						.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)).getPosX());
				bZ = (double) ((world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB(x - 10 / 2, y - 10 / 2, z - 10 / 2, x + 10 / 2, y + 10 / 2, z + 10 / 2), null)
						.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)).getPosZ());
				m = (double) (((bZ) - (aZ)) / ((bX) - (aX)));
				m = (double) Math.atan2((bZ) - (aZ), (bX) - (aX));
				entity.rotationYaw = (float) ((m));
				entity.rotationPitch = (float) (0);
			} else {
				entity.rotationYaw = (float) (((entity.rotationYaw) + 1));
				entity.rotationPitch = (float) (0);
			}
			Rl = (double) (entity.rotationYaw);
			entity.setMotion((0.8 * Math.cos((Rl))), (entity.getMotion().getY()), (0.8 * Math.sin((Rl))));
			entity.getPersistentData().putDouble("timer", 0);
		}
		entity.getPersistentData().putDouble("timer", ((entity.getPersistentData().getDouble("timer")) + 1));
	}
}
