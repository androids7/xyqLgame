package as.mke.xyq.screen;

import as.mke.xyq.MainActivity;
import as.mke.xyq.graph.Animation;

import loon.Screen;
import loon.canvas.LColor;
import loon.component.LButton;
import loon.component.LPaper;
import loon.event.GameTouch;
import loon.opengl.GLEx;
import loon.utils.timer.LTimerContext;

public class TitleScreen extends Screen {

    LButton start,end;
    LPaper title;

    private Animation[] animations;
    public TitleScreen(){

        animations = new Animation[4];
    }



    @Override
    public void draw(GLEx glEx) {

    }

    @Override
    public void onLoad() {

        setBackground("assets/wzife/login/background.jpg");

        // 创建一个开始按钮，按照宽191，高57分解按钮图，并设定其Click事件
       // Animation btnAnim = SpriteFactory.loadAnimation("wzife/login/btn_login.tcp");
        start = new LButton("开始游戏",new LColor(200,200,200)){
                //btnAnim.getLImages(), "", btnAnim.getWidth(),btnAnim.getHeight(),0, 0) {
            public void doClick() {
                start.setEnabled(false);
              //  addScreen(new ScenarioScreen());//createNextScreen());
            }
        };
        start.setLocation(520, 180);
        //start.setEnabled(false);
        add(start);
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void touchDown(GameTouch gameTouch) {

    }

    @Override
    public void touchUp(GameTouch gameTouch) {

    }

    @Override
    public void touchMove(GameTouch e) {

    }

    @Override
    public void touchDrag(GameTouch e) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void close() {

    }
    @Override
    public void alter(LTimerContext lTimerContext) {

    }
}
