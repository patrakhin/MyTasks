import java.util.*;
public class Level1 {
    static LinkedList<String> allStoryStrings = new LinkedList<>();
    static LinkedList <Integer> memoryUndo = new LinkedList<>();
    static LinkedList <Integer> memoryRedo = new LinkedList<>();
    static HashMap<Integer, String> mapCommand = new HashMap<>();
    static LinkedList <String> memoryOutPutItem = new LinkedList<>();
    static LinkedList <String> symbolString = new LinkedList<>();
    // flags
    static boolean flagUndo = false;
    static boolean flagLastUndo = false;
    static boolean flagLastRedo = false;
    static boolean flagFirstPut = false;
    static boolean flagCastString = false;
    static boolean flagUndoRedoForPut = false;
    // create allStoryStrings
    static {
        allStoryStrings.add("");
    }
    // create symbolString
    static {
        symbolString.add("");
    }
    // filling memoryUndo for zero string
    static {
        memoryUndo.add(0);
    }
    // create map command
    static final String ACTION_1 = "Put";
    static final String ACTION_2 = "DeleteItem";
    static final String ACTION_3 = "OutputItem";
    static final String ACTION_4 = "Undo()";
    static final String ACTION_5 = "Redo()";
    static {
        mapCommand.put(1, ACTION_1);
        mapCommand.put(2, ACTION_2);
        mapCommand.put(3, ACTION_3);
        mapCommand.put(4, ACTION_4);
        mapCommand.put(5, ACTION_5);
    }
    public static String BastShoe(String command) {
        String outString = "";
        String twoStringBuffer = "";
        String commandBuffer = "";
        StringBuilder stringBuffer = new StringBuilder();
        String stringBufferForDeleteItem = "";
        String stringBufferForDrop;
        boolean flagLimitItems = true;
        boolean flagCorrect = true;
        // number of items for delete
        int itemsDelete = 0;
        // number of items for OutputItems
        int itemsOutput = 0;
        //
        int zeroNumber = 0;
        //
        char[] ca;
        String outBuf;
        // reading incoming string
        if (!Character.isDigit(command.charAt(0))) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect) {
            zeroNumber = (Integer.parseInt(String.valueOf(command.charAt(0))));
        }
        if (flagCorrect && zeroNumber < 1) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect && zeroNumber > 5) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect && (zeroNumber == 1 || zeroNumber == 2 || zeroNumber == 3) && command.length() == 1) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect && (zeroNumber == 1 || zeroNumber == 2 || zeroNumber == 3) && command.charAt(1) != ' ') {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect && (zeroNumber == 1 || zeroNumber == 2 || zeroNumber == 3) && command.charAt(1) == ' ' && command.length() == 2) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect && (zeroNumber == 4 || zeroNumber == 5) && command.length() > 1) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            flagCorrect = false;
        }
        if (flagCorrect) {
            commandBuffer = (String.valueOf(command.charAt(0)));
            commandBuffer = mapCommand.get(Integer.parseInt(commandBuffer));
        }
        for (int i = 0; i < command.length() && flagCorrect; i++) {
            if (i > 1) {
                stringBuffer.append(command.charAt(i));
            }
        }

        // checks of the correct entry
        for (int i = 0; i < stringBuffer.length(); i++) {
            if ((commandBuffer.equals(ACTION_2) || commandBuffer.equals(ACTION_3)) && (stringBuffer.charAt(0) == '-') && stringBuffer.length() > 1) {
                continue;
            }
            if ((commandBuffer.equals(ACTION_2) || commandBuffer.equals(ACTION_3)) && (!Character.isDigit(stringBuffer.charAt(i)))) {
                outString = allStoryStrings.get(allStoryStrings.size() - 1);
                commandBuffer = "";
                stringBuffer = new StringBuilder();
            }
        }
        if ((commandBuffer.equals(ACTION_5) || commandBuffer.equals(ACTION_4)) && stringBuffer.length() != 0) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
            stringBuffer = new StringBuilder();
        }

        // condition to flagUndo
        if ((commandBuffer.contains(ACTION_5) || commandBuffer.contains(ACTION_3)) && flagUndo) {
            flagUndo = false;
        }

        //condition for Reload Undo
        if (flagUndo && (commandBuffer.equals(ACTION_2) || commandBuffer.equals(ACTION_1))) {
            stringBufferForDrop = memoryOutPutItem.get(0);
            allStoryStrings = new LinkedList<>();
            allStoryStrings.add(stringBufferForDrop);
            memoryOutPutItem = new LinkedList<>();
            memoryUndo = new LinkedList<>();
            memoryUndo.add(0);
            memoryRedo = new LinkedList<>();
            symbolString = new LinkedList<>();
            symbolString.add(0, "");
            flagUndo = false;
            flagLastUndo = false;
            flagLastRedo = false;
            flagFirstPut = false;
            flagCastString = false;
            flagUndoRedoForPut = false;
        }

        // condition for add after Undo or Redo
        if (commandBuffer.equals(ACTION_4) || commandBuffer.equals(ACTION_5)) {
            flagUndoRedoForPut = true;
        }
        // condition for add after OutputItem
        if (commandBuffer.equals(ACTION_3)) {
            flagCastString = true;
        }
        //filling allStoryStrings
        //block command-arrayStorage with Put

        if (!flagFirstPut) {
            allStoryStrings.add(allStoryStrings.get(allStoryStrings.size() - 1) + stringBuffer);
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            memoryUndo.add(allStoryStrings.size() - 1);
            memoryOutPutItem.add(allStoryStrings.get(allStoryStrings.size() - 1));
            flagFirstPut = true;
            commandBuffer = "";
        }

        //after Undo or Redo
        if (commandBuffer.equals(ACTION_1) && flagUndoRedoForPut) {
            twoStringBuffer = memoryOutPutItem.get(memoryOutPutItem.size() - 1);
            allStoryStrings.add(twoStringBuffer + stringBuffer);
            memoryOutPutItem.remove(memoryOutPutItem.size() - 1);
            memoryOutPutItem.add(allStoryStrings.get(allStoryStrings.size() - 1));
            memoryUndo.add(allStoryStrings.size() - 1);
            outString = memoryOutPutItem.get(memoryOutPutItem.size() - 1);
            commandBuffer = "";
            flagUndoRedoForPut = false;
        }

        //after OutPutItem
        if (commandBuffer.equals(ACTION_1) && flagCastString) {
            twoStringBuffer = symbolString.get(0);
            symbolString.add(0,"");
            flagCastString = false;
        }

        if (commandBuffer.equals(ACTION_1)) {
            allStoryStrings.add(allStoryStrings.get(allStoryStrings.size() - 1) + twoStringBuffer + stringBuffer);
            memoryOutPutItem.remove(memoryOutPutItem.size() - 1);
            memoryOutPutItem.add(allStoryStrings.get(allStoryStrings.size() - 1));
            memoryUndo.add(allStoryStrings.size() - 1);
            outString = memoryOutPutItem.get(memoryOutPutItem.size() - 1);
            commandBuffer = "";
        }

        //block command-arrayStorage with DeleteItem
        if (commandBuffer.equals(ACTION_2)) {
            itemsDelete = Integer.parseInt(stringBuffer.toString());
            stringBuffer = new StringBuilder();
        }
        if (itemsDelete < 0) {
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
            stringBuffer = new StringBuilder();
        }

        if (commandBuffer.equals(ACTION_2) && itemsDelete <= (String.valueOf(allStoryStrings.get(allStoryStrings.size() - 1))).length()) {
            stringBufferForDeleteItem += allStoryStrings.get(allStoryStrings.size() - 1);
        }
        if (commandBuffer.equals(ACTION_2) && itemsDelete > (String.valueOf(allStoryStrings.get(allStoryStrings.size() - 1))).length()) {
            memoryOutPutItem.add("");
            outString = "";
            commandBuffer = "";
            stringBuffer = new StringBuilder();
        }

        for (int i = 0; i < ((stringBufferForDeleteItem.length() - 1) - (itemsDelete - 1)); i++) {
            if (commandBuffer.equals(ACTION_2)) {
                stringBuffer.append(stringBufferForDeleteItem.charAt(i));
            }
        }
        if (commandBuffer.equals(ACTION_2)) {
            allStoryStrings.add(stringBuffer.toString());
            memoryUndo.add(allStoryStrings.size() - 1);
            memoryOutPutItem.remove(0);
            memoryOutPutItem.add(allStoryStrings.get(allStoryStrings.size() - 1) + symbolString.get(0));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
            stringBuffer = new StringBuilder();
        }
        //block output string with OutputItem
        if (commandBuffer.equals(ACTION_3)) {
            itemsOutput = Integer.parseInt(stringBuffer.toString());
        }
        if (commandBuffer.equals(ACTION_3) && (itemsOutput > (allStoryStrings.get(allStoryStrings.size() - 1).length() - 1) || itemsOutput < 0)) {
            outString = "";
            commandBuffer = "";
            flagLimitItems = false;
        }
        if (flagLimitItems && commandBuffer.equals(ACTION_3)) {
            outBuf = allStoryStrings.get(allStoryStrings.size() - 1);
            ca = outBuf.toCharArray();
            outBuf = String.valueOf(ca[itemsOutput]);
            symbolString.remove(0);
            symbolString.add(outBuf);
            memoryOutPutItem.remove(0);
            memoryOutPutItem.add(outBuf);
            flagCastString = true;
            outString = memoryOutPutItem.get(0);
            commandBuffer = "";
        }
        //block Undo

        if (commandBuffer.equals(ACTION_4) && flagLastRedo) {
            flagUndo = true;
            //twoStringBuffer = memoryOutPutItem.get(0); //add
            memoryOutPutItem.remove(0);
            memoryOutPutItem.add(allStoryStrings.get(memoryUndo.get(memoryUndo.size() - 1)) + symbolString.get(0)); /// add
            outString = memoryOutPutItem.get(0);
            commandBuffer = "";
            flagLastRedo = false;
        }
        if (commandBuffer.equals(ACTION_4) && memoryUndo.size() > 1) {
            flagUndo = true;
            memoryRedo.add(memoryUndo.get(memoryUndo.size() - 1));
            //twoStringBuffer = memoryOutPutItem.get(0); //add
            memoryOutPutItem.remove(0);
            memoryUndo.remove(memoryUndo.size() - 1);
            memoryOutPutItem.add(allStoryStrings.get(memoryUndo.get(memoryUndo.size() - 1)) + symbolString.get(0)); /// add
            outString = memoryOutPutItem.get(0);
            commandBuffer = "";
        }
        if (commandBuffer.equals(ACTION_4) && memoryUndo.size() == 1) {
            flagUndo = true;
            //twoStringBuffer = memoryOutPutItem.get(0); //add
            memoryOutPutItem.remove(0);
            memoryOutPutItem.add(allStoryStrings.get(memoryUndo.get(memoryUndo.size() - 1)) + symbolString.get(0)); /// add
            outString = memoryOutPutItem.get(0);
            commandBuffer = "";
            flagLastUndo = true;
        }
        // block Redo
        if (commandBuffer.equals(ACTION_5) && flagLastUndo && !memoryRedo.isEmpty()) {
            memoryOutPutItem.remove(0);
            memoryOutPutItem.add(allStoryStrings.get(memoryRedo.get(memoryRedo.size() - 1)) + symbolString.get(0)); /// add
            outString = memoryOutPutItem.get(0);
            commandBuffer = "";
            flagLastUndo = false;
        }
        if (commandBuffer.equals(ACTION_5) && flagLastUndo) {
            outString = memoryOutPutItem.get(0);
            commandBuffer = "";
            flagLastUndo = false;
        }
        if (commandBuffer.equals(ACTION_5) && memoryRedo.isEmpty()) {
            outString = memoryOutPutItem.get(0);
            commandBuffer = "";
        }
        if (commandBuffer.equals(ACTION_5) && memoryRedo.size() == 1) {
            //twoStringBuffer = memoryOutPutItem.get(0); //add
            memoryOutPutItem.remove(0);
            memoryOutPutItem.add(allStoryStrings.get(memoryRedo.get(memoryRedo.size() - 1)) + symbolString.get(0)); /// add
            outString = memoryOutPutItem.get(0);
            flagLastRedo = true;
            commandBuffer = "";
        }
        if (commandBuffer.equals(ACTION_5)) {
            memoryUndo.add(memoryRedo.get(memoryRedo.size() - 1));
            memoryOutPutItem.remove(0);
            memoryRedo.remove(memoryRedo.size() - 1);
            memoryOutPutItem.add(allStoryStrings.get(memoryUndo.get(memoryUndo.size() - 1)) + symbolString.get(0)); /// add
            outString = memoryOutPutItem.get(0);
        }

        return outString;
    }
}
