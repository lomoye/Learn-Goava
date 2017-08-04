package com.lomoye.learnGoava.functionSection;


import com.google.common.base.Function;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lomoye on 2017/8/2.
 */
public abstract class FluentIterable<E> implements Iterable<E> {

    private Iterable<E> iterable;


    private FluentIterable(Iterable<E> iterable) {
        this.iterable = iterable;
    }

    public static <E> FluentIterable<E> from(final Iterable<E> iterable) {
        return new FluentIterable<E>(iterable) {
            @Override
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    public <T> FluentIterable<T> transform(final Function<E, T> function) {
        Iterable<T> iter = new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new TransformIterator<E, T>(iterable.iterator()) {
                    @Override
                    T transform(E e) {
                        return function.apply(e);
                    }
                };
            }
        };
        return from(iter);
    }

    public List<E> toList() {
        List<E> list = new ArrayList<>();
        for (E e : iterable) {
            list.add(e);
        }
        return list;
    }
}
