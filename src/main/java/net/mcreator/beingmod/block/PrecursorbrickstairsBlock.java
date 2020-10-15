
package net.mcreator.beingmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.fluid.IFluidState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.beingmod.procedures.PrecursorbrickstairsBlockDestroyedByPlayerProcedure;
import net.mcreator.beingmod.procedures.PrecursorbricksPlayerStartsToDestroyProcedure;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@BeingmodModElements.ModElement.Tag
public class PrecursorbrickstairsBlock extends BeingmodModElements.ModElement {
	@ObjectHolder("beingmod:precursorbrickstairs")
	public static final Block block = null;
	public PrecursorbrickstairsBlock(BeingmodModElements instance) {
		super(instance, 131);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(12f, 10f)).getDefaultState(),
					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(12f, 10f).lightValue(0).harvestLevel(6)
							.harvestTool(ToolType.PICKAXE));
			setRegistryName("precursorbrickstairs");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public boolean removedByPlayer(BlockState state, World world, BlockPos pos, PlayerEntity entity, boolean willHarvest, IFluidState fluid) {
			boolean retval = super.removedByPlayer(state, world, pos, entity, willHarvest, fluid);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				PrecursorbrickstairsBlockDestroyedByPlayerProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void onBlockClicked(BlockState state, World world, BlockPos pos, PlayerEntity entity) {
			super.onBlockClicked(state, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				PrecursorbricksPlayerStartsToDestroyProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
