package ForTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.base.CharMatcher;
import java.util.concurrent.CompletableFuture;

public class MatcherGuava {

	public static void main(String[] args) {
		name();
	}

	public static void name() {

		// a.contains(a)
		StringBuffer builder = new StringBuffer();

		List<CompletableFuture<String>> intema =

				IntStream.range(0, 1000).mapToObj(a -> String.valueOf(a)).sequential().map(MatcherGuava::produceFuture)
						.map((future) -> future.whenComplete((value, throwable) -> builder.append(value)))
						.collect(Collectors.toList());

		intema.forEach((future) -> System.out.println(future.join()));

	}

	private static CompletableFuture<String> produceFuture(String value) {
		System.out.println();
		return CompletableFuture.supplyAsync(() -> String.format("%s - %s\n", value, "hello"));
	}

}
