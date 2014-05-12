package trend.relevantNames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ApiClassNameTokenizer {


    public List<String> getTokens(List<String> listClass) {
        ArrayList<String> listToken = new ArrayList();

        for (String nameClass : listClass) {
            listToken.addAll(tokenListFromClassName(nameClass));
        }

        return deleteDuplicateTokens(listToken);
         
    }

    private List<String> tokenListFromClassName(String nameClass) {
        return Arrays.asList(nameClass.split(patternCamelCase()));
    }

    private static String patternCamelCase() {
        return "(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])";
    }

    private List<String> deleteDuplicateTokens(ArrayList<String> listToken) {
        HashSet<String> checkDuplicates = new HashSet<>();
        ArrayList<String> listWithoutDuplicates = new ArrayList();
        
        for (String token : listToken) {
            if (checkDuplicates.add(token)) {
                listWithoutDuplicates.add(token);
            }
        }

        return listWithoutDuplicates;
    }

}
