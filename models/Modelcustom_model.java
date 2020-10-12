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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.ArmLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.ArmRight.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LegLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.LegRight.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}