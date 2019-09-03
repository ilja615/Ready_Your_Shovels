package rys.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class FruitTreeBlock extends BushBlock implements IGrowable {
	
	protected Item fruit;
	protected Item rottenFruit;
	
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
	public static final BooleanProperty DEAD = BooleanProperty.create("dead");
	
	private static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	
	public FruitTreeBlock(Item fruit, Item rottenFruit, Properties properties) {
		super(properties);
		this.fruit = fruit;
		this.rottenFruit = rottenFruit;
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)).with(DEAD, Boolean.valueOf(false)));
	}
	
	public Item getFruit() {
		return this.fruit;
	}
	
	public Item getRottenFruit() {
		return this.rottenFruit;
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
		int age = state.get(AGE);
		boolean isDead = state.get(DEAD);
		
		if (!worldIn.isAreaLoaded(pos, 1)) {
			return;
		}
		
		if (age < 3 && !isDead && worldIn.getLight(pos.up()) >= 9 && random.nextInt(7) == 0) {
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(age + 1)), 2);
		}
		
		if (age == 3 && !isDead && random.nextInt(28) == 0) {
			worldIn.setBlockState(pos, state.with(DEAD, true), 2);
		}
	}
	
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		ItemStack stack = player.getHeldItem(handIn);
		Item item = stack.getItem();
		
		int age = state.get(AGE);
		boolean isDead = state.get(DEAD);
		
		if (item == Items.BONE_MEAL && age < 3) {
			return false;
		}
		
		if (age == 3 && !isDead) {
			if (worldIn.rand.nextInt(10) == 0) {
				spawnAsEntity(worldIn, pos, new ItemStack(this.rottenFruit));
			} else {
				spawnAsEntity(worldIn, pos, new ItemStack(this.fruit, 1 + worldIn.rand.nextInt(4)));
			}
			
			worldIn.playSound(null, pos, SoundEvents.ITEM_SWEET_BERRIES_PICK_FROM_BUSH, SoundCategory.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(2)), 2);
			
			return true;
		}
		
		return false;
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE, DEAD);
	}
	
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.get(AGE) < 3;
	}
	
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return worldIn.rand.nextFloat() < 0.45F;
	}
	
	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
		int i = Math.min(3, state.get(AGE) + 1);
		worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i)), 2);
	}
	
}
