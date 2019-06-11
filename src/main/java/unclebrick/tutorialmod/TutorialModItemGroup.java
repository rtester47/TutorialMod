package unclebrick.tutorialmod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import unclebrick.tutorialmod.lists.BlockList;

public class TutorialModItemGroup extends ItemGroup
{

	public TutorialModItemGroup() 
	{
		super("tutorialmod_tab");
		
	}

	@Override
	public ItemStack createIcon() 
	{
		return  new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.tutorialmod_block_ore));
	}

}
