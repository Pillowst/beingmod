package net.mcreator.beingmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;
import java.util.Iterator;

@BeingmodModElements.ModElement.Tag
public class PrecursordirtBlockDestroyedByPlayerProcedure extends BeingmodModElements.ModElement {
	public PrecursordirtBlockDestroyedByPlayerProcedure(BeingmodModElements instance) {
		super(instance, 137);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PrecursordirtBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
				? ((ServerPlayerEntity) entity).getAdvancements()
						.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("beingmod:precursordungeonin")))
						.isDone()
				: false))) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("beingmod:precursordungeonin"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
		}
	}
}
