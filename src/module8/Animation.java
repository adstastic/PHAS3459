package module8;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/** Rotating square animation with start, stop and exit buttons. */
public class Animation {
	/** Create and display JFrame containing animation GUI panel */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			JFrame frame = new JFrame("Solar System");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500,600);
			JPanel panel = new AnimationGuiPanel();
			frame.add(panel);
			frame.setVisible(true);
			}
		});
	}
}
