package net.divinerpg.mob.entity.item;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityStromBall extends EntityThrowable
{
    public EntityStromBall(World var1)
    {
        super(var1);
    }

    public EntityStromBall(World var1, EntityLivingBase var3)
    {
        super(var1, var3);
    }

    public EntityStromBall(World var1, double var2, double var4, double var6)
    {
        super(var1, var2, var4, var6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition var1)
    {
        if (var1.entityHit != null)
        {
            byte var2 = 14;

            if (var1.entityHit instanceof EntityLiving)
            {
                var2 = 14;
            }

            if (var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2))
            {
                boolean var3 = true;
            }
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }

        if (var1.entityHit instanceof EntityLiving)
        {
            ((EntityLiving)var1.entityHit).setFire(3);
        }
    }
}
