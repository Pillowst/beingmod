package net.mcreator.beingmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.beingmod.entity.IndelicateEntity;
import net.mcreator.beingmod.block.BlockBeingBlock;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;
import java.util.HashMap;

@BeingmodModElements.ModElement.Tag
public class BeingspawningProcedure extends BeingmodModElements.ModElement {
	public BeingspawningProcedure(BeingmodModElements instance) {
		super(instance, 57);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Beingspawning!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Beingspawning!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Beingspawning!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Beingspawning!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Beingspawning!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
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
		if (((t) == (true))) {
			if ((Math.random() < 0.2)) {
				if (world instanceof World && !world.getWorld().isRemote) {
					Entity entityToSpawn = new IndelicateEntity.CustomEntity(IndelicateEntity.entity, world.getWorld());
					entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				if (!entity.world.isRemote)
					entity.remove();
			}
		}
	}

	@SubscribeEvent
	public void onEntitySpawned(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = event.getWorld().getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
