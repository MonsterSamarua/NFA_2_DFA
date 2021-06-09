package Beans;

import java.util.List;

public class NFA {

    private List<Integer> K;    // 状态集

    private char[] letters;     // 字母表

    private String[][] f;       // 转换函数

    private List<Integer> S;    // 初态集

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

    public List<Integer> getS() {
        return S;
    }

    public void setS(List<Integer> s) {
        S = s;
    }

    public List<Integer> getZ() {
        return Z;
    }

    public void setZ(List<Integer> z) {
        Z = z;
    }


}
