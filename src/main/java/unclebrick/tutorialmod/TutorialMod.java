package unclebrick.tutorialmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import unclebrick.tutorialmod.block.BlockCustomSlab;
import unclebrick.tutorialmod.block.BlockCustomStairs;
import unclebrick.tutorialmod.items.ItemCustomAxe;
import unclebrick.tutorialmod.items.ItemCustomPickaxe;
import unclebrick.tutorialmod.lists.ArmorMateriallist;
import unclebrick.tutorialmod.lists.BlockList;
import unclebrick.tutorialmod.lists.ItemList;
import unclebrick.tutorialmod.lists.ToolMaterialList;
import unclebrick.tutorialmod.world.OreGeneration;

@Mod("tutorialmod")
public class TutorialMod
{
	public static TutorialMod instance;
	public static final String modid = "tutorialmod";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup tutorialmod_tab = new TutorialModItemGroup();
	
	public TutorialMod()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		logger.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event) 
	{
		logger.info("ClientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
			event.getRegistry().registerAll
			(
				ItemList.tutorialmod_block_block = new ItemBlock(BlockList.tutorialmod_block_block, new Item.Properties().group(tutorialmod_tab)).setRegistryName(BlockList.tutorialmod_block_block.getRegistryName()),
				ItemList.tutorialmod_block_ore = new ItemBlock(BlockList.tutorialmod_block_ore, new Item.Properties().group(tutorialmod_tab)).setRegistryName(BlockList.tutorialmod_block_ore.getRegistryName()),
				ItemList.tutorialmod_block_ore_end = new ItemBlock(BlockList.tutorialmod_block_ore_end, new Item.Properties().group(tutorialmod_tab)).setRegistryName(BlockList.tutorialmod_block_ore_end.getRegistryName()),
				ItemList.tutorialmod_block_ore_nether = new ItemBlock(BlockList.tutorialmod_block_ore_nether, new Item.Properties().group(tutorialmod_tab)).setRegistryName(BlockList.tutorialmod_block_ore_nether.getRegistryName()),
				ItemList.tutorialmod_block_stairs = new ItemBlock(BlockList.tutorialmod_block_stairs, new Item.Properties().group(tutorialmod_tab)).setRegistryName(BlockList.tutorialmod_block_stairs.getRegistryName()),
				ItemList.tutorialmod_block_slab = new ItemBlock(BlockList.tutorialmod_block_slab, new Item.Properties().group(tutorialmod_tab)).setRegistryName(BlockList.tutorialmod_block_slab.getRegistryName()),
				
				ItemList.tutorialmod_item_axe = new ItemCustomAxe(ToolMaterialList.tutorialmod_tool_material, 5f, -3.0f, new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_axe")),
				ItemList.tutorialmod_item_boots = new ItemArmor(ArmorMateriallist.tutorialmod_armor_material, EntityEquipmentSlot.FEET, new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_boots")),
				ItemList.tutorialmod_item_chestplate = new ItemArmor(ArmorMateriallist.tutorialmod_armor_material, EntityEquipmentSlot.CHEST, new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_chestplate")),
				ItemList.tutorialmod_item_helmet = new ItemArmor(ArmorMateriallist.tutorialmod_armor_material, EntityEquipmentSlot.HEAD, new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_helmet")),
				ItemList.tutorialmod_item_hoe = new ItemHoe(ToolMaterialList.tutorialmod_tool_material, 0f, new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_hoe")),
			    ItemList.tutorialmod_item_ingot = new Item(new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_ingot")),
				ItemList.tutorialmod_item_leggings = new ItemArmor(ArmorMateriallist.tutorialmod_armor_material, EntityEquipmentSlot.LEGS, new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_leggings")),
				ItemList.tutorialmod_item_nugget = new Item(new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_nugget")),
				ItemList.tutorialmod_item_pickaxe = new ItemCustomPickaxe(ToolMaterialList.tutorialmod_tool_material, 1, -2.8f, new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_pickaxe")),
				ItemList.tutorialmod_item_shovel = new ItemSpade(ToolMaterialList.tutorialmod_tool_material, 1.5f, -3.0f, new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_shovel")),
				ItemList.tutorialmod_item_sword = new ItemSword(ToolMaterialList.tutorialmod_tool_material, 3, -2.4f, new Item.Properties().group(tutorialmod_tab)).setRegistryName(location("tutorialmod_item_sword"))
				
			);
			
			logger.info("Items registered.");
		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) 
		{
			event.getRegistry().registerAll
			(
				BlockList.tutorialmod_block_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("tutorialmod_block_block")),
				BlockList.tutorialmod_block_ore_end = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("tutorialmod_block_ore_end")),
				BlockList.tutorialmod_block_ore_nether = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("tutorialmod_block_ore_nether")),
				BlockList.tutorialmod_block_ore = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.STONE)).setRegistryName(location("tutorialmod_block_ore")),
				BlockList.tutorialmod_block_stairs = new BlockCustomStairs(BlockList.tutorialmod_block_block.getDefaultState(), Block.Properties.from(BlockList.tutorialmod_block_block)).setRegistryName(location("tutorialmod_block_stairs")),
				BlockList.tutorialmod_block_slab = new BlockCustomSlab(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0f, 3.0f).lightValue(0).sound(SoundType.METAL)).setRegistryName(location("tutorialmod_block_slab"))

			);
			
			logger.info("Blocks registered.");
		}
		
		private static ResourceLocation location(String name) 
		{
			return new ResourceLocation(modid, name);
		}
	}
}