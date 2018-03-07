package com.blackwell.level_01;


import com.blackwell.tree.BinaryTree;

public class Problem_018 {
    public Problem_018() {
        BinaryTree bn = new BinaryTree();
        for (int i = 0; i < 10; ++i) {
            bn.add(i);
        }
        bn.print(bn.getRoot());
    }
}
