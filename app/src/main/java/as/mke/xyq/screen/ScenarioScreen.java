package as.mke.xyq.screen;

import as.mke.xyq.MainActivity;
import loon.LTransition;
import loon.action.avg.AVGDialog;
import loon.action.avg.AVGScreen;
import loon.action.avg.drama.Command;
import loon.canvas.LColor;
import loon.component.LButton;
import loon.component.LMessage;
import loon.component.LPaper;
import loon.component.LSelect;
import loon.opengl.GLEx;

public class ScenarioScreen extends AVGScreen {

    LPaper roleName;

    // 自定义命令（有些自定义命令为了突出写成了中文，实际不推荐）
    String flag = "自定义命令.";

    String[] selects = { "年轻的你是否也在追逐梦想呢？" };
    private MainActivity activity;
    int type;
    private String scriptId;

    public ScenarioScreen(MainActivity activity, String scriptId) {
        super("assets/script/"+scriptId+".txt", AVGDialog.getRMXPDialog("assets/images/w6.png", 520, 150));
        this.activity = activity;
        this.scriptId = scriptId;
    }

    public void onLoading() {
//		roleName = new LPaper("assets/images/name0.png", 25, 25);
//		leftOn(roleName);
//		roleName.setLocation(5, 15);
//		add(roleName);
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void drawScreen(GLEx g) {
        switch (type) {
            case 1:

                g.drawSixStart(LColor.yellow, 130, 100, 100);

                break;
            default:
                break;
        }
        g.resetColor();
    }

    public void initCommandConfig(Command command) {
        // 初始化时预设变量
//		command.setVariable("p", "assets/p.png");
//		command.setVariable("sel0", selects[0]);
    }

    public void initMessageConfig(LMessage message) {

    }

    public void initSelectConfig(LSelect select) {
    }

    @Override
    public AVGScreen nextScript() {
        return super.nextScript();
    }

    @Override
    public boolean nextScript(String mes) {

        // 自定义命令（有些自定义命令为了突出写成了中文，实际不推荐）
        if (roleName != null) {
            if ("noname".equalsIgnoreCase(mes)) {
                roleName.setVisible(false);
            } else if ("name0".equalsIgnoreCase(mes)) {
                roleName.setVisible(true);
                roleName.setBackground("assets/name0.png");
                roleName.setLocation(5, 15);
            } else if ("name1".equalsIgnoreCase(mes)) {
                roleName.setVisible(true);
                roleName.setBackground("assets/name1.png");
                roleName.setLocation(getWidth() - roleName.getWidth() - 5, 15);
            }
        }
        if ((flag + "星星").equalsIgnoreCase(mes)) {
            // 添加脚本事件标记（需要点击后执行）
            setScrFlag(true);
            type = 1;
            return false;
        } else if ((flag + "去死吧，星星").equalsIgnoreCase(mes)) {
            type = 0;
        } else if ((flag + "关于天才").equalsIgnoreCase(mes)) {
            messageConfig().setVisible(false);
            setScrFlag(true);
            // 强行锁定脚本
            setScriptLocked(true);
            LButton yes = new LButton("assets/dialog_yes.png", 112, 33) {
                public void doClick() {
                    // 解除锁定
                    setLocked(false);
                    // 触发事件
                    // click();
                    // 删除当前按钮
                    remove(this);
                }
            };
            centerOn(yes);
            add(yes);
            return false;
        }
        return true;
    }


    public void onExit() {

    }

    public void onSelect(String message, int type) {
        if (selects[0].equalsIgnoreCase(message)) {
            command.setVariable("sel0", String.valueOf(type));
        }
    }
    @Override
    public LTransition onTransition() {
        return LTransition.newCrossRandom();
    }
}
