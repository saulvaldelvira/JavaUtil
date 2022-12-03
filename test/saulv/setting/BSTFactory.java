package saulv.setting;

import saulv.tree.Tree;
import saulv.tree.bst.BSTree;

public class BSTFactory<T extends Comparable<T>> implements TreeFactory<T> {

	@Override
	public Tree<T> newTree() {
		return new BSTree<T>();
	}

}
