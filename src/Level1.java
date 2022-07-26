import java.util.*;
public class Level1 {
    static String outString = "";
    static ArrayList <String> storyArray = new ArrayList<>();
    static int countStoryArray;
    static int countPut;
    static int countDeleteItem;
    static int countOutputItem;
    static HashMap <Integer, String> mapCommand = new HashMap<>();
    static HashMap <Integer, String> mapStory = new HashMap<>();
    static int storyCountStory = 0;
    static int countUndo = 0;
    static int countRedo = 0;
    static boolean flagUndo = false;
    static int memoryOfStoryCountStory = 0; // :)
    static int memoryForRedo = 0;
    static int countDA = 0;
    static int countPutAndDeleteItem = 0;
    //creat map - command
    static {
        mapCommand.put(1, "Put");
        mapCommand.put(2, "DeleteItem");
        mapCommand.put(3, "OutputItem");
        mapCommand.put(4, "Undo()");
        mapCommand.put(5, "Redo()");
    }
    //

    public static String BastShoe(String command) {
        String commandBuffer = "";
        String stringBuffer = "";
        String stringBufferForDeleteItem = "";
        String stringBufferForDrop = "";
        int countBufferForDrop = 0;
        boolean flagLimitItems = true;
        // number of items for delete
        int itemsDelete =0;
        // number of items for OutputItems
        int itemsOutput =0;
        String drop = "";
        //loop - reader incoming string
        for (int i = 0; i < command.length(); i++) {
            if (i == 0 && (!Character.isDigit(command.charAt(i))) ) {
                outString = "";
                outString = storyArray.get(storyArray.size() - 1);
                commandBuffer = "";
                stringBuffer = "";
            }
            if (i == 0 ) {
                commandBuffer += mapCommand.get(Integer.parseInt(String.valueOf(command.charAt(i))));
                continue;
            }
            if (i == 1 && command.charAt(i) != ' ') {
                outString = "";
                outString = storyArray.get(storyArray.size() - 1);
                commandBuffer = "";
                stringBuffer = "";
            }
            if ((commandBuffer.contains("4") || commandBuffer.contains("5")) && command.length() > 1) {
                outString = "";
                outString = storyArray.get(storyArray.size() - 1);
                commandBuffer = "";
                stringBuffer = "";
            }
            if (i == 1 && command.charAt(i) == ' ') {
                continue;
            }
            stringBuffer += command.charAt(i);
        }

        //

        //catcher for Undo
        if (commandBuffer.equals("Put") || commandBuffer.equals("DeleteItem") || commandBuffer.equals("Redo()")) {
            countPutAndDeleteItem += 1;
        }
        if (commandBuffer.equals("Undo()") && countPutAndDeleteItem > 0) {
            countPutAndDeleteItem -= 1;
        }
        if (commandBuffer.equals("Undo()") && countPutAndDeleteItem <= 0) {
            outString = "";
            commandBuffer = "";
            stringBuffer = "";
        }

        // drop flagUNDO
        if ((commandBuffer.equals("Put") || commandBuffer.equals("DeleteItem")) && flagUndo) {
            stringBufferForDrop = storyArray.get(storyArray.size() - 1);
            storyArray = new ArrayList<>();
            storyArray.add(stringBufferForDrop);
            stringBufferForDrop = "";
            countBufferForDrop = storyCountStory;
            stringBufferForDrop = mapStory.get(countBufferForDrop);
            countBufferForDrop = 0;
            storyCountStory = 1;
            mapStory = new HashMap<>();
            mapStory.put(storyCountStory, stringBufferForDrop);
            stringBufferForDrop = "";
            countStoryArray = 1;
            countPut = 0;
            flagUndo = false;
            countDeleteItem = 0;
            countOutputItem = 0;
            countUndo = 0;
            memoryOfStoryCountStory = 0; // :)
            memoryForRedo = 0;
            drop = "drop";
        }

        // add to mapStory
        storyCountStory += 1;
        mapStory.put(storyCountStory,commandBuffer);

        // relation Undo with Redo
        if (countUndo == 0) {
            countRedo = 0;
        }
        //counter Redo
        if (commandBuffer.equals("Redo()")) {
            countRedo += 1;
        }
        //catcher for Redo
        if (commandBuffer.equals("Redo()") && countUndo <= 0) {
            outString = "";
            outString = storyArray.get(storyArray.size() - 1);
            commandBuffer = "";
            stringBuffer = "";
        }

        //block command-arrayStorage with Put ONCE
        if ((commandBuffer.equals("Put") && storyArray.isEmpty())) {
            storyArray.add(String.valueOf(stringBuffer));
            countStoryArray += 1;
            countPut += 1;
            stringBuffer = "";
            commandBuffer = "";
            outString += storyArray.get(0);
        }
        //block command-arrayStorage with Put TWICE
        int w = countStoryArray;
        if (commandBuffer.equals("Put")) {
            stringBuffer = (storyArray.get(w - 1)) + stringBuffer;
            storyArray.add(String.valueOf(stringBuffer));
            countStoryArray += 1;
            countPut += 1;
            stringBuffer = "";
        }
        //block output string with Put

        if (commandBuffer.equals("Put")) {
            outString = "";
            outString = storyArray.get(storyArray.size() - 1);
            commandBuffer = "";
        }

        //block command-arrayStorage with DeleteItem
        if (commandBuffer.equals("DeleteItem")) {
            itemsDelete = Integer.parseInt(String.valueOf(stringBuffer));
            stringBuffer = "";
        }

        if (commandBuffer.equals("DeleteItem") && itemsDelete <= (String.valueOf(storyArray.get(storyArray.size() - 1))).length()) {
            stringBufferForDeleteItem += storyArray.get(storyArray.size() - 1);
        }
        if (commandBuffer.equals("DeleteItem") && itemsDelete > (String.valueOf(storyArray.get(storyArray.size() - 1))).length()) {
            outString = "";
            commandBuffer = "";
            stringBuffer = "";
            mapStory.remove(storyCountStory);
            storyCountStory -= 1;
        }

        for ( int i = 0 ;i < (stringBufferForDeleteItem.length() - 1) - (itemsDelete - 1) ; i++) {
            if (commandBuffer.equals("DeleteItem")) {
                stringBuffer += stringBufferForDeleteItem.charAt(i);
            }
        }
        if (commandBuffer.equals("DeleteItem")) {
            storyArray.add(stringBuffer);
            countDeleteItem += 1;
            countStoryArray += 1;
            stringBufferForDeleteItem = "";
            stringBuffer = "";
        }
        //block output string with DeleteItem
        if (commandBuffer.equals("DeleteItem")) {
            outString = "";
            outString = storyArray.get(storyArray.size() - 1);
            commandBuffer = "";
        }
        //block output string with OutputItem
        if (commandBuffer.equals("OutputItem")) {
            itemsOutput = Integer.parseInt(String.valueOf(stringBuffer));
            stringBuffer = "";
        }
        if (commandBuffer.equals("OutputItem") && itemsOutput > storyArray.get(storyArray.size() - 1).length()) {
            outString = "";
            commandBuffer = "";
            flagLimitItems = false;
        }
        for (int i = 0; i < storyArray.get(storyArray.size() - 1).length() && flagLimitItems && commandBuffer.equals("OutputItem"); i++) {
            stringBuffer = String.valueOf(storyArray.get(storyArray.size() - 1).charAt(itemsOutput));
            itemsOutput = 0;
            storyArray.add(stringBuffer);
            stringBuffer = "";
            outString = storyArray.get(storyArray.size() - 1);
            break;
        }

        //block Undo()
        int a = storyCountStory;
        for (; a > 0 && commandBuffer.equals("Undo()") && countUndo == 0; a --) {
            if (mapStory.get(a).contains("Put")) {
                storyArray.add(storyArray.get(a - 2));
                outString = storyArray.get(storyArray.size() - 1);
                flagUndo = true;
                countUndo += 1;
                memoryOfStoryCountStory = (a - 2);
                countStoryArray += 1;
                commandBuffer = "";
                break;
            }
            if (mapStory.get(a).contains("DeleteItem")) {
                storyArray.add(storyArray.get(a - 2));
                outString = storyArray.get(storyArray.size() - 1);
                flagUndo = true;
                countUndo += 1;
                memoryOfStoryCountStory = (a - 2);
                countStoryArray += 1;
                commandBuffer = "";
                break;
            }
        }
        int b  = memoryOfStoryCountStory;
        for (; b > 0 && commandBuffer.equals("Undo()") && countUndo != 0; b --) {
            if (mapStory.get(b).contains("Put")) {
                storyArray.add(storyArray.get(b - 1));
                outString = storyArray.get(storyArray.size() - 1);
                flagUndo = true;
                countUndo += 1;
                memoryOfStoryCountStory = (b - 1);
                countStoryArray += 1;
                break;
            }
            if (mapStory.get(b).contains("DeleteItem")) {
                storyArray.add(storyArray.get(b - 1));
                outString = storyArray.get(storyArray.size() - 1);
                flagUndo = true;
                countUndo += 1;
                memoryOfStoryCountStory = (b - 1);
                countStoryArray += 1;
                break;
            }
        }
        if ( commandBuffer.equals("Undo()") && mapStory.get(storyCountStory - 1).contains("Redo()")) {
            storyArray.add(storyArray.get((storyArray.size() - 1) - 1));
            outString = storyArray.get(storyArray.size() - 1);
        }
        //block REDO()
        int c = storyCountStory - 1;
        for (; c > 0 && commandBuffer.equals("Redo()") && countRedo == 1; c --) {
            if (mapStory.get(c).contains("Undo()")) {
                storyArray.add(storyArray.get(c - 2));
                outString = storyArray.get(storyArray.size() - 1);
                countUndo -= 1;
                memoryForRedo = (c - 1);
                countStoryArray += 1;
                commandBuffer = "";
                break;
            }
        }
        int d = memoryForRedo;
        for (; d > mapStory.size() - 1 && commandBuffer.equals("Redo()") && countRedo > 1; d --) {
            if (mapStory.get(d).contains("Undo()")) {
                storyArray.add(storyArray.get(d));
                outString = storyArray.get(storyArray.size() - 1);
                countUndo -= 1;
                memoryForRedo = (d - 1);
                commandBuffer = "";
                break;
            }
        }
        return outString;
    }
}
