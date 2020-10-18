package net.mcreator.beingmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class PrecursorspikestopEntityCollidesInTheBlockProcedure extends BeingmodModElements.ModElement {
	public PrecursorspikestopEntityCollidesInTheBlockProcedure(BeingmodModElements instance) {
		super(instance, 161);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PrecursorspikestopEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.CACTUS, (float) 4);
	}
}
