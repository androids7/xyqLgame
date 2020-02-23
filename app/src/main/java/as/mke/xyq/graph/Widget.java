package as.mke.xyq.graph;

import android.graphics.Canvas;

import java.io.Serializable;

import loon.opengl.GLEx;

public interface  Widget extends Serializable {

    /**
     * 动画播放每帧的间隔(ms)
     */
    public static final int ANIMATION_INTERVAL = 100;

    void draw(GLEx g , int x, int y);

    void dispose();

    int getWidth();

    int getHeight();

    boolean contains(int x, int y);
}
