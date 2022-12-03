package saulv.collections.list;

import java.util.ListIterator;

public class AbstractListIterator<E> implements ListIterator<E> {
	public static int CALL = 0b01,
					  ADD = 0b10,
					  REMOVE = 0b11;
	
	private int pos;
	private AbstractList<E> list;
	
	private E lastElement;
	
	private int operations;
	
	public AbstractListIterator(AbstractList<E> l) {
		pos = -1;
		list = l;
		lastElement = null;
		operations = 0;;
	}
	
	public AbstractListIterator(AbstractList<E> l, int add) {
		this(l);
		pos+=add;
	}
	
	@Override
	public boolean hasNext() {
		return pos<list.size();
	}

	@Override
	public E next() {
		operations &= ~CALL;
		return (lastElement = list.get(pos++));
	}

	@Override
	public boolean hasPrevious() {
		return pos>-1;
	}

	@Override
	public E previous() {
		operations &= ~CALL;
		return (lastElement = list.get(pos--));
	}

	@Override
	public int nextIndex() {
		return pos == list.size() ? pos : pos+1;
	}

	@Override
	public int previousIndex() {
		return pos == -1 ? pos : pos-1;
	}

	@Override
	public void remove() {
		if((operations & CALL) != 0 && (operations & ADD) != 0)
			return;
		operations |= CALL | REMOVE;
		list.remove(lastElement);
	}

	@Override
	public void set(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(E e) {
				
	}

}
