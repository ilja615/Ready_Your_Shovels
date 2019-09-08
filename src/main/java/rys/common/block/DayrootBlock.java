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
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		DoubleBlockHalf doubleblockhalf = stateIn.get(HALF);
		
		if (facing.getAxis() != Direction.Axis.Y || (doubleblockhalf == DoubleBlockHalf.LOWER) != (facing == Direction.UP) || facingState.getBlock() == this && facingState.get(HALF) != doubleblockhalf ) {
			if ( doubleblockhalf == DoubleBlockHalf.UPPER && facing == Direction.UP && !stateIn.isValidPosition(worldIn, currentPos)) {
				return Blocks.AIR.getDefaultState();
			} else {
				return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
			}
		} else {
			return Blocks.AIR.getDefaultState();
		}
	}
	
	// BlockState getStateForPlacement(BlockPlaceContext)
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockState blockstate = context.getWorld().getBlockState(context.getPos().down());
		if (blockstate.isReplaceable(context)) {
			return super.getStateForPlacement(context);
		} else {
			return Blocks.AIR.getDefaultState();
		}
	}
	
	// void setPlacedBy(Level, BlockPos, BlockState, LivingEntity, ItemStack)
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		worldIn.setBlockState(pos.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), 3);
	}
	
	// boolean canSurvive(BlockState, LevelReader, BlockPos)
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState blockstate = worldIn.getBlockState(pos.up());
		if (state.get(HALF) == DoubleBlockHalf.UPPER) {
			return blockstate.getBlock() == Blocks.GRASS_BLOCK || Block.isDirt(blockstate.getBlock()) || Block.isRock(blockstate.getBlock());
		} else {
			return blockstate.getBlock() == this && blockstate.get(HALF) == DoubleBlockHalf.UPPER;
		}
	}
	
	// void placeAt(LevelAccessor, BlockPos, int)
	public void placeAt(IWorld worldIn, BlockPos pos, int flags) {
		worldIn.setBlockState(pos, this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), flags);
		worldIn.setBlockState(pos.down(), this.getDefaultState().with(HALF, DoubleBlockHalf.LOWER), flags);
	}
	
	// void playerDestroy(Level, Player, BlockPos, BlockState, BlockEntity, ItemStack)
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, player, pos, Blocks.AIR.getDefaultState(), te, stack);
	}
	
	// void playerWillDestroy(Level, BlockPos, BlockState, Player)
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		BlockPos blockpos = pos.up();
		
		if (state.get(HALF) == DoubleBlockHalf.UPPER) {
			blockpos = pos.down();
		}
		
		worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
		
		spawnDrops(state, worldIn, pos, null, player, player.getHeldItemMainhand());
		
		super.onBlockHarvested(worldIn, pos, state, player);
		super.onBlockHarvested(worldIn, blockpos, state, player);
	}
	
	// void createBlockStateDefinition(StateDefinition.Builder)
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF);
	}
	
}
