package net.divinerpg.mob.entity.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityWreckStrengthShot extends EntityVetheanCannonShot
{
    public EntityWreckStrengthShot(World par1)
    {
        super(par1);
    }

    public EntityWreckStrengthShot(World par1, EntityLivingBase par2, int par3)
    {
        super(par1, par2, par3);
    }

    public EntityWreckStrengthShot(World par1, double par2, double par4, double par6)
    {
        super(par1, par2, par4, par6);
    }
}