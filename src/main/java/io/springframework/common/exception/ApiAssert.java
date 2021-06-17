package io.springframework.common.exception;


import io.springframework.common.i18n.I18NKey;
import io.springframework.common.response.CodeMsg;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Assert to throw ApiException
 * @author Wilson
 */
public final class ApiAssert {

    public static void notNull(Object obj, Supplier<ApiException> supplier) {
        if (obj == null) {
            throw supplier.get();
        }
    }

    public static void notNull(Object obj, String msg) {
        if (obj == null) {
            throw new ApiException(msg);
        }
    }

    public static void notNull(Object obj, CodeMsg codeMsg) {
        if (obj == null) {
            throw new ApiException(codeMsg);
        }
    }

    public static void notNull(Object obj, I18NKey key) {
        if (obj == null) {
            throw new ApiException(key);
        }
    }

    public static void isNull(Object obj, Supplier<ApiException> supplier) {
        if (obj != null) {
            throw supplier.get();
        }
    }

    public static void isNull(Object obj, String msg) {
        if (obj != null) {
            throw new ApiException(msg);
        }
    }

    public static void isNull(Object obj, CodeMsg codeMsg) {
        if (obj != null) {
            throw new ApiException(codeMsg);
        }
    }

    public static void isNull(Object obj, I18NKey key) {
        if (obj != null) {
            throw new ApiException(key);
        }
    }

    public static void isTrue(boolean expression, Supplier<ApiException> supplier) {
        if (!expression) {
            throw supplier.get();
        }
    }

    public static void isTrue(boolean expression, String msg) {
        if (!expression) {
            throw new ApiException(msg);
        }
    }

    public static void isTrue(boolean expression, CodeMsg codeMsg) {
        if (!expression) {
            throw new ApiException(codeMsg);
        }
    }

    public static void isTrue(boolean expression, I18NKey key) {
        if (!expression) {
            throw new ApiException(key);
        }
    }

    public static void isFalse(boolean expression, String msg) {
        if (expression) {
            throw new ApiException(msg);
        }
    }

    public static void isFalse(boolean expression, CodeMsg codeMsg) {
        if (expression) {
            throw new ApiException(codeMsg);
        }
    }

    public static void isFalse(boolean expression, I18NKey key) {
        if (expression) {
            throw new ApiException(key);
        }
    }

    public static void isEmpty(CharSequence string, CodeMsg codeMsg) {
        if (string != null && string.length() != 0) {
            throw new ApiException(codeMsg);
        }
    }

    public static void notEmpty(CharSequence string, String msg) {
        if (string == null || string.length() == 0) {
            throw new ApiException(msg);
        }
    }

    public static void notEmpty(CharSequence string, I18NKey key) {
        if (string == null || string.length() == 0) {
            throw new ApiException(key);
        }
    }

    public static <E> void isEmpty(Collection<E> collection, String msg) {
        if (collection != null && !collection.isEmpty()) {
            throw new ApiException(msg);
        }
    }

    public static <E> void notEmpty(Collection<E> collection, String msg) {
        if (collection == null || collection.isEmpty()) {
            throw new ApiException(msg);
        }
    }

    public static <E> void notEmpty(Collection<E> collection, I18NKey key) {
        if (collection == null || collection.isEmpty()) {
            throw new ApiException(key);
        }
    }



    /**
     * Check is a equals to b.
     *
     * @param a
     * @param b
     * @throws ApiException collection is empty
     */
    public static <E> void equals(Object a, Object b, String message) {
        if (!Objects.equals(a, b)) {
            throw new ApiException(message);
        }
    }

    /**
     * Check is a equals to b.
     *
     * @param a
     * @param b
     * @param key
     * @throws ApiException collection is empty
     */
    public static <E> void equals(Object a, Object b, I18NKey key) {
        if (!Objects.equals(a, b)) {
            throw new ApiException(key.key());
        }
    }

    /**
     * Check is a  not equals to b.
     *
     * @param a
     * @param b
     * @throws ApiException collection is empty
     */
    public static <E> void notEquals(Object a, Object b, String message) {
        if (Objects.equals(a, b)) {
            throw new ApiException(message);
        }
    }

    /**
     * Check is a not equals to b.
     *
     * @param a
     * @param b
     * @param key
     * @throws ApiException collection is empty
     */
    public static <E> void notEquals(Object a, Object b, I18NKey key) {
        if (Objects.equals(a, b)) {
            throw new ApiException(key.key());
        }
    }
}
