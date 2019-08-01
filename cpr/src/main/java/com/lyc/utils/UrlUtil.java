package com.lyc.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtil {
	private String urlSt;
	private URL url;

	public UrlUtil(String urlSt) {
		try {
			this.url = new URL(urlSt);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.urlSt = urlSt;
	}

	public String getQueryString(String name) {

		String query = url.getQuery();

		query = query.substring(query.indexOf(name + "="));
		if (query.indexOf("&") > -1)
			query = query.substring(name.length() + 1, query.indexOf("&"));
		else
			query = query.substring(name.length() + 1);

		return query;
	}

	public String getPath() {
		String path = url.getPath();
		int indexOf;
		while ((indexOf = path.indexOf("/")) > -1) {
			path = path.substring(indexOf + 1);
		}
		return path;
	}
}
