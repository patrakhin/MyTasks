package Level23;
import java.util.*;
public class Level1 {
    static LinkedList<String> allStoryStrings = new LinkedList<>();
    static String currentString = "";
    static int memoryUndo = 0;
    static boolean flagUndo = false;
    // create allStoryStrings and currentString
    static {
        allStoryStrings.add("");
    }
    public static String BastShoe(String command) {
        String outString = "";
        String commandBuffer = "";
        StringBuilder stringBuffer = new StringBuilder();
        int itemsDelete = 0;
        boolean flagCorrect = true;
        // reading incoming string
        if (!Character.isDigit(command.charAt(0))) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        int a = 0;
        if (flagCorrect) {
            a = Integer.parseInt(String.valueOf(command.charAt(0)));
        }
        if (a < 1 || a > 5) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
        }
        else {
            commandBuffer = String.valueOf(a);
        }
        for (int i = 0; i < command.length() && flagCorrect; i++) {
            if (i > 1) {
                stringBuffer.append(command.charAt(i));
            }
        }
        // checks of the correct entry
        for (int i = 0; i < stringBuffer.length(); i++) {
            if ((commandBuffer.contains("2") || commandBuffer.contains("3")) && (stringBuffer.charAt(0) == '-') && stringBuffer.length() > 1) {
                continue;
            }
            if ((commandBuffer.contains("2")|| commandBuffer.contains("3")) && (!Character.isDigit(stringBuffer.charAt(i)))) {
                outString = allStoryStrings.get(allStoryStrings.size() - 1);
                commandBuffer = "";
                stringBuffer = new StringBuilder();
            }
        }
        if ((commandBuffer.contains("5") || commandBuffer.contains("4")) && stringBuffer.length() != 0) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
            stringBuffer = new StringBuilder();
        }
        //condition for break story Undo
        if ((commandBuffer.contains("1") || commandBuffer.contains("2")) && flagUndo) {
            outString = currentString;
            allStoryStrings = new LinkedList<>();
            allStoryStrings.add(outString);
            memoryUndo = 0;
            flagUndo = false;
            outString = "";
        }
        //Put
        if (commandBuffer.contains("1")) {
            currentString = currentString + stringBuffer;
            allStoryStrings.add(currentString);
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            currentString = outString;
            memoryUndo = allStoryStrings.size() - 1;
            commandBuffer = "";
        }
        //Delete
        if (commandBuffer.contains("2")) {
            itemsDelete = Integer.parseInt(stringBuffer.toString());
            stringBuffer = new StringBuilder();
        }
        if (itemsDelete < 0) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (itemsDelete > (String.valueOf(allStoryStrings.get(allStoryStrings.size() - 1))).length()) {
            outString = "";
            allStoryStrings.add(outString);
            currentString = outString;
            memoryUndo = allStoryStrings.size() - 1;
            commandBuffer = "";
        }
        CharSequence stringBufferForDeleteItem = "";
        if ((commandBuffer.contains("2")) && (itemsDelete <= (String.valueOf(allStoryStrings.get(allStoryStrings.size() - 1))).length())) {
            stringBufferForDeleteItem += allStoryStrings.get(allStoryStrings.size() - 1);
        }
        for (int i = 0; i < ((stringBufferForDeleteItem.length() - 1) - (itemsDelete - 1)); i++) {
            if (commandBuffer.contains("2")) {
                stringBuffer.append(stringBufferForDeleteItem.charAt(i));
            }
        }
        if (commandBuffer.contains("2")) {
            allStoryStrings.add(stringBuffer.toString());
            memoryUndo = allStoryStrings.size() - 1;
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            currentString = outString;
            commandBuffer = "";
        }
        //OutputItem
        if (commandBuffer.contains("3")) {
            itemsDelete = Integer.parseInt(stringBuffer.toString());
        }
        if (commandBuffer.contains("3") && (itemsDelete > (allStoryStrings.get(allStoryStrings.size() - 1).length() - 1) || itemsDelete < 0)) {
            outString = "";
            commandBuffer = "";
        }
        if (commandBuffer.contains("3")) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            stringBuffer = new StringBuilder(String.valueOf(outString.charAt(itemsDelete)));
            outString = String.valueOf(stringBuffer);
            commandBuffer = "";
        }
        //Undo
        if (commandBuffer.contains("4") && memoryUndo > 0) {
            outString = allStoryStrings.get(memoryUndo - 1);
            currentString = outString;
            memoryUndo -= 1;
            flagUndo = true;
            commandBuffer = "";
        }
        if (commandBuffer.contains("4") && memoryUndo == 0) {
            outString = allStoryStrings.get(memoryUndo);
            currentString = outString;
            flagUndo = true;
            commandBuffer = "";
        }
        //Redo
        if (commandBuffer.contains("5") && memoryUndo < (allStoryStrings.size() - 1)) {
            outString = allStoryStrings.get(memoryUndo + 1);
            currentString = outString;
            memoryUndo += 1;
            flagUndo = false;
            commandBuffer = "";
        }
        if (commandBuffer.contains("5")  && memoryUndo == (allStoryStrings.size() - 1)) {
            outString = allStoryStrings.get(memoryUndo);
            currentString = outString;
            flagUndo = false;
        }
        return outString;
    }
}
