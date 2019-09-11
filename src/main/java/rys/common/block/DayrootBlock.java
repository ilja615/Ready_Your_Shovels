package rys.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
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
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class DayrootBlock extends BushBlock {
	
	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	
	public DayrootBlock(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.UPPER));
	}
	
	// BlockState updateShape(BlockState, Direction, BlockState, LevelAccessor, BlockPos, BlockPos)
	public BlockState updatePostPlacement(BlockState state, Direction direction, BlockState directionState, IWorld world, BlockPos currentPos, BlockPos directionPos) {
		DoubleBlockHalf half = state.get(HALF);
		
		if ((half == DoubleBlockHalf.UPPER && direction == Direction.DOWN && directionState.getBlock() == this && directionState.get(HALF) != half) || (half == DoubleBlockHalf.LOWER && direction == Direction.UP && directionState.getBlock() == this && directionState.get(HALF) != half) || (half == DoubleBlockHalf.LOWER && direction == Direction.DOWN) || (direction.getAxis() != Direction.Axis.Y)) {
			return super.updatePostPlacement(state, direction, directionState, world, currentPos, directionPos);
		} else {
			return Blocks.AIR.getDefaultState();
		}
	}
	
	// BlockState getStateForPlacement(BlockPlaceContext)
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if (context.getWorld().getBlockState(context.getPos().down()).isReplaceable(context)) {
			return super.getStateForPlacement(context);
		} else {
			return Blocks.AIR.getDefaultState();
		}
	}
	
	// void setPlacedBy(Level, BlockPos, BlockState, LivingEntity, ItemStack)
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		world.setBlockState(pos.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), 3);
	}
	
	// boolean canSurvive(BlockState, LevelReader, BlockPos)
	public boolean isValidPosition(BlockState state, IWorldReader world, BlockPos pos) {
		BlockState state_1 = world.getBlockState(pos.up());
		
		if (state.get(HALF) == DoubleBlockHalf.UPPER) {
			return state_1.canSustainPlant(world, pos.up(), Direction.DOWN, this);
		} else {
			return state_1.getBlock() == this && state_1.get(HALF) == DoubleBlockHalf.UPPER;
		}
	}
	
	// void placeAt(LevelAccessor, BlockPos, int)
	public void placeAt(IWorld world, BlockPos pos, int flags) {
		world.setBlockState(pos, this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), flags);
		world.setBlockState(pos.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), flags);
	}
	
	// void playerDestroy(Level, Player, BlockPos, BlockState, BlockEntity, ItemStack)
	public void harvestBlock(World world, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te, ItemStack stack) {
		super.harvestBlock(world, player, pos, Blocks.AIR.getDefaultState(), te, stack);
	}
	
	// void playerWillDestroy(Level, BlockPos, BlockState, Player)
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
	
	// void createBlockStateDefinition(StateDefinition.Builder)
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF);
	}
	
}
