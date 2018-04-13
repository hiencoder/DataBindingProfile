package vn.edu.imic.databindingprofile.utils;

/**
 * Created by MyPC on 13/04/2018.
 */

public class BindingUtils {
    /*Phuong thuc convert number co them hau to K,M */
    public static String convertToSuffix(long count){
        if (count < 1000){
            return count + "";
        }else {
            int exp = (int) (Math.log(count)/Math.log(1000));
            return String.format("%.1f%c",
                    count/Math.pow(1000,exp),
                    "kmgtpe".charAt(exp - 1));
        }
    }
}
