
package net.mcreator.beingmod.block;

import net.minecraft.block.material.Material;

@BeingmodModElements.ModElement.Tag
public class RedRockGrassBlock extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:red_rock_grass")
	public static final Block block = null;

	public RedRockGrassBlock(BeingmodModElements instance) {
		super(instance, 215);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.WET_GRASS).hardnessAndResistance(1f, 10f).lightValue(0));

			setRegistryName("red_rock_grass");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
