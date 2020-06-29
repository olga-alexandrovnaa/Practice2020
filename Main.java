import java.util.Scanner;
import java.util.*;

public class Main {
    public static String getStringWithoutBrackets(String str){
        char[] chars = str.toCharArray();
        int i = 0;

        while (chars[i] == ' ') i++;
        if (chars[i] != '('){
            System.out.println("Неправильная запись дерева");
            System.exit(1);
        }
        i++;
        int br = 1;
        int symbolsCount = 0;
        while ((br > 0) && (i+symbolsCount < str.length()-1))
        {
            symbolsCount++;
            if (chars[i+symbolsCount] == '(') br++;
            if (chars[i+symbolsCount] == ')') br--;
        }
        if (br > 0){
            System.out.println("Неправильная запись дерева");
            System.exit(1);
        }
        str = String.valueOf(chars);
        return str.substring(i, i + symbolsCount);
    }
    public static void main(String[] args) {
        int testCounter = 0;
        String str1, str2;
        Scanner in = new Scanner(System.in);
        System.out.println("Input first string:\n");
        str1 = in.nextLine();
        System.out.println("Input second string:\n");
        str2 = in.nextLine();
        BinaryTree tree1 = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();
        tree1.makeFromString(getStringWithoutBrackets(str1));
        tree2.makeFromString(getStringWithoutBrackets(str2));
        if(tree1.isResemlanceWith(tree2)){
            System.out.println("Подобны, ");
        }else{
            System.out.println("Не подобны, ");
        }
        if(tree1.isMirrorResemlanceWith(tree2)){
            System.out.println("Зеркально подобны, ");
        }else{
            System.out.println("Не зеркально подобны, ");
        }
        if(tree1.isEqualWith(tree2)){
            System.out.println("Равны, ");
        }else{
            System.out.println("Не равны, ");
        }
        if(tree1.isSymmetryWith(tree2)){
            System.out.println("Симметричны.");
        }else{
            System.out.println("Не симметричны.");
        }
        //System.out.println(getStringWithoutBrackets(str1));
        //System.out.println('\n');
        //System.out.println(getStringWithoutBrackets(str2));
    }

}
