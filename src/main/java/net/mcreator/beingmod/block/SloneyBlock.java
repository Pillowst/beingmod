
package net.mcreator.beingmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.item.BucketItem;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.beingmod.procedures.SloneyMobplayerCollidesBlockProcedure;
import net.mcreator.beingmod.itemgroup.AnomalousmaterialsItemGroup;
import net.mcreator.beingmod.BeingmodModElements;

import java.util.Map;
import java.util.HashMap;

@BeingmodModElements.ModElement.Tag
public class SloneyBlock extends BeingmodModElements.ModElement {
	@ObjectHolder("beingmod:sloney")
	public static final FlowingFluidBlock block = null;
	@ObjectHolder("beingmod:sloney_bucket")
	public static final Item bucket = null;
	public static FlowingFluid flowing = null;
	public static FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;
	public SloneyBlock(BeingmodModElements instance) {
		super(instance, 217);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerFluids(RegistryEvent.Register<Fluid> event) {
		event.getRegistry().register(still);
		event.getRegistry().register(flowing);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes.builder(new ResourceLocation("beingmod:blocks/amber"), new ResourceLocation("beingmod:blocks/amber")).luminosity(0)
						.density(14).viscosity(0)).bucket(() -> bucket).block(() -> block);
		still = (FlowingFluid) new ForgeFlowingFluid.Source(fluidproperties).setRegistryName("sloney");
		flowing = (FlowingFluid) new ForgeFlowingFluid.Flowing(fluidproperties).setRegistryName("sloney_flowing");
		elements.blocks.add(() -> new FlowingFluidBlock(still, Block.Properties.create(Material.WATER)) {
			@Override
			public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
				super.onEntityCollision(state, world, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					SloneyMobplayerCollidesBlockProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("sloney"));
		elements.items.add(
				() -> new BucketItem(still, new Item.Properties().containerItem(Items.BUCKET).maxStackSize(1).group(AnomalousmaterialsItemGroup.tab))
						.setRegistryName("sloney_bucket"));
	}
}
