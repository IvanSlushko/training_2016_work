package com.ivanslushko.training.web.servlets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ivanslushko.training.services.AuthenticationService;
import com.ivanslushko.training.services.components.UserDataStorage;

import redis.clients.jedis.Jedis;

public class BasicAuthFilter implements Filter {

	private AuthenticationService authService;

	private UserDataStorage userDataStorage;
	private ApplicationContext appContext;

	@Override
	public void init(FilterConfig config) throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		authService = context.getBean(AuthenticationService.class);
		appContext = context;

		/**
		 * start Jedis server
		 */
		try {
			new ProcessBuilder("cmd", "/c", "start", "C:/startRedis.bat").start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		userDataStorage = appContext.getBean(UserDataStorage.class);

		String[] credentials = resolveCredentials(req);

		boolean isCredentialsResolved = credentials != null && credentials.length == 2;
		if (!isCredentialsResolved) {
			res.sendError(401);
			return;
		}
		
		/**
		 * check contains Jedis login and password or no
		 */

		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("localhost", 6379);
		String username = null;
		String password = null;

		if (jedis.exists("userName") && jedis.exists("password")) {
			System.out.println("Redis working.       TTL: userName - " + jedis.ttl("userName") + "sec.,  password - "
					+ jedis.ttl("password") + "sec.");
			username = jedis.get("userName");
			password = jedis.get("password");

		} else {
			System.out.println("Redis does not contain userName and password");
			username = credentials[0];
			password = credentials[1];
			jedis.set("userName", username);
			jedis.set("password", password);
			jedis.expire("userName", 60);
			jedis.expire("password", 60);

		}

		if (authService.validateUserPassword(username, password)) {
			userDataStorage.setLoggedIn(true);
			chain.doFilter(request, response);
		} else {
			res.sendError(401);
		}
	}

	private String[] resolveCredentials(HttpServletRequest req) {
		try {
			Enumeration<String> headers = req.getHeaders("Authorization");
			String nextElement = headers.nextElement();
			String base64Credentials = nextElement.substring("Basic".length()).trim();
			String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
			return credentials.split(":", 2);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void destroy() {
	}
}