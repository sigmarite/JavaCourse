package JDK8lecture1;

/**
 * Created by mpividori on 01/09/2016.
 */


public class OverloadingClass {

    public String method() {
        return "Default method";
    }
    public String method(Integer i){
        return "Overloaded method " + i;
    }
}
