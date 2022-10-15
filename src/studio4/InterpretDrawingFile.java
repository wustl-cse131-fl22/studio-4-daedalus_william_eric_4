package studio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		String shape = in.next();
		int red = in.nextInt();
		int green = in.nextInt();
		int blue = in.nextInt();
		if(shape.equals("ellipse")) {
			StdDraw.setPenColor(red, green, blue);
			if(in.nextBoolean()) {
				StdDraw.filledEllipse(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
			}
			else StdDraw.ellipse(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
		}
		if(shape.equals("rectangle")) {
			StdDraw.setPenColor(red, green, blue);
			if(in.nextBoolean()) {
				StdDraw.filledRectangle(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
			}
			else StdDraw.rectangle(in.nextDouble(), in.nextDouble(), in.nextDouble(), in.nextDouble());
		}
		if(shape.equals("triangle")) {
			StdDraw.setPenColor(red, green, blue);
			boolean bool = in.nextBoolean();
			double[] xs = new double[3];
			double[] ys = new double[3];
			for(int i = 0; i < 3; i++) {
				xs[i] = in.nextDouble();
				ys[i] = in.nextDouble();
			}
			if(bool) {
				StdDraw.filledPolygon(xs,ys);
			}
			else StdDraw.polygon(xs,ys);
		}
	}
}
