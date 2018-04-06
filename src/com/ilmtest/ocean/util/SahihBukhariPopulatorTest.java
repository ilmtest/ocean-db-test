package com.ilmtest.ocean.util;

import org.junit.Before;
import org.junit.Test;

public class SahihBukhariPopulatorTest
{
	private SahihBukhariPopulator m_bukhari;

	@Before
	public void setUp() throws Exception
	{
		m_bukhari = new SahihBukhariPopulator();
	}

	@Test
	public void process() throws Exception
	{
		m_bukhari.process();
	}
}