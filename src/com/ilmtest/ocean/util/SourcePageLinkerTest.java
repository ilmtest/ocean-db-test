package com.ilmtest.ocean.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ocean.lib.io.DBUtils;

public class SourcePageLinkerTest
{
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Class.forName( org.sqlite.JDBC.class.getCanonicalName() ); // load the sqlite-JDBC driver using the current class loader
	}
	
	@Test
	public void link() throws Exception
	{
		SourcePageLinker instance = new SourcePageLinker();
		
		Connection master = DriverManager.getConnection("jdbc:sqlite:/Users/rhaq/workspace/canadainc_site/ocean/ilmtest/master.db");
		DBUtils.attach(master, "/Users/rhaq/workspace/resources/processed/28171.db", "flip");
		
		instance.process(master, 208);
		instance.write(master);
		
		master.close();
	}
}
