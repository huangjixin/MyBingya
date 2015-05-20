package com.jcin.cms.utils;

import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomerRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return CustomerContextHolder.getCustomerType();
	}

//	@Override
//	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
//		// TODO Auto-generated method stub
//		return null;
//	}
}