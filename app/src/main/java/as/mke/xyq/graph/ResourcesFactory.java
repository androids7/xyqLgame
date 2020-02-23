package as.mke.xyq.graph;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

import loon.LTexture;
import loon.canvas.Image;
import loon.canvas.Pixmap;
import loon.canvas.TGA;
import loon.opengl.LTextureImage;
import loon.utils.ArrayByte;


//需要优化
/**
 * 图像资源工厂类<br>
 *
 * @author Langlauf
 * @date
 */
public class ResourcesFactory {

    public static TCPFrame[] getAnimationFrames(String filename, int index){
        //TODO
        return null;
    }

    public static LTexture[] createLImages(Bitmap[] bitmaps) throws Exception{
        LTexture[] images = new LTexture[bitmaps.length];
        for(int i=0;i<bitmaps.length;i++){
             ByteArrayOutputStream bo=new ByteArrayOutputStream();
            bitmaps[i].compress(Bitmap.CompressFormat.PNG,100,bo);
            ArrayByte ab=new ArrayByte(bo.toByteArray());

            TGA.State tga=TGA.load(ab,new TGA.State(),true,false);
            Image img=Image.createImage(tga.width,tga.height);
            images[i] = LTexture.createTexture(tga.width,tga.height);
            img.setPixels(tga.pixels,tga.width,tga.height);
            images[i].update(img);
        }
        return images;
    }
}

