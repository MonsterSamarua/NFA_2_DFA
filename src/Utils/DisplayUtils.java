package Utils;

import Beans.DFA;
import Beans.NFA;

import java.util.Arrays;

/**
 * EnterUtils工具类————用于打印nfa对象
 */
public class DisplayUtils {

    public static void displayK(NFA nfa){
        System.out.println(nfa.getK());
    }

    public static void displayLetters(NFA nfa){
        System.out.println(Arrays.toString(nfa.getLetters()));
    }

    public static void displayF(NFA nfa){
        String[][] f = nfa.getF();
        for(int i = 0; i < f.length; i++){
            for(int j = 0; j < f.length; j++){
                if(f[i][j] == "")  continue;
                for(char c : f[i][j].toCharArray()){
                    if(i == j && c == 'ε')  continue;
                    StringBuilder sb = new StringBuilder().append(i).append(c).append(j).append("  ");
                    System.out.print(sb.toString());
                }
            }
        }
        System.out.println();
    }

    public static void displayS(NFA nfa){
        System.out.println(nfa.getS());
    }

    public static void displayZ(NFA nfa){
        System.out.println(nfa.getZ());
    }


    public static void displayK(DFA dfa){
        System.out.println(dfa.getK());
    }

    public static void displayLetters(DFA dfa){
        System.out.println(Arrays.toString(dfa.getLetters()));
    }

    public static void displayF(DFA dfa){
        String[][] f = dfa.getF();
        for(int i = 0; i < f.length; i++){
            for(int j = 0; j < f.length; j++){
                if(f[i][j] == "") continue;
                for(char c : f[i][j].toCharArray()){
                    StringBuilder sb = new StringBuilder().append(i).append(c).append(j).append("  ");
                    System.out.print(sb.toString());
                }
            }
        }
        System.out.println();
    }

    public static void displayS(DFA dfa){
        System.out.println(dfa.getS());
    }

    public static void displayZ(DFA dfa){
        System.out.println(dfa.getZ());
    }

    // 一个小小的细节：
    // 打印NFA的状态转移函数时，需要将自身通过ε向自身的转化删掉
    // 而DFA压根没有ε
    //
    // 这个细节也使得，DFA是不需要ε-closure闭包运算的————move就可以唯一确定下一状态

}
