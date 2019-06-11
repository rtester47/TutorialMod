package unclebrick.tutorialmod.world;

import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;
import unclebrick.tutorialmod.lists.BlockList;

public class OreGeneration {

	private static final Predicate<IBlockState> IS_NETHERRACK = state -> state.getBlock() == Blocks.NETHERRACK;
	private static final Predicate<IBlockState> IS_ENDSTONE = state -> state.getBlock() == Blocks.END_STONE;
		
	public static void setupOreGeneration()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			CountRangeConfig tutorialmod_ore_placement = new CountRangeConfig(2, 0, 0, 10);// Count, MinHeight, MaxHeightBase, MaxHeight
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, BlockList.tutorialmod_block_ore.getDefaultState(), 20), new CountRange(), tutorialmod_ore_placement));
		
			CountRangeConfig tutorialmod_ore_nether_placement = new CountRangeConfig(2, 0, 0, 256);// Count, MinHeight, MaxHeightBase, MaxHeight
			biome.addFeature(Decoration.UNDERGROUND_ORES, new DimensionalGenerator<>(Feature.MINABLE, new MinableConfig(IS_NETHERRACK, BlockList.tutorialmod_block_ore_nether.getDefaultState(), 20), new CountRange(), tutorialmod_ore_nether_placement, DimensionType.NETHER));
	
			CountRangeConfig tutorialmod_ore_end_placement = new CountRangeConfig(2, 0, 0, 256);// Count, MinHeight, MaxHeightBase, MaxHeight
			biome.addFeature(Decoration.UNDERGROUND_ORES, new DimensionalGenerator<>(Feature.MINABLE, new MinableConfig(IS_ENDSTONE, BlockList.tutorialmod_block_ore_end.getDefaultState(), 20), new CountRange(), tutorialmod_ore_end_placement, DimensionType.THE_END));	
		}
	}

}
