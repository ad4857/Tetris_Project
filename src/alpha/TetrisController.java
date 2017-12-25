package alpha;

public class TetrisController {
	private TetrisModel model;
	private TetrisView view;
	private SceneRoute scene;

	public TetrisController() {
		this.view = new TetrisView(this);
		this.model = new TetrisModel(this.view);
	}

	public void start() {
		this.view.initWindow();
		this.getView(SceneRoute.Startup);
	}

	public void getView(SceneRoute scene) {
		System.out.println(scene);
		this.scene = scene;
		switch (scene) {
		case Startup:
			StartupPanel panel = new StartupPanel(this.view);
			this.view.changeView(panel);
			break;
		case Game:
			GamePanel gamePanel = new GamePanel(this.view);
			this.view.changeView(gamePanel);
			break;
		case Developer:
			DeveloperPanel developer = new DeveloperPanel(this.view);
			this.view.changeView(developer);
			break;
		}
	}

	public SceneRoute getScene() {
		return this.scene;
	}

	public void changeModel(String scene) {

	}

	public void updateState(int state) {

	}
}
