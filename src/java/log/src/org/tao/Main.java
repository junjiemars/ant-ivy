package org.tao;

import static java.lang.System.out;
import org.apache.log4j.Logger;
import java.lang.System;

public final class Main {
	public static void main(final String[] args) {
		_logger.debug("log4j drill");
		_logger.warn("log4j warn level");
		_logger.error("log4j error level");

		Sub.staticCall();
		Sub sub = new Sub();
		sub.instanceCall();

		/*
		long b = System.currentTimeMillis();
		for (long i = 0; i < 100000; i++) {
			_logger.debug("count:" + Long.toString(i));
		}
		long e = System.currentTimeMillis();
		_logger.debug("elapsed:" + Long.toString(e-b));
		*/
	}

	static final Logger _logger = Logger.getLogger(Main.class);
}
