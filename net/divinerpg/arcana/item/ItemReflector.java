package net.divinerpg.arcana.item;

import java.util.List;

import net.divinerpg.arcana.ArcanaHelper;
import net.divinerpg.helper.base.ItemsBase;
import net.divinerpg.lib.Sound;
import net.divinerpg.mob.entity.item.EntityReflector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemReflector extends ItemsBase
{
    private int weaponDamage;

    public ItemReflector(int var1)
    {
        super(var1);
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
        this.weaponDamage = 0;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
    {
    	boolean var4 = var3.capabilities.isCreativeMode;
    	if (!var2.isRemote && ArcanaHelper.useBar(var3, 20))
    	{
        	var2.playSoundAtEntity(var3, Sound.Reflector, 1.0F, 1.0F);
    		var2.spawnEntityInWorld(new EntityReflector(var2));
    	}
    	return var1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * Returns the damage against a given entity.
     */
    public int getDamageVsEntity(Entity var1)
    {
        return this.weaponDamage;
    }

    @Override
    @SideOnly(Side.CLIENT)

    /**
     * allows items to add custom lines of information to the mouseover description
     */
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add("20 Arcana");
        par3List.add("Knocks entities away");
        par3List.add("No damage");
        //par3List.add(par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() + " Uses");
    }
}