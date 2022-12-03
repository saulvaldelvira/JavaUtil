package saulv.setting.tree;

import saulv.tree.Tree;

public interface TreeFactory<T extends Comparable<T>> {
	Tree<T> newTree();
}
