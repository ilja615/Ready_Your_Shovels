package rys.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class PlanterBoxBlock extends FarmlandBlock {
	
	public PlanterBoxBlock(Block.Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(BlockStateProperties.MOISTURE_0_7, Integer.valueOf(0)));
	}
	
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
		if (facing == Direction.UP) {
			PlantType type = plantable.getPlantType(world, pos.offset(facing));
			
			if (type == PlantType.Crop || type == PlantType.Plains || type == PlantType.Desert || type == PlantType.Cave) {
				return true;
			}
			
		}
		
		return false;
	}
	
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		return stateIn;
	}
	
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return true;
	}
	
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState();
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.fullCube();
	}
	
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		
	}
	
	public int tickRate(IWorldReader worldIn) {
		return 1;
	}
	
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		entityIn.fall(fallDistance, 1.0F);
	}
	
}
