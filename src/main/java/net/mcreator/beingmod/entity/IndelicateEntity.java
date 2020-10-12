
package net.mcreator.beingmod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.beingmod.procedures.BeingspawningProcedure;
import net.mcreator.beingmod.BeingmodModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

import com.google.common.collect.ImmutableMap;

@BeingmodModElements.ModElement.Tag
public class IndelicateEntity extends BeingmodModElements.ModElement {
	public static EntityType entity = null;
	public IndelicateEntity(BeingmodModElements instance) {
		super(instance, 56);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 0.8f)).build("indelicate")
						.setRegistryName("indelicate");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -3407668, -13434778, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("indelicate_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 100, 4, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> {
					int x = pos.getX();
					int y = pos.getY();
					int z = pos.getZ();
					return BeingspawningProcedure.executeProcedure(ImmutableMap.of("x", x, "y", y, "z", z, "world", world));
				});
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
				{
					this.addLayer(new GlowingLayer<>(this));
				}
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("beingmod:textures/beingbehemot.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class GlowingLayer<T extends Entity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
		public GlowingLayer(IEntityRenderer<T, M> er) {
			super(er);
		}

		public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing,
				float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEyes(new ResourceLocation("beingmod:textures/behglow.png")));
			this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		}
	}

	// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer LegRight;
		private final ModelRenderer ArmRight;
		private final ModelRenderer BigChestArea;
		private final ModelRenderer BackArea;
		private final ModelRenderer LegJoint;
		private final ModelRenderer ArmLeft;
		private final ModelRenderer LegLeft;
		private final ModelRenderer Head;
		private final ModelRenderer ArmJoint;
		public Modelcustom_model() {
			textureWidth = 64;
			textureHeight = 64;
			LegRight = new ModelRenderer(this);
			LegRight.setRotationPoint(-5.0F, 17.0F, 4.0F);
			setRotationAngle(LegRight, 0.0F, -0.0436F, 0.0F);
			LegRight.setTextureOffset(20, 27).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
			ArmRight = new ModelRenderer(this);
			ArmRight.setRotationPoint(-5.5F, 14.0F, -3.0F);
			ArmRight.setTextureOffset(0, 27).addBox(-2.0F, -2.9014F, -2.2577F, 2.0F, 13.0F, 3.0F, 0.0F, false);
			BigChestArea = new ModelRenderer(this);
			BigChestArea.setRotationPoint(-0.5F, 15.0F, -2.0F);
			setRotationAngle(BigChestArea, -0.0873F, 0.0F, 0.0F);
			BigChestArea.setTextureOffset(0, 0).addBox(-4.5F, -3.9063F, -4.4226F, 8.0F, 6.0F, 8.0F, 0.0F, false);
			BackArea = new ModelRenderer(this);
			BackArea.setRotationPoint(0.0F, 0.0F, 0.0F);
			BigChestArea.addChild(BackArea);
			setRotationAngle(BackArea, -0.2618F, 0.0F, 0.0F);
			BackArea.setTextureOffset(0, 14).addBox(-4.0F, -2.9962F, 0.0872F, 7.0F, 5.0F, 8.0F, 0.0F, false);
			LegJoint = new ModelRenderer(this);
			LegJoint.setRotationPoint(-10.5F, 17.0872F, -3.9962F);
			LegJoint.setTextureOffset(22, 16).addBox(5.0F, -0.0757F, 6.7347F, 9.0F, 1.0F, 1.0F, 0.0F, false);
			ArmLeft = new ModelRenderer(this);
			ArmLeft.setRotationPoint(4.0F, 14.0F, -3.0F);
			ArmLeft.setTextureOffset(10, 27).addBox(-0.5F, -2.9014F, -2.2577F, 2.0F, 13.0F, 3.0F, 0.0F, false);
			LegLeft = new ModelRenderer(this);
			LegLeft.setRotationPoint(3.0F, 17.0F, 3.0F);
			LegLeft.setTextureOffset(26, 27).addBox(0.0F, -1.0F, -1.0F, 1.0F, 8.0F, 2.0F, 0.0F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(-1.0F, 13.0F, -6.5F);
			Head.setTextureOffset(24, 0).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			ArmJoint = new ModelRenderer(this);
			ArmJoint.setRotationPoint(-0.5F, 17.0F, -3.0F);
			ArmJoint.setTextureOffset(22, 14).addBox(-6.0F, -3.6059F, -1.1853F, 11.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			LegRight.render(matrixStack, buffer, packedLight, packedOverlay);
			ArmRight.render(matrixStack, buffer, packedLight, packedOverlay);
			BigChestArea.render(matrixStack, buffer, packedLight, packedOverlay);
			LegJoint.render(matrixStack, buffer, packedLight, packedOverlay);
			ArmLeft.render(matrixStack, buffer, packedLight, packedOverlay);
			LegLeft.render(matrixStack, buffer, packedLight, packedOverlay);
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			ArmJoint.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.ArmLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.ArmRight.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LegLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LegRight.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
