
package net.mcreator.beingmod.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

import net.mcreator.beingmod.block.BlockOrcaniteBlock;
import net.mcreator.beingmod.block.BlockBeingBlock;
import net.mcreator.beingmod.BeingmodModElements;

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
					.category(Biome.Category.NONE).waterColor(-14791154).waterFogColor(-14791154)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BlockBeingBlock.block.getDefaultState(),
							BlockOrcaniteBlock.block.getDefaultState(), BlockOrcaniteBlock.block.getDefaultState())));
			setRegistryName("beingplains");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addOres(this);
		}
	}
}
