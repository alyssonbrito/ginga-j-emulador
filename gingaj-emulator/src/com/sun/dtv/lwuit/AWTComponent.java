package com.sun.dtv.lwuit;

import br.org.sbtvd.media.*;

import com.sun.dtv.lwuit.animations.Animation;
import com.sun.dtv.lwuit.events.StyleListener;
import com.sun.dtv.lwuit.geom.Dimension;

import com.sun.dtv.ui.Animated;

public final class AWTComponent extends Component implements Animation,
		StyleListener, Animated {
	private java.awt.Component component;

	public AWTComponent(java.awt.Component component) {
		this.component = component;
		if(this.component instanceof AWTVideoComponent)
		{
			((AWTVideoComponent)this.component).setWrapperComponent(this);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		component.paint(g.getAWTGraphics());
	}

	@Override
	public void repaint() {
		super.repaint();
		component.repaint();
	}

	@Override
	public void repaint(int x, int y, int w, int h) {
		super.repaint(x, y, w, h);
		component.repaint(x, y, w, h);
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		component.setEnabled(enabled);
	}

	@Override
	public void setFocusable(boolean focusable) {
		super.setFocusable(focusable);
		component.setFocusable(focusable);
	}

	@Override
	public void setX(int x) {
		super.setX(x);

		java.awt.Rectangle rect = component.getBounds();
		rect.x = x;
		component.setBounds(rect);
	}

	@Override
	public void setY(int y) {
		super.setY(y);

		java.awt.Rectangle rect = component.getBounds();
		rect.y = y;
		component.setBounds(rect);
	}

	@Override
	public void setWidth(int width) {
		super.setWidth(width);

		java.awt.Rectangle rect = component.getBounds();
		rect.width = width;
		component.setBounds(rect);
	}

	@Override
	public void setHeight(int height) {
		super.setHeight(height);

		java.awt.Rectangle rect = component.getBounds();
		rect.height = height;
		component.setBounds(rect);
	}

	@Override
	public void setPreferredSize(Dimension d) {
		super.setPreferredSize(d);

		java.awt.Dimension dimension = new java.awt.Dimension();
		dimension.setSize(d.getWidth(), d.getHeight());
		component.setSize(dimension);
	}

	@Override
	public void setSize(Dimension d) {
		super.setSize(d);

		java.awt.Dimension dimension = new java.awt.Dimension();
		dimension.setSize(d.getWidth(), d.getHeight());
		component.setSize(dimension);
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);

		component.setVisible(visible);
	}
}
