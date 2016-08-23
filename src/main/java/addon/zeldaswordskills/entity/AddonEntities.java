package addon.zeldaswordskills.entity;

import java.util.HashMap;
import java.util.Map;

import addon.zeldaswordskills.ZSSAddon;
import addon.zeldaswordskills.entity.bugs.EntityBigBeetle;
import addon.zeldaswordskills.entity.bugs.EntitySmallBeetle;
import addon.zeldaswordskills.entity.bugs.EntityVolcanicLadybug;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import zeldaswordskills.ZSSMain;
import zeldaswordskills.entity.CustomEntityList;
import zeldaswordskills.util.BiomeType;
import zeldaswordskills.util.SpawnableEntityData;

public class AddonEntities
{
	private static final Map<Class<? extends EntityLiving>, String[]> defaultSpawnListsAddon = new HashMap<Class<? extends EntityLiving>, String[]>();

	private static final Map<Class<? extends EntityLiving>, SpawnableEntityData> spawnableEntityDataAddon = new HashMap<Class<? extends EntityLiving>, SpawnableEntityData>();

	public static void preInit() {
		registerEntities();
		addSpawnLocations(EntityLandOctorok.class, BiomeType.PLAINS.defaultBiomes);
		addSpawnLocations(EntityGoldOctorok.class, BiomeType.ARID.defaultBiomes);
		addSpawnLocations(EntitySmallBeetle.class, BiomeType.JUNGLE.defaultBiomes);
		addSpawnLocations(EntityBigBeetle.class, BiomeType.JUNGLE.defaultBiomes);
		addSpawnLocations(EntityVolcanicLadybug.class, BiomeType.FIERY.defaultBiomes);
		addSpawnLocations(EntityCucco.class, BiomeType.PLAINS.defaultBiomes);
		
		CustomEntityList.addMapping(EntityLandOctorok.class, "landOctorok", 0xFF0000, 0xFFFFFF, 0x0066FF, 0xFFFFFF);
		CustomEntityList.addMapping(EntitySmallBeetle.class, "smallBeetle", 0x66FF33, 0x003399);
		CustomEntityList.addMapping(EntityBigBeetle.class, "bigBeetle", 0xFFD700, 0x003399);
		CustomEntityList.addMapping(EntityVolcanicLadybug.class, "volcanicLadybug", 0x474747, 0xb80000);
		CustomEntityList.addMapping(EntityGoldOctorok.class, "goldOctorok", 0xFFD700, 0xFFFFFF);
		CustomEntityList.addMapping(EntityCucco.class, "cucco", 0xFFFFFF, 0xFF3300);
		CustomEntityList.addMapping(EntityCuccoAngry.class, "cuccoAngry", 0xFF4D4D, 0xFF3300);
		CustomEntityList.addMapping(EntityCuccoGolden.class, "cuccoGolden", 0xFFFFFF, 0xFFD700);
	}

	/**
	 * Initializes entity spawn rates, spawn locations, and adds spawns.
	 */
	public static void postInit(Configuration config)
	{
		// REGISTER ENTITY SPAWN DATA
		int rate = config.get("Mob Spawns", "[Spawn Rate] Land Octorok spawn rate (0 to disable)[0+]", 2).getInt();
		addSpawnableEntityData(EntityLandOctorok.class, EnumCreatureType.MONSTER, 2, 4, rate);
		rate = config.get("Mob Spawns", "[Spawn Rate] Small Beetle spawn rate (0 to disable)[0+]", 2).getInt();
		addSpawnableEntityData(EntitySmallBeetle.class, EnumCreatureType.CREATURE, 2, 3, rate);
		rate = config.get("Mob Spawns", "[Spawn Rate] Big Beetle spawn rate (0 to disable)[0+]", 1).getInt();
		addSpawnableEntityData(EntitySmallBeetle.class, EnumCreatureType.CREATURE, 1, 2, rate);
		rate = config.get("Mob Spawns", "[Spawn Rate] Small Beetle spawn rate (0 to disable)[0+]", 1).getInt();
		addSpawnableEntityData(EntityVolcanicLadybug.class, EnumCreatureType.CREATURE, 1, 1, rate);
		rate = config.get("Mob Spawns", "[Spawn Rate] Cucco spawn rate (0 to disable)[0+]", 3).getInt();
		addSpawnableEntityData(EntityCucco.class, EnumCreatureType.CREATURE, 3, 4, rate);

		addSpawnableEntityData(EntityGoldOctorok.class, EnumCreatureType.MONSTER, 1, 1, 1);
		addSpawnableEntityData(EntityCuccoGolden.class, EnumCreatureType.MONSTER, 1, 1, 1);

		// ALLOWED BIOMES
		for (Class<? extends EntityLiving> entity : defaultSpawnListsAddon.keySet()) {
			String[] defaultBiomes = defaultSpawnListsAddon.get(entity);
			SpawnableEntityData spawnData = spawnableEntityDataAddon.get(entity);
			if (defaultBiomes != null && spawnData != null && spawnData.spawnRate > 0) {
				String[] biomes = config.get("Mob Spawns", String.format("[Spawn Biomes] List of biomes in which %s are allowed to spawn", entity.getName().substring(entity.getName().lastIndexOf(".") + 1)), defaultBiomes).getStringList();
				if (biomes != null) {
					addSpawns(entity, biomes, spawnData);
				}
			}
		}
	}

	private static void addSpawns(Class<? extends EntityLiving> entity, String[] biomes, SpawnableEntityData spawnData) {
		for (String name : biomes) {
			BiomeGenBase biome = getBiomeByName(name);
			if (biome != null) {
				EntityRegistry.addSpawn(entity, spawnData.spawnRate, spawnData.min, spawnData.max, spawnData.creatureType, biome);
			} else {
				ZSSMain.logger.warn(String.format("Unable to find matching biome for %s while adding spawns for %s!", name, entity.getName().substring(entity.getName().lastIndexOf(".") + 1)));
			}
		}
	}
	
	private static BiomeGenBase getBiomeByName(String name)
	{
		for (BiomeGenBase biome : BiomeGenBase.getBiomeGenArray())
		{
			if (biome != null && biome.biomeName != null && biome.biomeName.toLowerCase().replace(" ", "").equals(name.toLowerCase().replace(" ", "")))
			{
				return biome;
			}
		}
		return null;
	}

	private static void registerEntities()
	{
		int modEntityIndex = 0;
		EntityRegistry.registerModEntity(EntityLandOctorok.class, "landOctorok", ++modEntityIndex, ZSSAddon.instance, 64, 3, true);
    	EntityRegistry.registerModEntity(EntitySmallBeetle.class, "smallBeetle", ++modEntityIndex, ZSSAddon.instance, 64, 3, true);
    	EntityRegistry.registerModEntity(EntityBigBeetle.class, "bigBeetle", ++modEntityIndex, ZSSAddon.instance, 64, 3, true);
    	EntityRegistry.registerModEntity(EntityVolcanicLadybug.class, "volcanicLadybug", ++modEntityIndex, ZSSAddon.instance, 64, 3, true);
    	EntityRegistry.registerModEntity(EntityGoldOctorok.class, "goldOctorok", ++modEntityIndex, ZSSAddon.instance, 64, 3, true);
    	EntityRegistry.registerModEntity(EntityCucco.class, "cucco", ++modEntityIndex, ZSSAddon.instance, 64, 3, true);
    	EntityRegistry.registerModEntity(EntityCuccoAngry.class, "cuccoAngry", ++modEntityIndex, ZSSAddon.instance, 64, 3, true);
    	EntityRegistry.registerModEntity(EntityCuccoGolden.class, "cuccoGolden", ++modEntityIndex, ZSSAddon.instance, 64, 3, true);
    }

	public static void registerEntity(Class<? extends EntityLiving> entityClass, String name, int modEntityIndex, int trackingRange, int primaryColor, int secondaryColor)
	{
		EntityRegistry.registerModEntity(entityClass, name, modEntityIndex, ZSSMain.instance, trackingRange, 3, true);
		CustomEntityList.addMapping(entityClass, name, primaryColor, secondaryColor);
	}

	private static void addSpawnableEntityData(Class<? extends EntityLiving> entity, EnumCreatureType creatureType, int min, int max, int spawnRate) {
		if (spawnableEntityDataAddon.containsKey(entity)) {
			ZSSMain.logger.warn("Spawnable entity " + entity.getName().substring(entity.getName().lastIndexOf(".") + 1) + " has already been registered!");
		} else {
			spawnableEntityDataAddon.put(entity, new SpawnableEntityData(creatureType, min, max, spawnRate));
		}
	}

	private static void addSpawnLocations(Class<? extends EntityLiving> entity, String... biomes) {
		if (biomes != null && biomes.length > 0) {
			if (defaultSpawnListsAddon.containsKey(entity)) {
				ZSSMain.logger.warn(entity.getName().substring(entity.getName().lastIndexOf(".") + 1) + " already has an array of default spawn locations!");
			} else {
				defaultSpawnListsAddon.put(entity, biomes);
			}
		}
	}
}