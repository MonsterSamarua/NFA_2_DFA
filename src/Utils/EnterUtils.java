package Utils;

import Beans.DFA;
import Beans.NFA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * EnterUtils工具类————用于从外部获取输入，然后set给传入的nfa对象
 */
public class EnterUtils {

    /**
     * 状态集的个数（转换函数f也要用到）
     * 这个n被所有nfa类共享————为了防止出错，enterF一定要写在enterK的后面，才能保证初始化f时使用正确的n
     */
    private static int n;

    // 输入状态集
    public static void enterK(NFA nfa) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String[] strings = br.readLine().split("");
        for(String s : strings){
            list.add(Integer.parseInt(s));
        }
        n = list.size();
        nfa.setK(list);
    }

    // 输入字母表
    public static void enterLetters(NFA nfa) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] letters = br.readLine().toCharArray();
        nfa.setLetters(letters);
    }

    // 输入转换函数
    public  static void enterF(NFA nfa) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] f = new String[n][n];
        for(String[] arr : f){
            Arrays.fill(arr, "");
        }
        for(int i = 0; i < f.length; i++){
            f[i][i] = "ε";
        }
        String line = "";
        while(!(line = br.readLine().trim()).equals("end")){
            String[] arr = line.split("");
            f[Integer.parseInt(arr[0])][Integer.parseInt(arr[2])] += arr[1];
        }
        nfa.setF(f);
    }

    // 输入初态集
    public static void enterS(NFA nfa) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String[] strings = br.readLine().split("");
        for(String s : strings){
            list.add(Integer.parseInt(s));
        }
        nfa.setS(list);
    }

    // 输入终态集
    public static void enterZ(NFA nfa) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String[] strings = br.readLine().split("");
        for (String s : strings){
            list.add(Integer.parseInt(s));
        }
        nfa.setZ(list);
    }



    // 输入状态集
    public static void enterK(DFA dfa) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String[] strings = br.readLine().split("");
        for(String s : strings){
            list.add(Integer.parseInt(s));
        }
        n = list.size();
        dfa.setK(list);
    }

    // 输入字母表
    public static void enterLetters(DFA dfa) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] letters = br.readLine().toCharArray();
        dfa.setLetters(letters);
    }

    // 输入转换函数
    public  static void enterF(DFA dfa) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] f = new String[n][n];
        for(String[] arr : f){
            Arrays.fill(arr, "");
        }
        String line = "";
        while(!(line = br.readLine().trim()).equals("end")){
            String[] arr = line.split("");
            f[Integer.parseInt(arr[0])][Integer.parseInt(arr[2])] += arr[1];
        }
        dfa.setF(f);
    }

    // 输入初态集
    public static void enterS(DFA dfa) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        dfa.setS(S);
    }

    // 输入终态集
    public static void enterZ(DFA dfa) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String[] strings = br.readLine().split("");
        for (String s : strings){
            list.add(Integer.parseInt(s));
        }
        dfa.setZ(list);
    }

}
