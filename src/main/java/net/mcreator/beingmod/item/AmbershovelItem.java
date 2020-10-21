
package net.mcreator.beingmod.item;

@BeingmodModElements.ModElement.Tag
public class AmbershovelItem extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:ambershovel")
	public static final Item block = null;

	public AmbershovelItem(BeingmodModElements instance) {
		super(instance, 200);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 3;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(AmberItemItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("ambershovel"));
	}

}
