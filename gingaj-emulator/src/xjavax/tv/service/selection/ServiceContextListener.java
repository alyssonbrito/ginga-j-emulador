/*

 This file is part of XleTView 
 Copyright (C) 2003 Martin Sveden
 
 This is free software, and you are 
 welcome to redistribute it under 
 certain conditions;

 See LICENSE document for details.

*/

package xjavax.tv.service.selection;

/**
 * The <code>ServiceContextListener</code> interface is implemented by
 * applications wishing to receive events related to service contexts.
 * <HR>
 * 
 * 
 */
public interface ServiceContextListener extends java.util.EventListener
{
	/**
	 * Notifies the <code>ServiceContextListener</code> of an event
	 * generated by a <code>ServiceContext</code>.
	 * 
	 * @param e - The generated event.
	 */
	public void receiveServiceContextEvent( ServiceContextEvent e);

}
