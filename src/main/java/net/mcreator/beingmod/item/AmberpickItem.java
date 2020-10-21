
package net.mcreator.beingmod.item;

@BeingmodModElements.ModElement.Tag
public class AmberpickItem extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:amberpick")
	public static final Item block = null;

	public AmberpickItem(BeingmodModElements instance) {
		super(instance, 197);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
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

		}.setRegistryName("amberpick"));
	}

}
