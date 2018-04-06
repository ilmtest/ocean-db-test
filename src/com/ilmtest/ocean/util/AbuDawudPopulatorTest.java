package com.ilmtest.ocean.util;

import org.junit.Before;
import org.junit.Test;

public class AbuDawudPopulatorTest
{
	private AbuDawudPopulator m_abudawud;

	@Before
	public void setUp() throws Exception
	{
		m_abudawud = new AbuDawudPopulator();
	}

	@Test
	public void process() throws Exception
	{
		m_abudawud.process();
	}
}