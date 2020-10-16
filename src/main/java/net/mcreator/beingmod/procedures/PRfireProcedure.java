package net.mcreator.beingmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.Entity;

import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;
import java.util.Comparator;

@BeingmodModElements.ModElement.Tag
public class PRfireProcedure extends BeingmodModElements.ModElement {
	public PRfireProcedure(BeingmodModElements instance) {
		super(instance, 158);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PRfire!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure PRfire!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PRfire!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PRfire!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PRfire!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PRfire!");
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
			Z3 = (double) ((AMOUNTLOG) * Math.cos((O)));
			if (((P) >= 0)) {
				Y3 = (double) ((AMOUNTLOG) * Math.sin((P)));
			} else {
				Y3 = (double) ((AMOUNTLOG) * (Math.sin(((Math.PI * 2) - (P))) * (-1)));
			}
			world.addParticle(ParticleTypes.FLAME, ((X3) + (X1)), ((Y3) + (Y1)), ((Z3) + (Z1)), 0, 0, 0);
			AMOUNTLOG = (double) ((AMOUNTLOG) + (AMOUNTPART));
		}
		if (((world
				.getEntitiesWithinAABB(MonsterEntity.class,
						new AxisAlignedBB(
								(entity.world.rayTraceBlocks(
										new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
														entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getX()) - (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
														entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getY())
										- (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
														entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getZ()) - (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getX()) + (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getY()) + (5 / 2d),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
												entity.getLook(1f).z * 30),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
						null)
				.stream().sorted(
						Comparator
								.comparing(
										_entcnd -> _entcnd
												.getDistanceSq(
														(entity.world.rayTraceBlocks(new RayTraceContext(
																entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																		entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
																.getX()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																				entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																				entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()))))
				.findFirst().orElse(null)) != null)) {
			(world.getEntitiesWithinAABB(MonsterEntity.class,
					new AxisAlignedBB(
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
					null).stream().sorted(
							Comparator
									.comparing(
											_entcnd -> _entcnd.getDistanceSq(
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getX()),
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																			entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()))))
					.findFirst().orElse(null)).attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 5);
			(world.getEntitiesWithinAABB(MonsterEntity.class,
					new AxisAlignedBB(
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
					null).stream().sorted(
							Comparator
									.comparing(
											_entcnd -> _entcnd.getDistanceSq(
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getX()),
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																			entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()))))
					.findFirst().orElse(null)).setFire((int) 15);
		} else if (((world
				.getEntitiesWithinAABB(PlayerEntity.class,
						new AxisAlignedBB(
								(entity.world.rayTraceBlocks(
										new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
														entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getX()) - (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
														entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getY())
										- (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
														entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getZ()) - (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getX()) + (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getY()) + (5 / 2d),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
												entity.getLook(1f).z * 30),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
						null)
				.stream().sorted(
						Comparator
								.comparing(
										_entcnd -> _entcnd
												.getDistanceSq(
														(entity.world.rayTraceBlocks(new RayTraceContext(
																entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																		entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
																.getX()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																				entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																				entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()))))
				.findFirst().orElse(null)) != null)) {
			(world.getEntitiesWithinAABB(PlayerEntity.class,
					new AxisAlignedBB(
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
					null).stream().sorted(
							Comparator
									.comparing(
											_entcnd -> _entcnd.getDistanceSq(
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getX()),
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																			entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()))))
					.findFirst().orElse(null)).attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 5);
			(world.getEntitiesWithinAABB(PlayerEntity.class,
					new AxisAlignedBB(
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
					null).stream().sorted(
							Comparator
									.comparing(
											_entcnd -> _entcnd.getDistanceSq(
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getX()),
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																			entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()))))
					.findFirst().orElse(null)).setFire((int) 15);
		} else if (((world
				.getEntitiesWithinAABB(AnimalEntity.class,
						new AxisAlignedBB(
								(entity.world.rayTraceBlocks(
										new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
														entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getX()) - (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
														entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getY())
										- (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
														entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getZ()) - (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getX()) + (5 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getY()) + (5 / 2d),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
												entity.getLook(1f).z * 30),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
						null)
				.stream().sorted(
						Comparator
								.comparing(
										_entcnd -> _entcnd
												.getDistanceSq(
														(entity.world.rayTraceBlocks(new RayTraceContext(
																entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																		entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
																.getX()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																				entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																				entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()))))
				.findFirst().orElse(null)) != null)) {
			(world.getEntitiesWithinAABB(AnimalEntity.class,
					new AxisAlignedBB(
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
					null).stream().sorted(
							Comparator
									.comparing(
											_entcnd -> _entcnd.getDistanceSq(
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getX()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																			entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																			entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()))))
					.findFirst().orElse(null)).attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 5);
			(world.getEntitiesWithinAABB(AnimalEntity.class,
					new AxisAlignedBB(
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()) + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
					null).stream().sorted(
							Comparator
									.comparing(
											_entcnd -> _entcnd.getDistanceSq(
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getX()),
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30,
																	entity.getLook(1f).z * 30),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
															.getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 30,
																			entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()))))
					.findFirst().orElse(null)).setFire((int) 15);
		}
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(ParticleTypes.FLAME,
					(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
					(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
					(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 30, entity.getLook(1f).y * 30, entity.getLook(1f).z * 30),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
					(int) 9, 1, 1, 1, 1);
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 5);
	}
}
