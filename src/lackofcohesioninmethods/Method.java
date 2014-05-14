package lackofcohesioninmethods;

import java.util.ArrayList;

public class Method {
    private String signature;
    private String body;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public int getNumberOfLines(){
        String[] code = body.split("\n");
        int lineCounter = 0;
        for (String line : code) {
            if(!line.equals(""))lineCounter++;
            if(line.contains("[") && line.contains("]") && line.contains("{")) lineCounter--;
        }
        return lineCounter;
    }
    
    public ArrayList<String> getMethodParameters(){
        String[] parameterData = extractParameters().split(",");
        return extractParameterNames(parameterData);
    }

    private ArrayList<String> extractParameterNames(String[] parameterNames) {
        ArrayList<String> parameters = new ArrayList<>();
        for (String parameter : parameterNames)
            parameters.add(parameter.substring(parameter.lastIndexOf(" ")+1,parameter.length()));
        return parameters;
    }
    
    private String extractParameters(){
        int start = signature.indexOf("(");
        int end = signature.lastIndexOf(")");
        return signature.substring(start+1, end);
    }
    
    public boolean isAccessing(String attribute){
        if(isEqualParameter(attribute))
            attribute = "this."+attribute;
        for (String line : body.split("\n")) {
            if(line.contains(attribute)){
                return checkLine(line, attribute);
            }
        }
        return false;
    }
    
    private boolean isEqualParameter(String attribute){
        for (String parameter : getMethodParameters())
            if(parameter.equals(attribute)) return true;
        return false;
    }
    
    private boolean checkLine(String line, String attribute) {
        line = line.substring(line.indexOf(attribute));
        return !(Character.isAlphabetic(line.charAt(attribute.length())+1));
    }
}