package com.ilmtest.ocean.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

public class ColumnNormalizerTest
{
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Class.forName( org.sqlite.JDBC.class.getCanonicalName() ); // load the sqlite-JDBC driver using the current class loader
	}
	
	@Test
	public void simplify() throws Exception
	{
		ColumnNormalizer instance = new ColumnNormalizer("entries", "id", "collection > 1");
		
		Connection c = DriverManager.getConnection("jdbc:sqlite:/Users/rhaq/workspace/canadainc_site/ocean/ilmtest/master.db");
		instance.process(c, "ar_body");
		instance.write(c, "ar_body_plain");
	}

	@Test
	public void process() throws Exception
	{
		String fileName = UUID.randomUUID().toString()+".db";
		Connection c = null;

		try {
			c = DriverManager.getConnection("jdbc:sqlite:"+fileName);
			c.setAutoCommit(false);

			PreparedStatement ps = c.prepareStatement("CREATE TABLE entries (id INTEGER PRIMARY KEY, ar_body TEXT, ar_body_plain TEXT);");
			ps.execute();
			ps.close();

			ps = c.prepareStatement("INSERT INTO entries (ar_body) VALUES (?)");
			ps.setString(1,"بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ");
			ps.execute();

			c.commit();
			ps.close();

			ColumnNormalizer instance = new ColumnNormalizer("entries", "id", null);
			instance.process(c, "ar_body");
			instance.write(c, "ar_body_plain");

			ps = c.prepareStatement("SELECT ar_body_plain FROM entries");
			ResultSet rs = ps.executeQuery();

			rs.next();
			assertEquals( "بسم ٱلله ٱلرحمن ٱلرحيم", rs.getString("ar_body_plain") );

			assertFalse( rs.next() );

			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			fail("Didn't work...");
		} finally {
			if (c != null) {
				c.close();
			}

			new File(fileName).delete();
			new File(fileName+"-journal").delete();
		}
	}
}
