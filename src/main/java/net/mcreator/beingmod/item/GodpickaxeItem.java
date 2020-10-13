
package net.mcreator.beingmod.item;

@BeingmodModElements.ModElement.Tag
public class GodpickaxeItem extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:godpickaxe")
	public static final Item block = null;

	public GodpickaxeItem(BeingmodModElements instance) {
		super(instance, 92);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 3000;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ItemBeingItem.block, (int) (1)));
			}
		}, 1, -2f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("godpickaxe"));
	}

}
