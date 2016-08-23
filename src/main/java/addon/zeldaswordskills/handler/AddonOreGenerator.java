package addon.zeldaswordskills.handler;

import java.util.Random;

import addon.zeldaswordskills.items.AddonItems;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class AddonOreGenerator implements IWorldGenerator
{
	//Maybe rewrite this?
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimensionId())
		{
		case -1:
		    generateNether(world, rand, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, rand, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, rand, chunkX * 16, chunkZ * 16);
		    break;
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {}

	private void generateSurface(World world, Random random, int i, int j)
	{
		for(int k = 0; k < 10; k++)
		{
			BlockPos firstBlockPos = new BlockPos(i + random.nextInt(16), random.nextInt(50), j + random.nextInt(16));
			
			(new WorldGenMinable(AddonItems.metal1ore.getDefaultState(), 1)).generate(world, random, firstBlockPos);
			(new WorldGenMinable(AddonItems.metal2ore.getDefaultState(), 1)).generate(world, random, firstBlockPos);
			(new WorldGenMinable(AddonItems.metal3ore.getDefaultState(), 1)).generate(world, random, firstBlockPos);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {}
}
