package net.mcreator.beingmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.beingmod.item.QuantumbatteryItem;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;

@BeingmodModElements.ModElement.Tag
public class DiamondfireraygunrightclickonairprocedureProcedure extends BeingmodModElements.ModElement {
	public DiamondfireraygunrightclickonairprocedureProcedure(BeingmodModElements instance) {
		super(instance, 114);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Diamondfireraygunrightclickonairprocedure!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure Diamondfireraygunrightclickonairprocedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Diamondfireraygunrightclickonairprocedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Diamondfireraygunrightclickonairprocedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Diamondfireraygunrightclickonairprocedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Diamondfireraygunrightclickonairprocedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
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
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(QuantumbatteryItem.block, (int) (1)))
				: false)) {
			X1 = (double) x;
			Y1 = (double) (y + 1.4);
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
			P = (double) (((entity.rotationPitch) * 0.01745329252) * (-1));
			O = (double) (((entity.rotationYaw) * 0.01745329252) * (-1));
			AMOUNTPART = (double) ((DIST) / (AMOUNT));
			AMOUNTLOG = (double) (AMOUNTPART);
			for (int index0 = 0; index0 < (int) ((AMOUNT)); index0++) {
				X3 = (double) ((AMOUNTLOG) * Math.sin((O)));
				Y3 = (double) ((AMOUNTLOG) * Math.sin((P)));
				Z3 = (double) ((AMOUNTLOG) * Math.cos((O)));
				world.addParticle(ParticleTypes.ENCHANTED_HIT, ((X3) + (X1)), ((Y3) + (Y1)), ((Z3) + (Z1)), 0, 0, 0);
				AMOUNTLOG = (double) ((AMOUNTLOG) + (AMOUNTPART));
			}
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null, (int) (X2), (int) (Y2), (int) (Z2), (float) 8, Explosion.Mode.BREAK);
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 160);
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vec3d((X2), (Y2), (Z2)), Vec2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						"/summon firework_rocket ~ ~ ~ {NoGravity:1b,Life:0,LifeTime:0,FireworksItem:{id:firework_rocket,Count:1,tag:{Fireworks:{Explosions:[{Type:2,Flicker:1b,Trail:1b,Colors:[I;61183],FadeColors:[I;14417663]},{Type:1,Flicker:1b,Colors:[I;14942198],FadeColors:[I;1638655]}]}}}}");
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(QuantumbatteryItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
		}
	}
}
