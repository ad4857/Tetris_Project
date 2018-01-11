package beta;

import java.awt.event.KeyEvent;

import beta.components.*;
import beta.enums.*;

public class TetrisController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TetrisController controller = new TetrisController();
		controller.start();
	}

	private TetrisModel model;
	private TetrisView view;

	public TetrisController() {
		this.view = new TetrisView(this);
		this.model = new TetrisModel(this.view);
	}

	public void start() {
		this.view.initWindow();
		this.view.stateHasChanged(null, GameState.ViewStartup);
	}

	public void userHasInput(Command command) {
		switch (command) {
		case EnterStartup:
			this.model.setState(GameState.ViewStartup);
			break;
		case EnterGame:
			this.model.setState(GameState.Idle);
			break;
		case StartGame:
			this.model.setState(GameState.Playing);
			break;
		case PauseGame:
			this.model.setState(GameState.Paused);
			break;
		case StopGame:
			this.model.setState(GameState.Stop);
			break;
		case EnterDeveloper:
			this.model.setState(GameState.ViewDeveloper);
			break;
		case ExitDeveloper:
			this.model.setState(GameState.Idle);
			break;
		}
	}

	public void keyboardInput(KeyEvent e) {
		model.setAction(e);
	}
	
}
