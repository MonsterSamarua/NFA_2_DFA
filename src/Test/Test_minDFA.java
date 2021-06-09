package Test;

import Beans.DFA;
import Service.minDFA;
import Utils.DisplayUtils;
import Utils.EnterUtils;

import java.io.IOException;

public class Test_minDFA {
    public static void main(String[] args) throws IOException {

        DFA dfa = new DFA();

        System.out.print("请输入DFA状态集：");          EnterUtils.enterK(dfa);
        System.out.print("请输入DFA字母表：");          EnterUtils.enterLetters(dfa);
        System.out.print("请输入DFA状态转换函数：");     EnterUtils.enterF(dfa);
        System.out.print("请输入DFA唯一初态：");        EnterUtils.enterS(dfa);
        System.out.print("请输入DFA终态集：");          EnterUtils.enterZ(dfa);

        new minDFA().minDFA(dfa);

        /*
        0a2
        2c2
        2b5
        5b5
        6b5
        3b6
        3c2
        2d4
        3d4
        4a3
        1a3
        1b1
        0b1
        end
         */

    }
}
