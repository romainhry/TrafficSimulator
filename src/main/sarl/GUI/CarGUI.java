package GUI;

import javafx.scene.image.ImageView;


public class CarGUI extends ImageView {
	private java.util.UUID UUID;
	public CarGUI() {
		super();
	}

	public CarGUI(String imgurl , java.util.UUID id) {
		super(imgurl);
		this.UUID = id;
	}

	public java.util.UUID getUUID() {
		return UUID;
	}

	public void setUUID(java.util.UUID uUID) {
		UUID = uUID;
	}
	
}