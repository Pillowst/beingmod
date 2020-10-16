package net.mcreator.beingmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.Entity;

import net.mcreator.beingmod.item.LapisboltItem;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;
import java.util.Comparator;

@BeingmodModElements.ModElement.Tag
public class RailGunFireProcedure extends BeingmodModElements.ModElement {
	public RailGunFireProcedure(BeingmodModElements instance) {
		super(instance, 150);
	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RailGunFire!");
			return;
		}
		if(dependencies.get("itemstack") == null) {
			if(!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure RailGunFire!");
			return;
		}
		if(dependencies.get("x") == null) {
			if(!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure RailGunFire!");
			return;
		}
		if(dependencies.get("y") == null) {
			if(!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure RailGunFire!");
			return;
		}
		if(dependencies.get("z") == null) {
			if(!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure RailGunFire!");
			return;
		}
		if(dependencies.get("world") == null) {
			if(!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure RailGunFire!");
			return;
		}
				Entity entity = (Entity) dependencies.get("entity");
				ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
				double x = dependencies.get("x") instanceof Integer
					? (int) dependencies.get("x") : (double) dependencies.get("x");
				double y = dependencies.get("y") instanceof Integer
					? (int) dependencies.get("y") : (double) dependencies.get("y");
				double z = dependencies.get("z") instanceof Integer
					? (int) dependencies.get("z") : (double) dependencies.get("z");
				IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof PlayerEntity)?((PlayerEntity)entity).inventory.hasItemStack(new ItemStack(LapisboltItem.block, (int)(1))):false)) {for (int index0 = 0; index0<(int)(); index0++) {if ((>=0)) {}else{}world.addParticle(ParticleTypes.BUBBLE, (+), (+), (+), 0, 0, 0);}if (((world.getEntitiesWithinAABB(MonsterEntity.class, new AxisAlignedBB(
            x - (2 / 2d), y - (2 / 2d), z - (2 / 2d),
            x + (2 / 2d), y + (2 / 2d), z + (2 / 2d)), null)
    .stream()
    .sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z)))
    .findFirst().orElse(null)
) != null)) {    (world.getEntitiesWithinAABB(MonsterEntity.class, new AxisAlignedBB(
            x - (2 / 2d), y - (2 / 2d), z - (2 / 2d),
            x + (2 / 2d), y + (2 / 2d), z + (2 / 2d)), null)
    .stream()
    .sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z)))
    .findFirst().orElse(null)
).attackEntityFrom(DamageSource.LIGHTNING_BOLT,(float)10);
}if(entity instanceof PlayerEntity)
	((PlayerEntity)entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 30);if(entity instanceof PlayerEntity)
	((PlayerEntity)entity).inventory
        .clearMatchingItems(p -> new ItemStack(LapisboltItem.block, (int)(1)).getItem() == p.getItem(), (int)1);}
	}
}
