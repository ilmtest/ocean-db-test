package com.ilmtest.ocean.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SilsilahDaifPopulatorTest
{
	private SilsilahDaifPopulator m_instance;

	@Before
	public void setUp() throws Exception
	{
		m_instance = new SilsilahDaifPopulator();
	}

	@Test
	public void testProcess() throws Exception
	{
		m_instance.process();
	}
}
