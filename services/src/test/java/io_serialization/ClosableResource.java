package io_serialization;

public class ClosableResource implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.printf("autoclose");
	}

}