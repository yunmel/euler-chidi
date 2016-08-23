/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package com.primeton.euler.chidi.service.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.primeton.euler.chidi.service.util.DbUtils;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
public class DevOpsDbInitialize {
	
	private static final String SCRIPT_PATH = DevOpsDbInitialize.class.getResource("/").getPath();
	
	private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/euler_chidi?autoReconnect=true&characterEncoding=UTF-8";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "root";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<File> sqlFiles = new ArrayList<>();
		// sem
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/db_table_init.sql"));
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/data/default.sql"));
		
		// ci
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/00-ci-ddl.sql"));
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/01-ci-data.sql"));
		
		// iam
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/0-iam-ddl.sql"));
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/1-iam-data.sql"));
		
		// mkt
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/00-mkt-ddl.sql"));
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/01-mkt-data.sql"));
		
		// pm
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/00-pm-ddl.sql"));
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/01-pm-dml.sql"));
		
		// scm
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/00-scm-ddl.sql"));
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/01-scm-data.sql"));
		
		
		// spm
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/00-spm-ddl.sql"));
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/01-spm-data.sql"));
		
		// srm
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/00-srm-ddl.sql"));
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/01-srm-data.sql"));

		// tm
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/0-tm-ddl.sql"));
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/1-tm-data.sql"));
		
		// vcs
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/00-vcs-ddl.sql"));
		sqlFiles.add(new File(SCRIPT_PATH + "db_script/01-vcs-data.sql"));
		
		// umc  需要根据实际环境修改被监控服务器的信息
		//sqlFiles.add(new File(SCRIPT_PATH + "db_script/0-umc-ddl.sql"));
		//sqlFiles.add(new File(SCRIPT_PATH + "db_script/1-umc-data.sql"));
		
		
		for (File file : sqlFiles) {
			try {
				System.out.println(file.getPath() + ": " + file.exists());
				DbUtils.executeSqlScript(DbUtils.getConnection(JDBC_DRIVER, JDBC_URL, JDBC_USER, JDBC_PASS), file);
				System.out.println("Execute SQL file " + file.getAbsolutePath() + " success.");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Execute SQL file " + file.getAbsolutePath() + " error.");
			}
		}
	}
	
}
