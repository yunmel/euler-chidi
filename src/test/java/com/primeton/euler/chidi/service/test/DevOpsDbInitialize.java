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
	
	private static final String WORKSPACE = "D:\\gitlab";
	
	private static final String JDBC_URL = "jdbc:mysql://10.15.15.99:3306/euler?autoReconnect=true&characterEncoding=UTF-8";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "root";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<File> sqlFiles = new ArrayList<>();
		
		// ci
		sqlFiles.add(new File(WORKSPACE + "\\euler-ci\\euler-ci-service\\sql\\00-ci-ddl.sql"));
		sqlFiles.add(new File(WORKSPACE + "\\euler-ci\\euler-ci-service\\sql\\01-ci-data.sql"));
		
		// iam
		sqlFiles.add(new File(WORKSPACE + "\\euler-iam\\euler-iam-service\\sql\\0-iam-ddl.sql"));
		sqlFiles.add(new File(WORKSPACE + "\\euler-iam\\euler-iam-service\\sql\\1-iam-data.sql"));
		
		// mkt
		sqlFiles.add(new File(WORKSPACE + "\\euler-mkt\\euler-mkt-service\\sql\\0-mkt-ddl.sql"));
		sqlFiles.add(new File(WORKSPACE + "\\euler-mkt\\euler-mkt-service\\sql\\1-mkt-data.sql"));
		
		// pm
		sqlFiles.add(new File(WORKSPACE + "\\euler-pm\\euler-pm-service\\sql\\00-pm-ddl.sql"));
		sqlFiles.add(new File(WORKSPACE + "\\euler-pm\\euler-pm-service\\sql\\01-pm-dml.sql"));
		
		// scm
		sqlFiles.add(new File(WORKSPACE + "\\euler-scm\\euler-scm-service\\sql\\00-scm-ddl.sql"));
		sqlFiles.add(new File(WORKSPACE + "\\euler-scm\\euler-scm-service\\sql\\01-scm-data.sql"));
		
		// sem
		sqlFiles.add(new File(WORKSPACE + "\\euler-sem\\euler-sem-service\\sql\\0-sem-ddl.sql"));
		sqlFiles.add(new File(WORKSPACE + "\\euler-sem\\euler-sem-service\\sql\\1-sem-data.sql"));
		
		// spm
		sqlFiles.add(new File(WORKSPACE + "\\euler-spm\\euler-spm-service\\sql\\00-spm-ddl.sql"));
		sqlFiles.add(new File(WORKSPACE + "\\euler-spm\\euler-spm-service\\sql\\01-spm-data.sql"));
		
		// srm
		sqlFiles.add(new File(WORKSPACE + "\\euler-srm\\euler-srm-service\\sql\\00-srm-ddl.sql"));
		sqlFiles.add(new File(WORKSPACE + "\\euler-srm\\euler-srm-service\\sql\\01-srm-data.sql"));

		// tm
		sqlFiles.add(new File(WORKSPACE + "\\euler-tm\\euler-tm-service\\sql\\0-tm-ddl.sql"));
		sqlFiles.add(new File(WORKSPACE + "\\euler-tm\\euler-tm-service\\sql\\1-tm-data.sql"));
		
		// vcs
		sqlFiles.add(new File(WORKSPACE + "\\euler-vcs\\euler-vcs-service\\sql\\00-vcs-ddl.sql"));
		sqlFiles.add(new File(WORKSPACE + "\\euler-vcs\\euler-vcs-service\\sql\\01-vcs-data.sql"));
		
		for (File file : sqlFiles) {
			try {
				DbUtils.executeSqlScript(DbUtils.getConnection(JDBC_DRIVER, JDBC_URL, JDBC_USER, JDBC_PASS), file);
				System.out.println("Execute SQL file " + file.getAbsolutePath() + " success.");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Execute SQL file " + file.getAbsolutePath() + " error.");
			}
		}
	}
	
}
