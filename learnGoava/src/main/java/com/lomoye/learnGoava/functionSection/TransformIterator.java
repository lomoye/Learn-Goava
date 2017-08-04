package com.lomoye.learnGoava.functionSection;




import java.util.Iterator;


/**
 * Created by lomoye on 2017/8/3.
 */
public abstract class TransformIterator<E, T> implements Iterator<T> {

    private Iterator<E> iterator;



    public TransformIterator(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    abstract T transform(E e);

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        return transform(iterator.next());
    }

    @Override
    public void remove() {
        iterator.remove();
    }

}
