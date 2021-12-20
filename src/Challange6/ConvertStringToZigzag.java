package Challange6;

public class ConvertStringToZigzag {
    public static void main(String[] args) {
        System.out.println(convertZigZag("PAYPALISHIRING",3));
        System.out.println("PAHNAPLSIIGYIR".equals(convertZigZag("PAYPALISHIRING",3)));
    }

    public static String convertZigZag(String s, int numRows){
        int elementCountBetweenAmongColumns = (numRows > 1) ?((numRows  - 2) + numRows): 1;
        int currentRowFirstIndex = 0;
        int amongElement = 0;
        StringBuilder result = new StringBuilder();
        for(int index = 0; index < numRows; index++){
            currentRowFirstIndex = index;
            while( currentRowFirstIndex < s.length()){
                if(index > 0 && index < numRows - 1){
                    amongElement = currentRowFirstIndex +  elementCountBetweenAmongColumns - (2 * index) ;
                    result.append(s.charAt(currentRowFirstIndex))
                            .append(amongElement < s.length() ? s.charAt(amongElement): "");
                }else{
                    result.append(s.charAt(currentRowFirstIndex));
                }
                currentRowFirstIndex = currentRowFirstIndex + elementCountBetweenAmongColumns;
            }

        }
        return result.toString();
    }
}
