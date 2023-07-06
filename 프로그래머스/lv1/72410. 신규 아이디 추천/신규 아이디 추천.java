class Solution {
    public String solution(String newId) {
        newId = newId.toLowerCase()
                     .replaceAll("[^a-z0-9-_.]","")
                     .replaceAll("\\.+",".");
        
        if(newId.startsWith(".")){newId = newId.substring(1,newId.length());}
        if(newId.endsWith(".")){newId = newId.substring(0,newId.length()-1);}
        
        if(newId.length() ==0){newId="aaa";}
        
        if(newId.length()>=16){newId = newId.substring(0,15);}
        if(newId.endsWith(".")){newId = newId.substring(0,newId.length()-1);}
        
        while(newId.length()<=2){
            newId += newId.charAt(newId.length()-1);
        }
                    
        return newId;
    }
}