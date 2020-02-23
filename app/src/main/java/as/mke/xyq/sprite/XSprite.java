package as.mke.xyq.sprite;

import as.mke.xyq.graph.ResourcesFactory;
import as.mke.xyq.graph.SpriteFactory;
import loon.LTexture;
import loon.action.sprite.Sprite;
import loon.opengl.LTextureImage;

/**
 * Created by IntelliJ IDEA.
 * <p/>
 * User: gongdewei
 * Date: 12-3-20
 * Time: 下午9:51
 */
public class XSprite extends Sprite {

    public static final int DIR_DOWN = 0x4;

    public static final int DIR_DOWN_LEFT = 0x1;

    public static final int DIR_DOWN_RIGHT = 0x0;

    public static final int DIR_LEFT = 0x5;

    public static final int DIR_RIGHT = 0x7;

    public static final int DIR_UP = 0x6;

    public static final int DIR_UP_LEFT = 0x2;

    public static final int DIR_UP_RIGHT = 0x3;

    /**
     * 动画播放每帧的间隔(ms)
     */
    public static final int ANIMATION_INTERVAL = 100;
    private String resName;

    public XSprite(String spriteName, String resName, double x, double y) {

        super(spriteName, new LTexture[0],0, (float)x,(float) y, ANIMATION_INTERVAL);

        this.resName = resName;
    }

    public XSprite(String spriteName, String fileName, int animIndex, double x, double y) {
        this(spriteName, fileName, x, y);
        this.setDirection(animIndex);
    }

    public void setDirection(int animIndex){
        LTexture[] images = SpriteFactory.loadAnimationAsBitmap(resName, animIndex);
                //ResourcesFactory.createLImages(SpriteFactory.loadAnimationAsBitmap(resName, animIndex));
        setAnimation(images, -1, ANIMATION_INTERVAL);
    }

}

