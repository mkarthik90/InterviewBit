/*
 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * Example
 * Given array A as
 *  1 0 1
 * 1 1 1 
 * 1 1 1
 * On returning, the array A should be :
 * 0 0 0
 * 1 0 1
 * 1 0 1
*/
class SetMatrixZero {

    public void setZeroes(ArrayList<ArrayList<Integer>> list) {

        List<Integer> rowEntries = new ArrayList<Integer>();
        List<Integer> columnEntries = new ArrayList<Integer>();
        
        int rowSize = list.size();
        int columnSize = list.get(0).size();
        
        for(int i=0; i< rowSize;i++) {
            rowEntries.add(0);
        }
        
        for(int k=0; k<columnSize; k++) {
            columnEntries.add(0);
        }
        

        for (int i = 0; i < list.size(); i++) {
            List<Integer> intValues = list.get(i);

            for (int j = 0; j < intValues.size(); j++) {
                if (intValues.get(j) == 0) {
                    
                    rowEntries.set(i, -1);
                    columnEntries.set(j, -1);
                }
            }
        }
    
        for (int i = 0; i < rowEntries.size(); i++) {
            if (rowEntries.get(i) == -1) {
                // This row needs to be set to zero
                List<Integer> intValues = list.get(i);
                ArrayList<Integer> newList = new ArrayList<>();
                for (int j : intValues) {
                    newList.add(0);
                }
                list.set(i, newList);
            }
        }

        for (int j = 0; j < columnEntries.size(); j++) {
            if (columnEntries.get(j) == -1) {
                // This columns needs to be set to zero
                for (int i = 0; i < list.size(); i++) {
                    List<Integer> w = list.get(i);
                    w.set(j, 0);
                }
            }
        }
    }

}