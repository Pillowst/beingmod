package net.mcreator.beingmod.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.block.Blocks;

import net.mcreator.beingmod.block.ManufactoryitemsinBlock;
import net.mcreator.beingmod.block.ManufactorygenericBlock;
import net.mcreator.beingmod.block.ManufactoryenergyBlock;
import net.mcreator.beingmod.block.ManufactoryUIBlock;
import net.mcreator.beingmod.block.FrameblockBlock;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;
import java.util.HashMap;

@BeingmodModElements.ModElement.Tag
public class FrameblockNeighbourBlockChangesProcedure extends BeingmodModElements.ModElement {
	public FrameblockNeighbourBlockChangesProcedure(BeingmodModElements instance) {
		super(instance, 142);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure FrameblockNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure FrameblockNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure FrameblockNeighbourBlockChanges!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure FrameblockNeighbourBlockChanges!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 0)))).getBlock() == FrameblockBlock.block.getDefaultState()
				.getBlock())) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("1"));
			}
			if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 1)))).getBlock() == FrameblockBlock.block
					.getDefaultState().getBlock())) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("1"));
				}
				if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.IRON_BARS.getDefaultState()
						.getBlock())) {
					{
						MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
						if (mcserv != null)
							mcserv.getPlayerList().sendMessage(new StringTextComponent("1"));
					}
					if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.IRON_BARS
							.getDefaultState().getBlock())) {
						{
							MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
							if (mcserv != null)
								mcserv.getPlayerList().sendMessage(new StringTextComponent("1"));
						}
						if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (y + 0), (int) (z + 1)))).getBlock() == Blocks.IRON_BLOCK
								.getDefaultState().getBlock())) {
							{
								MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
								if (mcserv != null)
									mcserv.getPlayerList().sendMessage(new StringTextComponent("1"));
							}
							if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 0), (int) (z + 0)))).getBlock() == Blocks.IRON_BLOCK
									.getDefaultState().getBlock())) {
								{
									MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
									if (mcserv != null)
										mcserv.getPlayerList().sendMessage(new StringTextComponent("1"));
								}
								if (((world.getBlockState(new BlockPos((int) (x - 0), (int) (y + 1), (int) (z + 0)))).getBlock() == Blocks.IRON_BLOCK
										.getDefaultState().getBlock())) {
									{
										Map<String, Object> $_dependencies = new HashMap<>();
										$_dependencies.put("world", world);
										$_dependencies.put("x", x);
										$_dependencies.put("y", y);
										$_dependencies.put("z", z);
										FrameblockemptyspaceProcedure.executeProcedure($_dependencies);
									}
									world.setBlockState(new BlockPos((int) x, (int) y, (int) z), ManufactoryUIBlock.block.getDefaultState(), 3);
									world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z),
											ManufactoryitemsinBlock.block.getDefaultState(), 3);
									world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z + 1)),
											ManufactoryenergyBlock.block.getDefaultState(), 3);
									world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) (z + 1)),
											ManufactorygenericBlock.block.getDefaultState(), 3);
									world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)),
											ManufactorygenericBlock.block.getDefaultState(), 3);
									world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z),
											ManufactorygenericBlock.block.getDefaultState(), 3);
									world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z),
											ManufactorygenericBlock.block.getDefaultState(), 3);
									world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)),
											ManufactorygenericBlock.block.getDefaultState(), 3);
								}
							}
						}
					}
				}
			}
		}
	}
}
