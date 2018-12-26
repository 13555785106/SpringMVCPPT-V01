package com.sample.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;

@WebListener
public class AppListener implements HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener,
		ServletRequestListener, ServletRequestAttributeListener {

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("sessionCreated " + hse.getSession());
		Formatter f;
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent hse) {
		System.out.println("sessionWillPassivate " + hse.getSession());
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent hse) {
		System.out.println("sessionDidActivate " + hse.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("sessionDestroyed " + hse.getSession());
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent hse) {
		System.out.println("session attributeAdded " + hse.getName() + "=" + hse.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent hse) {
		System.out.println("session attributeReplaced " + hse.getName() + "=" + hse.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent hse) {
		System.out.println("session attributeRemoved " + hse.getName() + "=" + hse.getValue());
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized " + sre.getServletRequest());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed " + sre.getServletRequest());
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("request attributeAdded " + srae.getName() + "=" + srae.getValue());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request attributeReplaced " + srae.getName() + "=" + srae.getValue());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("request attributeRemoved " + srae.getName() + "=" + srae.getValue());
	}

}
