/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年9月12日 下午5:50:25
 *******************************************************************************/

package com.primeton.euler.chidi.service.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.slf4j.Logger;

import com.primeton.euler.cbc.log.LoggerFactory;

public class ProductInstanceUtils {
	private static final Logger logger = LoggerFactory.getTraceLogger(ProductInstanceUtils.class);
	
	private static Properties props = new Properties();
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() {
		try {
			InputStream in = ProductInstanceUtils.class.getResourceAsStream("/pse.properties");
			props.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String user = props.getProperty("db.user");
		String password = props.getProperty("db.password");
		String url = props.getProperty("db.url");
		logger.info(">>>> "+user + ", " + password + ", " + url);
		
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void updateProductInstanceUrls(String instanceId, String productDestroyUrl, String productDetailUrl) {
		Connection conn = getConnection();
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("update mkt_my_product_instance ");
			sb.append("set EXTEND2 = '" + productDestroyUrl + "' ");
			sb.append(", EXTEND3 = '" + productDetailUrl + "' ");
			sb.append("where INSTANCE_ID = '" + instanceId + "'");
			logger.info(">>>> update product instance urls: " + sb.toString());
			Statement stmt = conn.createStatement();
			stmt.execute(sb.toString());
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		ProductInstanceUtils.getConnection();
//		String destroyUrl = "http://10.15.15.99:8089/chidi/actions/deleteProductInstance.html";
//		String detailUrl = "http://10.15.15.99:8089/chidi/actions/viewProductInstance.html";
//		updateProductInstanceUrls("6951e4e5-4f7b-4b23-9d4e-0b97e46ed791", destroyUrl, detailUrl);
	}
}
