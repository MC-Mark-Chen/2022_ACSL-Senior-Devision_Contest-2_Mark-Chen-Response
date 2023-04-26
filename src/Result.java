public class Result {
    public static int findLastOctal(String s) {
        String[] binaryArray = new String[s.length()];
        String binaryInput = "";
        String binaryOutput;
        StringBuilder strb;
        StringBuilder strO;
        String sum = "";

        boolean leftFound = true;
        boolean rightFound = true;
        int num = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            binaryArray[i] = Integer.toString((int)(s.charAt(i)), 2);
            
            if(binaryArray[i].length() < 8)
            {
                for(int j = 0; j <= 8 - binaryArray[i].length(); j++)
                {
                    binaryArray[i] = "0" + binaryArray[i];
                }
            }
        }
        
        for(int i = 0; i < binaryArray.length; i++)
        {
            binaryInput += binaryArray[i];
        }
        
        strb = new StringBuilder(binaryInput);
        
        while(leftFound || rightFound)
        {
            leftFound = false;
            for(int i = 0; i <= strb.length() - Integer.toBinaryString(num).length(); i++)
            {
                if(strb.substring(i, i + Integer.toBinaryString(num).length()).equals(Integer.toBinaryString(num)))
                {
                    leftFound = true;
                    int idx = i;
                    for(int j = i; j < i + Integer.toBinaryString(num).length(); j++)
                    {
                        strb = strb.deleteCharAt(idx);
                    }
                    break;
                }
            }
            
            rightFound = false;
            for(int i = strb.length(); i >= 0 + Integer.toBinaryString(num).length(); i--)
            {
                if(strb.substring(i - Integer.toBinaryString(num).length(), i).equals(Integer.toBinaryString(num)))
                {
                    rightFound = true;
                    int idx = i - Integer.toBinaryString(num).length();
                    for(int j = i - Integer.toBinaryString(num).length(); j < i ; j++)
                    {
                        strb = strb.deleteCharAt(idx);
                    }
                    break;
                }
            }
            
            num++;
        }

        binaryOutput = strb.substring(strb.toString().length() % 3);

        for(int i = 0; i < binaryOutput.length() - 2; i+=3)
        {
            int tempSum = 0;
            int power = 2;
            for(int j = 0; j < 3; j++)
            {
                tempSum += (int)(Integer.parseInt(binaryOutput.substring(i + j, i + j + 1)) * Math.pow(2, power));
                power--;
            }
            sum += tempSum;
        }
        
        strO = new StringBuilder(sum);

        leftFound = true;
        rightFound = true;
        num = 0;
        while(leftFound || rightFound)
        {
            leftFound = false;
            for(int i = 0; i <= strO.length() - Integer.toOctalString(num).length(); i++)
            {
                if(strO.substring(i, i + Integer.toOctalString(num).length()).equals(Integer.toOctalString(num)))
                {
                    leftFound = true;
                    int idx = i;
                    for(int j = i; j < i + Integer.toOctalString(num).length(); j++)
                    {
                        strO = strO.deleteCharAt(idx);
                    }
                    break;
                }
            }
            
            rightFound = false;
            for(int i = strO.length(); i >= 0 + Integer.toOctalString(num).length(); i--)
            {
                if(strO.substring(i - Integer.toOctalString(num).length(), i).equals(Integer.toOctalString(num)))
                {
                    rightFound = true;
                    int idx = i - Integer.toOctalString(num).length();
                    for(int j = i - Integer.toOctalString(num).length(); j < i ; j++)
                    {
                        strO = strO.deleteCharAt(idx);
                    }
                    break;
                }
            }
            
            num++;
        }
        
        return num - 2;
    }

    public static void main(String[] args)
    {
        System.out.println(findLastOctal("A stitch in time saves nine."));
    }
}

