
import java.awt.event.*;

public class doAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == GUI.about_button){
			GUI.about.setVisible(true);
		} else if (source == GUI.login_button){
			if (true){
				GUI.login.dispose();
				GUI.about.dispose();
				GUI.game.setVisible(true);
				GUI.game.setTitle("Game - Room No .");
			}
		}
	}
}
