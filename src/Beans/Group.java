package Beans;

import java.util.Set;

public class Group {
    public int groupID;
    public Set<Integer> stateSet;

    public Group(int groupID, Set<Integer> stateSet) {
        this.groupID = groupID;
        this.stateSet = stateSet;
    }
}

