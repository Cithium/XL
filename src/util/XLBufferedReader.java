package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import model.Slot;
import model.SlotTypeChecker;

//TODO move to another package
public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    // TODO Change Object to something appropriate
    public void load(Map<String, Slot> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                string.split("=");
                String key = string.substring(0, i);
                Slot value = SlotTypeChecker.check(string.substring(i+1));
                map.put(key, value);
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
