package as.mke.xyq;

import android.os.Bundle;

import as.mke.xyq.screen.TitleScreen;
import loon.LSystem;
import loon.Screen;
import loon.android.AndroidGame;
import loon.android.Loon;
import loon.font.LFont;

public class MainActivity extends Loon
{

   // public static LFont DEFAULT_FONT=LFont.getFont(LSystem.getSystemGameFontName(),0,16);
    private final static float TARGET_HEAP_UTILIZATION = 0.99f;

    private final static int CWJ_HEAP_SIZE = 5* 1024* 1024 ;

    public static final float NORMAL_SPEED = 0.13f;
    //    public static final float NORMAL_SPEED = 0.12f;
//    public static final float BEVEL_SPEED = 0.071f;
    public static final int STEP_DISTANCE = 20;

    private static boolean debug;

    public static MainActivity instance;
    @Override
    public void onMain()
    {
        /*
        try {
            Class<?> vmRumTimeClass;
            vmRumTimeClass = Class.forName("dalvik.system.VMRuntime");
            Object runtime = vmRumTimeClass.getMethod("getRuntime").invoke(null);
            vmRumTimeClass.getMethod("setTargetHeapUtilization", Float.TYPE).invoke(runtime, TARGET_HEAP_UTILIZATION);
            vmRumTimeClass.getMethod("setMinimumHeapSize", Long.TYPE).invoke(runtime, CWJ_HEAP_SIZE);
        } catch (Exception e) {
            throw new RuntimeException("设置VM出错！");
        }
        */

        this.instance=this;
        AndroidGame.AndroidSetting setting=new AndroidGame.AndroidSetting();
        setting.isFPS=true;
        setting.isMemory=true;
        setting.isLogo=false;
        setting.fullscreen=true;
        setting.width=800;
        setting.height=600;
        setting.fontName = "Dialog";
        setting.useOrientation=false;//设置横屏
       //setting.useRatioScaleFactor=true;
        setting.fps=60;
        register(setting,new Data(){
            @Override
            public Screen onScreen() {
                return new TitleScreen();
            }
        });
    }

    /**
     * 人物升级经验表
     */
    private static final int [] levelExpTable =
            {40,110,237,450,779,1252,1898,2745,3822,5159,6784,8726,11013,13674,16739,20236,24194,28641,330606,39119,
                    45208,51902,59229,67218,75899,85300,95450,106377,118110,130679,144112,158438,173685,189882,207059,
                    225244,244466,264753,286134,308639,332296,357134,383181,410466,439019,468868,500042,532569,566478,
                    601799,638560,676790,716517,757770,800579,844972,890978,938625,987942,1038959,1091704,1146206,1202493,
                    1260594,1320539,1382356,1446074,1511721,1579326,1648919,1720528,1794182,1869909,1947738,2027699,
                    2109820,2194130,2280657,2369430,2460479,2553832,2649518,2747565,2848002,2950859,3056164,3163946,
                    3274233,3387054,3502439,3620416,3741014,3864261,3990186,4118819,4250188,4384322,4521249,4660998,4803599};

    /**
     * 获取等级的升级经验
     * @param level
     * @return
     */
    static public long getLevelExp(int level) {
        return levelExpTable[level];
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        MainActivity.debug = debug;
    }

    public static MainActivity getInstance(){
    return instance;
    }
}
