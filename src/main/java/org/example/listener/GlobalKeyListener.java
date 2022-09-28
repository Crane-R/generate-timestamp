package org.example.listener;

import org.example.function.Util;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.Timer;
import java.util.TimerTask;

import static org.example.frame.MainFrame.formatText;
import static org.example.frame.MainFrame.resultLabel;

/**
 * @Description ：
 * @Author ：ZhouXingxue
 * @Date ：2022/9/23 21:56
 */
public class GlobalKeyListener implements NativeKeyListener {
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));

        if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        System.out.println(nativeKeyEvent.getKeyCode());
        //为了不必要的影响，还是设定一个比较远的键，但是键都有功能，综合考虑还是G比较合适g
        //G
        if (nativeKeyEvent.getKeyCode() == 34) {
            System.out.println(formatText.getText());
            Util.stick(Util.generateTime(formatText.getText()));
            resultLabel.setVisible(true);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    resultLabel.setVisible(false);
                }
            }, 2000);
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        System.out.println("Key Typed: " + NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
    }

}
