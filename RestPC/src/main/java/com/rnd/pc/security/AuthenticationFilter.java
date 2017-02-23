package com.rnd.pc.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class AuthenticationFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo; // Information about the method

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
			.entity("You cannot access this resource").build();
	private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
			.entity("Access blocked for all users !!").build();

	public void filter(ContainerRequestContext context) throws IOException {

		Method method = resourceInfo.getResourceMethod();

		// Checking if method has PermitAll Annotation - If yes, no further
		// check needed. All allowed to access the method.
		// Otherwise, we will proceed to check further.
		if (!method.isAnnotationPresent(PermitAll.class)) {
			if (method.isAnnotationPresent(DenyAll.class)) {
				context.abortWith(ACCESS_FORBIDDEN);
				return;
			}

			// Get Request Header Map
			final MultivaluedMap<String, String> headersMap = context.getHeaders();

			// Get Authorization Header
			List<String> authorizationHeader = headersMap.get(AUTHORIZATION_PROPERTY);

			// Abort if authorizationHeader is null or empty
			if (null == authorizationHeader || authorizationHeader.isEmpty()) {
				context.abortWith(ACCESS_DENIED);
				return;
			}

			// Get Authorization Info - UsernamePassword Combined colon
			// delimited String
			String encoded_usernamepassword = authorizationHeader.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
			String usernamepassword = new String(Base64.decode(encoded_usernamepassword));

			StringTokenizer tokenizer = new StringTokenizer(usernamepassword, ":");
			String userName = tokenizer.nextToken();
			String password = tokenizer.nextToken();

			// Verify username and password with DB
			System.out.println(userName);
			System.out.println(password);

			// Verify Roles Access
			if (method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAllowed = method.getAnnotation(RolesAllowed.class);
				String roles[] = rolesAllowed.value();

				Set<String> roleSet = new HashSet<String>(Arrays.asList(roles));

				if (!isUserAllowed(userName, password, roleSet)) {
					context.abortWith(ACCESS_DENIED);
				}
			}

		}

	}

	private boolean isUserAllowed(String userName, String password, Set<String> roleSet) {

		boolean isAllowed = false;

		if (userName.equals("admin") && password.equals("pwd")) {
			String role = "Administrator";
			if (roleSet.contains(role)) {
				isAllowed = true;
			}
		}

		return isAllowed;
	}

}
