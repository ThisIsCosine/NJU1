


import java.util.ArrayList;
import java.util.regex.*;

public class Lexer{
    public String lamadaString;
    public TokenType token;
    public String tokenvalue;
    public ArrayList<TokenType> tokenTypes;
    public ArrayList<String> tokens;
    public int TokensNum;
    public int ExplainedCharNum;
    /**
     * Lexer 类内构造函数
     * @param s
     */
    public Lexer(String s){
        lamadaString = s.replaceAll("\\s+","");
        TokensNum = 0;
        ExplainedCharNum = 0;
        tokenTypes = new ArrayList<>();
        tokens = new ArrayList<>();
     //TODO
    }

    /**
     * 解析函数，本次作业主任务
     * @return TokenType 当前合法的token的tokenType
     */
    public TokenType nextToken(){
        if (ExplainedCharNum < lamadaString.length()){
            if (lamadaString.charAt(ExplainedCharNum) == '\\'){
                System.out.println("LAMBDA");
                tokenvalue = "\\";
                tokens.add(tokenvalue);
                token = TokenType.LAMBDA;
                tokenTypes.add(token);
                ExplainedCharNum ++;
                TokensNum ++;
                return token;
            } else if (lamadaString.charAt(ExplainedCharNum) == '('){
                System.out.println("LPAREN");
                tokenvalue = "(";
                tokens.add(tokenvalue);
                token = TokenType.LPAREN;
                tokenTypes.add(token);
                ExplainedCharNum ++;
                TokensNum ++;
                return token;
            } else if (lamadaString.charAt(ExplainedCharNum) == ')'){
                System.out.println("RPAREN");
                tokenvalue = ")";
                tokens.add(tokenvalue);
                token = TokenType.RPAREN;
                tokenTypes.add(token);
                ExplainedCharNum ++;
                TokensNum ++;
                return token;
            } else if (lamadaString.charAt(ExplainedCharNum) == '.'){
                System.out.println("DOT");
                tokenvalue = ".";
                tokens.add(tokenvalue);
                token = TokenType.DOT;
                tokenTypes.add(token);
                ExplainedCharNum ++;
                TokensNum ++;
                return token;
            } else if (lamadaString.charAt(ExplainedCharNum) >= 'a' && lamadaString.charAt(ExplainedCharNum) <= 'z') {
                int lcidLength = 0;
                StringBuilder stringBuilder = new StringBuilder();
                while ((lamadaString.charAt(ExplainedCharNum + lcidLength) >= 'A' && lamadaString.charAt(ExplainedCharNum + lcidLength) <= 'Z')
                        || (lamadaString.charAt(ExplainedCharNum + lcidLength) >= 'a' && lamadaString.charAt(ExplainedCharNum + lcidLength) <= 'z')){
                    stringBuilder.append(lamadaString.charAt(ExplainedCharNum + lcidLength));
                    System.out.println("LCID");
                    lcidLength ++;
                }
                ExplainedCharNum += lcidLength;
                tokenvalue = stringBuilder.toString();
                tokens.add(tokenvalue);
                token = TokenType.LCID;
                tokenTypes.add(token);
                TokensNum ++;
                return token;
            }
        }
        System.out.println("EOF");
        token = TokenType.EOF;
        tokenTypes.add(token);
        //TODO
        return token;
    }
    /**
     * check token == t 检查类型
     * @param t
     * @return 类型是否匹配
     */
    public boolean nextIsMatched(TokenType t){
        //TODO
        return false;
    }

    /**
     * 保证当前token的类型与传入的t相同，并解析下一个符合此法规则的token
     * 如果解析到不同于t的类型，则退出并报错
     * @param t
     */
    public void checkAndNext(TokenType t){
        //TODO
    }

    /**
     * 跳过当前TokenType t，并解析下一个符合此法规则的token
     * @param t
     * @return 是否skip成功
     */
    public boolean skipThisType(TokenType t){
       //TODO
        return false;
    }
}
