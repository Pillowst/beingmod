
package net.mcreator.beingmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.beingmod.itemgroup.AnomalousmaterialsItemGroup;
import net.mcreator.beingmod.BeingmodModElements;

@BeingmodModElements.ModElement.Tag
public class KjaldarCrystalITEMItem extends BeingmodModElements.ModElement {
	@ObjectHolder("beingmod:kjaldar_crystal_item")
	public static final Item block = null;
	public KjaldarCrystalITEMItem(BeingmodModElements instance) {
		super(instance, 99);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(AnomalousmaterialsItemGroup.tab).maxStackSize(16).rarity(Rarity.EPIC));
			setRegistryName("kjaldar_crystal_item");
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
