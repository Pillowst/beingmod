// Made with Blockbench 3.6.6

public static class Modelanimated_entity_model extends AnimatedEntityModel {

	private final AnimatedModelRenderer center;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer arms;

	public Modelanimated_entity_model() {
		textureWidth = 16;
		textureHeight = 16;
		center = new AnimatedModelRenderer(this);
		center.setRotationPoint(0.0F, -13.5F, 3.75F);
		center.setTextureOffset(0, 0).addBox(-6.0F, -10.5F, -5.75F, 12.0F, 10.0F, 10.0F, 0.0F, false);
		center.setTextureOffset(0, 0).addBox(2.0F, 11.5F, 0.25F, 3.0F, 32.0F, 3.0F, 0.0F, false);
		center.setTextureOffset(0, 0).addBox(-5.0F, 11.5F, 0.25F, 3.0F, 32.0F, 3.0F, 0.0F, false);
		center.setTextureOffset(0, 0).addBox(-5.0F, -0.5F, -2.75F, 10.0F, 12.0F, 7.0F, 0.0F, false);
		center.setModelRendererName("center");
		this.registerModelRenderer(center);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -7.5F, -5.75F);
		center.addChild(head);
		head.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		arms = new AnimatedModelRenderer(this);
		arms.setRotationPoint(-6.5F, -2.5F, -2.25F);
		center.addChild(arms);
		arms.setTextureOffset(0, 0).addBox(-2.5F, -2.0F, -1.5F, 3.0F, 32.0F, 3.0F, 0.0F, false);
		arms.setTextureOffset(0, 0).addBox(12.5F, -2.0F, -1.5F, 3.0F, 32.0F, 3.0F, 0.0F, false);
		arms.setModelRendererName("arms");
		this.registerModelRenderer(arms);

		this.rootBones.add(center);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation("MODID", "animations/ANIMATIONFILE.json");
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}