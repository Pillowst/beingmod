
package net.mcreator.beingmod.item;

@BeingmodModElements.ModElement.Tag
public class KjaldarshardItem extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:kjaldarshard")
	public static final Item block = null;

	public KjaldarshardItem(BeingmodModElements instance) {
		super(instance, 90);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("kjaldarshard");
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
