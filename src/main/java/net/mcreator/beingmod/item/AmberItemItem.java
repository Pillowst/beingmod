
package net.mcreator.beingmod.item;

@BeingmodModElements.ModElement.Tag
public class AmberItemItem extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:amber_item")
	public static final Item block = null;

	public AmberItemItem(BeingmodModElements instance) {
		super(instance, 196);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.EPIC));
			setRegistryName("amber_item");
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
