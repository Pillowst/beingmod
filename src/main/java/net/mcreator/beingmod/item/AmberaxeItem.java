
package net.mcreator.beingmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.beingmod.BeingmodModElements;

@BeingmodModElements.ModElement.Tag
public class AmberaxeItem extends BeingmodModElements.ModElement {
	@ObjectHolder("beingmod:amberaxe")
	public static final Item block = null;
	public AmberaxeItem(BeingmodModElements instance) {
		super(instance, 198);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
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
		}.setRegistryName("amberaxe"));
	}
}
