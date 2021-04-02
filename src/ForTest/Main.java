package ForTest;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;


public class Main {

	private String uri = "https://google.com/asdfasdf/ptyojty/aeryethtr";

	  @Benchmark
	  @Warmup(iterations = 5)
	  @Measurement(iterations = 5)
	  @Fork(value = 1, warmups = 0)
	  public void initContains() throws InterruptedException {
	    if (uri.contains("/br/fab") || uri.contains("/br/err") || uri.contains("/br/sts")) {}
	  }

	  @Benchmark
	  @Warmup(iterations = 5)
	  @Measurement(iterations = 5)
	  @Fork(value = 1, warmups = 0)
	  public void initMatches() throws InterruptedException {
	    if (uri.matches(".*/br/(fab|err|sts).*")) {}
	  }

	  public static void main(String[] args) throws Exception {
	    org.openjdk.jmh.Main.main(args);
	  }
	}

