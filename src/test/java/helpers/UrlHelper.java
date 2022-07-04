package helpers;

public class UrlHelper {
    public static String getLastPartOfUrl(String url){
        for(int i=url.length()-1; i>=0; i--) {

            if (url.charAt(i) == '/' && i !=url.length()-1) {
                return url.substring(i+1);
            }
        }
        return "";
    }
}
