package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

import model.Sheet;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;
    Sheet sheet;

    public SlotLabels(int rows, int cols, CurrentSlot currentSlot, Sheet sheet) {
        super(rows + 1, cols);
    	this.sheet = sheet;
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
            	String position = ch+String.valueOf(row);
                SlotLabel label = new SlotLabel(position, currentSlot/* sheet observar inte längre SlotLabel, sheet*/);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        currentSlot.set(firstLabel);
        sheet.addObserver(this);
    }

	@Override	// NY METOD 010616
	public void update(Observable arg0, Object arg1) {
		System.out.println("SlotLabels/update");
		// TODO Auto-generated method stub
		for (SlotLabel slotLabel : labelList) {
			String position = slotLabel.toString(); // Ger positionen
			slotLabel.setText(sheet.print(position));
		}
		
	}
}
