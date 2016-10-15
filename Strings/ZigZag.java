public class ZigZag {
  
    public String convert(String a, int row) {
        if(row == 1) {
            return a;
        }
       List<StringBuilder> listBuilders = new ArrayList<>();
       int rowNum = 0;
       boolean startNegation = false;
       boolean startAddition = true;
       for(int i=0; i<a.length(); i++) {
           
           if(rowNum == 0) {
               startAddition = true;
               startNegation = false;
           }
           
           if(rowNum == row-1) {
               startNegation = true;
               startAddition = false;
           }
           
           if(startAddition) {
               // Add elements to next row
                listBuilders = addElement(a, i, rowNum, listBuilders);
               rowNum = rowNum + 1;
           }
           
           else if(startNegation) {
               // Add elements to previous row
                listBuilders = addElement(a, i, rowNum, listBuilders);
               rowNum = rowNum-1;
           }
           
       }
         
        StringBuilder result = new StringBuilder();
        for(int i=0; i<listBuilders.size(); i++) {
            StringBuilder b = listBuilders.get(i);
            result.append(b);
        }
    
        return result.toString();
    }

    public List<StringBuilder> addElement(String a, int index, int rowNum, List<StringBuilder> listBuilders) {
        StringBuilder build = new StringBuilder();
        if (listBuilders.size() > rowNum) {
            build = listBuilders.get(rowNum);
            build.append(a.charAt(index));
            listBuilders.set(rowNum, build);
        } else {
            build.append(a.charAt(index));
            listBuilders.add(build);
        }
        return listBuilders;
    }
    
}