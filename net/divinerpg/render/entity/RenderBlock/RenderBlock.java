package net.divinerpg.render.entity.RenderBlock;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderBlock extends Render {

    public static interface IBlockRender {

        public int getBlockID();

        public int getBlockMeta();

        public float getBlockScale();

    }

    // Render for entities that renders a block at the entity position

    @Override
    public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        GL11.glPushMatrix();
        //loadTexture("/terrain.png");
        Block block = Block.blocksList[((IBlockRender)var1).getBlockID()];
        int meta = ((IBlockRender)var1).getBlockMeta();
        float scale = ((IBlockRender)var1).getBlockScale();
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef((float)var2 - (0.5F * scale), (float)var4, (float)var6 - (0.5F * scale));
        renderBlocks.renderBlockAsItem(block, meta, 1F);
        GL11.glPopMatrix();
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}