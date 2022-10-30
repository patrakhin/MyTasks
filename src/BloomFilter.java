import java.util.*;
public class BloomFilter
{
    public int filter_len;
    public int [] tableResult;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        // create byte array length f_len ...
        tableResult = new int[filter_len];
    }

    // hash-func
    public int hash1(String str1)
    {
        // 17
        int resultHash1 = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = str1.charAt(i);
            resultHash1 = ((resultHash1+ code) * 17 ) % filter_len;
        }
        return resultHash1;
    }
    public int hash2(String str1)
    {
        // 223
        int resultHash2 = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = str1.charAt(i);
            resultHash2 = (resultHash2 * 223 + code) % filter_len;
        }
        return resultHash2;
    }

    public void add(String str1)
    {
        // add string to filter
        int buff1 = hash1(str1.trim());
        int buff2 = hash2(str1.trim());
        tableResult [buff1] = 1;
        tableResult [buff2] = 1;
    }

    public boolean isValue(String str1)
    {
        // check - contain filter this string
        int buff1 = hash1(str1.trim());
        int buff2 = hash2(str1.trim());
        if (tableResult [buff1] == 1 && tableResult [buff2] == 1)
            return true;
        return false;
    }
}