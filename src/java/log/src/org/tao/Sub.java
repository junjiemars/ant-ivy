package org.tao;

import org.apache.log4j.Logger;

public final class Sub {
	public static void staticCall() {
		_logger.error("in staticCall()");
	}

	public void instanceCall() {
		_logger.error("in instanceCall()");
	}

	static final Logger _logger = Logger.getLogger(Sub.class);
}
