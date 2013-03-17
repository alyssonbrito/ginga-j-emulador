package br.org.sbtvd.ui;

import com.sun.dtv.resources.ResourceTypeListener;
import com.sun.dtv.resources.ScarceResourceListener;
import com.sun.dtv.resources.TimeoutException;

import com.sun.dtv.ui.*;

public class VideoPlane extends Plane {

	public VideoPlane() {
		super("VideoPlane");

		capabilities = new VideoCapabilities();
		setups = new PlaneSetup[1];
		setups[0] = new VideoPlaneSetup(this);
		currentSetup = getDefaultSetup();

                this.dtvContainer = null;
	}
	
	@Override
	protected void notifyScarceResourceTypeListeners(boolean reserved) {
		for(int i = 0; i < resourceListeners.size(); i++){
			if(reserved){
				((ResourceTypeListener)resourceListeners.get(i)).reserved(0);
			}else{
				((ResourceTypeListener)resourceListeners.get(i)).released(1);
			}
		}
	}
	
	public static Plane reserveOne(boolean force, long timeoutms, ScarceResourceListener listener) throws IllegalArgumentException, TimeoutException
	{
		Plane[] planes = Device.getInstance().getDefaultScreen().getAllPlanes();
		
		for(int i = 0; i < planes.length; i++){
			if(planes[i].getID().equals("VideoPlane")){
				planes[i].reserve(force, timeoutms, listener);
				return planes[i];
			}
		}
		
		return null;
	}

}
