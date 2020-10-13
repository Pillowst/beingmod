
package net.mcreator.beingmod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.beingmod.item.N48chunkItem;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.List;
import java.util.Collections;

@BeingmodModElements.ModElement.Tag
public class N48oreBlock extends BeingmodModElements.ModElement {
	@ObjectHolder("beingmod:n_48ore")
	public static final Block block = null;
	public N48oreBlock(BeingmodModElements instance) {
		super(instance, 74);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(3f, 10f).lightValue(0).tickRandomly());
			setRegistryName("n_48ore");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(N48chunkItem.block, (int) (2)));
		}
	}
}
