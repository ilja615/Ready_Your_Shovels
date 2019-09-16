package rys.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class DayrootBlock extends BushBlock implements IGrowable {
	
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	
	public DayrootBlock(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.UPPER));
	}
	
	public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState directionState, IWorld world, BlockPos currentPos, BlockPos directionPos) {
		DoubleBlockHalf half = state.get(HALF);
		
		if ((direction.getAxis() != Direction.Axis.Y) || (half == DoubleBlockHalf.UPPER && direction == Direction.DOWN && directionState.getBlock() == this && directionState.get(HALF) != half) || (half == DoubleBlockHalf.LOWER && direction == Direction.UP && directionState.getBlock() == this && directionState.get(HALF) != half) || (half == DoubleBlockHalf.LOWER && direction == Direction.DOWN)) {
			return super.updatePostPlacement(state, direction, directionState, world, currentPos, directionPos);
		} else {
			return Blocks.AIR.getDefaultState();
		}
	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if (context.getWorld().getBlockState(context.getPos().down()).isReplaceable(context)) {
			return super.getStateForPlacement(context);
		} else {
			return null;
		}
	}
	
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		world.setBlockState(pos.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), 3);
	}
	
	public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
		BlockState state_1 = world.getBlockState(pos.up());
		
		if (state.get(HALF) == DoubleBlockHalf.UPPER) {
			return state_1.canSustainPlant(world, pos.up(), Direction.DOWN, this) || Block.isRock(state_1.getBlock());
		} else {
			return state_1.getBlock() == this && state_1.get(HALF) == DoubleBlockHalf.UPPER;
		}
	}
	
	public void placeAt(IWorld world, BlockPos pos, int flags) {
		world.setBlockState(pos, this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), flags);
		world.setBlockState(pos.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), flags);
	}
	
	public void harvestBlock(World world, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te, ItemStack stack) {
		super.harvestBlock(world, player, pos, Blocks.AIR.getDefaultState(), te, stack);
	}
	
	public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		BlockPos pos_1 = pos.up();
		
		if (state.get(HALF) == DoubleBlockHalf.UPPER) {
			pos_1 = pos.down();
		}
		
		world.setBlockState(pos_1, Blocks.AIR.getDefaultState(), 35);
		
		if (!world.isRemote() && !player.isCreative()) {
			spawnDrops(state, world, pos, null, player, player.getHeldItemMainhand());
		}
		
		super.onBlockHarvested(world, pos, state, player);
		super.onBlockHarvested(world, pos_1, state, player);
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF);
	}
	
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}
	
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}
	
	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
		for (int n = 0; n < 16; n++) {
			int x = rand.nextInt(9) - 4;
			int z = rand.nextInt(9) - 4;
			int y = rand.nextInt(5) - 2;
			
			BlockPos pos_n = pos.add(x, y, z);
			
			if (rand.nextFloat() < 0.5F) {
				if (worldIn.isAirBlock(pos_n) && worldIn.isAirBlock(pos_n.down()) && state.isValidPosition(worldIn, pos_n)) {
					this.placeAt(worldIn, pos_n, 3);
				}
			}
		}
	}
	
}
