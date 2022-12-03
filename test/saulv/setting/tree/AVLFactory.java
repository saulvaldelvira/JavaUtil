package saulv.setting.tree;

import saulv.tree.Tree;
import saulv.tree.avl.AVLTree;

public class AVLFactory<T extends Comparable<T>> implements TreeFactory<T> {

	@Override
	public Tree<T> newTree() {
		return new AVLTree<T>();
	}

}
