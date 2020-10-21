
package net.mcreator.beingmod.item;

@BeingmodModElements.ModElement.Tag
public class AmberswordItem extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:ambersword")
	public static final Item block = null;

	public AmberswordItem(BeingmodModElements instance) {
		super(instance, 201);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 250;
			}

			public float getEfficiency() {
				return 5f;
			}

			public float getAttackDamage() {
				return 7f;
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
		}, 3, 0f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("ambersword"));
	}

}
