
package net.mcreator.beingmod.item;

@BeingmodModElements.ModElement.Tag
public class N48pickaxeItem extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:n_48pickaxe")
	public static final Item block = null;

	public N48pickaxeItem(BeingmodModElements instance) {
		super(instance, 93);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2500;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 18;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(N48chunkItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("n_48pickaxe"));
	}

}
