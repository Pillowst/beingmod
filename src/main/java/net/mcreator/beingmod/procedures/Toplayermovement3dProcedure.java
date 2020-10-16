package net.mcreator.beingmod.procedures;

@BeingmodModElements.ModElement.Tag
public class Toplayermovement3dProcedure extends BeingmodModElements.ModElement {

	public Toplayermovement3dProcedure(BeingmodModElements instance) {
		super(instance, 152);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Toplayermovement3d!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Toplayermovement3d!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Toplayermovement3d!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Toplayermovement3d!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Toplayermovement3d!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		double AX = 0;
		double AY = 0;
		double AZ = 0;
		double BX = 0;
		double BY = 0;
		double BZ = 0;
		double RL = 0;
		if (((entity.getPersistentData().getDouble("timer")) == 10)) {
			entity.setMotion(0, 0, 0);
			if (((world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
					.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)) != null)) {
				entity.getPersistentData()
						.putDouble(
								"px", ((world
										.getEntitiesWithinAABB(PlayerEntity.class,
												new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d),
														z + (20 / 2d)),
												null)
										.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null))
												.getPosX()));
				entity.getPersistentData()
						.putDouble(
								"py", ((world
										.getEntitiesWithinAABB(PlayerEntity.class,
												new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d),
														z + (20 / 2d)),
												null)
										.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null))
												.getPosY()));
				entity.getPersistentData()
						.putDouble(
								"pz", ((world
										.getEntitiesWithinAABB(PlayerEntity.class,
												new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d),
														z + (20 / 2d)),
												null)
										.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null))
												.getPosZ()));
			} else {
				entity.getPersistentData().putDouble("px", ((entity.getPosX()) + 5));
				entity.getPersistentData().putDouble("py", (entity.getPosY()));
				entity.getPersistentData().putDouble("pz", (entity.getPosZ()));
			}
		} else if (((entity.getPersistentData().getDouble("timer")) == 30)) {
			if (((world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB(x - (20 / 2d), y - (20 / 2d), z - (20 / 2d), x + (20 / 2d), y + (20 / 2d), z + (20 / 2d)), null)
					.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)) != null)) {
				AX = (double) (entity.getPosX());
				AY = (double) (entity.getPosY());
				AZ = (double) (entity.getPosZ());
				BX = (double) (entity.getPersistentData().getDouble("px"));
				BY = (double) (entity.getPersistentData().getDouble("py"));
				BZ = (double) (entity.getPersistentData().getDouble("pz"));
				RL = (double) Math.sqrt((Math.pow(((AX) - (AX)), 2) + (Math.pow(((AX) - (AX)), 2) + Math.pow(((AX) - (AX)), 2))));
				entity.setMotion((((BX) - (AX)) / (RL)), (((BY) - (AY)) / (RL)), (((BZ) - (AZ)) / (RL)));
			}
			entity.getPersistentData().putDouble("timer", 0);
		}
		entity.getPersistentData().putDouble("timer", ((entity.getPersistentData().getDouble("timer")) + 1));

	}

}
