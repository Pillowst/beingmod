package net.mcreator.beingmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class KjaldarcrystalStartToDestroyProcedure extends BeingmodModElements.ModElement {
	public KjaldarcrystalStartToDestroyProcedure(BeingmodModElements instance) {
		super(instance, 171);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure KjaldarcrystalStartToDestroy!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 10);
	}
}
