package alpha;

public class TetrisController {
	private TetrisModel model;
	private TetrisView view;

	public TetrisController() {
		this.view = new TetrisView(this);
		this.model = new TetrisModel(this.view);
	}

	public void start() {
		this.view.initWindow();
		this.model.setState("developer");
	}
	
	public void changeModel(String scene) {
		
	}
	
	public void updateState(int state) {
		
	}
}
