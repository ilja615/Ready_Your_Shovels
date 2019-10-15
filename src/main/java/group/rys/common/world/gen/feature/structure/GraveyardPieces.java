package group.rys.common.world.gen.feature.structure;

import java.util.List;
import java.util.Random;

import group.rys.core.util.Reference;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class GraveyardPieces {
	
	private static final ResourceLocation graveyard_1 = new ResourceLocation(Reference.MOD_ID, "graveyard_1");
	private static final ResourceLocation graveyard_2 = new ResourceLocation(Reference.MOD_ID, "graveyard_2");
	
	private static final ResourceLocation[] structures = new ResourceLocation[] { graveyard_1, graveyard_2 };
	
	private static final BlockPos[] spawners_1 = new BlockPos[] { new BlockPos(3, 0, 2), new BlockPos(3, 0, 4), new BlockPos(3, 0, 6), new BlockPos(5, 0, 2), new BlockPos(5, 0, 4), new BlockPos(5, 0, 6) };
	private static final BlockPos[] spawners_2 = new BlockPos[] { new BlockPos(2, 0, 2), new BlockPos(2, 0, 5), new BlockPos(2, 0, 8), new BlockPos(4, 0, 2), new BlockPos(4, 0, 5), new BlockPos(4, 0, 8), new BlockPos(6, 0, 2), new BlockPos(6, 0, 5), new BlockPos(6, 0, 8), new BlockPos(8, 0, 2), new BlockPos(8, 0, 5), new BlockPos(8, 0, 8) };
	
	private static final IStructurePieceType GRAVEYARD = IStructurePieceType.register(GraveyardPieces.Piece::new, Reference.MOD_ID + ".graveyard");
	
	public static void addPieces(TemplateManager templateManagerIn, BlockPos blockpos, Rotation rotation, List<StructurePiece> components, Random rand) {
		int i = rand.nextInt(structures.length);
		
		components.add(new GraveyardPieces.Piece(templateManagerIn, structures[i], blockpos, rotation));
	}
	
	public static class Piece extends TemplateStructurePiece {
		
		private final ResourceLocation templateLocation;
		private final Rotation rotation;
		
		public Piece(TemplateManager templateManagerIn, ResourceLocation templateLocationIn, BlockPos blockpos, Rotation rotation) {
			super(GRAVEYARD, 0);
			this.templateLocation = templateLocationIn;
			this.rotation = rotation;
			this.templatePosition = blockpos;
			this.loadTemplate(templateManagerIn);
		}
		
		public Piece(TemplateManager templateManagerIn, CompoundNBT compoundnbt) {
			super(GRAVEYARD, 0);
			this.templateLocation = new ResourceLocation(compoundnbt.getString("Template"));
			this.rotation = Rotation.valueOf(compoundnbt.getString("Rot"));
			this.loadTemplate(templateManagerIn);
		}
		
		private void loadTemplate(TemplateManager templateManagerIn) {
			Template template = templateManagerIn.getTemplateDefaulted(this.templateLocation);
			PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(this.rotation).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
			this.setup(template, this.templatePosition, placementsettings);
		}
		
		protected void readAdditional(CompoundNBT tagCompound) {
			super.readAdditional(tagCompound);
			tagCompound.putString("Template", this.templateLocation.toString());
			tagCompound.putString("Rot", this.rotation.name());
		}
		
		protected void handleDataMarker(String function, BlockPos pos, IWorld worldIn, Random rand, MutableBoundingBox sbb) {
			
		}
		
		public boolean addComponentParts(IWorld worldIn, Random randomIn, MutableBoundingBox structureBoundingBoxIn, ChunkPos chunkpos) {
			BlockPos blockpos_1 = this.templatePosition;
			int i = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, blockpos_1.getX(), blockpos_1.getZ());
			
			this.templatePosition = this.templatePosition.add(0, i - 111, 0);
			
			PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(this.rotation).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
			
			boolean flag = super.addComponentParts(worldIn, randomIn, structureBoundingBoxIn, chunkpos);
			
			if (this.templateLocation.equals(graveyard_1)) {
				for (int j = 0; j < 1; j++) {
					BlockPos blockpos_2 = spawners_1[randomIn.nextInt(spawners_1.length)];
					BlockPos blockpos_3 = this.templatePosition.add(Template.transformedBlockPos(placementsettings, blockpos_2));
					
					worldIn.setBlockState(blockpos_3, Blocks.SPAWNER.getDefaultState(), 3);
					
					TileEntity tileentity = worldIn.getTileEntity(blockpos_3);
					if (tileentity instanceof MobSpawnerTileEntity) {
						((MobSpawnerTileEntity) tileentity).getSpawnerBaseLogic().setEntityType(EntityType.ZOMBIE);
					}
				}
			}
			
			if (this.templateLocation.equals(graveyard_2)) {
				for (int j = 0; j < 2; j++) {
					BlockPos blockpos_2 = spawners_2[randomIn.nextInt(spawners_2.length)];
					BlockPos blockpos_3 = this.templatePosition.add(Template.transformedBlockPos(placementsettings, blockpos_2));
					
					worldIn.setBlockState(blockpos_3, Blocks.SPAWNER.getDefaultState(), 3);
					
					TileEntity tileentity = worldIn.getTileEntity(blockpos_3);
					if (tileentity instanceof MobSpawnerTileEntity) {
						((MobSpawnerTileEntity) tileentity).getSpawnerBaseLogic().setEntityType(EntityType.ZOMBIE);
					}
				}
			}
			
			this.templatePosition = blockpos_1;
			return flag;
		}
		
	}
	
}
