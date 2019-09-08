package rys.common.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.Tags;
import rys.common.block.ModBlocks;

public class CaveFeature extends Feature<NoFeatureConfig> {
	
	private static BlockPos[] arrayOfPos = new BlockPos[] { new BlockPos(-1, -1, -1), new BlockPos(-1, -1, 0), new BlockPos(-1, -1, 1), new BlockPos(0, -1, -1), new BlockPos(0, -1, 0), new BlockPos(0, -1, 1), new BlockPos(1, -1, -1), new BlockPos(1, -1, 0), new BlockPos(1, -1, 1), new BlockPos(-1, 0, -1), new BlockPos(-1, 0, 0), new BlockPos(-1, 0, 1), new BlockPos(0, 0, -1), new BlockPos(0, 0, 1), new BlockPos(1, 0, -1), new BlockPos(1, 0, 0), new BlockPos(1, 0, 1), new BlockPos(-1, 1, -1), new BlockPos(-1, 1, 0), new BlockPos(-1, 1, 1), new BlockPos(0, 1, -1), new BlockPos(0, 1, 0), new BlockPos(0, 1, 1), new BlockPos(1, 1, -1), new BlockPos(1, 1, 0), new BlockPos(1, 1, 1) };
	
	public CaveFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}
	
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int surfaceY = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, pos.add(x, 0, z)).getY();
				
				Biome biome = worldIn.getBiome(pos.add(x, 0, z));
				String name = biome.getRegistryName().toString();
				
				if (!name.contains("ocean") && !name.contains("mountains") && !name.contains("river") && !name.contains("stone")) {
					for (int y = surfaceY - 20; y < surfaceY; y++) {
						this.tryPlace(worldIn, pos.add(x, y, z));
					}
					
					this.tryPlaceLayer(worldIn, rand, pos.add(x, surfaceY - 20, z));
				}
			}
		}
		
		return true;
	}
	
	private void tryPlace(IWorld world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		
		if (state.isIn(Tags.Blocks.STONE)) {
			this.trySetBlockState(world, pos, ModBlocks.tough_dirt.getDefaultState());
		}
		
		if (state.getBlock() == Blocks.COAL_ORE) {
			this.trySetBlockState(world, pos, ModBlocks.peat_deposit.getDefaultState());
		}
		
		if (state.getBlock() == Blocks.IRON_ORE) {
			this.trySetBlockState(world, pos, ModBlocks.iron_deposit.getDefaultState());
		}
		
		if (state.getBlock() == Blocks.GOLD_ORE) {
			this.trySetBlockState(world, pos, ModBlocks.gold_deposit.getDefaultState());
		}
	}
	
	private void tryPlaceLayer(IWorld world, Random random, BlockPos pos) {
		BlockPos pos_0 = pos.add(0, random.nextInt(2) - random.nextInt(2), 0);
		BlockPos pos_1 = pos.add(0, (random.nextInt(2) - random.nextInt(2)) - 1, 0);
		BlockPos pos_2 = pos.add(0, (random.nextInt(2) - random.nextInt(2)) - 2, 0);
		
		BlockState state_0 = world.getBlockState(pos_0);
		BlockState state_1 = world.getBlockState(pos_1);
		BlockState state_2 = world.getBlockState(pos_2);
		
		if (state_0.isIn(Tags.Blocks.STONE) || state_0.getBlock() == ModBlocks.tough_dirt) {
			this.trySetBlockState(world, pos_0, ModBlocks.regolith.getDefaultState());
		}
		
		if (state_1.isIn(Tags.Blocks.STONE) || state_1.getBlock() == ModBlocks.tough_dirt) {
			this.trySetBlockState(world, pos_1, ModBlocks.regolith.getDefaultState());
		}
		
		if (state_2.isIn(Tags.Blocks.STONE) || state_2.getBlock() == ModBlocks.tough_dirt) {
			this.trySetBlockState(world, pos_2, ModBlocks.regolith.getDefaultState());
		}
	}
	
	private void trySetBlockState(IWorld world, BlockPos pos, BlockState state) {
		for (BlockPos posInArray : arrayOfPos) {
			if (world.isAirBlock(pos.add(posInArray))) {
				this.setBlockState(world, pos, state);
			}
		}
	}
	
}
