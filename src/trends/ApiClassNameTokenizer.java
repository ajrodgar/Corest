package trends;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiClassNameTokenizer {


    public List<String> tokens(List<String> listClass) {
        ArrayList<String> listToken = new ArrayList();

        for (String nameClass : listClass) {
            listToken.addAll(tokenListFromClassName(nameClass));
        }
        
        return listToken;
    }

    private List<String> tokenListFromClassName(String nameClass) {
        return Arrays.asList(nameClass.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])"));
    }

}
