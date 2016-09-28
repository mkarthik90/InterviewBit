public class RomanToInteger {
    public int romanToInt(String a) {
        
        if(a == null) {
            return 0;
        }
        
        int total = 0;
        for(int i=0; i< a.length(); i++) {
            char c = a.charAt(i);
            int temp = getValue(c);
            
            if(i != a.length() -1) {
                char n = a.charAt(i + 1);
                int nextValue = getValue(n);
                if(temp < nextValue) {
                    total = total - temp;
                }                
                else {
                    total = total + temp;
                }
            }
            
            else {
                total = total + temp;
            }
        }
        return total;
        
    }
    
    public int getValue(char r) {
        if (r == 'I')
        return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
     
        return -1;
    }
}
