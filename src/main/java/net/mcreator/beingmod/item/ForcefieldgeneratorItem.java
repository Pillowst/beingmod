
package net.mcreator.beingmod.item;

@BeingmodModElements.ModElement.Tag
public class ForcefieldgeneratorItem extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:forcefieldgenerator")
	public static final Item block = null;

	public ForcefieldgeneratorItem(BeingmodModElements instance) {
		super(instance, 88);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("forcefieldgenerator");
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
