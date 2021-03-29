// Time: O(length of string)
// Space: O(# of open braces)

class Solution {
    public boolean isValid(String s) {
      if(s.length() == 1){
        return false;
      }      
      
      HashMap<Character,Character> map = new HashMap<>();
      map.put('(',')');
      map.put('{','}');
      map.put('[',']');
      
      Stack<Character> stack = new Stack<>();
      char popped;
      
      for(int i=0;i<s.length();i++){
        char curr = s.charAt(i);
        
        if(curr == '[' || curr == '{' || curr == '('){
          stack.push(curr);
        }
        else if(curr == ']' || curr == '}' || curr == ')'){
          if(!stack.isEmpty()){
            popped = stack.pop();
            if(map.get(popped) != curr){
              return false;
            }
          }else return false;
          
        }
      }
      if(!stack.isEmpty()) return false;
      return true;
    }
}
