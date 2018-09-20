package com.yl.learn.dp.strategy.imp;

import com.yl.learn.dp.strategy.ArraySortAlgorithm;

public enum ArraySortStrategy {

    SELECT_SORT {
        @Override
        public <T> ArraySortAlgorithm algorithm(T... array) {
            return new ArraySortAlgorithm<T>() {
                @Override
                public T[] algorithm(T[] array) {
                    checkArray(array);
                    return null;
                }
            };
        }
    };

    public abstract <T> ArraySortAlgorithm algorithm(T... array);

}
