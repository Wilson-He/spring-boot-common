package io.springframework.common.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Wilson
 */
public class OptionalCollectionTest {

	@Test
	public void build() {
		Assertions.assertThrows(NullPointerException.class, () -> OptionalCollection.of(null));
		Assertions.assertFalse(OptionalCollection.ofEmpty(null).isPresent());
		Assertions.assertTrue(OptionalCollection.ofEmpty(null).isEmpty());
		Assertions.assertTrue(OptionalCollection.ofEmpty(Arrays.asList("1", "2")).isNotEmpty());
	}

	@Test
	public void orElse() {
		List<String> defaultList = Arrays.asList("1", "2", "3");
		List<String> nullList = null;
		List<String> testList = new ArrayList<>();
		// null orElse test
		Assertions.assertEquals(OptionalCollection.ofEmpty(nullList)
				.orElse(defaultList), defaultList);
		Assertions.assertEquals(OptionalCollection.ofEmpty(nullList)
				.orNullGet(() -> Arrays.asList("1", "2", "3")), defaultList);
		// empty orElse test
		Assertions.assertNotEquals(OptionalCollection.ofEmpty(testList)
				.orElse(defaultList), defaultList);
		Assertions.assertEquals(OptionalCollection.ofEmpty(testList)
				.orEmptyElse(defaultList), defaultList);
		Assertions.assertNotEquals(OptionalCollection.ofEmpty(testList)
				.orNullGet(() -> Arrays.asList("1", "2", "3")), defaultList);
		Assertions.assertEquals(OptionalCollection.ofEmpty(testList)
				.orEmptyGet(() -> Arrays.asList("1", "2", "3")), defaultList);

	}

	@Test
	public void throwException() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->
				OptionalCollection.ofEmpty(null)
						.orNullThrow(() -> new IllegalArgumentException("集合不能为null")));
		Assertions.assertThrows(IllegalArgumentException.class, () ->
				OptionalCollection.ofEmpty(new ArrayList<>())
						.orEmptyThrow(() -> new IllegalArgumentException("集合不能为空")));
	}

	@Test
	public void map() {
		List<String> defaultList = Arrays.asList("1", "2", "3");
		Collection<Integer> resultList = OptionalCollection.ofEmpty(defaultList)
				.map(collection -> collection.stream()
						.map(Integer::valueOf)
						.collect(Collectors.toList()))
				.orElse(Arrays.asList(111, 222));
		int sum = resultList.stream().reduce(Integer::sum).orElse(100);
		Assertions.assertEquals(sum, 6);

	}

	@Test
	public void stream() {
		List<String> defaultList = Arrays.asList("1", "2", "3");
		Assertions.assertEquals("123", OptionalCollection.ofEmpty(defaultList)
				.stream()
				.reduce((a, b) -> a + b)
				.orElse("empty"));

		List<String> emptyList = new ArrayList<>();
		Assertions.assertEquals("empty", OptionalCollection.ofEmpty(emptyList)
				.stream()
				.reduce((a, b) -> a + b)
				.orElse("empty"));

		List<String> nullList = null;
		Assertions.assertEquals("empty", OptionalCollection.ofEmpty(nullList)
				.stream()
				.reduce((a, b) -> a + b)
				.orElse("empty"));
	}

	@Test
	public void filter() {
		List<String> defaultList = Arrays.asList("aa", "bb", "cc", "abcd");
		Assertions.assertTrue(OptionalCollection.ofEmpty(defaultList)
				.filter(collection -> collection.contains("abcd"))
				.isNotEmpty());
		Assertions.assertTrue(OptionalCollection.ofEmpty(defaultList)
				.filter(collection -> collection.contains("cd"))
				.isEmpty());
		Assertions.assertTrue(OptionalCollection.ofEmpty(defaultList)
				.filterOrElse(collection -> collection.contains("cd"), Arrays.asList("cd", "ef"))
				.isNotEmpty());
		Assertions.assertTrue(OptionalCollection.ofEmpty(defaultList)
				.filterOrElse(collection -> collection.contains("cd"), Arrays.asList("cd", "ef"))
				.get()
				.contains("cd"));
	}

	@Test
	public void ifPresentOrElse() {
		List<String> defaultList = Arrays.asList("a", "b", "c");
		String concat = OptionalCollection.ofEmpty(defaultList)
				.ifPresentOrElse(collection -> collection.stream()
						.reduce((a, b) -> a + "," + b)
						.orElse("abc"), "aaa");
		Assertions.assertEquals(concat, "a,b,c");

		Assertions.assertEquals("aaa", OptionalCollection.ofEmpty(null)
				.ifPresentOrElse(collection -> collection.stream()
						.reduce((a, b) -> a + "," + b)
						.orElse("abc"), "aaa"));
	}

	@Test
	public void ifNotEmpty() {
		List<String> strList = Arrays.asList("a", "b", "c");
		// print
		OptionalCollection.ofEmpty(strList)
				.ifNotEmpty(OptionalCollectionTest::deleteBatchIds);
		// won't print
		OptionalCollection.ofEmpty(null)
				.ifNotEmpty(OptionalCollectionTest::deleteBatchIds);
		OptionalCollection.ofEmpty(new ArrayList<>())
				.ifNotEmpty(OptionalCollectionTest::deleteBatchIds);

		// then
		List<Integer> intList = null;
		List<String> resultList = OptionalCollection.ofEmpty(intList)
				.ifPresentThen(OptionalCollectionTest::selectByIds);
		Assertions.assertNull(resultList);

		intList = new ArrayList<>();
		resultList = OptionalCollection.ofEmpty(intList)
				.ifPresentThen(OptionalCollectionTest::selectByIds);
		Assertions.assertNotNull(resultList);
		Assertions.assertTrue(resultList.isEmpty());

		intList = Arrays.asList(1, 2, 3);
		resultList = OptionalCollection.ofEmpty(intList)
				.ifPresentThen(OptionalCollectionTest::selectByIds);
		Assertions.assertEquals(resultList, Arrays.asList("1", "2", "3"));
	}

	private static <V> void deleteBatchIds(Collection<V> collection) {
		Assertions.assertFalse(collection.isEmpty());
		System.out.println("delete batch ids: " + collection);
	}

	private static List<String> selectByIds(Collection<? extends Number> collection) {
		return collection.stream()
				.map(String::valueOf)
				.collect(Collectors.toList());
	}

	@Test
	public void ifNotEmptyOrElse() {
		List<String> defaultList = Arrays.asList("a", "b", "c");
		Assertions.assertEquals("abc", OptionalCollection.ofEmpty(defaultList)
				.ifNotEmptyOrElse(collection -> collection.stream()
								.reduce((a, b) -> a + b)
								.get(),
						"abcdef"));

		List<String> nullList = null;
		Assertions.assertEquals("abcdef", OptionalCollection.ofEmpty(nullList)
				.ifNotEmptyOrElse(collection -> collection.stream()
								.reduce((a, b) -> a + b)
								.orElse("abc"),
						"abcdef"));
	}

}