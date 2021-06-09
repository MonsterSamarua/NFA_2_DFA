package Test;

import Beans.DFA;
import Beans.NFA;
import Service.NFA2DFA;
import Service.minDFA;
import Utils.DisplayUtils;
import Utils.EnterUtils;

import java.io.IOException;

public class Test_NFA2DFA {
    public static void main(String[] args) throws IOException {

        NFA nfa = new NFA();

        System.out.print("请输入NFA状态集：");          EnterUtils.enterK(nfa);
        System.out.print("请输入NFA字母表：");          EnterUtils.enterLetters(nfa);
        System.out.print("请输入NFA状态转换函数：");     EnterUtils.enterF(nfa);
        System.out.print("请输入NFA初态集：");          EnterUtils.enterS(nfa);
        System.out.print("请输入NFA终态集：");          EnterUtils.enterZ(nfa);

        DFA dfa = new NFA2DFA().definite(nfa);

        System.out.print("DFA状态集：");            DisplayUtils.displayK(dfa);
        System.out.print("DFA字母表：");            DisplayUtils.displayLetters(dfa);
        System.out.print("DFA状态转换函数：");       DisplayUtils.displayF(dfa);
        System.out.print("DFA唯一初态：");          DisplayUtils.displayS(dfa);
        System.out.print("DFA终态集：");            DisplayUtils.displayZ(dfa);

    }

}
