
package net.mcreator.beingmod.itemgroup;

@BeingmodModElements.ModElement.Tag
public class AnomalousmaterialsItemGroup extends BeingmodModElements.ModElement {

	public AnomalousmaterialsItemGroup(BeingmodModElements instance) {
		super(instance, 159);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabanomalousmaterials") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlockBeingBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}
