package com.ilmtest.ocean.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ocean.lib.io.DBUtils;
import com.ocean.lib.io.IOUtils;

public class LibraryCollectorTest
{
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Class.forName( org.sqlite.JDBC.class.getCanonicalName() ); // load the sqlite-JDBC driver using the current class loader
	}

	@Test
	public void write() throws SQLException
	{
		LibraryCollector lc = new LibraryCollector();
		
		File f = IOUtils.getFreshFile("/Users/rhaq/workspace/canadainc_site/ocean/ilmtest/library.db");
		
		Connection library = DriverManager.getConnection("jdbc:sqlite:"+f.getPath());
		DBUtils.attach(library, "/Users/rhaq/workspace/canadainc_site/ocean/ilmtest/master.db", "master");
		
		lc.process("/Users/rhaq/workspace/canadainc_site/ocean/ilmtest/shamela");
		lc.write(library, "master");
		
		library.close();
	}
}