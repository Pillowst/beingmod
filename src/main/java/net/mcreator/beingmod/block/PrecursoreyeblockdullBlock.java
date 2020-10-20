
package net.mcreator.beingmod.block;

import net.minecraft.block.material.Material;

@BeingmodModElements.ModElement.Tag
public class PrecursoreyeblockdullBlock extends BeingmodModElements.ModElement {

	@ObjectHolder("beingmod:precursoreyeblockdull")
	public static final Block block = null;

	public PrecursoreyeblockdullBlock(BeingmodModElements instance) {
		super(instance, 173);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(AnomalousmaterialsItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(12f, 10f).lightValue(0).harvestLevel(6)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("precursoreyeblockdull");
		}

		@Override
		public int tickRate(IWorldReader world) {
			return 100;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean moving) {
			super.onBlockAdded(state, world, pos, oldState, moving);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, this.tickRate(world));
		}

		@Override
		public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
			super.tick(state, world, pos, random);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				PrecursoreyeblockdullUpdateTickProcedure.executeProcedure($_dependencies);
			}
			world.getPendingBlockTicks().scheduleTick(new BlockPos(x, y, z), this, this.tickRate(world));
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
