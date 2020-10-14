
package net.mcreator.beingmod.item;

@BeingmodModElements.ModElement.Tag
public class QuantumbatteryItem extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:quantumbattery")
	public static final Item block = null;

	public QuantumbatteryItem(BeingmodModElements instance) {
		super(instance, 111);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(16).rarity(Rarity.EPIC));
			setRegistryName("quantumbattery");
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

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

	}

}
