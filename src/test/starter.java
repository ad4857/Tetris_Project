package test;

import javax.swing.*;
import java.awt.*;

public class starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainWindow window = new MainWindow();
		StateController controller = new StateController(window);		
		controller.ChangeView(ViewsEnum.initView);
	}

}
