package io.springframework.common.exception;


import io.springframework.common.i18n.I18NKey;
import io.springframework.common.response.CodeMsg;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Assert to throw ApiException
 *
 * @author Wilson
 */
public final class ApiAssert {

    public static void notNull(Object obj, Supplier<ApiException> supplier) {
        if (obj == null) {
            throw supplier.get();
        }
    }

    public static void notNull(Object obj, String msg, Object... formats) {
        if (obj == null) {
            throw new ApiException(msg, formats);
        }
    }

    public static void notNull(Object obj, CodeMsg codeMsg) {
        if (obj == null) {
            throw new ApiException(codeMsg);
        }
    }

    public static void notNull(Object obj, I18NKey key, Object... formats) {
        if (obj == null) {
            throw new ApiException(key, formats);
        }
    }

    public static void isNull(Object obj, Supplier<ApiException> supplier) {
        if (obj != null) {
            throw supplier.get();
        }
    }

    public static void isNull(Object obj, String msg, Object... formats) {
        if (obj != null) {
            throw new ApiException(msg, formats);
        }
    }

    public static void isNull(Object obj, CodeMsg codeMsg) {
        if (obj != null) {
            throw new ApiException(codeMsg);
        }
    }

    public static void isNull(Object obj, I18NKey key, Object... formats) {
        if (obj != null) {
            throw new ApiException(key, formats);
        }
    }

    public static void isTrue(boolean expression, Supplier<ApiException> supplier) {
        if (!expression) {
            throw supplier.get();
        }
    }

    public static void isTrue(boolean expression, String msg, Object... formats) {
        if (!expression) {
            throw new ApiException(msg, formats);
        }
    }

    public static void isTrue(boolean expression, CodeMsg codeMsg) {
        if (!expression) {
            throw new ApiException(codeMsg);
        }
    }

    public static void isTrue(boolean expression, I18NKey key, Object... formats) {
        if (!expression) {
            throw new ApiException(key, formats);
        }
    }

    public static void isFalse(boolean expression, String msg, Object... formats) {
        if (expression) {
            throw new ApiException(msg, formats);
        }
    }

    public static void isFalse(boolean expression, CodeMsg codeMsg) {
        if (expression) {
            throw new ApiException(codeMsg);
        }
    }

    public static void isFalse(boolean expression, I18NKey key, Object... formats) {
        if (expression) {
            throw new ApiException(key, formats);
        }
    }

    public static void isEmpty(CharSequence string, CodeMsg codeMsg) {
        if (string != null && string.length() != 0) {
            throw new ApiException(codeMsg);
        }
    }

    public static void notEmpty(CharSequence string, String msg, Object... formats) {
        if (string == null || string.length() == 0) {
            throw new ApiException(msg, formats);
        }
    }

    public static void notEmpty(CharSequence string, I18NKey key, Object... formats) {
        if (string == null || string.length() == 0) {
            throw new ApiException(key, formats);
        }
    }

    public static <E> void isEmpty(Collection<E> collection, String msg, Object... formats) {
        if (collection != null && !collection.isEmpty()) {
            throw new ApiException(msg, formats);
        }
    }

    public static <E> void notEmpty(Collection<E> collection, String msg, Object... formats) {
        if (collection == null || collection.isEmpty()) {
            throw new ApiException(msg, formats);
        }
    }

    public static <E> void notEmpty(Collection<E> collection, I18NKey key, Object... formats) {
        if (collection == null || collection.isEmpty()) {
            throw new ApiException(key, formats);
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
    public static <E> void equals(Object a, Object b, I18NKey key, Object... formats) {
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
    public static <E> void notEquals(Object a, Object b, I18NKey key, Object... formats) {
        if (Objects.equals(a, b)) {
            throw new ApiException(key.key());
        }
    }
}
