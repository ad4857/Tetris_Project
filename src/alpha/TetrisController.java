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
	}
	
	public void getView(String scene) {
		System.out.println(scene);
		switch (scene) {
		case "startup":
			StartupPanel panel = new StartupPanel(this);
			this.view.changeView(panel);
			break;
		case "game":
			GamePanel gamePanel = new GamePanel(this);
			this.view.changeView(gamePanel);
			break;
		case "developer":
			DeveloperPanel developer = new DeveloperPanel(this);
			this.view.changeView(developer);
			break;
		}
	}
	public void changeModel(String scene) {
		
	}
	
	public void updateState(int state) {
		
	}
}
