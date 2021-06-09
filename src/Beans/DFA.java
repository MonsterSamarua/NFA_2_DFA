package Beans;

import java.util.List;

public class DFA {

    private List<Integer> K;    // 状态集

    private char[] letters;     // 字母表

    private String[][] f;       // 转换函数

    private int S;              // 唯一初态

    private List<Integer> Z;    // 终态集

    public List<Integer> getK() {
        return K;
    }

    public void setK(List<Integer> k) {
        K = k;
    }

    public char[] getLetters() {
        return letters;
    }

    public void setLetters(char[] letters) {
        this.letters = letters;
    }

    public String[][] getF() {
        return f;
    }

    public void setF(String[][] f) {
        this.f = f;
    }

    public int getS() {
        return S;
    }

    public void setS(int s) {
        S = s;
    }

    public List<Integer> getZ() {
        return Z;
    }

    public void setZ(List<Integer> z) {
        Z = z;
    }
}
