package com.hlhj.guanggou.paging;

/**
 * totalCount 临时保存变量
 *
 * @author huangdaiyi
 * @since 1.0.0
 */
public class TotalCountHolder {

    private static ThreadLocal<Integer> holder = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void set(int value) {
        holder.set(value);
    }

    public static int get() {
        return holder.get();
    }

    public static void remove() {
        holder.remove();
    }
}
