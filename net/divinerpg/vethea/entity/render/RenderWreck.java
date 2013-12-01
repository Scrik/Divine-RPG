package net.divinerpg.vethea.entity.render;

import net.divinerpg.lib.Reference;
import net.divinerpg.render.entity.RenderLivingCreature;
import net.divinerpg.render.entity.model.WreckForm2;
import net.divinerpg.render.entity.model.WreckForm3;
import net.divinerpg.vethea.entity.EntityWreck;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWreck extends RenderLivingCreature
{
	private ModelBase form2 = new WreckForm2();
	private ModelBase form3 = new WreckForm3();
	public RenderWreck(ModelBase var1, float var2, ResourceLocation loc)
	{
		super(var1, var2, loc);
	}

	public void renderWreck(EntityWreck var1, double var2, double var4, double var6, float var8, float var9)
	{
		if (var1.stage == 1)
		{
			this.mainModel = form2;
		}
		else if (var1.stage == 2)
		{
			this.mainModel = form3;
		}

		BossStatus.setBossStatus(var1, true);
		super.doRenderLiving(var1, var2, var4, var6, var8, var9);
	}

	@Override
	public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
	{
		this.renderWreck((EntityWreck)var1, var2, var4, var6, var8, var9);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
	{
		this.renderWreck((EntityWreck)var1, var2, var4, var6, var8, var9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		if(EntityWreck.stage == 1){
			return new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/Wreck.png");
		}
		if(EntityWreck.stage == 2){
			return new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/WreckForm2.png");
		}
		if(EntityWreck.stage == 3){
			return new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/WreckForm3.png");
		}
		return new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/Wreck.png");
	}

}