public class BinaryTree {
    char value;
    BinaryTree leftLeaf;
    BinaryTree rightLeaf;

    int makeFromString(String str)
    {
        char[] chars = str.toCharArray();
        if ((str.length() == 0) || (chars[0] == '#'))
        {
            //value = null;
            return 0;
        }
        if ((chars[0] == '(') || (chars[0] == ')')){
            System.out.println("Неправильная запись дерева");
            System.exit(1);
        }

        value = chars[0];

        char[] leftStr = {}, rightStr = {};

        if (str.length() > 1)
        {
            if (chars[1] != '('){
                System.out.println("Неправильная запись дерева");
                System.exit(1);
            }
            int leftStart = 2;
            int leftEnd;
            int rightStart;
            int rightEnd;

            leftEnd = getEndPos(str, leftStart);
            leftStr = str.substring(leftStart, leftEnd + 1).toCharArray();

            rightStart = leftEnd + 1;
            if (chars[rightStart] == ')')
                rightEnd = rightStart - 1;
            else
                rightEnd = getEndPos(str, rightStart);
            rightStr = str.substring(rightStart, rightEnd + 1).toCharArray();
        }

        leftLeaf = new BinaryTree();
        rightLeaf = new BinaryTree();

        String leftString = String.valueOf(leftStr);
        String rightString = String.valueOf(rightStr);
        leftLeaf.makeFromString(leftString);
        rightLeaf.makeFromString(rightString);
        return 0;
    }

    boolean isResemlanceWith(BinaryTree secondTree)
    {
        boolean result = false;
        if (secondTree != null)
        {
            if ( (secondTree.leftLeaf  == null) == (leftLeaf  == null) &&
                    (secondTree.rightLeaf == null) == (rightLeaf == null)    ){
                result = true;
                if (leftLeaf != null)
                    result = leftLeaf.isResemlanceWith(secondTree.leftLeaf);
                if (rightLeaf != null)
                    result &= rightLeaf.isResemlanceWith(secondTree.rightLeaf);
            }
        }
        return result;
    }

    boolean isMirrorResemlanceWith(BinaryTree secondTree)
    {
        boolean result = false;
        if (secondTree != null)
        {
            if ( (secondTree.leftLeaf  == null) == (rightLeaf  == null) &&
                    (secondTree.rightLeaf == null) == (leftLeaf   == null)    ){
                result = true;
                if (leftLeaf != null)
                    result = leftLeaf.isMirrorResemlanceWith(secondTree.rightLeaf);
                if (rightLeaf != null)
                    result &= rightLeaf.isMirrorResemlanceWith(secondTree.leftLeaf);
            }
        }
        return result;
    }

    boolean isEqualWith(BinaryTree secondTree)
    {
        boolean result = false;
        if (secondTree != null)
        {
            if ( (secondTree.leftLeaf  == null) == (leftLeaf  == null) &&
                    (secondTree.rightLeaf == null) == (rightLeaf == null) &&
                    (secondTree.value == value)                              ){
                result = true;
                if (leftLeaf != null)
                    result = leftLeaf.isEqualWith(secondTree.leftLeaf);
                if (rightLeaf != null)
                    result &= rightLeaf.isEqualWith(secondTree.rightLeaf);
            }
        }
        return result;
    }

    boolean isSymmetryWith(BinaryTree secondTree)
    {
        boolean result = false;
        if (secondTree != null)
        {
            if ( (secondTree.leftLeaf  == null) == (rightLeaf  == null) &&
                    (secondTree.rightLeaf == null) == (leftLeaf   == null) &&
                    (secondTree.value == value)                              ){
                result = true;
                if (leftLeaf != null)
                    result = leftLeaf.isSymmetryWith(secondTree.rightLeaf);
                if (rightLeaf != null)
                    result &= rightLeaf.isSymmetryWith(secondTree.leftLeaf);
            }
        }
        return result;
    }

    int getEndPos(String str, int startPos)
    {
        char[] chars = str.toCharArray();
        int endPos;
        if (chars[startPos + 1] == '(')
        {
            endPos = startPos + 2;
            int brackets = 1;
            while ((brackets > 0) && (endPos < str.length()))
            {
                if (chars[endPos] == '(') brackets++;
                if (chars[endPos] == ')') brackets--;
                endPos++;
            }
            if (brackets > 0) {
                System.out.println("Неправильная запись дерева");
                System.exit(1);
            } // неправильная строка
            endPos--;
        }
        else
            endPos = startPos;
        return endPos;
    }
}
