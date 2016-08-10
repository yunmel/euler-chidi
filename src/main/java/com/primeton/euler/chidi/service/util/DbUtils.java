/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package com.primeton.euler.chidi.service.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
public class DbUtils {

	/**
	 * None instance. <br>
	 */
	private DbUtils() {
		super();
	}
	
	/**
	 * 
	 * @param connection
	 * @param sqlFile
	 * @throws Exception
	 */
	public static void executeSqlScript(Connection connection, File sqlFile) throws Exception {
		if (null == sqlFile || !sqlFile.exists() || !sqlFile.isFile()) {
			return;
		}
		executeSqlScript(connection, new FileInputStream(sqlFile));
	}
	
	/**
	 * 
	 * @param connection
	 * @param in
	 * @throws Exception
	 */
	public static void executeSqlScript(Connection connection, InputStream in) throws Exception {
		if (null == connection || null == in) {
			return;
		}
		ScriptRunner runner = new ScriptRunner(connection);
		runner.setAutoCommit(true);
		Reader reader = null;
		try {
			reader = new InputStreamReader(in, "utf-8"); //$NON-NLS-1$
			runner.runScript(reader);
		} catch (Throwable e) {
			throw new Exception("An error occured while try to execute SQL script.", e);
		} finally {
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(in);
			runner.closeConnection();
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param url
	 * @param user
	 * @param pass
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection(String driver, String url, String user, String pass)
			throws ClassNotFoundException, SQLException {
		if (StringUtils.isBlank(driver) || StringUtils.isEmpty(url)) {
			return null;
		}
		Class.forName(driver);
		return null == user && null == pass ? DriverManager.getConnection(url)
				: DriverManager.getConnection(url, user, pass);
	}

}
