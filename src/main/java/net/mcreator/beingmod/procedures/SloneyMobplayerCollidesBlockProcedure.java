package net.mcreator.beingmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class SloneyMobplayerCollidesBlockProcedure extends BeingmodModElements.ModElement {
	public SloneyMobplayerCollidesBlockProcedure(BeingmodModElements instance) {
		super(instance, 217);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SloneyMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getMotion().getY()) < 0.1)) {
			entity.setMotion((entity.getMotion().getX()), ((entity.getMotion().getY()) * (-1.1)), (entity.getMotion().getZ()));
		}
	}
}
