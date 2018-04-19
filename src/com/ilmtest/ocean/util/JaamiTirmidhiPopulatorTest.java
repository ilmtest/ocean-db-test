package com.ilmtest.ocean.util;

import org.junit.Before;
import org.junit.Test;

public class JaamiTirmidhiPopulatorTest
{
	private TirmidhiPopulator m_populator;

	@Before
	public void setUp() throws Exception
	{
		m_populator = new TirmidhiPopulator();
	}

	@Test
	public void process() throws Exception
	{
		m_populator.process();
	}
}