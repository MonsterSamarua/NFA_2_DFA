package Service;

import Beans.DFA;
import Beans.Group;

import java.util.*;

 /**
 *【DFA的最小化】
 * 核心思路：
 *  1. 定义一个Group类，作为「分组」。
 *     Group有两个属性：groupID作为唯一标识；StateSet为该分组包含的状态集
 *  2. separate()方法的作用是，根据某个字母(letter)对分组集合(groupSet)进行彻底分裂
 *  3. 对于字母表中的每个字母，进行separate分裂
 *
 * 下面的论述有利于理解这个算法：
 *  1. HashMap做映射，是该算法的一个关键点。
 *     对于某个字母，一个分组(group)的所有状态(state)根据这个字母，用HashMap记录它们分别会被映射到哪个分组里，据此分裂。
 *     举个例子：{group1,[0, 1]}, {group2,[2, 3]}    (key是组，value是转化后指向该组的所有状态)
 *     ⬆ 0,1状态会转化到1组，2,3状态会转化到2组，据此，旧组分裂为了两个新组，然后删掉旧组，新组入队BFS
 *     ⬆️ 如果这个哈希表的size==1，说明所有状态只能转化到一个组中，那么它们是等价的，不用删掉旧组，该组直接进入finalGroupSet最终分组
 *   2. groupID的作用是什么？为什么还要专门维护它？
 *      唯一标识。从1中看出，过程中不断进行着"删掉旧组，生成新组"的行为。维护这个ID主要是为了HashMap做映射
 *
 */
public class minDFA {

    private int cnt = 0;

    public void minDFA(DFA dfa){
        List<Integer> K = dfa.getK();
        List<Integer> Z = dfa.getZ();
        String[][] f = dfa.getF();
        char[] letters = dfa.getLetters();

        K.removeAll(Z);         // 全部状态集K - 终态集Z = 非终态集
        Group groupx = new Group(cnt++, new HashSet<>(K));
        Group groupy = new Group(cnt++, new HashSet<>(Z));
        Set<Group> finalGroupSet = new HashSet<>();             // 最终分组
        Set<Group> curGroupSet = new HashSet<>();               // 此时的分组
        finalGroupSet.add(groupx);
        finalGroupSet.add(groupy);

        for(char letter : letters){                                 // 对于每个字母
            curGroupSet = finalGroupSet;                            // 【最终分组】不断沦为【此时分组】
            finalGroupSet = separate(curGroupSet, letter, f);       // 【此时分组】又分裂成新的【最终分组】
        }                                                           // 所有字母都用了一次后，成为名副其实的【最终分组】

        // 打印最终分组(一组中的状态等价)
        for(Group group : finalGroupSet){
            System.out.print(group.groupID);
            System.out.print(group.stateSet);
            System.out.println();
        }
    }

    private Set<Group> separate(Set<Group> groupSet, char letter, String[][] f){
        Set<Group> finalGroupSet = new HashSet<>();
        Set<Group> curGroupSet = groupSet;
        Queue<Group> queue = new LinkedList<>();
        for(Group group : groupSet){
            queue.add(group);
        }

        while (!queue.isEmpty()){
            Group oldGroup = queue.poll();
            Map<Group, List<Integer>> map = new HashMap<>();  //根据指向的组，对状态Integer进行分类
            for(Integer state : oldGroup.stateSet){
                Group stateNextBelong = beLong(state, letter, f, curGroupSet);
                if(!map.containsKey(stateNextBelong)){
                    map.put(stateNextBelong, new ArrayList<>());
                }
                map.get(stateNextBelong).add(state);
            }
            if (map.size() == 1){   // 如果这些状态映射到了一个状态集(Group)中，则为最终分组
                finalGroupSet.add(oldGroup);
            }else{                  // 如果这些状态映射到了多个状态集(Group)中，则删除原先分组，创建多个新分组，并将新分组入队
                curGroupSet.remove(oldGroup);
                for(List<Integer> list : map.values()){
                    Group newGroup = new Group(cnt++, new HashSet<>(list));
                    curGroupSet.add(newGroup);
                    queue.add(newGroup);
                }
            }
        }
        return finalGroupSet;
    }

    /**
     * move方法: 返回唯一后继状态（-1表示没有后继状态）
     */
    private int move(int state, char letter, String[][] f){
        for(int nextState = 0; nextState < f.length; nextState++){
            for(char c : f[state][nextState].toCharArray()){
                if(c == letter){
                    return nextState;
                }
            }
        }
        return -1;
    }

    /**
     * beLong方法: 某状态(state)经过字母(letter)一次转化(move)后，所属于的当前分组(group)
     */
    private Group beLong(int state, char letter, String[][] f, Set<Group> groupSet){
        int newState = move(state, letter, f);
        for(Group group : groupSet){
            if(group.stateSet.contains(newState)){
                return group;
            }
        }
        return null;
    }


}








/**
 * 注：
 * 1.本代码仅仅实现了DFA的状态的分组，即找出等价状态。但等价状态的合并由读者自行实现（这并不困难）
 * 2.考举个例子，当根据a分裂一次后，接着根据b分裂，那么，是否根据a又可以再分裂一次呢？这是本代码不严谨的地方，需要再加一个"可分裂检查"的逻辑
 */
