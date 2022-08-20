import  java.util.*;
public class Level1 {
    static LinkedList <String> allStoryStrings = new LinkedList<>();
    static LinkedList <Integer> memoryUndo = new LinkedList<>();
    static LinkedList <Integer> memoryRedo = new LinkedList<>();
    static HashMap <Integer, String> mapCommand = new HashMap<>();
    // flags
    static boolean flagUndo = false;
    static boolean flagReUndo = false;
    static boolean flagRedo = false;
    // create allStoryStrings
    static {
        allStoryStrings.add("");
    }
    // filling memoryUndo for zero string
    static {
        memoryUndo.add(0);
    }
    // create map command
    static {
        mapCommand.put(1, "Put");
        mapCommand.put(2, "DeleteItem");
        mapCommand.put(3, "OutputItem");
        mapCommand.put(4, "Undo()");
        mapCommand.put(5, "Redo()");
    }
    public static String BastShoe (String command) {
        String outString = "";
        String commandBuffer = "";
        String stringBuffer = "";
        String stringBufferForDeleteItem = "";
        String stringBufferForDrop = "";
        boolean flagLimitItems = true;
        // number of items for delete
        int itemsDelete =0;
        // number of items for OutputItems
        int itemsOutput =0;
        //loop - reader incoming string
        for (int i = 0; i < command.length(); i++) {
            if (i == 0 && (!Character.isDigit(command.charAt(i))) ) {
                outString = allStoryStrings.get(0);
            }
            if (i == 0 ) {
                commandBuffer += mapCommand.get(Integer.parseInt(String.valueOf(command.charAt(i))));
                continue;
            }
            if (i == 1 && command.charAt(i) != ' ') {
                outString = allStoryStrings.get(0);
            }
            if ((commandBuffer.contains("4") || commandBuffer.contains("5")) && command.length() > 1) {
                outString = allStoryStrings.get(0);
            }
            if (i == 1 && command.charAt(i) == ' ') {
                continue;
            }
            stringBuffer += command.charAt(i);
        }
        // condition to flagUndo
        if (commandBuffer.contains("Redo()") && flagUndo) {
            flagUndo = false;
        }
        //condition for Reload Undo
        if (flagUndo && (commandBuffer.equals("DeleteItem") || commandBuffer.equals("Put")) ) {
            stringBufferForDrop = allStoryStrings.get(memoryUndo.size() - 1);
            allStoryStrings = new LinkedList<>();
            allStoryStrings.add(stringBufferForDrop);
            memoryUndo = new LinkedList<>();
            memoryUndo.add(0);
            memoryRedo = new LinkedList<>();
            flagUndo = false;
        }
        //filling allStoryStrings
        //block command-arrayStorage with Put
        if (commandBuffer.equals("Put")) {
            allStoryStrings.add(allStoryStrings.get(allStoryStrings.size() - 1) + stringBuffer);
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            memoryUndo.add(allStoryStrings.size() - 1);
        }
        //block command-arrayStorage with DeleteItem
        if (commandBuffer.equals("DeleteItem")) {
            itemsDelete = Integer.parseInt(stringBuffer);
            stringBuffer = "";
        }

        if (commandBuffer.equals("DeleteItem") && itemsDelete <= (String.valueOf(allStoryStrings.get(allStoryStrings.size() - 1))).length()) {
            stringBufferForDeleteItem += allStoryStrings.get(allStoryStrings.size() - 1);
        }
        if (commandBuffer.equals("DeleteItem") && itemsDelete > (String.valueOf(allStoryStrings.get(allStoryStrings.size() - 1))).length()) {
            allStoryStrings.add("");
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            memoryUndo.add(allStoryStrings.size() - 1);
            commandBuffer = "";
            stringBuffer = "";
        }

        for ( int i = 0 ;i < ((stringBufferForDeleteItem.length() - 1) - (itemsDelete - 1)); i++) {
            if (commandBuffer.equals("DeleteItem")) {
                stringBuffer += stringBufferForDeleteItem.charAt(i);
            }
        }
        if (commandBuffer.equals("DeleteItem")) {
            allStoryStrings.add(stringBuffer);
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            memoryUndo.add(allStoryStrings.size() - 1);
            commandBuffer = "";
            stringBuffer = "";
        }
        //block output string with OutputItem
        if (commandBuffer.equals("OutputItem")) {
            itemsOutput = Integer.parseInt(stringBuffer);
            stringBuffer = "";
        }
        if (commandBuffer.equals("OutputItem") && itemsOutput > allStoryStrings.get(allStoryStrings.size() - 1).length()) {
            allStoryStrings.add("");
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
            flagLimitItems = false;
            stringBuffer = "";
        }
        for (int i = 0; i < allStoryStrings.get(allStoryStrings.size() - 1).length(); i++) {
            if (flagLimitItems && commandBuffer.equals("OutputItem")) {
                stringBuffer = String.valueOf(allStoryStrings.get(allStoryStrings.size() - 1).charAt(itemsOutput - 1));
                itemsOutput = 0;
                allStoryStrings.add(stringBuffer);
                outString = allStoryStrings.get(allStoryStrings.size() - 1);
                stringBuffer = "";
                break;
            }
        }
        //block Undo
        if (commandBuffer.equals("Undo()") && memoryUndo.size() > 1 && !flagUndo) {
            flagUndo = true;
            memoryRedo.add(memoryUndo.size() - 1);
            memoryUndo.remove(memoryUndo.size() - 1);
            allStoryStrings.add(allStoryStrings.get(memoryUndo.size() - 1));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals("Undo()") && memoryUndo.size() > 1 && flagUndo) {
            memoryRedo.add(memoryUndo.size() - 1);
            memoryUndo.remove(memoryUndo.size() - 1);
            allStoryStrings.add(allStoryStrings.get(memoryUndo.size() - 1));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals("Undo()") && memoryUndo.size() == 1 && !flagReUndo) {
            flagReUndo = true;
            memoryRedo.add(memoryUndo.get(0));
            allStoryStrings.add(allStoryStrings.get(memoryUndo.size() - 1));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals("Undo()") && memoryUndo.size() == 1 && flagReUndo) {
            allStoryStrings.add(allStoryStrings.get(memoryUndo.get(0)));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals("Undo()") && memoryRedo.size() == 1 && flagRedo) {
            memoryUndo.remove(memoryUndo.size() - 1);
            allStoryStrings.add(allStoryStrings.get(memoryUndo.get(memoryUndo.size() - 1)));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }

        // block Redo
        if (commandBuffer.equals("Redo()") && memoryUndo.size() == 1 && flagReUndo) {
            flagReUndo = false;
            memoryRedo.remove(memoryRedo.size() - 1);
            allStoryStrings.add(allStoryStrings.get((memoryUndo.get(memoryUndo.size() - 1))));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals("Redo()") && memoryRedo.size() == 1 && !flagRedo) {
            flagRedo = true;
            memoryUndo.add(0);
            allStoryStrings.add(allStoryStrings.get(memoryUndo.size() - 1));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals("Redo()") && memoryRedo.size() == 1 && flagRedo) {
            allStoryStrings.add(allStoryStrings.get(memoryRedo.get(0)));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }
        if (commandBuffer.equals("Redo()") && memoryRedo.size() > 1) {
            memoryUndo.add(memoryRedo.get(memoryRedo.size() - 1));
            memoryRedo.remove(memoryRedo.size() - 1);
            allStoryStrings.add(allStoryStrings.get(memoryUndo.get(memoryUndo.size() - 1)));
            outString = allStoryStrings.get(allStoryStrings.size() - 1);
            commandBuffer = "";
        }

        return outString;
    }
}
