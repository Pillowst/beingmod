
package net.mcreator.beingmod.block;

import net.minecraft.block.material.Material;

@BeingmodModElements.ModElement.Tag
public class N48AlloyBlock extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:n_48_alloy")
	public static final Block block = null;

	public N48AlloyBlock(BeingmodModElements instance) {
		super(instance, 89);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).lightValue(0));

			setRegistryName("n_48_alloy");
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
