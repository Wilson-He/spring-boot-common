package io.springframework.common.exception;


import io.springframework.common.response.CodeMsg;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * @author Wilson
 */
public final class ApiAssert {

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

}
