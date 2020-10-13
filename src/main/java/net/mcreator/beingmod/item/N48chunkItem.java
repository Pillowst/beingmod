
package net.mcreator.beingmod.item;

@BeingmodModElements.ModElement.Tag
public class N48chunkItem extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:n_48chunk")
	public static final Item block = null;

	public N48chunkItem(BeingmodModElements instance) {
		super(instance, 90);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("n_48chunk");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
