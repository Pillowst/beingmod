
package net.mcreator.beingmod.world.biome;

import net.minecraft.block.material.Material;

@BeingmodModElements.ModElement.Tag
public class BeingplainsBiome extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:beingplains")
	public static final CustomBiome biome = null;

	public BeingplainsBiome(BeingmodModElements instance) {
		super(instance, 178);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BlockBeingBlock.block.getDefaultState(),
							BlockOrcaniteBlock.block.getDefaultState(), BlockOrcaniteBlock.block.getDefaultState())));

			setRegistryName("beingplains");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addOres(this);

		}

	}

}
